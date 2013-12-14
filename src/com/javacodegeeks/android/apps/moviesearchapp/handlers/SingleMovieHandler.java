package com.javacodegeeks.android.apps.moviesearchapp.handlers;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.javacodegeeks.android.apps.moviesearchapp.model.Movie;

public class SingleMovieHandler extends DefaultHandler {
	
	private StringBuffer buffer = new StringBuffer();
	
	private Movie movie;
	
	@Override
	public void startElement(String namespaceURI, String localName,
			String qName, Attributes atts) throws SAXException {

		buffer.setLength(0);
		
		if (localName.equals("movie")) {
			movie = new Movie();
		}
		
	}
	
	@Override
	public void endElement(String uri, String localName, String qName)throws SAXException {
		
		if (localName.equals("title")) {
			movie.title = buffer.toString();
		}
		else if (localName.equals("id")) {
			movie.id = buffer.toString();
		}
		
	}
	
	@Override
	public void characters(char[] ch, int start, int length) {
		buffer.append(ch, start, length);
	}
	
	public Movie retrieveMovie() {
		return movie;
	}

}
