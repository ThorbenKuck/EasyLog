package com.github.thorbenkuck.logging;

import java.io.File;
import java.io.OutputStream;

public interface Output {

	void println(String message);

	static Output toFile(File target) {
		return new FileOutput(target);
	}

	static Output toConsole() {
		return toOutputStream(System.out);
	}

	static Output toErrorStream() {
		return toOutputStream(System.err);
	}

	static Output toOutputStream(OutputStream printStream) {
		return new OutputStreamOutput(printStream);
	}

}
