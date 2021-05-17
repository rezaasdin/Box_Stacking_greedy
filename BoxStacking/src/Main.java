import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Box> boxes = new ArrayList<>();
        boxes.add(new Box(4, 1));
        boxes.add(new Box(13, 6));
        boxes.add(new Box(1, 3));
        boxes.add(new Box(5, 2));
        boxes.add(new Box(25, 1));

        BoxStacking boxStacking = new BoxStacking(boxes);
        boxStacking.solve();
        boxStacking.printResult();
    }

}
