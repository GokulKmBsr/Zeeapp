package com.zee.zee5app.service;

import java.util.List;
import java.util.Optional;


import com.zee.zee5app.dto.Episode;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.NameNotFoundException;

public interface EpisodeService {
	
	public String addEpisode(Episode episode);
	public String deleteEpisode(String id) throws IdNotFoundException;
	public String modifyEpisode(String id, Episode episode) throws IdNotFoundException;
	public Optional<Episode> getEpisodeById(String id) throws IdNotFoundException, NameNotFoundException, InvalidIdLengthException;
	public Optional<List<Episode>> getAllEpisode() throws InvalidIdLengthException;

}