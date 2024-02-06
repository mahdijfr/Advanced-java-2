import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Creature[] creatures = {
            new RoadRunner(),
            new NinjaTurtle("Leonardo"),
            new NinjaTurtle("Raphael"),
            new NinjaTurtle("Donatello"),
            new NinjaTurtle("Michelangelo"),
            new NinjaTurtle("Splinter"),
            new Coyote(),
            new BabyShark(),
            new SpongeBob(),
            new Patrick()
        };
        int[] characterTypes = new int[4];

        Scanner stdin = new Scanner(System.in);
        int inpNums = stdin.nextInt();
        stdin.nextLine();


        for (int i = 0; i < inpNums; i++) {
            String characterName = stdin.nextLine();
            String characterAnswer = stdin.nextLine();

            Creature character = new Creature(characterName) {
                @Override
                public String answer() {
                    return characterAnswer;
                }
            };
            

            boolean added = false;

            for (Creature cr: creatures) {
                if (cr.getName().equals(character.getName())) {
                    characterTypes[(cr.equals(character)) ? 0 : 1]++;
                    added = true;
                    break;
                }
                else if (!cr.getName().equals(character.getName()) && cr.equals(character)){
                    characterTypes[2]++;
                    added = true;
                    break;
                }
            }
            if (!added) {characterTypes[3] += 1;}
        }

        System.out.println("Number of real characters: " + characterTypes[0]);
        System.out.println("Number of fake characters: " + characterTypes[1]);
        System.out.println("Number of lost characters: " + characterTypes[2]);
        System.out.println("Others: " + characterTypes[3]);
        
        stdin.close();
    }
}