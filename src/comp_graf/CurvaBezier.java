package comp_graf;

import java.awt.List;
import java.util.ArrayList;

public class CurvaBezier {

    public static Tuple3d[] getCurvePoints(Tuple3d[] controls, double detail) {

        if (detail > 1 || detail < 0) {

            throw new IllegalStateException("Parâmetro inválido");

        }

        ArrayList<Tuple3d> pontosRenderizacao = new ArrayList<Tuple3d>();
        ArrayList<Tuple3d> pontosControle = new ArrayList<Tuple3d>();

        pontosControle.add(controls[0]);
        pontosControle.add(controls[1]);
        pontosControle.add(controls[2]);
        pontosControle.add(controls[3]);
        Tuple3d a0, a1, a2, a3;

        for (int i = 0; i < pontosControle.size() - 2; i += 4) {

            a0 = pontosControle.get(i);
            a1 = pontosControle.get(i + 1);
            a2 = pontosControle.get(i + 2);
            a3 = pontosControle.get(i + 3);

            for (double j = 0; j < 1; j += detail) {

                pontosRenderizacao.add(cubicBezier(a0, a1, a2, a3, j));

            }

        }

        Tuple3d[] points = new Tuple3d[pontosRenderizacao.size()];

        pontosRenderizacao.toArray(points);

        return points;

    }

    public static Tuple3d cubicBezier(Tuple3d p1, Tuple3d p2, Tuple3d p3, Tuple3d p4, double t) {

        return new Tuple3d(
                cubicBezierPoint(p1.x, p2.x, p3.x, p4.x, t),
                cubicBezierPoint(p1.y, p2.y, p3.y, p4.y, t),
                cubicBezierPoint(p1.z, p2.z, p3.z, p4.z, t));

    }

    private static double cubicBezierPoint(double a0, double a1, double a2, double a3, double t) {

        return Math.pow(1 - t, 3) * a0 + 3 * Math.pow(1 - t, 2) * t * a1 + 3 * (1 - t) * Math.pow(t, 2) * a2 + Math.pow(t, 3) * a3;

    }

}
