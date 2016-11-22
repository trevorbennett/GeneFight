package geneticSolver;

import genefighter.Fighter;
import genefighter.GeneFighter;

/**
 * Created by Trevor on 11/21/2016.
 */
public class Main {
    public static final Long POPULATION_COUNT = 4000L;

    public static void main(String[] args) {

        Population initialPopulation = new Population(POPULATION_COUNT);
        initialPopulation.generatePopulation();
        for (Fighter populationMember: initialPopulation.getPopulation()) {
            GeneFighter.geneFight(populationMember);
        }

    }
}