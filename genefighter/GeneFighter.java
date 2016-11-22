package genefighter;

public final class GeneFighter {

    private static Long victories;

    public static void geneFight(Fighter userFighter) {
        Fighter enemyFighter = new Fighter();
        fightSeries(userFighter);
        userFighter.setFitness(victories);


    }

    private static void fightSeries(Fighter userFighter) {
        Fighter enemyFighter = new Fighter();
        Boolean continueCombat = true;
        victories = 0L;

        while(continueCombat){
            enemyFighter = FighterUtils.createNewFighter();
            Combat combat = new Combat(userFighter, enemyFighter);
            continueCombat = combat.fight();
            if(continueCombat)
                victories++;
        }

        //             put in genefight for debugging
        System.out.print("The winner had " + enemyFighter.getAttack() + " attack and was "
                + enemyFighter.getGeneType().toString() + " type! Your Genefighter won " + victories + " times!\n");
    }




}
