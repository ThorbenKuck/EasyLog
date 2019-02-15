package com.github.thorbenkuck.logging;

import java.io.PrintWriter;
import java.io.StringWriter;

public class Logger {

	private static final Object styleLock = new Object();
	private static final Dispatcher dispatcher = new SimpleDispatcher();
	private static Style style = new DefaultStyle();

	private Logger() {
		throw new UnsupportedOperationException("instantiation");
	}

	private static void dispatchLog(Object o) {
		dispatcher.println(o);
	}

	public static void addOutput(Output output) {
		dispatcher.append(output);
	}

	public static Dispatcher getDispatcher() {
		return dispatcher;
	}

	public static Style getStyle() {
		return style;
	}

	public static String convert(Object message, Object depth) {
		synchronized (styleLock) {
			return style.apply(message, depth);
		}
	}

	public static void setStyle(Style style) {
		synchronized (styleLock) {
			Logger.style = style;
		}
	}

	public static void trace(Object o) {
		dispatchLog(convert(o, "TRACE"));
	}

	public static void debug(Object o) {
		dispatchLog(convert(o, "DEBUG"));
	}

	public static void info(Object o) {
		dispatchLog(convert(o, "INFO") + o);
	}

	public static void warn(Object o) {
		dispatchLog(convert(o, "WARN") + o);
	}

	public static void error(Object o) {
		dispatchLog(convert(o, "ERROR"));
	}

	public static void catching(Throwable throwable) {
		StringWriter stringWriter = new StringWriter();
		throwable.printStackTrace(new PrintWriter(stringWriter));
		String stackTrace = stringWriter.toString();

		dispatchLog(convert(throwable.getMessage(), "CATCHING"));
		dispatchLog(stackTrace);
	}

}
