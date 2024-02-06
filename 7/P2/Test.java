
public class Test {
    public static void main(String[] args) {
        AirConditioner airConditioner = new AirConditioner();
        String[] names = {"Nima", "Mohammadreza", "Parsa"};
        for (String name : names) {
            (new Person(airConditioner, name, 2, 1)).start();
        }
    }
}
