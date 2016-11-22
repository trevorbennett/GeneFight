package geneticSolver;

import genefighter.Fighter;

/**
 * Created by Trevor on 11/22/2016.
 */
public class NaturalSelection {

    private static Long fitnessThreshold;
    private static Long populationCount;

    public static Population naturallySelectNewGeneration(Population currentGeneration){
        populationCount = currentGeneration.getPopulationCount();
        Population newGeneration = new Population(populationCount);

        cullHerd(currentGeneration);



        return newGeneration;
    }

    public static void cullHerd(Population currentGeneration){

        for (Fighter populationMember: currentGeneration.getPopulationGroup()) {
            if(populationMember.getFitness() < (fitnessThreshold / populationCount)){
                currentGeneration.getPopulationGroup().remove(populationMember);
            }
        }
    }

    public void addVictories(Long additionalVictories){fitnessThreshold += additionalVictories;}

    public Long getVictories(){return fitnessThreshold;}

    public void clearVictories(){fitnessThreshold = 0L;}

}
