package com.javacodegeeks.android.apps.moviesearchapp.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Movie implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6814886315783830255L;
	
	public boolean adult;
	public String backdrop_path;
	public String id;
	public String original_title;
	public String release_date;
	public String poster_path;
	public String popularity;
	public String title;
	public double vote_average;
	public int vote_count;
	

	public ArrayList<Image> imagesList;
	
	public String retrieveThumbnail() {
		if (imagesList!=null && !imagesList.isEmpty()) {
			for (Image movieImage : imagesList) {
				if (movieImage.size.equalsIgnoreCase(Image.SIZE_THUMB) &&
						movieImage.type.equalsIgnoreCase(Image.TYPE_POSTER)) {
					return movieImage.url;
				}
			}
		}
		return null;
	}
	
	public String retrieveCoverImage() {
		if (imagesList!=null && !imagesList.isEmpty()) {
			for (Image movieImage : imagesList) {
				if (movieImage.size.equalsIgnoreCase(Image.SIZE_COVER) &&
						movieImage.type.equalsIgnoreCase(Image.TYPE_POSTER)) {
					return movieImage.url;
				}
			}
		}
		return null;
	}

}
