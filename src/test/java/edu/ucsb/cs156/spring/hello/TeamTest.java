package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.beans.Transient;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_compares_same_class() {
        Team team1 = new Team("team1");
        team1.addMember("Ryan");
        team1.addMember("Chiran");

        Team team2 = null;

        assertEquals(false, team1.equals(team2));
    }

    @Test
    public void equals_compares_same_object() {
        Team team1 = new Team("team1");
        team1.addMember("Ryan");
        team1.addMember("Chiran");

        assertEquals(true, team1.equals(team1));
    }

    @Test
    public void equals_returns_correct_equivalence() {
        Team team1 = new Team("team1");
        team1.addMember("Ryan");
        team1.addMember("Chiran");

        Team team2 = new Team("team1");
        team2.addMember("Ryan");
        team2.addMember("Chiran");

        assertEquals(true, team1.equals(team2));
    }

    @Test
    public void equals_returns_correct_members() {
        Team team1 = new Team("team1");
        team1.addMember("Ryan");
        team1.addMember("Chiran");

        Team team2 = new Team("team1");
        team2.addMember("Dave");
        team2.addMember("Anthony");

        assertEquals(false, team1.equals(team2));
    }

    @Test
    public void equals_returns_correct_inequivalence() {
        Team team1 = new Team("team1");
        team1.addMember("Ryan");
        team1.addMember("Chiran");

        Team team2 = new Team("team2");
        team2.addMember("Dave");
        team2.addMember("Anthony");

        assertEquals(false, team1.equals(team2));
    }

    @Test
    public void hashCode_returns_correct_hash() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");
        assertEquals(t1.hashCode(), t2.hashCode());
    }

    @Test
    public void hashCode_returns_correct_hash_mutation_equivalent() {
        int result = team.hashCode();
        int expectedResult = -1226298695;
        assertEquals(expectedResult, result);
    }
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

}
