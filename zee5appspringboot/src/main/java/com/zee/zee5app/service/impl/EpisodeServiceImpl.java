package com.zee.zee5app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Episode;
import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.User;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.exception.NameNotFoundException;
import com.zee.zee5app.repository.EpisodeRepository;
import com.zee.zee5app.service.EpisodeService;
//import com.zee.zee5app.repository.impl.EpisodeRepositoryImpl;

@Service
public class EpisodeServiceImpl implements EpisodeService {
	
	@Autowired
	private EpisodeRepository repository;

	@Override
	public String addEpisode(Episode episode) {
		// TODO Auto-generated method stub
		Episode episode2 = repository.save(episode);
		if (episode2 != null) {
			return "Successfully added episode";
		} else {
			return "failed to add episode";
		}
	}

	@Override
	public String deleteEpisode(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Episode> optional;
		try {
			optional = this.getEpisodeById(id);
			if(optional.isEmpty()) {
				throw new IdNotFoundException("record not found");
			}
			else {
				repository.deleteById(id);
				return " episode deleted  ";
			}
		} catch (IdNotFoundException | InvalidIdLengthException | NameNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IdNotFoundException(e.getMessage());
		}
	}

	@Override
	public String modifyEpisode(String id, Episode episode) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Episode> getEpisodeById(String id)
			throws IdNotFoundException, NameNotFoundException, InvalidIdLengthException {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public Optional<List<Episode>> getAllEpisode() throws InvalidIdLengthException {
		// TODO Auto-generated method stub
		return Optional.ofNullable(repository.findAll());
	}

}