package com.example.projectpraktikum.model.country;

import com.google.gson.annotations.SerializedName;

public class Query{

	@SerializedName("country")
	private String country;

	@SerializedName("month")
	private String month;

	@SerializedName("api_key")
	private String apiKey;

	@SerializedName("year")
	private String year;

	@SerializedName("day")
	private String day;

	public void setCountry(String country){
		this.country = country;
	}

	public String getCountry(){
		return country;
	}

	public void setMonth(String month){
		this.month = month;
	}

	public String getMonth(){
		return month;
	}

	public void setApiKey(String apiKey){
		this.apiKey = apiKey;
	}

	public String getApiKey(){
		return apiKey;
	}

	public void setYear(String year){
		this.year = year;
	}

	public String getYear(){
		return year;
	}

	public void setDay(String day){
		this.day = day;
	}

	public String getDay(){
		return day;
	}

	@Override
 	public String toString(){
		return 
			"Query{" + 
			"country = '" + country + '\'' + 
			",month = '" + month + '\'' + 
			",api_key = '" + apiKey + '\'' + 
			",year = '" + year + '\'' + 
			",day = '" + day + '\'' + 
			"}";
		}
}