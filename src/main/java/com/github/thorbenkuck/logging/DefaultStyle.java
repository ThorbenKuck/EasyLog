package com.github.thorbenkuck.logging;

import java.time.LocalDateTime;

public class DefaultStyle implements Style {
	@Override
	public String apply(Object toLog, Object depth) {
		return "[" + depth + "] (" + Thread.currentThread() + ") {" + LocalDateTime.now() + "} : " + toLog;
	}
}
