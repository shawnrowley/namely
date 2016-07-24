package com.teaching.strategies.service.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import javax.enterprise.context.ApplicationScoped;

import org.codehaus.jackson.map.ObjectMapper;

import com.teaching.strategies.model.Gender;
/**
 * Gender API Client
 * 
 * @author srowley
 *
 */
// TODO Refactor client
public class GenderAPIClient {
	
	public final static String key = "drdTuwqCXVAMYkReEo";
	public final static String genderAPIurl = "https://gender-api.com/get?key=";

	public GenderAPIClient() {
	
	}

	/**
	 * Returns Gender Object based on name
	 * 
	 * 
	 * @param name
	 * @return Gender
	 */
	public Gender getGenderByName(String name){
		BufferedReader reader = null;
		StringBuilder builder = null;
		String line = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			URL url = new URL(genderAPIurl + key + "&name=" + name);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
  			
			reader  = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			builder = new StringBuilder();

			while ((line = reader.readLine()) != null)
			{
				builder.append(line + '\n');
			}
			return mapper.readValue(builder.toString(), Gender.class);

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}	
	
	/**
	 * Returns Gender Object based on name and IP
	 * Future
	 * @param name
	 * @param ipAddress
	 * @return
	 */
	public Gender getGenderByIP(String name, String ipAddress){
		BufferedReader reader = null;
		StringBuilder builder = null;
		String line = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			URL url = new URL(genderAPIurl + key + "&name=" + name + "&ip=" + ipAddress);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
  			
			reader  = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			builder = new StringBuilder();

			while ((line = reader.readLine()) != null)
			{
				builder.append(line + '\n');
			}
			return mapper.readValue(builder.toString(), Gender.class);

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}	
	
	/**
	 * Returns Gender Object based on name and country code
	 * Future
	 * @param name
	 * @param country
	 * @return
	 */
    public Gender getGenderByCountry(String name, String country){
		BufferedReader reader = null;
		StringBuilder builder = null;
		String line = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			URL url = new URL(genderAPIurl + key + "&name=" + name + "&country=" + country);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
  			
			reader  = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			builder = new StringBuilder();

			while ((line = reader.readLine()) != null)
			{
				builder.append(line + '\n');
			}
			return mapper.readValue(builder.toString(), Gender.class);

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}	


}
