public class ClockState {
    
    long whiteTime;
    long blackTime;
    boolean isWhiteTurn;

    long passedTimePlayer;
    long passedTime;
    long startingTimeMillis;

    public ClockState(long startingTimeMillis) {
        whiteTime = startingTimeMillis;
        blackTime = startingTimeMillis;
        isWhiteTurn = true;

        passedTimePlayer = 0;
        passedTime = 0;

        this.startingTimeMillis = startingTimeMillis;
    }
    

    public void setWhiteTime(long whiteTime) {
        this.whiteTime = whiteTime;
    }

    public void setBlackTime(long blackTime) {
        this.blackTime = blackTime;
    }

    public void setIsWhiteTurn(boolean isWhiteTurn) {
        this.isWhiteTurn = isWhiteTurn;
    }

    public void addPassedTimePlayer(long millis) {
        passedTimePlayer += millis;
    }

    public void setPassedTimePlayer(long millis) {
        passedTimePlayer = millis;
    }

    public void setPassedTime(long millis) {
        passedTime = millis;
    }
}
