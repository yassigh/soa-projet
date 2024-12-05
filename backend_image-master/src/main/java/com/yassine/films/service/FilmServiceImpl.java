package com.yassine.films.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yassine.films.entities.Film;
import com.yassine.films.entities.Genre;
import com.yassine.films.repos.FilmRepository;
import com.yassine.films.repos.ImageRepository;

@Service
public class FilmServiceImpl implements FilmService {

	@Autowired
	FilmRepository filmRepository;

	@Autowired
	ImageRepository imageRepository;

	@Override
	public Film saveFilm(Film f) {
		return filmRepository.save(f);
	}

	@Override
	public Film updateFilm(Film f) {
	Film filmUpdated = filmRepository.save(f);
	return filmUpdated;
	}

	@Override
	public void deleteFilm(Film f) {
		filmRepository.delete(f);
	}

	@Override
	public void deleteFilmById(Long id) {
		filmRepository.deleteById(id);

	}

	@Override
	public Film getFilm(Long id) {
		return filmRepository.findById(id).get();

	}

	@Override
	public List<Film> getAllFilms() {
		return filmRepository.findAll();
	}

	@Override
	public List<Film> findByNomFilm(String nom) {
		return filmRepository.findByNomFilm(nom);
	}

	@Override
	public List<Film> findByNomFilmContains(String nom) {
		return filmRepository.findByNomFilmContains(nom);
	}

	@Override
	public List<Film> findByNomRate(String nom, Double rate) {
		return filmRepository.findByNomRate(nom, rate);
	}

	@Override
	public List<Film> findByGenre(Genre genre) {
		return filmRepository.findByGenre(genre);
	}

	@Override
	public List<Film> findByGenreIdGenre(Long id) {
		return filmRepository.findByGenreIdGenre(id);
	}

	@Override
	public List<Film> findByOrderByNomFilmAsc() {
		return filmRepository.findByOrderByNomFilmAsc();
	}

	@Override
	public List<Film> trierFilmsnomsRates() {
		return filmRepository.trierFilmsnomsRates();
	}

}
