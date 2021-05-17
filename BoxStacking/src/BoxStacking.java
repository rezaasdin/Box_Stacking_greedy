import java.util.ArrayList;

// Implementation of "BOX STACKING" using greedy algorithm
// Each time choose a box that has the minimum bearing weight

public class BoxStacking {

    private ArrayList<Box> boxes;
    private ArrayList<Box> res;

    public BoxStacking(ArrayList<Box> box) {

        this.boxes = box;
        res = new ArrayList<>();
    }

    public ArrayList<Box> solve() {

        res = new ArrayList<>();
        int boxSize = boxes.size();

        boolean firstBox = true;


        if (boxSize == 0) {
            return res;
        }


        do {

            res.add(0, findMinTolerableWeight());

            if (!firstBox) {
                if (!check()) {
                    res.remove(0);
                    break;
                }
            }

            firstBox = false;

        } while (boxes.size() != 0);


        return res;

    }

    private boolean check() {

        int sumWeight = 0;

        for (int i = 1; i < res.size(); i++)
            sumWeight += res.get(i).getWeight();

        if (sumWeight > res.get(0).getTolerableWeight())
            return false;
        else
            return true;

    }

    public Box findMinTolerableWeight() {


        int min = 0;
        int index = 0;
        boolean first = true;

        for (int i = 0; i < boxes.size(); i++) {

            int val = boxes.get(i).getTolerableWeight();

            if (first) {
                first = false;
                min = val;
                index = i;
            } else {
                if (val < min) {
                    min = val;
                    index = i;
                }
            }

        }

        Box minTWBox = new Box(boxes.get(index).getTolerableWeight(), boxes.get(index).getWeight());
        boxes.remove(index);

        return minTWBox;

    }

    public ArrayList<Box> getRes() {
        return res;
    }

    public void printResult() {

        if (res.size() == 0) {
            System.out.println("There is no box!");
        } else {

            for (int i = res.size() - 1; i > -1; i--) {

                System.out.println("#" + (i + 1) + " Tolerable weight: " + res.get(i).getTolerableWeight()
                        + " Weight: " + res.get(i).getWeight());

            }

        }

    }

}
