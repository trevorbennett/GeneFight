package genefighter;

import genefighter.GeneType;

/**
 * Created by D532387 on 11/19/2016.
 */
public class TypeAdvantage {

    private GeneType attackerGene;
    private GeneType defenderGene;
    private final Double superEffectiveAttack = 2.0;
    private final Double normalAttack = 2.0;


    TypeAdvantage(GeneType attackerGene, GeneType defenderGene){
        this.attackerGene = attackerGene;
        this.defenderGene = defenderGene;
    }

    public Double calculateTypeAdvantage(){

        Double attackMultiplierDelta = determineIfTypeWekanessExists();
        attackMultiplierDelta *= calculateTypeBasedAttackAndDefenseMultiplier();
        return attackMultiplierDelta;
    }

    private Double calculateTypeBasedAttackAndDefenseMultiplier() {
        Double attackMultiplierDelta = 1.0;
        if(attackerGene.equals(GeneType.FIRE)){ attackMultiplierDelta *=  1.7; }
        if(attackerGene.equals(GeneType.WATER)){ attackMultiplierDelta *= .55; }
        if(attackerGene.equals(GeneType.GRASS)){ attackMultiplierDelta *= 1.2; }
        if(defenderGene.equals(GeneType.FIRE)){ attackMultiplierDelta /=  .6;  }
        if(defenderGene.equals(GeneType.WATER)){ attackMultiplierDelta /= 1.9; }
        if(defenderGene.equals(GeneType.GRASS)){ attackMultiplierDelta /= .85; }
        return attackMultiplierDelta;
    }

    private Double determineIfTypeWekanessExists() {
        if(attackerGene == GeneType.FIRE && defenderGene == GeneType.GRASS){ return superEffectiveAttack; }
        if(attackerGene == GeneType.WATER && defenderGene == GeneType.FIRE){ return superEffectiveAttack; }
        if(attackerGene == GeneType.GRASS && defenderGene == GeneType.WATER){ return superEffectiveAttack; }
        return normalAttack;
    }
}
