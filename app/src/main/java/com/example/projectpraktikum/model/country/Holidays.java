package com.example.projectpraktikum.model.country;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Holidays{

	@SerializedName("holidays")
	private List<CountryDiscoverHolidaysItem> holidays;

	@SerializedName("query")
	private Query query;

	public void setHolidays(List<CountryDiscoverHolidaysItem> holidays){
		this.holidays = holidays;
	}

	public List<CountryDiscoverHolidaysItem> getHolidays(){
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