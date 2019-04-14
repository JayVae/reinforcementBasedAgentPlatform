package com.xjtu.power.agent.core.jade.core.messaging;

class QueueFullException extends RuntimeException {
	
	public Throwable fillInStackTrace() {
		return this;
	}
}
