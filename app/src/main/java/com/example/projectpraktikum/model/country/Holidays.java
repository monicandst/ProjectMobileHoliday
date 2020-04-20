package com.example.projectpraktikum.model.country;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Holidays{

	@SerializedName("holidays")
	private ArrayList<CountryDiscoverHolidaysItem> holidays;

	@SerializedName("query")
	private Query query;

	public void setHolidays(ArrayList<CountryDiscoverHolidaysItem> holidays){
		this.holidays = holidays;
	}

	public ArrayList<CountryDiscoverHolidaysItem> getHolidays(){
		return holidays;
	}

	public void setQuery(Query query){
		this.query = query;
	}

	public Query getQuery(){
		return query;
	}

	@Override
 	public String toString(){
		return 
			"Holidays{" + 
			"holidays = '" + holidays + '\'' + 
			",query = '" + query + '\'' + 
			"}";
		}
}