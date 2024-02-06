public interface ClockStrategy {
    public void updateTimes(ClockState state);
    public void updateTimesAndChangeTurn(ClockState state);
}
