package com.github.thorbenkuck.logging;

import java.util.ArrayList;
import java.util.List;

class SimpleDispatcher implements Dispatcher {

	private final List<Output> outputs = new ArrayList<>();

	SimpleDispatcher() {
		outputs.add(Output.toConsole());
	}

	@Override
	public void println(Object o) {
		outputs.forEach(output -> output.println(o.toString()));
	}

	@Override
	public void append(Output output) {
		outputs.add(output);
	}
}
