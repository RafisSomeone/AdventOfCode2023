class Condition {
    int maxRedCounter;
    int maxGreenCounter;
    int maxBlueCounter;

    public Condition(int maxRed, int maxGreen, int maxBlue) {
        this.maxRedCounter = maxRed;
        this.maxGreenCounter = maxGreen;
        this.maxBlueCounter = maxBlue;
    }

    public boolean isGamePossible(Game game) {
        return game.rounds().stream().allMatch(this::isRoundPossible);
    }

    private boolean isRoundPossible(Round round) {
        return round.blueCounter() <= maxBlueCounter && round.greenCounter() <= maxGreenCounter && round.redCounter() <= maxRedCounter;
    }
}
