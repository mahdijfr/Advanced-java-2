public class HourglassStrategy implements ClockStrategy {

    @Override
    public void updateTimes(ClockState state) {
        if (state.isWhiteTurn) {
            state.whiteTime = (state.whiteTime > state.passedTime) 
                            ? state.whiteTime - state.passedTime 
                            : 0;
            state.blackTime = 2 * state.startingTimeMillis - state.whiteTime;
        } else {
            state.blackTime = (state.blackTime > state.passedTime) 
                            ? state.blackTime - state.passedTime 
                            : 0;
            state.whiteTime = 2 * state.startingTimeMillis - state.blackTime;
        }
    }
    
    @Override
    public void updateTimesAndChangeTurn(ClockState state) {
        state.setIsWhiteTurn(!state.isWhiteTurn);
        state.setPassedTimePlayer(0);
    }
    
}
