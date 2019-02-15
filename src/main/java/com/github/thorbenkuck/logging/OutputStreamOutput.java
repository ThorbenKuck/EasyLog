package com.github.thorbenkuck.logging;

import java.io.IOException;
import java.io.OutputStream;

class OutputStreamOutput implements Output {

	private final OutputStream outputStream;

	OutputStreamOutput(OutputStream outputStream) {
		this.outputStream = outputStream;
	}

	@Override
	public void println(String message) {
		try {
			outputStream.write((message + System.lineSeparator()).getBytes());
		} catch (IOException e) {
			throw new IllegalStateException(e);
		}
	}
}
