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
	private String gender;
	private String samples;
	private String accuracy;
	private String duration;
	private String country;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
}


