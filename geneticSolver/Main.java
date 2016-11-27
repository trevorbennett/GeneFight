package geneticSolver;

import genefighter.Fighter;
import genefighter.GeneFighter;

import javax.print.attribute.standard.MediaSize;

/**
 * Created by Trevor on 11/21/2016.
 */
public class Main {
    public static final Long POPULATION_COUNT = 4000L;
    public static void main(String[] args) {
        Population population = new Population(POPULATION_COUNT);
        population.generatePopulation();
        NaturalSelection.resetFitnessThreshold();

        for(int i = 0; i<1000; i++) {
            for (Fighter populationMember : population.getPopulationGroup()) {
                GeneFighter.geneFight(populationMember);
                NaturalSelection.addVictories(populationMember.getFitness());
            }
            population = NaturalSelection.naturallySelectNewGeneration(population);
        }
    }
}