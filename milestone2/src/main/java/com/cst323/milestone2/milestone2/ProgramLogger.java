package com.cst323.milestone2.milestone2;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProgramLogger implements HandlerInterceptor {

    // Logger instance for the ProgramLogger class
    Logger logger = LoggerFactory.getLogger(ProgramLogger.class);


    // Method to log the pre-handling of a request and display the request details
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        // Initialize variables for logging the request details
        String methodName = null;
        Long timeStamp = System.currentTimeMillis();
        String currentDate = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date(timeStamp));

        // Check if the handler is an instance of HandlerMethod and extract the method name
        if (handler instanceof org.springframework.web.method.HandlerMethod) {
            methodName = ((org.springframework.web.method.HandlerMethod) handler).getMethod().getName();

        }
         else if(!(handler instanceof org.springframework.web.method.HandlerMethod)) {
            return true;
        }

        // Log the request details
        logger.info("Request Received: Time Stamp: " + currentDate + " Request Class: " + ((org.springframework.web.method.HandlerMethod) handler).getBeanType().getCanonicalName() + " Method Name: " + methodName + "() ");
        return true;
    }

   /* @Override
    public void postHandle(HttpServletRequest req"uest, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        logger.info("Request processed: " + request.getRequestURI());
    } */


    // Method to log the completion of a request and display the request details
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        // Initialize variables for logging the request details
        String methodName = null;
        Long timeStamp = System.currentTimeMillis();
        String currentDate = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date(timeStamp));

        // Check if the handler is an instance of HandlerMethod and extract the method name
        if (handler instanceof org.springframework.web.method.HandlerMethod) {
            methodName = ((org.springframework.web.method.HandlerMethod) handler).getMethod().getName();
        }
        else if(!(handler instanceof org.springframework.web.method.HandlerMethod)) {
            return;
        }

        // Log the request details
        logger.info("Request Completed: Time Stamp: " + currentDate + " Request Class: " + ((org.springframework.web.method.HandlerMethod) handler).getBeanType().getCanonicalName() + " Method Name: " + methodName + "() ");
    }

    // Method to log errors during request processing and display the request and errordetails
    public void errorHandler(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        // Initialize variables for logging the request details
        String methodName = null;
        Long timeStamp = System.currentTimeMillis();
        String currentDate = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date(timeStamp));

        // Check if the handler is an instance of HandlerMethod and extract the method name
        if (handler instanceof org.springframework.web.method.HandlerMethod) {
            methodName = ((org.springframework.web.method.HandlerMethod) handler).getMethod().getName();
        }
        else if(!(handler instanceof org.springframework.web.method.HandlerMethod)) {
            return;
        }

        // Log the request and error details
        logger.error("Request Error: " + ex.getMessage() + " Time Stamp: " + currentDate + " Request Class: " + ((org.springframework.web.method.HandlerMethod) handler).getBeanType().getCanonicalName() + " Method Name: " + methodName + "() ");
    }

}

/* import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProgramLogger implements HandlerInterceptor {
    private Logger logger = LoggerFactory.getLogger(ProgramLogger.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        String methodName = null;
        String className = null;
        Long timeStamp = System.currentTimeMillis();
        String currentDate = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date(timeStamp));

        if (handler instanceof org.springframework.web.method.HandlerMethod handlerMethod) {
            methodName = handlerMethod.getMethod().getName();
            className = handlerMethod.getBeanType().getCanonicalName();
        }
        logger.info("Request received: Timestamp: " + currentDate + " Class: " + className + " Method: " + methodName + "()");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        String methodName = null;
        String className = null;
        Long timeStamp = System.currentTimeMillis();
        String currentDate = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date(timeStamp));

        if (handler instanceof org.springframework.web.method.HandlerMethod handlerMethod) {
            methodName = handlerMethod.getMethod().getName();
            className = handlerMethod.getBeanType().getCanonicalName();
        }
        logger.info("Response sent: Timestamp: " + currentDate + " Class: " + className + " Method: " + methodName + "()");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
       String methodName = null;
        String className = null;
        Long timeStamp = System.currentTimeMillis();
        String currentDate = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date(timeStamp));

        if (handler instanceof org.springframework.web.method.HandlerMethod handlerMethod) {
            methodName = handlerMethod.getMethod().getName();
            className = handlerMethod.getBeanType().getCanonicalName();
        }
        logger.info("Request completed: Timestamp: " + currentDate + " Class: " + className + " Method: " + methodName + "()");

    }

    public void errorHandler(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        String methodName = null;
        String className = null;
        Long timeStamp = System.currentTimeMillis();
        String currentDate = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date(timeStamp));

        if (handler instanceof org.springframework.web.method.HandlerMethod handlerMethod) {
            methodName = handlerMethod.getMethod().getName();
            className = handlerMethod.getBeanType().getCanonicalName();
        }
        logger.error("Request Error: " + ex.getMessage() + " Timestamp: " + currentDate + " Class: " + className + " Method: " + methodName + "()");
    }
} */
