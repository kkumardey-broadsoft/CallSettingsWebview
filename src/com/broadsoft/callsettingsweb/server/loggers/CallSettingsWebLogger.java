/* Copyright � 2017 BroadSoft Inc. */
package com.broadsoft.callsettingsweb.server.loggers;

import com.broadsoft.callsettingsweb.server.AppConstants;
import com.broadsoft.xsp.app.base.ChannelSeverity;
import com.broadsoft.xsp.app.base.IChannelLogger;
import com.broadsoft.xsp.app.server.XSPBaseAppContext;

/**
 * This class implements the ApplicationChannelLogger interface. This class logs
 * to the Channels configured/available for the application.
 * 
 * @author Kanchan.dey
 * 
 */
public class CallSettingsWebLogger implements ApplicationChannelLogger {

	private IChannelLogger channelLogger;
	private String applicationChannelName;

	public CallSettingsWebLogger(XSPBaseAppContext appContext) {
		channelLogger = appContext.getChannelLogger();
		applicationChannelName = channelLogger.getApplicationChannelName();
	}

	@Override
	public void log(ChannelSeverity severity, String message) {
		logText(applicationChannelName, severity, message);
	}

	@Override
	public void log(ChannelSeverity severity, String component, String message) {
		logText(applicationChannelName, severity, component + " | " + message);
	}

	@Override
	public void log(ChannelSeverity severity, Throwable throwable) {
		logThrowable(applicationChannelName, severity, throwable);
	}

	@Override
	public void logGenericInterface(ChannelSeverity severity, String message) {
		logText(AppConstants.GENERIC_INTERFACE_CHANNEL, severity, message);
	}

	@Override
	public void logGenericInterface(ChannelSeverity severity,
			Throwable throwable) {
		logThrowable(AppConstants.GENERIC_INTERFACE_CHANNEL, severity,
				throwable);
	}
	
	@Override
	public void logHttpChannel(ChannelSeverity severity, String message) {
		logText(AppConstants.HTTP_CHANNEL, severity, message);
	}

	@Override
	public void logHttpChannel(ChannelSeverity severity,
			Throwable throwable) {
		logThrowable(AppConstants.HTTP_CHANNEL, severity,
				throwable);
	}
	
	@Override
	public void logHttpChannel(ChannelSeverity severity, String component, String message) {
		logText(AppConstants.HTTP_CHANNEL, severity, component + " | " + message);
		
	}

	private void logText(String channelName, ChannelSeverity severity,
			String message) {

		switch (severity) {
		case DEV_DEBUG:
			channelLogger.logDevDebug(channelName, message);
			break;

		case FIELD_DEBUG:
			channelLogger.logFieldDebug(channelName, message);
			break;

		case INFO:
			channelLogger.logInfo(channelName, message);
			break;
		case NOTICE:
			channelLogger.logNotice(channelName, message);
			break;
		case WARN:
			channelLogger.logWarn(channelName, message);
			break;

		default:
			break;
		}

	}

	private void logThrowable(String channelName, ChannelSeverity severity,
			Throwable throwble) {

		switch (severity) {
		case DEV_DEBUG:
			channelLogger.logDevDebug(channelName, throwble);
			break;

		case FIELD_DEBUG:
			channelLogger.logFieldDebug(channelName, throwble);
			break;

		case INFO:
			channelLogger.logInfo(channelName, throwble);
			break;
		case NOTICE:
			channelLogger.logNotice(channelName, throwble);
			break;
		case WARN:
			channelLogger.logWarn(channelName, throwble);
			break;

		default:
			break;
		}

	}

	@Override
	public void logConsole(String message) {
		channelLogger.logConsole(message);

	}

	@Override
	public ChannelSeverity getLogLevel(String channelName) {
		return channelLogger.getLogLevel(channelName);
	}


}
