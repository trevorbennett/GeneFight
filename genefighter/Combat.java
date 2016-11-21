package genefighter;


public class Combat {

    private Boolean didUserWinCombat;
    private Boolean isCombatOngoing;
    private Fighter userFighter;
    private Fighter enemyFighter;

    private Double userRemainingHealth;
    private Double enemyRemainingHealth;

    private Double resetUserHealth;

    Combat(Fighter userFighter, Fighter enemyFighter){
        this.userFighter = userFighter;
        this.enemyFighter = enemyFighter;
    }

    public Boolean fight(){
        isCombatOngoing = true;
        resetUserHealth = userFighter.getHealth();
        while(isCombatOngoing){
            nextTurn();
            checkForCombatEnd();
        }
        userFighter.setHealth(resetUserHealth);
        return didUserWinCombat;
    }

    private void checkForCombatEnd() {
        if(enemyFighter.getHealth() <= 0){
            isCombatOngoing = false;
            didUserWinCombat = true;
        }
        else if(userFighter.getHealth() <= 0){
            isCombatOngoing = false;
            didUserWinCombat = false;
        }
    }

    private Double attack(Double attackerAttack, Double DefenderHealth) {
        TypeAdvantage typeAdvantageCalculator = new TypeAdvantage(userFighter.getGeneType(), enemyFighter.getGeneType());
        Double damage = (attackerAttack * Math.random()) * typeAdvantageCalculator.calculateTypeAdvantage();
        return DefenderHealth - damage;
    }

    private void nextTurn(){
        enemyRemainingHealth = attack(userFighter.getAttack(),enemyFighter.getHealth());
        enemyFighter.setHealth(enemyRemainingHealth);
        userRemainingHealth = attack(enemyFighter.getAttack(),userFighter.getHealth());
        userFighter.setHealth(userRemainingHealth);
    }
}
