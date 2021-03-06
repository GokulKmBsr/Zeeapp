package com.zee.zee5app.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Series;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.NameNotFoundException;
import com.zee.zee5app.service.SeriesService;
import com.zee.zee5app.repository.SeriesRepository;
//import com.zee.zee5app.repository.impl.SeriesRepositoryImpl;

@Service
public class SeriesServiceImpl implements SeriesService {
	
	@Autowired
	private SeriesRepository seriesRepository;

	@Override
	public String addSeries(Series series) {
		// TODO Auto-generated method stub
		Series series2 = seriesRepository.save(series);
		if (series2 != null) {
			return "Successfully added series";
		} else {
			return "failed toadd series";
		}
		//return null;
	}

	@Override
	public String deleteSeries(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Series> optional;
		try {
			optional = this.getSeriesById(id);
			if(optional.isEmpty()) {
				throw new IdNotFoundException("record not found");
			}
			else {
				seriesRepository.deleteById(id);
				return "series deleted";
			}
		} catch (IdNotFoundException | InvalidIdLengthException | NameNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IdNotFoundException(e.getMessage());
		}
		//return null;
	}

	@Override
	public String modifySeries(String id, Series series) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Series> getSeriesById(String id)
			throws IdNotFoundException, NameNotFoundException, InvalidIdLengthException {
		// TODO Auto-generated method stub
		return seriesRepository.findById(id);
		//return null;
	}

	@Override
	public Optional<List<Series>> getAllSeries() throws NameNotFoundException, InvalidIdLengthException {
		// TODO Auto-generated method stub
		return Optional.ofNullable(seriesRepository.findAll());
		//return null;
	}

//	private SeriesRepository repository = SeriesRepositoryImpl.getInstance();
//	private static SeriesService service;	
//	
//	public static SeriesService getInstance() throws IOException{
//		if(service == null)
//			service = new SeriesServiceImpl();
//		return service;
//	}
//	
//    private SeriesServiceImpl() throws IOException {
//		
//	}

//	@Override
//	public String addSeries(Series series) {
//		// TODO Auto-generated method stub
//		return this.repository.addSeries(series);
//	}
//
//	@Override
//	public String deleteSeries(String id) throws IdNotFoundException {
//		// TODO Auto-generated method stub
//		return this.repository.deleteSeries(id);
//	}
//
//	@Override
//	public String modifySeries(String id, Series series) throws IdNotFoundException {
//		// TODO Auto-generated method stub
//		return this.repository.modifySeries(id, series);
//	}
//
//	@Override
//	public Optional<Series> getSeriesById(String id) throws IdNotFoundException, NameNotFoundException, InvalidIdLengthException {
//		// TODO Auto-generated method stub
//		return this.repository.getSeriesById(id);
//	}
//
//	@Override
//	public Optional<List<Series>> getAllSeries() throws NameNotFoundException, InvalidIdLengthException {
//		// TODO Auto-generated method stub
//		return this.repository.getAllSeries();
//	}
	
//	@Override
//	public String addSeries(Series series) {
//		// TODO Auto-generated method stub
//		return this.repository.addSeries(series);
//	}
//
//	@Override
//	public Series getSeriesById(String id) {
//		// TODO Auto-generated method stub
//		return this.repository.getSeriesById(id);
//	}
//
//	@Override
//	public Series[] getAllSeries() {
//		// TODO Auto-generated method stub
//		return repository.getAllSeries();
//	}

}