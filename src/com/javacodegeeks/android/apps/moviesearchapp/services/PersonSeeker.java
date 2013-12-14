package com.javacodegeeks.android.apps.moviesearchapp.services;

import java.util.ArrayList;

import android.util.Log;

import com.javacodegeeks.android.apps.moviesearchapp.model.Person;

public class PersonSeeker extends GenericSeeker<Person> {
	
	//private static final String PERSON_SEARCH_PATH = "person/popular?";
	//private static final String PERSON_SEARCH_PATH = "Person.search/";
	private static final String PERSON_SEARCH_PATH = "search/person?";
	
	
	public ArrayList<Person> find(String query) {
		ArrayList<Person> personList = retrievePersonList(query);
		return personList;
	}
	
	public ArrayList<Person> find(String query, int maxResults) {
		ArrayList<Person> personList = retrievePersonList(query);
		return retrieveFirstResults(personList, maxResults);
	}
	
	private ArrayList<Person> retrievePersonList(String query) {
		String url = constructSearchUrl(query);
		String response = httpRetriever.retrieve(url);
		if(response == null){
			Log.e("PersonSeeker", "retrievePersonList response = null");
			return null;
		}else{
			Log.d("PersonSeeker", "retrievePersonList response = " + response);
		}
		return jsonParser.parsePersonResponse(response);
	}
	
	public Person findLatest(){
		return null;
	}

	@Override
	public String retrieveSearchMethodPath() {
		return PERSON_SEARCH_PATH;
	}
}
