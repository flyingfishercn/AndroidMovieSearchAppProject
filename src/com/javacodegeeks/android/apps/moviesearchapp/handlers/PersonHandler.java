package com.javacodegeeks.android.apps.moviesearchapp.handlers;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.javacodegeeks.android.apps.moviesearchapp.model.Image;
import com.javacodegeeks.android.apps.moviesearchapp.model.Person;

public class PersonHandler extends DefaultHandler {
	
	private StringBuffer buffer = new StringBuffer();
	
	private ArrayList<Person> personList;
	private Person person;
	private ArrayList<Image> personImagesList;
	private Image personImage;
	
	@Override
	public void startElement(String namespaceURI, String localName,
			String qName, Attributes atts) throws SAXException {
		
		buffer.setLength(0);
		
		if (localName.equals("people")) {
			personList = new ArrayList<Person>();
		}
		else if (localName.equals("person")) {
			person = new Person();
		}
		else if (localName.equals("images")) {
			personImagesList = new ArrayList<Image>();
		}
		else if (localName.equals("image")) {
			personImage = new Image();
			personImage.type = atts.getValue("type");
			personImage.url = atts.getValue("url");
			personImage.size = atts.getValue("size");
			personImage.width = Integer.parseInt(atts.getValue("width"));
			personImage.height = Integer.parseInt(atts.getValue("height"));
		}

	}
	
	@Override
	public void endElement(String uri, String localName, String qName)throws SAXException {
		
			
		if (localName.equals("image")) {
			personImagesList.add(personImage);
		}	
		else if (localName.equals("images")) {
			person.imagesList = personImagesList;
		}
		
	}
	
	@Override
	public void characters(char[] ch, int start, int length) {
		buffer.append(ch, start, length);
	}
		
	public ArrayList<Person> retrievePersonList() {
		return personList;
	}
	
}
