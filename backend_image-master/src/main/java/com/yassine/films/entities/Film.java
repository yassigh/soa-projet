package com.yassine.films.entities;
import jakarta.persistence.Entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import jakarta.validation.constraints.Size;
@Entity
public class Film {	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFilm;

    @NotBlank(message = "Le nom du film ne doit pas être vide.")
    @Size(min = 2, max = 10, message = "Le nom du film doit contenir entre 2 et 10 caractres.")
    private String nomFilm;

    @DecimalMin(value = "0.0", inclusive = true, message = "La note du film doit etre un nombre positif.")
    private double rateFilm;

    @NotNull(message = "La date de sortie ne doit pas être null.")
   private Date dateSortie;

    @ManyToOne
    @NotNull(message = "Le genre ne doit pas être null.")
    private Genre genre;
	

	 @OneToMany (mappedBy = "film")
	 private List<Image> images;
	


	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public Film(String nomFilm, float rateFilm, String genre, Date dateSortie) {
		super();
		this.nomFilm = nomFilm;
		this.rateFilm = rateFilm;
		this.dateSortie = dateSortie;
	}

	public Film() {
		super();
		
	}
	
	@Override
	public String toString() {
		return "Film [idFilm=" + idFilm + ", nomFilm=" + nomFilm + ", rateFilm=" + rateFilm +  "]";
	}
	public Long getIdFilm() {
		return idFilm;
	}
	public void setIdFilm(Long idFilm) {
		this.idFilm = idFilm;
	}
	public String getNomFilm() {
		return nomFilm;
	}
	public void setNomFilm(String nomFilm) {
		this.nomFilm = nomFilm;
	}
	public double getRateFilm() {
		return rateFilm;
	}
	public void setRateFilm(double d) {
		this.rateFilm = d;
	}
	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	public Date getDateSortie() {
		return dateSortie;
	}
	public void setDateSortie(Date dateSortie) {
		this.dateSortie = dateSortie;
	}

	

	
}
