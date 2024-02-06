public class BronsteinIncrementStrategy implements ClockStrategy {
    long increment;

    BronsteinIncrementStrategy(long increment) {
        this.increment = increment;
    }

    @Override
    public void updateTimes(ClockState state) {
        if (state.isWhiteTurn) {
            state.whiteTime = (state.whiteTime > state.passedTime) 
                            ? state.whiteTime - state.passedTime 
                            : 0;
        } else {
            state.blackTime = (state.blackTime > state.passedTime) 
                            ? state.blackTime - state.passedTime 
                            : 0;
        }
    }

    @Override
    public void updateTimesAndChangeTurn(ClockState state) {
        if (state.isWhiteTurn) {
            state.whiteTime += (state.passedTimePlayer < increment) 
                            ? state.passedTimePlayer 
                            : increment;
        } else {
            state.blackTime += (state.passedTimePlayer < increment) 
                            ? state.passedTimePlayer 
                            : increment;
        }
        state.setIsWhiteTurn(!state.isWhiteTurn);
        state.setPassedTimePlayer(0);
    }
    
}
