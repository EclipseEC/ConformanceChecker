package conformance;

/**
 * @(#) ConformanceChecker.java
 */

public class ConformanceChecker
{
    private int missingTokens = 0;
    private int remainingTokens = 0;
    private int consumedTokens = 0;
    private int producedTokens = 0;

    public void addMissingToken(int num) {
        missingTokens += num;
    }

    public void addRemainingToken(int num) {
        remainingTokens += num;
    }

    public void addConsumedToken(int num) {
        consumedTokens += num;
    }

    public void addProducedToken(int num) {
        producedTokens += num;
    }

    public int getMissingTokens() {
        return missingTokens;
    }

    public int getRemainingTokens() {
        return remainingTokens;
    }

    public int getConsumedTokens() {
        return consumedTokens;
    }

    public int getProducedTokens() {
        return producedTokens;
    }

    public double calculateFitnessLeft(double instances) {
        return (instances * missingTokens) / (instances * consumedTokens);
    }

    public double calculateFitnessRight(double instances) {
        return (instances * remainingTokens) / (instances * producedTokens);
    }

    public double calculateSbaTop(double instances, double transitions, double meanTransitions) {
        return instances * (transitions - meanTransitions);
    }

}
