package com.duff.client.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duff.client.param.SpotifyParam;
import com.duff.client.presenter.BeerPresenter;
import com.duff.client.presenter.Playlist;
import com.duff.client.presenter.Track;
import com.google.common.collect.Lists;
import com.neovisionaries.i18n.CountryCode;
import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.specification.ArtistSimplified;
import com.wrapper.spotify.model_objects.specification.PlaylistSimplified;
import com.wrapper.spotify.model_objects.specification.PlaylistTrack;
import com.wrapper.spotify.requests.data.playlists.GetPlaylistRequest;
import com.wrapper.spotify.requests.data.search.simplified.SearchPlaylistsRequest;

/**
 * The Class SpotifyService.
 */
@Service
public class SpotifyService implements ISpotifyService {

	/** The spotify param. */
	@Autowired
	private SpotifyParam spotifyParam;
	
	
	/* (non-Javadoc)
	 * @see com.duff.client.service.ISpotifyService#findPlaylistByName(java.lang.String)
	 */
	@Override
	public Playlist findPlaylistByName(String name) {
		Playlist playlist = new Playlist();
		try {
			final SearchPlaylistsRequest searchPlaylistsRequest = spotifyApi().searchPlaylists(name)
					.market(CountryCode.BR).limit(1).offset(0).build();

			final PlaylistSimplified[] playlistSimplified = searchPlaylistsRequest.execute().getItems();
			PlaylistSimplified play = Lists.newArrayList(playlistSimplified).get(0);
			playlist.setName(play.getName());

			final GetPlaylistRequest getPlaylistRequest = spotifyApi().getPlaylist(play.getOwner().getId(), play.getId())
					.market(CountryCode.BR).build();
			final com.wrapper.spotify.model_objects.specification.Playlist playlistSpotify = getPlaylistRequest
					.execute();
			List<PlaylistTrack> tracks = Lists.newArrayList(playlistSpotify.getTracks().getItems());
			tracks.stream().map(trck -> convertTrackToPresenter(trck)).forEach(playlist.getTracks()::add);

		} catch (IOException | SpotifyWebApiException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return playlist;
	}

	/**
	 * Convert track to presenter.
	 *
	 * @param playlistTrack the playlist track
	 * @return the track
	 */
	private Track convertTrackToPresenter(PlaylistTrack playlistTrack) {
		Track track = new Track(); 
		track.setArtist(Lists.newArrayList(playlistTrack.getTrack().getArtists()).stream().map(ArtistSimplified::getName).collect(Collectors.joining(",")));
		track.setLink(playlistTrack.getTrack().getHref());
		track.setName(playlistTrack.getTrack().getName());
		return track;

	}

	/* (non-Javadoc)
	 * @see com.duff.client.service.ISpotifyService#findPlaylistByBeerNameStyle(java.util.List)
	 */
	@Override
	public List<BeerPresenter> findPlaylistByBeerNameStyle(List<String> name) {
		List<BeerPresenter> beerPresenters =  new ArrayList<>();
		name.stream().forEach(nm ->{
			BeerPresenter beerPresenter =  new BeerPresenter();
			beerPresenter.setBeerStyle(nm);
			beerPresenter.setPlaylist(findPlaylistByName(nm));
			beerPresenters.add(beerPresenter);
		});
		return beerPresenters;
	}
	
	/**
	 * Spotify api.
	 *
	 * @return the spotify api
	 */
	private SpotifyApi spotifyApi() {
		return SpotifyAbstractService.getSpotifyApiAccess(spotifyParam);
	}
	

}
