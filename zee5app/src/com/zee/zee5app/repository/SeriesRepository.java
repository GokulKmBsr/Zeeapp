package com.zee.zee5app.repository;
import com.zee.zee5app.dto.Series;

public class SeriesRepository {
	
	private Series[] seriess = new Series[10];
	private static int count=-1;
	private SeriesRepository() {
		// TODO Auto-generated constructor stub
	}

	public Series[] getSeries() {
		return seriess;
	}

	public String deleteSeries(String id) {
		return null;
	}

	
	public String updateSeries(String id , Series series) {
		seriess[++count]=series;
		return "added";
	}
	
	public Series getSeriesById(String id) {
		
		for (Series series : seriess) {
			if(series!=null && series.getId().equals(id) ) {
				return series;
			}
		}
		
		return null;
		
	}
	
	// add a new user
	public String addSeries(Series series) {
		

		if(count==seriess.length-1) {

			Series temp[] = new Series[seriess.length*2];
			
			System.arraycopy(seriess, 0, temp, 0, seriess.length);
			seriess= temp;
			seriess[++count] = series;
			
			
			return "success";
			
		}
		seriess[++count] = series;
		return "success";
		
				
		
	}
	private static SeriesRepository seriesRepository;
	public static SeriesRepository getInstance() {
		
		if(seriesRepository==null)
			seriesRepository = new SeriesRepository();
		return seriesRepository;
		
	}

}
