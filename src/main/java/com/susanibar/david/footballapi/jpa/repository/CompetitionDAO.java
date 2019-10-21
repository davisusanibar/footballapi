package com.susanibar.david.footballapi.jpa.repository;

import com.susanibar.david.footballapi.jpa.entity.CompetitionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetitionDAO extends JpaRepository<CompetitionEntity, Integer> {
}
