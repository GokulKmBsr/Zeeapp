package com.zee.zee5app.service;

import com.zee.zee5app.dto.Series;
import com.zee.zee5app.repository.SeriesRepository;


public class SeriesService {

	private SeriesRepository repository = SeriesRepository.getInstance();
	// service is consuming the repository
	
	private SeriesService() {
		// TODO Auto-generated constructor stub
	}
	// if we want ot create that single object then we have to create it
	// inside the same class
	// and we have to share ref with others
	// to do the same we have to declare a method.
	private static SeriesService  service = null;
	// this would be a static 
	// only one copy.
	
	public static SeriesService getInstance() {
		// it  becomes object independant?
		// static will make it independant on the object for execution.
		
		// static method will access only static ref
		if(service==null)
		service = new SeriesService();
		return service;
		
	}
	
	public String addSeries(Series series) {
		// do we need to consume the addUser method from repo.
		return this.repository.addSeries(series);
	}
	
	public Series getSeriesById(String id) {
		return repository.getSeriesById(id);
	}
	public Series[] getSeries() {
		return repository.getSeries();
	}
	
	public String updateSeries(String id, Series series) {
		return repository.updateSeries("ab23", series);
	}
}