package com.yassine.films.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yassine.films.entities.Film;
import com.yassine.films.service.FilmService;



@RestController
@RequestMapping("/api")
@CrossOrigin
public class FilmRESTController {
	@Autowired
	FilmService filmService;
	
	
	@RequestMapping(path="/all",method = RequestMethod.GET)
	public List<Film> getAllFilms() {
	return filmService.getAllFilms();
	}
	@RequestMapping(value="/getbyid/{id}",method = RequestMethod.GET)
	public Film getFilmById(@PathVariable("id") Long id) {
	return filmService.getFilm(id);
	 }
	@RequestMapping(path="/addfilm",method = RequestMethod.POST)
	public Film createFilm(@RequestBody Film film) {
	return filmService.saveFilm(film);
	}

	@RequestMapping(path="/updatefilm",method = RequestMethod.PUT)
	public Film updateFilm(@RequestBody Film film) {
	return filmService.updateFilm(film);
	}
	@RequestMapping(value="/delfilm/{id}",method = RequestMethod.DELETE)
	public void deleteFilm(@PathVariable("id") Long id)
	{
		filmService.deleteFilmById(id);
	}
	@RequestMapping(value="/filmsgenre/{idGenre}",method = RequestMethod.GET)
	public List<Film> getFilmsByGenreId(@PathVariable("idGenre") Long idGenre) {
	return filmService.findByGenreIdGenre(idGenre);
	}


}
