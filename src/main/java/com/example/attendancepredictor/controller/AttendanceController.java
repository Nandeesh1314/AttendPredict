package com.example.attendancepredictor.controller;

import com.example.attendancepredictor.model.AttendanceResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class AttendanceController {
    
    @GetMapping("/calculate")
    public AttendanceResponse calculateAttendance(
            @RequestParam int attended,
            @RequestParam int total,
            @RequestParam double required) {
        
        if (total <= 0 || attended < 0 || attended > total || required < 0 || required > 100) {
            AttendanceResponse error = new AttendanceResponse();
            error.setStatus("error");
            error.setMessage("Invalid input values. Please check your entries.");
            return error;
        }
        
        double currentPercentage = (attended * 100.0) / total;
        AttendanceResponse response = new AttendanceResponse();
        response.setCurrentPercentage(Math.round(currentPercentage * 100.0) / 100.0);
        
        if (currentPercentage >= required) {
            int classesToSkip = calculateClassesToSkip(attended, total, required);
            double percentageAfterSkip = ((attended * 100.0) / (total + classesToSkip));
            
            if (classesToSkip > 0) {
                double buffer = currentPercentage - required;
                
                if (buffer < 5) {
                    response.setStatus("caution");
                    response.setStatusBadge("Caution");
                    response.setMessage("You're above the required percentage but close to the limit. You can skip up to " + 
                                      classesToSkip + " more classes.");
                } else {
                    response.setStatus("safe");
                    response.setStatusBadge("Safe to Skip");
                    response.setMessage("You're well above the required percentage! You can skip up to " + 
                                      classesToSkip + " more classes.");
                }
                
                response.setPrediction("Can skip: " + classesToSkip + " classes");
                response.setPredictionDetail("Your attendance will be: " + 
                                            String.format("%.2f", percentageAfterSkip) + "%");
            } else {
                response.setStatus("maintain");
                response.setStatusBadge("Maintain");
                response.setMessage("You're exactly at the required percentage. Don't skip any classes!");
                response.setPrediction("Cannot skip any classes");
                response.setPredictionDetail("Maintain perfect attendance to stay on track.");
            }
        } else {
            if (required == 100.0 && attended < total) {
                response.setStatus("error");
                response.setStatusBadge("Unreachable");
                response.setMessage("Cannot reach 100% attendance once classes are missed.");
                response.setPrediction("Target unreachable");
                response.setPredictionDetail("It's mathematically impossible to achieve 100% attendance.");
                return response;
            }
            
            int classesToAttend = calculateClassesToAttend(attended, total, required);
            double percentageAfterAttend = ((attended + classesToAttend) * 100.0) / (total + classesToAttend);
            
            response.setStatus("attend");
            response.setStatusBadge("Need to Attend");
            response.setMessage("You're below the required percentage. You need to attend " + 
                              classesToAttend + " consecutive classes.");
            response.setPrediction("Must attend: " + classesToAttend + " classes");
            response.setPredictionDetail("Your attendance will be: " + 
                                        String.format("%.2f", percentageAfterAttend) + "%");
        }
        
        return response;
    }
    
    private int calculateClassesToSkip(int attended, int total, double required) {
        if (required == 0) {
            return Integer.MAX_VALUE;
        }
        
        double r = required / 100.0;
        int classesToSkip = (int) Math.floor((attended / r) - total);
        return Math.max(0, classesToSkip);
    }
    
    private int calculateClassesToAttend(int attended, int total, double required) {
        if (required == 100.0) {
            return 0;
        }
        
        double r = required / 100.0;
        int classesToAttend = (int) Math.ceil((r * total - attended) / (1.0 - r));
        return Math.max(0, classesToAttend);
    }
}
