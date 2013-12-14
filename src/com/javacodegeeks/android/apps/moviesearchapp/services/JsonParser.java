package com.javacodegeeks.android.apps.moviesearchapp.services;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import android.util.Log;

import com.javacodegeeks.android.apps.moviesearchapp.model.Movie;
import com.javacodegeeks.android.apps.moviesearchapp.model.Person;

public class JsonParser {
	private static final String TAG = "JsonParser";
	
	public ArrayList<Person> parsePersonResponse(String strPerson) {
		Log.v(TAG, "parsePersonResponse begin");
		ArrayList<Person> alPersonList = new ArrayList<Person>();
		Person person = null;
		try{
		JSONObject jsonObject = new JSONObject(strPerson.trim());
		JSONObject jsonMovieObject = null;
		String filePath = null;
		JSONArray jsonArray = jsonObject.getJSONArray("results");
		
		for (int i = 0; i < jsonArray.length(); i++) {
			person = new Person();
			jsonMovieObject = (JSONObject) jsonArray.getJSONObject(i);
			person.name  = jsonMovieObject.getString("name"); 
			alPersonList.add(person);
			Log.v(TAG, "parsePeopleResponse filePath = "+ filePath);
		}
		}catch(Exception e){
			Log.v(TAG, "exception"+e.getMessage());
		}
		return alPersonList;
	}

	public ArrayList<Movie> parseMovieResponse(String strMovies) {
		Log.v(TAG, "parseMovieResponse begin");
		ArrayList<Movie> alMovieList = new ArrayList<Movie>();
		Movie movie = null;
		try{
		JSONObject jsonObject = new JSONObject(strMovies.trim());
		JSONObject jsonMovieObject = null;
		String filePath = null;
		JSONArray jsonArray = jsonObject.getJSONArray("results");
		
		for (int i = 0; i < jsonArray.length(); i++) {
			movie = new Movie();
			jsonMovieObject = (JSONObject) jsonArray.getJSONObject(i);
			movie.title  = jsonMovieObject.getString("title");
			movie.adult = jsonMovieObject.getBoolean("adult");
			movie.backdrop_path = jsonMovieObject.getString("backdrop_path");;
			movie.id  = jsonMovieObject.getString("id");;
			movie.original_title  = jsonMovieObject.getString("original_title");;
			movie.release_date  = jsonMovieObject.getString("release_date");;
			movie.poster_path  = jsonMovieObject.getString("poster_path");;
			movie.popularity  = jsonMovieObject.getString("popularity");;
			movie.title  = jsonMovieObject.getString("title");;
			movie.vote_average  = jsonMovieObject.getDouble("vote_average");;
			movie.vote_count  = jsonMovieObject.getInt("vote_count");

			alMovieList.add(movie);
			Log.v(TAG, "parseMovieResponse filePath = "+ filePath);
		}
		}catch(Exception e){
			Log.v(TAG, "exception "+e.getMessage());
		}
		Log.v(TAG, "parseMovieResponse alMovieList.size = "+ alMovieList.size());
		return alMovieList;
	}
	
	public Movie parseLatestMovieResponse(String strMovie) {
		Log.v(TAG, "parseLatestMovieResponse begin");
		ArrayList<Movie> alMovieList = new ArrayList<Movie>();
		Movie movie = null;
		try{
		JSONObject jsonMovie = new JSONObject(strMovie.trim());
		
		String filePath = null;
		
		movie = new Movie();

		movie.title  = jsonMovie.getString("title");
		movie.adult = jsonMovie.getBoolean("adult");
		movie.backdrop_path = jsonMovie.getString("backdrop_path");;
		movie.id  = jsonMovie.getString("id");;
		movie.original_title  = jsonMovie.getString("original_title");;
		movie.release_date  = jsonMovie.getString("release_date");;
		movie.poster_path  = jsonMovie.getString("poster_path");;
		movie.popularity  = jsonMovie.getString("popularity");;
		movie.title  = jsonMovie.getString("title");;
		movie.vote_average  = jsonMovie.getDouble("vote_average");;
		movie.vote_count  = jsonMovie.getInt("vote_count");

		Log.v(TAG, "parseMovieResponse filePath = "+ filePath);

		}catch(Exception e){
			Log.v(TAG, "exception "+e.getMessage());
		}
		Log.v(TAG, "parseMovieResponse alMovieList.size = "+ alMovieList.size());
		return movie;
	}
}
