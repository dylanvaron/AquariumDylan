import java.io.IOException;
import java.util.Scanner;

public class AquariumApp {

    public static void main(String[] args) {

        SeaCreature[] tank = new SeaCreature[8];

        try {        
            tank = CreatureIO.loadCreatures("creatures.txt");
        }
        catch (IOException e) {
            System.out.println(e);
        }

        // =====================================================
        // STUDENT TODO
        // =====================================================
        // 1. Create at least TWO additional SeaCreature subclasses.
        // 2. Add objects from those subclasses to this array.
        // 3. Make their movement behavior meaningfully different.
        //
        // Example once you create the class:
        // tank[2] = new Shark(...);
        // tank[3] = new Turtle(...);

        Aquarium aquarium = new Aquarium(tank);
        Scanner input = new Scanner(System.in);

        boolean running = true;

        System.out.println("====================================");
        System.out.println("        JAVA TERMINAL AQUARIUM");
        System.out.println("====================================");

        // The game loop
        while (running) {
            printMenu();
            System.out.print("Choose an option: ");
            String choice = input.nextLine().trim();

            // Switch statement handles menu options
            switch (choice) {
                case "1":
                    aquarium.display();
                    break;

                case "2":
                    aquarium.advanceTurn();
                    aquarium.display();
                    break;

                case "3":
                    aquarium.listCreatureDetails();
                    break;

                case "4":
                    aquarium.feedAll();
                    break;

                case "5":
                    running = false;
                    System.out.println("Aquarium closed. Goodbye!");
                    break;

                default:
                    System.out.println("Please choose 1, 2, 3, 4, or 5.");
            }
        }

        input.close();
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("1. View Aquarium");
        System.out.println("2. Advance One Turn");
        System.out.println("3. View Creature Details");
        System.out.println("4. Feed All The Fish");
        System.out.println("5. Quit");
    }
}
/*
Final Challenge:
We don't want SeaCreature direcly printing an error message itself because we want to leave it up to AquariumApp to decide how to handle that error.
By having SeaCreature throw the error instead of handling itself, it allows for AquariumApp to catch that error and handle it by itself.
This is preferable to having SeaCreature handle the error because it is good program design to allow the frontend to determine how to handle an exception.



*/
