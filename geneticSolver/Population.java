package geneticSolver;

import genefighter.Fighter;
import genefighter.FighterUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Trevor on 11/21/2016.
 */
public class Population {

    private static Long populationCount;

    public static List<Fighter> getPopulation() {
        return population;
    }

    public static void setPopulation(List<Fighter> population) {
        Population.population = population;
    }

    private static List<Fighter> population;

    Population(Long populationCount){
        this.populationCount = populationCount;
    }

    public void generatePopulation(){
        population = new ArrayList<Fighter>();
        for(Long i = populationCount; i>0; i--){
            population.add(FighterUtils.createNewFighter());
        }
    }


}
