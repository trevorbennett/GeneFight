package genefighter;

public final class GeneFighter {

    private static Long victories;

    public static Long geneFight(Fighter userFighter) {
        Fighter enemyFighter = new Fighter();
        fightSeries(userFighter);
        return victories;
    }

    private static void fightSeries(Fighter userFighter) {
        Fighter enemyFighter;
        Boolean continueCombat = true;

        while(continueCombat){
            enemyFighter = FighterUtils.createNewFighter();
            Combat combat = new Combat(userFighter, enemyFighter);
            continueCombat = combat.fight();
            if(continueCombat)
                victories++;
        }
    }


    //          put in genefight for debugging
//        System.out.print("The winner had " + enemyFighter.getAttack() + " attack and was "
//                + enemyFighter.getGeneType().toString() + " type! Your Genefighter won " + victories + " times!\n");


}
