package com.xjtu.power.agent.core.jade.core.sam;

//#DOTNET_EXCLUDE_FILE

public abstract class DifferentialCounterValueProvider implements CounterValueProvider {

	@Override
	public boolean isDifferential() {
		return true;
	}

}
