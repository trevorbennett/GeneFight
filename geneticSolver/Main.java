package geneticSolver;

import genefighter.GeneFighter;

/**
 * Created by Trevor on 11/21/2016.
 */
public class Main {

    public static final Long population = 4000L;

    public static void main(String[] args) {

        String[] geneFighterParameters = {"GRASS","50"};
        for(Long i = 0L; i< population; i++)
        GeneFighter.main(geneFighterParameters);
    }
}