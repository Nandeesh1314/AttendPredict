package com.example.attendancepredictor.model;

public class AttendanceResponse {
    private double currentPercentage;
    private String status;
    private String statusBadge;
    private String message;
    private String prediction;
    private String predictionDetail;
    
    public AttendanceResponse() {
    }
    
    public AttendanceResponse(double currentPercentage, String status, String statusBadge, 
                            String message, String prediction, String predictionDetail) {
        this.currentPercentage = currentPercentage;
        this.status = status;
        this.statusBadge = statusBadge;
        this.message = message;
        this.prediction = prediction;
        this.predictionDetail = predictionDetail;
    }
    
    public double getCurrentPercentage() {
        return currentPercentage;
    }
    
    public void setCurrentPercentage(double currentPercentage) {
        this.currentPercentage = currentPercentage;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getStatusBadge() {
        return statusBadge;
    }
    
    public void setStatusBadge(String statusBadge) {
        this.statusBadge = statusBadge;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public String getPrediction() {
        return prediction;
    }
    
    public void setPrediction(String prediction) {
        this.prediction = prediction;
    }
    
    public String getPredictionDetail() {
        return predictionDetail;
    }
    
    public void setPredictionDetail(String predictionDetail) {
        this.predictionDetail = predictionDetail;
    }
}
