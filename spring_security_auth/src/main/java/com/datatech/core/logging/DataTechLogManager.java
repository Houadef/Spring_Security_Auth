package com.datatech.core.logging;

import org.apache.logging.log4j.LogManager;


import org.apache.logging.log4j.Logger;



public class DataTechLogManager {

   protected static final Logger  PARENTLOGGER =  LogManager.getLogger();
   
   private Logger logger = PARENTLOGGER;
    
    //Info Level Logs
    protected void info (String message) {
    	this.logger.info(message);
    }

    //Warn Level Logs
    protected  void warn (String message) {
    	logger.warn(message);
    }

    //Error Level Logs
    protected  void error (String message) {
    	this.logger.error(message);
    }

    //Fatal Level Logs
    protected void fatal (String message) {
    	this.logger.fatal(message);
    }

    //Debug Level Logs
    protected void debug (String message) {
    	this.logger.debug(message);
    }
    
    //trace Level Logs
    protected void trace (String message) {
    	this.logger.trace(message);
    }
    
    protected Logger getLogger() {
        return logger;
    }

    protected void setLogger(Logger logger) {
        this.logger = logger;
    }
    
}