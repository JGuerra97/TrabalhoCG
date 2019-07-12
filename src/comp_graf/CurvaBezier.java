package comp_graf;

import java.awt.List;
import java.util.ArrayList;

public class CurvaBezier {

    /**
     *
     * Generates several 3D points in a continuous Bezier curve based upon * the
     * parameter list of points.
     *
     *
     * @param controls
     *
     * @param detail
     *
     * @return
     *
     */
    public static Tuple3d[] getCurvePoints(Tuple3d[] controls, double detail) {

        if (detail > 1 || detail < 0) {

            throw new IllegalStateException("Parâmetro inválido");

        }

        ArrayList<Tuple3d> renderingPoints = new ArrayList<Tuple3d>();

        ArrayList<Tuple3d> controlPoints = new ArrayList<Tuple3d>();

        controlPoints.add(controls[0]);
        controlPoints.add(controls[1]);
        controlPoints.add(controls[2]);
        controlPoints.add(controls[3]);

        //generate the end and control points
        /* for (int i = 0; i < controls.length - 1; i += 2) {

            //controlPoints.add(center(controls[i - 1], controls[i]));
            controlPoints.add(controls[i]);

            controlPoints.add(controls[i + 1]);

            if (i + 2 < controls.length - 1) {

                controlPoints.add(controls[i + 2]);

            }

        } */
        //Generate the detailed points.
        Tuple3d a0, a1, a2, a3;

        for (int i = 0; i < controlPoints.size() - 2; i += 4) {

            a0 = controlPoints.get(i);

            a1 = controlPoints.get(i + 1);

            a2 = controlPoints.get(i + 2);

            if (i + 3 > controlPoints.size() - 1) {

                //quad
                for (double j = 0; j < 1; j += detail) {

                    renderingPoints.add(quadBezier(a0, a1, a2, j));

                }

            } else {

                //cubic
                a3 = controlPoints.get(i + 3);

                for (double j = 0; j < 1; j += detail) {

                    renderingPoints.add(cubicBezier(a0, a1, a2, a3, j));

                }

            }

        }

        Tuple3d[] points = new Tuple3d[renderingPoints.size()];

        renderingPoints.toArray(points);

        return points;

    }

    /**
     *
     * A cubic bezier method to calculate the point at t along the Bezier Curve
     * give
     *
     * the parameter points.
     *
     * @param p1
     *
     * @param p2
     *
     * @param p3
     *
     * @param p4
     *
     * @param t A value between 0 and 1, inclusive.
     *
     * @return
     *
     */
    public static Tuple3d cubicBezier(Tuple3d p1, Tuple3d p2, Tuple3d p3, Tuple3d p4, double t) {

        return new Tuple3d(
                cubicBezierPoint(p1.x, p2.x, p3.x, p4.x, t),
                cubicBezierPoint(p1.y, p2.y, p3.y, p4.y, t),
                cubicBezierPoint(p1.z, p2.z, p3.z, p4.z, t));

    }

    /**
     *
     * A quadratic Bezier method to calculate the point at t along the Bezier
     * Curve give
     *
     * the parameter points.
     *
     * @param p1
     *
     * @param p2
     *
     * @param p3
     *
     * @param t A value between 0 and 1, inclusive.
     *
     * @return
     *
     */
    public static Tuple3d quadBezier(Tuple3d p1, Tuple3d p2, Tuple3d p3, double t) {

        return new Tuple3d(
                quadBezierPoint(p1.x, p2.x, p3.x, t),
                quadBezierPoint(p1.y, p2.y, p3.y, t),
                quadBezierPoint(p1.z, p2.z, p3.z, t));

    }

    /**
     *
     * The cubic Bezier equation.
     *
     *
     * @param a0
     *
     * @param a1
     *
     * @param a2
     *
     * @param a3
     *
     * @param t
     *
     * @return
     *
     */
    private static double cubicBezierPoint(double a0, double a1, double a2, double a3, double t) {

        return Math.pow(1 - t, 3) * a0 + 3 * Math.pow(1 - t, 2) * t * a1 + 3 * (1 - t) * Math.pow(t, 2) * a2 + Math.pow(t, 3) * a3;

    }

    /**
     *
     * The quadratic Bezier equation,
     *
     * @param a0
     *
     * @param a1
     *
     * @param a2
     *
     * @param t
     *
     * @return
     *
     */
    private static double quadBezierPoint(double a0, double a1, double a2, double t) {

        return Math.pow(1 - t, 2) * a0 + 2 * (1 - t) * t * a1 + Math.pow(t, 2) * a2;

    }

    /**
     *
     * Calculates the center point between the two parameter points.
     *
     * @param p1
     *
     * @param p2
     *
     * @return
     *
     */
    public static Tuple3d center(Tuple3d p1, Tuple3d p2) {

        return new Tuple3d(
                (p1.x + p2.x) / 2,
                (p1.y + p2.y) / 2,
                (p1.z + p2.z) / 2
        );

    }

}
