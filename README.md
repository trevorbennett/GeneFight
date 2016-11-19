# GeneFight

Genefight is a simple example of a genetic algolrithm at work, with the goal of attempting to find the optimal 'genefighter'.

## What is a genefighter?

A genefighter is sort of like a simplied version of a pokemon. It has three interlinked attributes, called type, attack, and health. The meanings of these attributes are as follows:

Attack - A random number between 0-100. Each singular attack in a round of combat is a random damage value from (0 - attack)
Health - A value given by the formula (100-attack)^2/(30+attack) * 10, which gives health a range of (0 - 3,333)
Type - FIRE, WATER, or GRASS.

### More on types

Fire type: offense biased, Fire type does 1.7x damage but only blocks .6x damage
Water type: defense biased, Water type does .55x but blocks 1.9x damage
Grass type: slightly offense biased, Grass type does 1.2x damage, but only blocks .85x damage

In addition, fire attacks deal double damage to grass, water attacks deal double damage to fire, and grass attacks deal double damage to water.

## So what's the goal of all this?

The goal is to determine the best genefighter. The problem is sufficiently complex enough that random guessing of type type and attack will not produce an intuitive optimal solution, and since the field of solution sets produces a series of local maxmiums with no way of guarenteeing an absolute maximum, the problem is suitable to be solved via a genetic algorithm.
