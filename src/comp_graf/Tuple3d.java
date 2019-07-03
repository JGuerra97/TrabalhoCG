package comp_graf;

public class Tuple3d {

    public final double x;

    public final double y;

    public final double z;

    /**
     *
     * Constructs a new Tuple class.      *
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
