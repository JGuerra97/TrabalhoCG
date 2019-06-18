package comp_graf;


public class Quaternio {
   
    private float nx,ny,nz;
    double angulo;
    
    public Quaternio(float nx, float ny, float nz, double angulo) {
        this.nx = nx;
        this.ny = ny;
        this.nz = nz;
        this.angulo = angulo; 
    }
    
    double seno = Math.sin(Math.toRadians(angulo));
    double cosseno = Math.cos(Math.toRadians(angulo));
    
    private double    q0= cosseno/2.0;       // Componente do ângulo
    private double    q1= seno/2.0 * nx;   
    private double    q2= seno/2.0 * ny;  
    private double    q3= seno/2.0 * nz;    
    
    public Quaternio calculaConjugado(Quaternio q){
        q.q0 = q0;
        q.q1 = -q1;
        q.q2 = -q2;
        q.q3 = -q2;
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
