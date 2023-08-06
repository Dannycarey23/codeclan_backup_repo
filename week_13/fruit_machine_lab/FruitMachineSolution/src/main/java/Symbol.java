public enum Symbol {
    JACKPOT (10),
    CHERRY (8),
    BAR (6),
    BELL (4),
    SEVEN (2);

    private final int winnings;

    Symbol(int winnings) {
        this.winnings = winnings;
    }

    public int getWinnings(){
        return this.winnings;
    }
}