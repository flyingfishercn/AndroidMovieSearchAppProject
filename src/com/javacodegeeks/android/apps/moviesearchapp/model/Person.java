package com.javacodegeeks.android.apps.moviesearchapp.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Person implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6794898677027141412L;
	public boolean adult;
	public int id;
	public String name;
	public double pupularity;
	public String profile_path;

	public ArrayList<Image> imagesList;
}
