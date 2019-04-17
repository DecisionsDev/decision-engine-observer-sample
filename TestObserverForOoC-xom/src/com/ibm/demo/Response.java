package com.ibm.demo;

import com.ibm.demo.util.EngineTrace;

public class Response {

	private int outputNumber;
	private String msg;
	private EngineTrace engineTrace;

	public void setEngineTrace(EngineTrace engineTrace) {
		this.engineTrace = engineTrace;
	}

	public Response() {
		this.engineTrace = null;
	}

	public int getOutputNumber() {
		return outputNumber;
	}
	public void setOutputNumber(int outputNumber) {
		this.outputNumber = outputNumber;
	}

	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

	public EngineTrace getEngineTrace() {
		return engineTrace;
	}
}
