
public class FighterUtils {

    public static Double calculateHealthBasedOnAttack(Double attack){
        Double calculatedHealth = (Math.pow(100 - attack, 2)
                / (30 + attack)) * 10;
        return calculatedHealth;
    }

    public static void generateRandomAttack(Fighter fighter){
        Double randomAttack = Math.random() * 100;
        fighter.setAttack(randomAttack);
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

    public static Fighter createNewEnemyFighter() {
        Fighter enemyFighter = new Fighter();
        FighterUtils.generateRandomType(enemyFighter);
        FighterUtils.generateRandomAttack(enemyFighter);
        enemyFighter.setHealth(FighterUtils.calculateHealthBasedOnAttack(enemyFighter.getAttack()));
        return enemyFighter;
    }
}
