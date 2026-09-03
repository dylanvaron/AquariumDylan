import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CreatureIO {
    
    private static SeaCreature[] loadCreatures(String fileName) throws IOException {
        FileReader file = new FileReader(fileName);
        Scanner input = new Scanner(file);
        int numberOfCreatures = input.nextInt();
        input.nextLine();

        SeaCreature[] tank = new SeaCreature[numberOfCreatures];
        for (int i = 0; i < tank.length; i++) {
            String line = input.nextLine();
            tank[i] = createCreature(line);
        }

        input.close();
        return tank;
    }

    private static SeaCreature createCreature(String line) {
        Scanner data = new Scanner(line);
        data.useDelimiter(",");
        String classType = data.next();
        String name = data.next();
        int position = data.nextInt();
        int speed = data.nextInt();
        int direction = data.nextInt();

        switch(classType) {
            case "Fish":
                String symbol = data.next();
                return new Fish(name,position,speed,direction,symbol);
                break;
            default:
                return null;
        }

    }
}
