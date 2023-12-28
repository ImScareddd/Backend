package com.example.hackaton.repository;

import com.example.hackaton.entity.EmotionalScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmotionalScoreRepository extends JpaRepository<EmotionalScore, Long> {
    List<EmotionalScore> findByGoogleId(String googleId);
    @Query(value = "SELECT e FROM EmotionalScore e WHERE e.googleId = :googleId AND e.date >= :startDate ORDER BY e.date ASC")
    List<EmotionalScore> findRecentScores(String googleId, String startDate);
}