public class ReferenceLab {

    public static void main(String[] args) {

        // ==================================================
        // EXPERIMENT A: ALIASING
        // ==================================================

        SeaCreature nemo = new Fish("Nemo", 5, 3, 1, "><>");
        SeaCreature copy = nemo;

        // PREDICT BEFORE RUNNING:
        // What will copy.getPosition() return after nemo.setPosition(25)?

        // I predict copy.getPosition() will return 25 after nemo.setPosition(25)

        nemo.setPosition(25);

        System.out.println("Experiment A - Aliasing");
        System.out.println("nemo position: " + nemo.getPosition());
        System.out.println("copy position: " + copy.getPosition());

        // ANSWERS:
        // After copy = nemo, how many SeaCreature objects exist?
        //      Only one SeaCreature object exists. copy and nemo are both just references that point to the same SeaCreature in memory.
        // Why does changing nemo also appear when you access copy?
        //      Since nemo and copy point to the same object in memory, changing nemo will also change copy.


        // ==================================================
        // EXPERIMENT B: TWO DIFFERENT OBJECTS
        // ==================================================

        SeaCreature fish1 = new Fish("Fish", 10, 2, 1, "><>");
        SeaCreature fish2 = new Fish("Fish", 10, 2, 1, "><>");

        // PREDICT BEFORE RUNNING:
        // Will fish1 == fish2 be true or false?

        // I predict that fish1 == fish2 will be false

        System.out.println();
        System.out.println("Experiment B - Separate Objects");
        System.out.println("fish1 == fish2: " + (fish1 == fish2));

        // ANSWERS:
        // fish1 and fish2 contain matching data. Predict fish1 == fish2.
        //      I correctly predicted that fish1 == fish2 would be false.
        // What does == compare when it is used with object references?
        //      When used with object references, == compares the pointers to places in memory both object references have. Even though the fish1 and fish2 objects are identical,
        //      they both point to different places in memory, therefore they do not return true when compared with ==.


        // ==================================================
        // EXPERIMENT C: ARRAY REFERENCES
        // ==================================================

        SeaCreature[] tank = new SeaCreature[5];
        tank[0] = new Fish("Bubbles", 8, 1, 1, "><((('>");

        SeaCreature selected = tank[0];

        // PREDICT BEFORE RUNNING:
        // What happens to tank[0] if selected is modified?

        // I predict that the fish in tank[0] will be changed if selected is modified

        selected.setPosition(35);

        System.out.println();
        System.out.println("Experiment C - Array References");
        System.out.println("selected position: " + selected.getPosition());
        System.out.println("tank[0] position: " + tank[0].getPosition());

        // ANSWERS:
        // After selected = tank[0], how many creature objects exist?
        //      Only one SeaCreature object exists. The reference in tank[0] and the reference in selected both point to the same SeaCreature in memory.
        // Why does changing selected also change what you observe through tank[0]?
        //      The selected object reference and the object reference stored in tank[0] both point to the same object in memory. By changing selected, you change what you observe through tank[0].


    }
}
