import java.util.*;

class Person extends Thread {
    private AirConditioner airConditioner;
    private String name;
    private int testsCount;
    private int repairsCount;

    public Person(AirConditioner airConditioner, String name, int testsCount, int repairsCount) {
        this.airConditioner = airConditioner;
        this.name = name;
        this.testsCount = testsCount;
        this.repairsCount = repairsCount;
    }
    @Override
    public void run() {
        List<Integer> operations = new ArrayList<>();
        for (int i = 0; i < testsCount; i++) {
            operations.add(0);
        }
        for (int i = 0; i < repairsCount; i++) {
            operations.add(1);
        }
        Collections.shuffle(operations);
        for (int operation : operations) {
            if (operation == 0) {
                this.airConditioner.startTesting();
                System.out.println(this.name + " started testing the air conditioner.");
                // Repair the air conditioner
                System.out.println(this.name + " finished testing the air conditioner.");
                this.airConditioner.finishTesting();
                continue;
            }
            this.airConditioner.startRepairing();
            System.out.println(this.name + " started repairing the air conditioner.");
            // Test the air conditioner
            System.out.println(this.name + " finished repairing the air conditioner.");
            this.airConditioner.finishRepairing();
        }
    }
}