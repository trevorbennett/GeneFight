package geneticSolver;

import genefighter.Fighter;
import genefighter.FighterUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Trevor on 11/21/2016.
 */
public class Population {

    private Long populationCount;
    private List<Fighter> populationGroup;


    Population(Long populationCount){
        this.populationCount = populationCount;
    }

    public Long getPopulationCount() {
        return populationCount;
    }

    public void generatePopulation(){
        populationGroup = new ArrayList<Fighter>();
        for(Long i = populationCount; i>0; i--){
            populationGroup.add(FighterUtils.createNewFighter());
        }
    }

    public List<Fighter> getPopulationGroup() {
        return populationGroup;
    }

    public void setPopulationGroup(List<Fighter> populationGroup) {
        this.populationGroup = populationGroup;
    }


}
