package geneticSolver;

import genefighter.Fighter;
import genefighter.FighterUtils;

import java.util.ArrayList;
import java.util.Iterator;
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

        System.out.print("victories in generation: " + fitnessThreshold + "\n");

        killUnfitPopulation(currentGeneration);
        breedNewGeneration(currentGeneration, newGeneration);
        mutateNewGeneration(newGeneration);

        resetFitnessThreshold();
        return newGeneration;
    }

    public static void resetFitnessThreshold() {
        fitnessThreshold = 0L;
    }

    private static void mutateNewGeneration(Population newGeneration) {
        for (Fighter populationMember: newGeneration.getPopulationGroup()) {
            Boolean willTypeMutate = (Math.random() * 10) >= 8.5;  //10% + 5% for 1/3 chance that mutate arrives at same result
            Boolean willAttackMutate = (Math.random() * 10) >= 8.99; //10% + .1% for the 1/100 chance that mutate arrives at same result

            if (willTypeMutate) {
                FighterUtils.generateRandomType(populationMember);
            }
            if (willAttackMutate) {
                FighterUtils.generateRandomAttackAndHealth(populationMember);
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

    private static Fighter GenerateChildByAlphaParentBiasedGeneticCrossover(Fighter alphaParent, Fighter betaParent) {
        Fighter child = new Fighter();
        Double attack = (alphaParent.getAttack() * .75) + (betaParent.getAttack() *.25);
        child.setGeneType(alphaParent.getGeneType());
        child.setAttack(attack);
        child.setHealth(FighterUtils.calculateHealthBasedOnAttack(attack));
        return child;
    }

    private static Fighter GenerateChildByRandomSinglePointGeneticCrossover(Fighter alphaParent, Fighter betaParent) {
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




    private static void killUnfitPopulation(Population currentGeneration){
        Iterator<Fighter> populationIterator = currentGeneration.getPopulationGroup().iterator();

        while (populationIterator.hasNext()) {
            Fighter populationMember = populationIterator.next();
            if(populationMember.getFitness() < (fitnessThreshold / populationCount)){
                populationIterator.remove();
            }
        }
    }

    public static void addVictories(Long additionalVictories){fitnessThreshold += additionalVictories;}


}
