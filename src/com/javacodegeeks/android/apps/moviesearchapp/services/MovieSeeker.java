package com.javacodegeeks.android.apps.moviesearchapp.services;

import java.util.ArrayList;

import android.util.Log;

import com.javacodegeeks.android.apps.moviesearchapp.model.Movie;

public class MovieSeeker extends GenericSeeker<Movie> {
	private final String TAG = "MovieSeeker";	
	private static final String MOVIE_SEARCH_PATH = "search/movie?";
	private static final String LATEST_MOVIE_PATH = "movie/latest?";
	
	public ArrayList<Movie> find(String query) {
		ArrayList<Movie> moviesList = retrieveMoviesList(query);
		return moviesList;
	}
	
	public ArrayList<Movie> find(String query, int maxResults) {
		ArrayList<Movie> moviesList = retrieveMoviesList(query);
		if(moviesList == null){
			Log.e(TAG, "find = moviesList null");
			return null;
		}
		else{
			return retrieveFirstResults(moviesList, maxResults);
		}
	}
	
	private ArrayList<Movie> retrieveMoviesList(String query) {
		String url = constructSearchUrl(query);
		String response = httpRetriever.retrieve(url);
		if(response == null){
			Log.e("MovieSeeker", "retrieveMoviesList response = null");
			return null;
		}else{
			Log.d("MovieSeeker", "retrievePersonList response = " + response);
		}
		
		return jsonParser.parseMovieResponse(response);
	}

	@Override
	public String retrieveSearchMethodPath() {
		return MOVIE_SEARCH_PATH;
	}
	
	public Movie findLatest() {
		String url = constructLatestMovieSearchUrl();
		String response = httpRetriever.retrieve(url);
		Movie movie = jsonParser.parseLatestMovieResponse(response);
		Log.v(TAG, "find response "+response);
		return movie;

	}
	
	private String constructLatestMovieSearchUrl() {
		StringBuffer sb = new StringBuffer();
		sb.append(BASE_URL);
		sb.append(LATEST_MOVIE_PATH);
		sb.append(API_KEY);
		return sb.toString();
	}

}
