package comp_graf;

public class Tuple3d {

    public double x;

    public double y;

    public double z;

    /**
     *
     * Constructs a new Tuple class.
     *
     *
     * @param x
     *
     * @param y
     *
     * @param z
     *
     */
    public Tuple3d(double x, double y, double z) {

        this.x = x;

        this.y = y;

        this.z = z;

    }

    @Override

    public String toString() {

        return "[" + x + ":" + y + ":" + z + "]";

    }

}
