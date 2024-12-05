package com.yassine.films.restcontrollers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yassine.films.entities.Genre;
import com.yassine.films.repos.GenreRepository;


@RestController
@RequestMapping("/api/genre")
 @CrossOrigin("*") 

public class GenreRestController {
	@Autowired
	GenreRepository genreRepository;
	@RequestMapping(method=RequestMethod.GET)
	public List<Genre> getAllGenres()
	{
	return genreRepository.findAll();
	}
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Genre getGenreById(@PathVariable("id") Long id) {
	return genreRepository.findById(id).get();
	}

}
