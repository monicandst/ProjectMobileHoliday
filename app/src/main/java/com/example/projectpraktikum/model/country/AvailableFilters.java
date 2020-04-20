package com.example.projectpraktikum.model.country;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class AvailableFilters{

	@SerializedName("languages")
	private ArrayList<String> languages;

	@SerializedName("states")
	private States states;

	public void setLanguages(ArrayList<String> languages){
		this.languages = languages;
	}

	public ArrayList<String> getLanguages(){
		return languages;
	}

	public void setStates(States states){
		this.states = states;
	}

	public States getStates(){
		return states;
	}

	@Override
 	public String toString(){
		return 
			"AvailableFilters{" + 
			"languages = '" + languages + '\'' + 
			",states = '" + states + '\'' + 
			"}";
		}
}