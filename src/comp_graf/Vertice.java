package comp_graf;

public class Vertice {

    protected int x;
    protected int y;
    protected int z;

    private Vertice() {
    }

    public Vertice(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

}
