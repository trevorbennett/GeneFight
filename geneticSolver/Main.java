package geneticSolver;

import genefighter.Fighter;
import genefighter.GeneFighter;

/**
 * Created by Trevor on 11/21/2016.
 */
public class Main {
    public static final Long POPULATION_COUNT = 4000L;
    public static NaturalSelection naturalSelection;
    public static void main(String[] args) {

        Population population = new Population(POPULATION_COUNT);
        population.generatePopulation();

        for (Fighter populationMember: population.getPopulationGroup()) {
            GeneFighter.geneFight(populationMember);
            naturalSelection.addVictories(populationMember.getFitness());
        }


    }
}