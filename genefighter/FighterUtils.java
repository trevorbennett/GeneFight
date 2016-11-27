package genefighter;

public class FighterUtils {

    public static Double calculateHealthBasedOnAttack(Double attack){
        Double calculatedHealth = (Math.pow(100 - attack, 2)
                / (30 + attack)) * 10;
        return calculatedHealth;
    }

    public static void generateRandomAttack(Fighter fighter){
        Double randomAttack = Math.floor(Math.random() * 100);
        fighter.setAttack(randomAttack);
    }

    public static void generateRandomAttackAndHealth(Fighter fighter){
        generateRandomAttack(fighter);
        fighter.setHealth(calculateHealthBasedOnAttack(fighter.getAttack()));
    }
    public static void generateRandomType(Fighter fighter){
        fighter.setGeneType(GeneType.getRandom());
    }

    public static GeneType determineType(String geneTypeString){
        GeneType geneType = GeneType.FIRE;
        if(geneTypeString.equalsIgnoreCase("FIRE")){
            geneType = GeneType.FIRE;
        }
        if(geneTypeString.equalsIgnoreCase("WATER")){
            geneType = GeneType.WATER;
        }
        if(geneTypeString.equalsIgnoreCase("GRASS")){
            geneType = GeneType.GRASS;
        }
        return geneType;
    }

    public static Fighter createNewFighter() {
        Fighter fighter = new Fighter();
        FighterUtils.generateRandomType(fighter);
        FighterUtils.generateRandomAttackAndHealth(fighter);
        return fighter;
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
