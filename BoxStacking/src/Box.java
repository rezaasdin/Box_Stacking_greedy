public class Box {

    private int weight;
    private int tolerableWeight;

    private boolean placed;

    public Box(int tolerableWeight, int weight) {
        this.weight = weight;
        this.tolerableWeight = tolerableWeight;
        placed = false;
    }

    public int getWeight() {
        return weight;
    }

    public int getTolerableWeight() {
        return tolerableWeight;
    }

    public boolean isPlaced() {
        return placed;
    }

    public void setPlaced(boolean placed) {
        this.placed = placed;
    }

}
