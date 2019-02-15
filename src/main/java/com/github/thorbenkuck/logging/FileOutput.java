package com.github.thorbenkuck.logging;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class FileOutput implements Output {

	private final FileWriter target;

	FileOutput(File target) {
		try {
			this.target = new FileWriter(target);
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public synchronized void println(String message) {
		try {
			target.append(message).append(System.lineSeparator());
		} catch (IOException e) {
			throw new IllegalStateException(e);
		}
	}
}
