package com.yassine.films.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yassine.films.entities.Image;

public interface ImageRepository extends JpaRepository<Image , Long> {

}
