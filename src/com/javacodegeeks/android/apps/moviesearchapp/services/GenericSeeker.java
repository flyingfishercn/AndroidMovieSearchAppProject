package com.javacodegeeks.android.apps.moviesearchapp.services;

import java.net.URLEncoder;
import java.util.ArrayList;

import com.javacodegeeks.android.apps.moviesearchapp.model.Movie;

public abstract class GenericSeeker<E> {

	protected static final String BASE_URL = "http://api.themoviedb.org/3/";
	protected static final String LANGUAGE_PATH = "en/";
	protected static final String XML_FORMAT = "xml/";
	protected static final String API_KEY = "api_key=2b84d9349bdc4671e2acc9820b72e449";
	protected static final String SLASH = "/";
	protected static final String BY_PASS = "&";
	protected static final String PREFIX_URL = "query=";

	protected HttpRetriever httpRetriever = new HttpRetriever();
	protected XmlParser xmlParser = new XmlParser();
	protected JsonParser jsonParser = new JsonParser();

	public abstract ArrayList<E> find(String query);
	public abstract E findLatest();

	public abstract ArrayList<E> find(String query, int maxResults);

	public abstract String retrieveSearchMethodPath();
	
	public  String getPrefixUrl(){
		return PREFIX_URL;
	}

	protected String constructSearchUrl(String query) {
		StringBuffer sb = new StringBuffer();
		sb.append(BASE_URL);
		sb.append(retrieveSearchMethodPath());
		//sb.append(LANGUAGE_PATH);
		//sb.append(XML_FORMAT);
		sb.append(API_KEY);
		//sb.append(SLASH);
		sb.append(BY_PASS);
		sb.append(PREFIX_URL);
		sb.append(URLEncoder.encode(query));
		return sb.toString();
	}

	public ArrayList<E> retrieveFirstResults(ArrayList<E> list, int maxResults) {
		ArrayList<E> newList = new ArrayList<E>();
		int count = Math.min(list.size(), maxResults);
		for (int i = 0; i < count; i++) {
			newList.add(list.get(i));
		}
		return newList;
	}

}
