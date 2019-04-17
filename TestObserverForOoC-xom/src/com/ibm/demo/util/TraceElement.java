package com.ibm.demo.util;

import javax.xml.bind.annotation.XmlElement;

public class TraceElement {
	@XmlElement(name="message")
	private String value;

	public TraceElement(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
