package geneticSolver;

import genefighter.Fighter;
import genefighter.FighterUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Trevor on 11/22/2016.
 */
public class NaturalSelection {

    private static Long fitnessThreshold;
    private static Long populationCount;

    public static Population naturallySelectNewGeneration(Population currentGeneration){
        populationCount = currentGeneration.getPopulationCount();
        Population newGeneration = new Population(populationCount);

        killUnfitPopulation(currentGeneration);
        breedNewGeneration(currentGeneration, newGeneration);
        mutateNewGeneration(newGeneration);

        return newGeneration;
    }

    private static void mutateNewGeneration(Population newGeneration) {
        for (Fighter populationMember: newGeneration.getPopulationGroup()) {
            Boolean willTypeMutate = (Math.random() * 10) >= 8.5;
            Boolean willAttackMutate = (Math.random() * 10) >= 8.99;

            if (willTypeMutate) {
                FighterUtils.generateRandomType(populationMember);
            }
            if (willAttackMutate) {
                FighterUtils.generateRandomAttack(populationMember);
            }

        }

    }

    private static void breedNewGeneration(Population currentGeneration, Population newGeneration) {
        List<Fighter> newPopulation = new ArrayList<Fighter>();

        for (Fighter populationMember: currentGeneration.getPopulationGroup()) {
            Fighter randomBiasedChild = GenerateChildByAlphaParentBiasedGeneticCrossover(populationMember, currentGeneration.getRandomPopulationMember());
            Fighter parentBiasedChild = GenerateChildByRandomSinglePointGeneticCrossover(populationMember, currentGeneration.getRandomPopulationMember());
            newPopulation.add(randomBiasedChild);
            newPopulation.add(parentBiasedChild);
        }
        newGeneration.setPopulationGroup(newPopulation);
    }

    private static Fighter GenerateChildByRandomSinglePointGeneticCrossover(Fighter alphaParent, Fighter betaParent) {
        Fighter child = new Fighter();
        Double attack = (alphaParent.getAttack() * .75) + (betaParent.getAttack() *.25);
        child.setGeneType(alphaParent.getGeneType());
        child.setAttack(attack);
        child.setHealth(FighterUtils.calculateHealthBasedOnAttack(attack));
        return child;
    }

    private static Fighter GenerateChildByAlphaParentBiasedGeneticCrossover(Fighter alphaParent, Fighter betaParent) {
        Fighter child = new Fighter();
        Double attack = (alphaParent.getAttack() * .5) + (betaParent.getAttack() *.5);
        Boolean isTypeOfAlphaParent = Math.random() < 0.5;
        if(isTypeOfAlphaParent) {
            child.setGeneType(alphaParent.getGeneType());
        } else {
            child.setGeneType(betaParent.getGeneType());
        }
        child.setAttack(attack);
        child.setHealth(FighterUtils.calculateHealthBasedOnAttack(attack));
        return child;
    }




    public static void killUnfitPopulation(Population currentGeneration){

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
