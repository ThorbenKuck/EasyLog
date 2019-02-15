package com.github.thorbenkuck.logging;

public interface Dispatcher {

	void println(Object o);

	void append(Output output);
}
