package com.example.hackaton.repository;

import com.example.hackaton.entity.EmotionalScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmotionalScoreRepository extends JpaRepository<EmotionalScore, Long> {
    List<EmotionalScore> findByGoogleId(long googleId);
}