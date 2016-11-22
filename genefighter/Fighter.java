package genefighter;

public class Fighter {

    GeneType geneType;
    Double health;
    Double attack;
    Long fitness;

    public Long getFitness() {return fitness;}

    public void setFitness(Long fitness) { this.fitness = fitness;}

    public GeneType getGeneType() {
        return geneType;
    }

    public void setGeneType(GeneType geneType) {
        this.geneType = geneType;
    }

    public Double getHealth() {
        return health;
    }

    public void setHealth(Double health) {
        this.health = health;
    }

    public Double getAttack() {
        return attack;
    }

    public void setAttack(Double attack) {
        this.attack = attack;
    }
}
