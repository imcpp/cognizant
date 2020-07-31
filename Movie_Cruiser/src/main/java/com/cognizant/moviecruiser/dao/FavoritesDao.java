package com.cognizant.moviecruiser.dao;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import com.cognizant.moviecruiser.model.Favorites;
import com.cognizant.moviecruiser.model.Movie;

@Service
public class FavoritesDao {
	private final static Logger LOGGER = LoggerFactory.getLogger(FavoritesDao.class);
	public static ArrayList<Favorites> fav_list = new ArrayList<Favorites>();
	List<Movie> movie = new ArrayList<Movie>();
	
	@Autowired
	FavoritesDao favoriteDao;
	
	@Autowired
	MovieDao movieDao;

	public void addFavoritesMovie(int movieId) {
		
		int id=fav_list.size();
		
		Favorites fav=new Favorites(id,1,movieId);
		fav_list.add(fav);
		for (Favorites favourites : fav_list) {
			Movie movie1 = movieDao.findById(favourites.getMv_id());
			
			if(!movie.contains(movie1)) 
				movie.add(movie1);
			LOGGER.debug("fav: {}", fav_list.toString());
		}
		LOGGER.debug("fav: {}", fav_list.toString());
	}
	
	public List<Movie> getAllFavoritesMovies(int userId) throws EmptyFoundException {
		return movie;
	}
	
	public void removeFavoritesMovie(int movieId) {
	    int d=0;
		for(Movie mvy:movie) {
			if(mvy.getId() == movieId) 
					movie.remove(d);
			 else 
				d++;
			}
		LOGGER.debug("fav: {}", fav_list.toString());
	}
}
