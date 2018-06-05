package com.teaching.strategies.model;
/**
 * Gender class for GenderAPI
 * 
 * 
 * @author srowley
 *
 */
public  class Gender {

	private String name;
	private String name_sanitized;
	private String gender;
	private String samples;
	private String accuracy;
	private String duration;
	private String country;
	private String credits_used;
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName_sanitized() {
		return name_sanitized;
	}
	public void setName_sanitized(String name_sanitized) {
		this.name_sanitized = name_sanitized;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSamples() {
		return samples;
	}
	public void setSamples(String samples) {
		this.samples = samples;
	}
	public String getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(String accuracy) {
		this.accuracy = accuracy;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCredits_used() {
		return credits_used;
	}
	public void setCredits_used(String credits_used) {
		this.credits_used = credits_used;
	}
	
}


