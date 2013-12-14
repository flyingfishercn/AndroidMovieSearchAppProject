package com.javacodegeeks.android.apps.moviesearchapp.handlers;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.javacodegeeks.android.apps.moviesearchapp.model.Image;
import com.javacodegeeks.android.apps.moviesearchapp.model.Movie;

public class MovieHandler extends DefaultHandler {
	
	private StringBuffer buffer = new StringBuffer();
	
	private ArrayList<Movie> moviesList;
	private Movie movie;
	private ArrayList<Image> movieImagesList;
	private Image movieImage;
	
	@Override
	public void startElement(String namespaceURI, String localName,
			String qName, Attributes atts) throws SAXException {
		
		buffer.setLength(0);
		
		if (localName.equals("movies")) {
			moviesList = new ArrayList<Movie>();
		}
		else if (localName.equals("movie")) {
			movie = new Movie();
		}
		else if (localName.equals("images")) {
			movieImagesList = new ArrayList<Image>();
		}
		else if (localName.equals("image")) {
			movieImage = new Image();
			movieImage.type = atts.getValue("type");
			movieImage.url = atts.getValue("url");
			movieImage.size = atts.getValue("size");
			movieImage.width = Integer.parseInt(atts.getValue("width"));
			movieImage.height = Integer.parseInt(atts.getValue("height"));
		}

	}
	
	@Override
	public void endElement(String uri, String localName, String qName)throws SAXException {
		
		if (localName.equals("movie")) {
			moviesList.add(movie);
		}
		else if (localName.equals("adult")) {
			movie.adult = Boolean.valueOf(buffer.toString());
		}
		else if (localName.equals("image")) {
			movieImagesList.add(movieImage);
		}	
		else if (localName.equals("images")) {
			movie.imagesList = movieImagesList;
		}
		
	}
	
	@Override
	public void characters(char[] ch, int start, int length) {
		buffer.append(ch, start, length);
	}
		
	public ArrayList<Movie> retrieveMoviesList() {
		return moviesList;
	}

}
