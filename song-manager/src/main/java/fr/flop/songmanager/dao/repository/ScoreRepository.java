package fr.flop.songmanager.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.flop.songmanager.dao.entity.Score;

public interface ScoreRepository extends JpaRepository<Score, Integer> {

}
