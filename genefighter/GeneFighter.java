package genefighter;

public final class GeneFighter {


    public static void main(String[] args) {
        Fighter userFighter = new Fighter();
        createFighterFromParameters(args, userFighter);
        Boolean continueCombat = true;
        Long victories = 0L;

        while(continueCombat){
            Fighter enemyFighter = FighterUtils.createNewEnemyFighter();
            Combat combat = new Combat(userFighter, enemyFighter);
            continueCombat = combat.fight();
            if(continueCombat) {
                victories++;
            } else {
                System.out.print("The winner had " + enemyFighter.getAttack() + " attack and was "
                + enemyFighter.getGeneType().toString() + " type! Your Genefighter won " + victories + " times!\n");
            }
        }
    }

    private static Fighter createFighterFromParameters(String[] args, Fighter userFighter) {
        String userGeneTypeString = args[0];
        String userAttack = args[1];
        userFighter.setGeneType(FighterUtils.determineType(userGeneTypeString));
        userFighter.setAttack(Double.parseDouble(userAttack));
        userFighter.setHealth(FighterUtils.calculateHealthBasedOnAttack(Double.parseDouble(userAttack)));
        return userFighter;
    }

}
