package com.yassine.films.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomFilm", types = { Film.class })

public interface FilmProjection {
	public String getNomFilm();

}
