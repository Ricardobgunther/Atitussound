package br.edu.atitus.atitusound.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.edu.atitus.atitusound.dtos.PlaylistDTO;
import br.edu.atitus.atitusound.entities.ArtistEntity;
import br.edu.atitus.atitusound.entities.MusicEntity;
import br.edu.atitus.atitusound.entities.PlaylistEntity;
import br.edu.atitus.atitusound.services.MusicService;
import br.edu.atitus.atitusound.services.PlaylistService;
import br.edu.atitus.atitusound.services.GenericService;

@RestController
@RequestMapping("/playlists")
public class PlaylistController extends GenericController<PlaylistEntity, PlaylistDTO>{

	private final PlaylistService playlistService;

	public PlaylistController(PlaylistService playlistService) {
		this.playlistService = playlistService;
	}

	protected PlaylistEntity convertDTO2Entity(PlaylistDTO dto) {
		PlaylistEntity playlist = new PlaylistEntity();
		BeanUtils.copyProperties(dto, playlist);
		return playlist;
	}

	@Override
	public GenericService<PlaylistEntity> getService() {
		return playlistService;
	}
}