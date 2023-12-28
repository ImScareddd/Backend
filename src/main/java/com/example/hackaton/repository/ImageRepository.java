package com.example.hackaton.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.hackaton.entity.Image;
import java.awt.*;
import java.util.Optional;

@Repository
public interface ImageRepository extends JpaRepository<Image,Long> {
    Image save(Image image);

    Optional<Image> findByID(Long id);

}
