public class ChessClock {
    private ClockState state;
    private ClockStrategy strategy;
    private long startingTimeMillis;

    public ChessClock(ClockStrategy strategy, long startingTimeMillis) {
        this.strategy = strategy;
        this.startingTimeMillis = startingTimeMillis;
        state = new ClockState(startingTimeMillis);
    }


    public void changeSettingAndReset(ClockStrategy strategy, long startingTimeMillis) {
        this.strategy = strategy;
        this.startingTimeMillis = startingTimeMillis;
        state = new ClockState(startingTimeMillis);
    }

    public void passTime(long millis) {
        if (!isReachedZero()) {
            state.setPassedTime(millis);
            state.addPassedTimePlayer(millis);
            
            strategy.updateTimes(state);

            state.setPassedTime(0);
        }
    }

    public void onWhitePress() {
        if (state.isWhiteTurn && !isReachedZero()) {
            strategy.updateTimesAndChangeTurn(state);
        }
    }
    
    public void onBlackPress() {
        if (!state.isWhiteTurn && !isReachedZero()) {
            strategy.updateTimesAndChangeTurn(state);
        }
    }

    public long getWhiteTime() {
        return state.whiteTime;
    }

    public long getBlackTime() {
        return state.blackTime;
    }

    public boolean isWhiteTurn() {
        return state.isWhiteTurn;
    }

    public boolean isReachedZero() {
        return (state.whiteTime == 0 || state.blackTime == 0);
    }
}
