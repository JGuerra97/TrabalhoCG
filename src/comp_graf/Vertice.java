package comp_graf;

public class Vertice {

    protected int x;
    protected int y;
    
    private Vertice(){
    }
    
    public Vertice(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public void translacao(int x, int y){
        this.x += x;
        this.y += y;
    }
}
