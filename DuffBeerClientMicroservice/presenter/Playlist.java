package com.duff.client.presenter;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class Playlist.
 */
public class Playlist {

	/** The beer name. */
	private String name;

	/** The tracks. */
	private List<Track> tracks;

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the tracks.
	 *
	 * @return the tracks
	 */
	public List<Track> getTracks() {
		if (tracks == null) {
			tracks = new ArrayList<>();
		}
		return tracks;
	}

	/**
	 * Sets the tracks.
	 *
	 * @param tracks
	 *            the new tracks
	 */
	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;
	}

}