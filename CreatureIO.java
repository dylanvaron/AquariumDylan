import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CreatureIO {
    
    public static SeaCreature[] loadCreatures(String fileName) throws IOException {
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

    public static SeaCreature createCreature(String line) {
        Scanner data = new Scanner(line);
        data.useDelimiter(",");
        String classType = data.next();
        String name = data.next();
        int position = data.nextInt();
        int speed = data.nextInt();
        int direction = data.nextInt();
        String symbol = data.next();

        try {
            switch(classType) {
                case "Fish":
                    data.close();
                    return new Fish(name,position,speed,direction,symbol);
                case "Jellyfish":
                    String symbol2 = data.next();
                    data.close();
                    return new Jellyfish(name,position,speed,direction,symbol,symbol2);
                case "ClownFish":
                    String symbolSmile = data.next();
                    int maxCount = data.nextInt();
                    data.close();
                    return new ClownFish(name,position,speed,direction,symbol,symbolSmile,maxCount);
                default:
                    data.close();
                    return null;
            }
        }
        catch(InvalidCreatureException e) {
            System.out.println("Invalid creature made.");
            System.out.println(e.getMessage());
            data.close();
            return null;
        }

    }
}
