# Attendance Calculator

## Overview

The Attendance Calculator is a web-based application designed to help users track and calculate their attendance statistics. The application appears to be built using Java with Spring Boot on the backend, serving a modern, responsive frontend with a dark-themed user interface. The project uses a gradient-based design system with purple accent colors, providing a clean and professional user experience.

## User Preferences

Preferred communication style: Simple, everyday language.

## System Architecture

### Frontend Architecture

**Technology Stack:**
- Pure HTML, CSS, and JavaScript (no frontend framework detected)
- Modern CSS with gradient backgrounds and flexbox layouts
- Responsive design with mobile-first approach using viewport meta tags

**Design Decisions:**
- **Dark Theme UI**: Implemented using CSS gradients (blues and purples) to provide a modern, eye-friendly interface
- **Component-based Layout**: Header component with logo and title separated into reusable visual sections
- **Responsive Typography**: Uses system font stack for optimal performance and native look across platforms
- **Gradient Branding**: Purple gradient accent colors (#a855f7 to #c084fc) for brand consistency

### Backend Architecture

**Technology Stack:**
- Java-based backend (Spring Boot framework implied by directory structure)
- Maven build system (indicated by target/classes structure)
- Static resource serving from `src/main/resources/static`

**Design Decisions:**
- **Spring Boot Static Resources**: Leverages Spring Boot's default static resource serving from `/static` directory
- **Compiled Output Structure**: Uses standard Maven target directory for build artifacts
- **Separation of Concerns**: Clear separation between source files and compiled classes

### Resource Organization

**Static File Structure:**
- Source files located in: `src/main/resources/static/`
- Compiled files output to: `target/classes/static/`
- Single-page application with `index.html` as entry point

**Rationale**: This structure follows Spring Boot conventions, allowing automatic serving of static resources while maintaining clear separation between source and build outputs.

## External Dependencies

### Backend Dependencies
- **Spring Boot Framework**: Core framework for the Java backend application
- **Maven**: Build automation and dependency management tool

### Frontend Dependencies
- **System Fonts**: Uses native system font stack (-apple-system, BlinkMacSystemFont, Segoe UI, Roboto, etc.) to avoid external font dependencies
- **No External Libraries Detected**: The frontend appears to use vanilla JavaScript, HTML, and CSS without external UI frameworks or libraries

### Infrastructure
- **Static File Server**: Application serves static files through Spring Boot's built-in static resource handler
- **No Database Detected**: Current repository structure shows no database configuration or schema files (may be added later if persistence is needed)