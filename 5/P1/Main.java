public class Main {
    public static void main(String[] args) {
        ChessClock clock = new ChessClock(new HourglassStrategy(), 100);

        System.out.printf("Is white turn: %b\n", clock.isWhiteTurn());

        clock.passTime(120);
        System.out.println();
        System.out.println("Passed time  " + clock.getePassedPlayerTime());
        System.out.printf("White time: %d\n", clock.getWhiteTime());
        System.out.printf("Black time: %d\n", clock.getBlackTime());

        
        clock.onWhitePress();
        clock.changeSettingAndReset(new BronsteinIncrementStrategy(60), 100);
        System.out.println("Clock pressed");
        System.out.println("Passed time  " + clock.getePassedPlayerTime());
        System.out.printf("White time: %d\n", clock.getWhiteTime());
        System.out.printf("Black time: %d\n", clock.getBlackTime());
        System.out.printf("Is white turn: %b\n", clock.isWhiteTurn());

        clock.passTime(50);
        System.out.println();
        System.out.println("Passed time  " + clock.getePassedPlayerTime());
        System.out.printf("White time: %d\n", clock.getWhiteTime());
        System.out.printf("Black time: %d\n", clock.getBlackTime());
        
        clock.onWhitePress();
        System.out.println("Clock pressed");
        System.out.println("Passed time  " + clock.getePassedPlayerTime());
        System.out.printf("White time: %d\n", clock.getWhiteTime());
        System.out.printf("Black time: %d\n", clock.getBlackTime());
        System.out.printf("Is white turn: %b\n", clock.isWhiteTurn());
    }
}
