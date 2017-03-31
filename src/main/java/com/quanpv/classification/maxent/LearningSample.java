package com.quanpv.classification.maxent;


public class LearningSample {

	private final String klass;
	private final String text;

	public LearningSample(String klass, String text) {
		this.klass = klass;
		this.text = text;
	}

	public String getKlass() {
		return klass;
	}

	public String getText() {
		return text;
	}
}
