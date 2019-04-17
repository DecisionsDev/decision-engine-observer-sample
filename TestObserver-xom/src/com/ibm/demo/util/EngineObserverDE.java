package com.ibm.demo.util;

import com.ibm.rules.engine.observer.Observable;
import com.ibm.rules.engine.ruledef.runtime.AgendaObserver;
import com.ibm.rules.engine.ruledef.runtime.RuleEngineObserver;
import com.ibm.rules.engine.ruledef.runtime.RuleInstance;
import com.ibm.rules.engine.ruleflow.runtime.RuleflowEngineInput;
import com.ibm.rules.engine.ruleflow.runtime.RuleflowEngineOutput;
import com.ibm.rules.engine.ruleflow.runtime.RuleflowObserver;
import com.ibm.rules.engine.ruleflow.runtime.Task;
import com.ibm.rules.engine.runtime.EngineInput;
import com.ibm.rules.engine.runtime.EngineOutput;

public class EngineObserverDE implements RuleEngineObserver, RuleflowObserver, AgendaObserver {

	private EngineTrace trace;

	public EngineObserverDE(EngineTrace trace) {
		this.trace = trace;
	}
	
	@Override
	public void ruleFlowStarted(Observable o, Task t, RuleflowEngineInput rei) {
		addTrace("ruleFlowStarted "+t.getName());
	}

	@Override
	public void ruleFlowEnded(Observable o, Task t, RuleflowEngineOutput reo) {
		addTrace("ruleFlowEnded "+t.getName());
	}
	
	@Override
	public void taskStarted(Observable o, Task t, EngineInput ei) {
		addTrace("taskStarted "+t.getName());
	}

	@Override
	public void taskEnded(Observable o, Task t, EngineOutput eo) {
		addTrace("taskEnded "+t.getName());
	}

	@Override
	public void exceptionRaisedInAction(Observable o, Exception ex, RuleInstance ri, boolean b) {
		addTrace("exceptionRaisedInAction "+ri.getRuleName()+ex.getMessage());
	}

	@Override
	public void exceptionRaisedInCondition(Observable o, Exception ex, boolean b) {
		addTrace("exceptionRaisedInCondition "+ex.getMessage());
	}

	@Override
	public void ruleExecutionEnded(Observable o, RuleInstance ri) {
		addTrace("ruleExecutionEnded "+ri.getRuleName());
	}

	@Override
	public void ruleExecutionStarted(Observable o, RuleInstance ri) {
		if (trace.isTraceRules()) {
			addTrace(ri.getRuleName());
		}
	}
	
	public void addTrace(String message) {
			trace.add(new TraceElement(message));
			//System.out.println(message);
		}
	

	@Override
	public void ruleInstanceInserted(Observable o, RuleInstance ri,
			RuleInstance arg2) {
		addTrace("ruleInstanceInserted "+ri.getRuleName());
	}

	@Override
	public void ruleInstanceRetracted(Observable o, RuleInstance ri) {
		addTrace("ruleInstanceRetracted "+ri.getRuleName());
	}

	@Override
	public void ruleInstanceUpdated(Observable o, RuleInstance ri1,
			RuleInstance ri2) {
		addTrace("ruleInstanceUpdated "+ri1.getRuleName());
	}
}
