package com.yassine.films.repos;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.yassine.films.entities.Film;
import com.yassine.films.entities.Genre;

@RepositoryRestResource(path = "rest")

public interface FilmRepository extends JpaRepository<Film, Long> {

	List<Film> findByNomFilm(String nom);
	// meme une partie de nom
	 List<Film> findByNomFilmContains(String nom); 
 @Query("select f from Film f where f.nomFilm like %:nom and f.rateFilm > :rate")
	 List<Film> findByNomRate (@Param("nom") String nom,@Param("rate") Double rate);
	 
	 @Query("select f from Film f where f.genre = ?1")
	 List<Film> findByGenre (Genre genre);
	 List<Film> findByGenreIdGenre(Long id);
	 List<Film> findByOrderByNomFilmAsc();
	 @Query("select f from Film f order by f.nomFilm ASC, f.rateFilm DESC")
	 List<Film> trierFilmsnomsRates ();
}
