package com.ionix.ionix.model;

public class Result {
	private int responseCode;
	private String description;
	private int elapsedTime;
	private TestTecnico result;
	public int getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getElapsedTime() {
		return elapsedTime;
	}
	public void setElapsedTime(int elapsedTime) {
		this.elapsedTime = elapsedTime;
	}
	public TestTecnico getResult() {
		return result;
	}
	public void setResult(TestTecnico result) {
		this.result = result;
	}
	
}
