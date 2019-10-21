package com.susanibar.david.footballapi.jpa.repository;

import com.susanibar.david.footballapi.jpa.entity.CompetitionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetitionDAO extends JpaRepository<CompetitionEntity, Integer> {

    @Query(
            "SELECT COUNT(c) FROM CompetitionEntity c " +
            "WHERE c.code = :leagueCode"
    )
    int validateIfLeagueWasImported(@Param("leagueCode") String leagueCode);

    @Query(
            "SELECT COUNT(c) FROM CompetitionEntity c " +
                "RIGHT JOIN TeamEntity t " +
                    "ON c.code = :leagueCode " +
                    "AND c.id = t.competition " +
                "RIGHT JOIN PlayerEntity p " +
                    "ON t.id = p.team"
    )
    int totalPlayersByLeague(@Param("leagueCode") String leagueCode);
}
