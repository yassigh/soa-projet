package com.yassine.films.restcontrollers;

import java.io.IOException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import com.yassine.films.entities.Image;
import com.yassine.films.service.FilmService;
import com.yassine.films.service.ImageService;

@RestController
@RequestMapping("/api/image")
@CrossOrigin(origins = "*")
public class ImageRestController {
	@Autowired
	ImageService imageService;
	@Autowired
	FilmService filmService;
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public Image uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
		return imageService.uplaodImage(file);
	}

	@RequestMapping(value = "/get/info/{id}", method = RequestMethod.GET)
	public Image getImageDetails(@PathVariable("id") Long id) throws IOException {
		return imageService.getImageDetails(id);
	}

	@RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getImage(@PathVariable("id") Long id) throws IOException {
		return imageService.getImage(id);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void deleteImage(@PathVariable("id") Long id) {
		imageService.deleteImage(id);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public Image UpdateImage(@RequestParam("image") MultipartFile file) throws IOException {
		return imageService.uplaodImage(file);
	}

	@PostMapping(value = "/uploadImageFilm/{idFilm}")
	public Image uploadMultiImages(@RequestParam("image") MultipartFile file, @PathVariable("idFilm") Long idFilm)
			throws IOException {
		return imageService.uplaodImageFilm(file, idFilm);
	}

	@RequestMapping(value = "/getImagesFilm/{idFilm}", method = RequestMethod.GET)
	public List<Image> getImagesFilm(@PathVariable("idFilm") Long idFilm) throws IOException {
		return imageService.getImagesParFilm(idFilm);
	}

	
}
