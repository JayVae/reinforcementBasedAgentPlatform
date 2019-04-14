package com.xjtu.power.agent.core.jade.content.onto;

//#APIDOC_EXCLUDE_FILE

public class NotAnAggregate extends OntologyException {

	public NotAnAggregate() {
		super("");
	}
	
	public Throwable fillInStackTrace() {
		return this;
	}
}
