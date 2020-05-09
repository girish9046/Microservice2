package com.example.demo.logging;

import java.sql.Timestamp;
import java.util.Properties;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author girish
 */
public class SingleLogger {
	
	private Logger logger;
	private String fileName;
	
//	@Autowired
//	LogConstants logConstants;
//	
	/**
	 * logs to independent file
	 * @param filename filename this logger will log to
	 */
	public SingleLogger(String filename) {
		try {
			if (filename != null && !filename.isEmpty()) {
				this.fileName = filename;
				init();
			} else {
				throw new Exception("filename cannot be null or empty");
			}
		} catch (Exception e) {
			System.out.println("[ SingleLogger ] error : " + e.getMessage());
		}
	}
	
	/**
	 * logs single message to this SingleLogger's filename
	 * @param msg 
	 */
	public void logSingle(String msg, Level level) {
		this.logger.log(level, addDate() + addLogFileName() + msg);
	}
	
	/**
	 * gets the time stamp for log messages
	 */
	 private String addDate() {
	        java.util.Date date = new java.util.Date();
	        String time = new Timestamp(date.getTime()).toString();
	        return "time=\"" + time + "\" ";
	    }
	 
	 /**
		 * gets the Log File Name for log messages
		 */
		 private String addLogFileName() {
			 String filename = this.getFileName();
		        return " LogFileName=\"" + filename + "\" ";
		    }
	 
	private void init() {
		try {
			String filename = this.getFileName();
			//this.logger = Logger.getLogger(filename);
			//fa = new FileAppender(new SimpleLayout(), "d:/logs/" + filename + ".log");
			
//			RollingFileAppender fileAppender = new RollingFileAppender(new SimpleLayout(), Constants.LOG_FILE_PATH + filename + Constants.LOG_FILE_FILE_EXT);
//			fileAppender.setMaxFileSize(Constants.LOG_FILE_MAX_SIZE);
//			fileAppender.setMaxBackupIndex(Constants.LOG_FILE_BACKUP_INDEX);
//			logger.addAppender(fileAppender);
//             fa = new FileAppender(new SimpleLayout(), "../logs/" + appName + ".log");
//			System.out.println("filename....................."+filename);
//			Properties properties=new Properties();
//			properties.setProperty("log4j.appender."+filename, "org.apache.log4j.RollingFileAppender");
//		    properties.setProperty("log4j.appender."+filename+".File", Constants.LOG_FILE_PATH + filename + Constants.LOG_FILE_FILE_EXT);
//		    properties.setProperty("log4j.appender."+filename+".MaxFileSize", Constants.LOG_FILE_MAX_SIZE);
//		    properties.setProperty("log4j.appender."+filename+".MaxBackupIndex", ""+Constants.LOG_FILE_BACKUP_INDEX);
//		    properties.setProperty("log4j.appender."+filename+".layout",  "org.apache.log4j.PatternLayout");
//		    properties.setProperty("log4j.appender."+filename+".layout.ConversionPattern","%d{yyyy/MM/dd HH:mm:ss.SSS} [,%X{X-B3-TraceId:-}] [%5p] %t (%F) - %m%n");
//		    PropertyConfigurator.configure(properties);
//		    this.logger  = Logger.getLogger(filename);
		    
		    PatternLayout layout = new PatternLayout();
	        String conversionPattern = "%d{yyyy/MM/dd HH:mm:ss.SSS} [,%X{X-B3-TraceId:-}] [%5p] %t (%F) - %m%n";
	        layout.setConversionPattern(conversionPattern);
	 
	        // creates console appender
	        ConsoleAppender consoleAppender = new ConsoleAppender();
	        consoleAppender.setLayout(layout);
	        consoleAppender.activateOptions();
	 
	        // creates file appender
	        FileAppender fileAppender = new FileAppender();
	        fileAppender.setFile(Constants.LOG_FILE_PATH + filename + Constants.LOG_FILE_FILE_EXT);
	        fileAppender.setLayout(layout);
	        fileAppender.activateOptions();
	 
	        // configures the root logger
	        this.logger   = Logger.getRootLogger();
	        this.logger.setLevel(Level.DEBUG);
	        this.logger.addAppender(consoleAppender);
	        this.logger.addAppender(fileAppender);
	        
//			logger.addAppender(fileAppender);
			
//			logger.addAppender(fa);
//			fa.setLayout(new SimpleLayout());
		} catch (Exception e) {
			System.err.println("[ SingleLogger ] error : " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public String getFileName() {
		return fileName;
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
}

