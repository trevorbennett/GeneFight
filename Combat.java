import java.util.Random;

public class Combat {

    private Boolean didUserWinCombat;
    private Boolean isCombatOngoing;
    private Fighter userFighter;
    private Fighter enemyFighter;

    private Double userRemainingHealth;
    private Double enemyRemainingHealth;

    Combat(Fighter userFighter, Fighter enemyFighter){
        this.userFighter = userFighter;
        this.enemyFighter = enemyFighter;
    }

    public Boolean fight(){
        isCombatOngoing = true;
        while(isCombatOngoing){
            nextTurn();
            checkForCombatEnd();
        }
        return didUserWinCombat;
    }

    private void checkForCombatEnd() {
        if(enemyFighter.getHealth() <= 0){
            isCombatOngoing = false;
            didUserWinCombat = true;
        }
        if(userFighter.getHealth() <= 0){
            isCombatOngoing = false;
            didUserWinCombat = false;
        }
    }

    private Double attack(Double attackerAttack, Double DefenderHealth) {
        return DefenderHealth - (attackerAttack * Math.random());
    }

    private void nextTurn(){
        enemyRemainingHealth = attack(userFighter.getAttack(),enemyFighter.getHealth());
        enemyFighter.setHealth(enemyRemainingHealth);
        userRemainingHealth = attack(enemyFighter.getAttack(),userFighter.getHealth());
        userFighter.setHealth(userRemainingHealth);
    }
}
