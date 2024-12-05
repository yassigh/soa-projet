package com.yassine.films;

import java.util.Date;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.yassine.films.entities.Film;
import com.yassine.films.entities.Genre;
import com.yassine.films.repos.FilmRepository;

@SpringBootTest
class ProduitsApplicationTests {
@Autowired
private FilmRepository filmRepository;


/*
 * @Test public void testCreateFilm() { Film film = new
 * Film("aka",3,"comedie",new Date()); filmRepository.save(film); }
 * 
 * @Test public void testFindFilm() { Film f =
 * filmRepository.findById(2L).get(); System.out.println(f); }
 * 
 * @Test public void testUpdateFilm() { Film f
 * =filmRepository.findById(1L).get(); f.setRateFilm(1000.0);
 * filmRepository.save(f); }
 * 
 * @Test public void testDeleteFilm() { filmRepository.deleteById(1L);; }
 * 
 * @Test public void testListerTousFilms() { List<Film> films =
 * filmRepository.findAll(); for (Film f : films) { System.out.println(f); } }
 * 
 * public void testFindFilmBynom() { List<Film> films =
 * filmRepository.findByNomFilm("aka"); for (Film f : films) {
 * System.out.println(f); } }
 * 
 * @Test public void testFindByNomProduitContains () { List<Film>
 * films=filmRepository.findByNomFilmContains("a"); for (Film f : films) {
 * System.out.println(f); }}
 */ 
/*
 * @Test public void testfindByNomRate() { List<Film> films =
 * filmRepository.findByNomRate("aka",2.0); for (Film f : films) {
 * System.out.println(f); } }
 */
  
/*
 * @Test public void testfindByGenre() { Genre gen = new Genre();
 * gen.setIdGenre(1L); List<Film> films = filmRepository.findByGenre(gen); for
 * (Film f : films) { System.out.println(f); } }
 */
/*
 * @Test public void findByGenreIdGenre() { List<Film> films =
 * filmRepository.findByGenreIdGenre(1L); for (Film f : films) {
 * System.out.println(f); } }
 */

/*
 * @Test public void testfindByOrderByNomProduitAsc() { List<Film> films =
 * filmRepository.findByOrderByNomFilmAsc(); for (Film f : films) {
 * System.out.println(f); } }
 */

@Test
public void testTrierProduitsNomsPrix()
{
List<Film> films = filmRepository.trierFilmsnomsRates();
for (Film f : films) {
	 System.out.println(f); } }
}
