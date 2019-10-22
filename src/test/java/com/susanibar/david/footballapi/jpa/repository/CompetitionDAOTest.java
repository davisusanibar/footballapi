package com.susanibar.david.footballapi.jpa.repository;

import com.susanibar.david.footballapi.jpa.entity.CompetitionEntity;
import com.susanibar.david.footballapi.jpa.entity.PlayerEntity;
import com.susanibar.david.footballapi.jpa.entity.TeamEntity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class CompetitionDAOTest {
    @Autowired
    private CompetitionDAO competitionDAO;

    private CompetitionEntity competitionEntity;
    private TeamEntity teamEntity;
    private PlayerEntity playerEntity;

    @Test
    public void validateIfLeagueWasImported() {
        competitionDAO.save(competitionEntity);

        Optional<CompetitionEntity> localCompetitionEntity = competitionDAO.findById(1);

        int quantity = competitionDAO.validateIfLeagueWasImported("CL");

        Assert.assertEquals(1, quantity);
    }

    @Before
    public void init(){
        competitionEntity = new CompetitionEntity(1, "UEFA Champions League", "CL", "Europe");

        teamEntity = new TeamEntity(1, "Chelsea FC", "CHE", "Chelsea", "Europe", "info@chelsea.com");
        competitionEntity.addTeam(teamEntity);

        playerEntity = new PlayerEntity(1, "Cristiano Ronaldo", "Attacker", "1984-12-31", "Portugal", "Portugal");
        teamEntity.addPlayer(playerEntity);
    }

    @Test
    public void save() {
        competitionDAO.save(competitionEntity);

        Optional<CompetitionEntity> localCompetitionEntity = competitionDAO.findById(1);

        Assert.assertEquals(localCompetitionEntity.get().getName(), competitionEntity.getName());
    }

    @Test
    public void totalPlayersByLeague() {
    }
}