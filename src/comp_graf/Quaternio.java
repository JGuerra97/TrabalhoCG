package comp_graf;

public class Quaternio {

    private double q0;
    private double q1;
    private double q2;
    private double q3;

    public Quaternio(double nx, double ny, double nz, double angulo) {
        double seno = Math.sin(Math.toRadians(angulo / 2));
        double cosseno = Math.cos(Math.toRadians(angulo / 2));
        q0 = cosseno;
        q1 = seno * nx;
        q2 = seno * ny;
        q3 = seno * nz;
    }

    public Quaternio calculaConjugado(Quaternio q) {
        q.q0 = q0;
        q.q1 = -q1;
        q.q2 = -q2;
        q.q3 = -q3;
        return q;
    }

    public double getQ0() {
        return q0;
    }

    public double getQ1() {
        return q1;
    }

    public double getQ2() {
        return q2;
    }

    public double getQ3() {
        return q3;
    }

}
