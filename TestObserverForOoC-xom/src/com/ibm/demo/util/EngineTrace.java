package com.ibm.demo.util;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

public class EngineTrace {
	@XmlElementWrapper(name="traces")
	@XmlElement(name="trace")
	private List<TraceElement> elements = new ArrayList<TraceElement>();

	private boolean traceRules=true;
	private boolean traceRuleFlows=true;
	private boolean traceAgenda=true;

	public EngineTrace() {}

	public boolean isTraceRules() {
		return traceRules;
	}
	public void setTraceRules(boolean traceRules) {
		this.traceRules = traceRules;
	}

	public boolean isTraceRuleFlows() {
		return traceRuleFlows;
	}
	public void setTraceRuleFlows(boolean traceRuleFlows) {
		this.traceRuleFlows = traceRuleFlows;
	}

	public boolean isTraceAgenda() {
		return traceAgenda;
	}
	public void setTraceAgenda(boolean traceAgenda) {
		this.traceAgenda = traceAgenda;
	}

	public void add(TraceElement e) {
		elements.add(e);
		
	}
}
