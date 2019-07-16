package comp_graf;

import java.awt.Color;
import java.awt.Graphics;
import static java.lang.Math.cos;

public class Objeto3DAviao {

    int[] profundidade = new int[14];

    protected final Face[] faces = new Face[14];

    public Objeto3DAviao() {
        // Bico
        faces[0] = new Face(3, new int[]{0, 50, 50}, new int[]{0, -50, 0}, new int[]{0, 0, -50}); // Triângulo Bico 1
        faces[1] = new Face(3, new int[]{0, 50, 50}, new int[]{0, 0, 50}, new int[]{0, -50, 0}); // Triângulo Bico 2
        faces[2] = new Face(3, new int[]{0, 50, 50}, new int[]{0, 50, 0}, new int[]{0, 0, 50}); // Triângulo Bico 3
        faces[3] = new Face(3, new int[]{0, 50, 50}, new int[]{0, 0, -50}, new int[]{0, 50, 0}); // Triângulo Bico 4

        // Corpo
        faces[4] = new Face(4, new int[]{350, 350, 50, 50}, new int[]{-50, 0, 0, -50}, new int[]{0, -50, -50, 0}); // Retângulo Corpo 1
        faces[5] = new Face(4, new int[]{350, 350, 50, 50}, new int[]{0, 50, 50, 0}, new int[]{-50, 0, 0, -50}); // Retângulo Corpo 2
        faces[6] = new Face(4, new int[]{350, 350, 50, 50}, new int[]{50, 0, 0, 50}, new int[]{0, 50, 50, 0}); // Retângulo Corpo 3
        faces[7] = new Face(4, new int[]{350, 350, 50, 50}, new int[]{0, -50, -50, 0}, new int[]{50, 0, 0, 50}); // Retângulo Corpo 4
        faces[8] = new Face(4, new int[]{350, 350, 350, 350}, new int[]{-50, 0, 50, 0}, new int[]{0, -50, 0, 50}); // Quadrado Fundo

        // Asas
        faces[9] = new Face(3, new int[]{250, 100, 250}, new int[]{0, 0, 0}, new int[]{-50, -50, -250}); // Asa 1
        faces[10] = new Face(3, new int[]{250, 100, 250}, new int[]{0, 0, 0}, new int[]{50, 50, 250}); // Asa 2

        // Barbatanas
        faces[11] = new Face(3, new int[]{350, 350, 300}, new int[]{0, 0, 0}, new int[]{-50, -100, -50}); // Barbatana Lateral 1
        faces[12] = new Face(3, new int[]{350, 350, 300}, new int[]{0, 0, 0}, new int[]{50, 100, 50}); // Barbatana Lateral 2
        faces[13] = new Face(3, new int[]{350, 350, 300}, new int[]{-50, -125, -50}, new int[]{0, 0, 0}); // Barbatana Superior
    }

    public void transformar() {
        for (Face f : faces) {
            f.transformar();
        }
    }

    public void translacao(int x, int y, int z) {
        for (Face f : faces) {
            f.translacao(x, y, z);
        }
    }

    public void escalaX(double sx, int referenciax) {
        for (Face f : faces) {
            f.escalaX(sx, referenciax);
        }
    }

    public void escalaY(double sy, int referenciay) {
        for (Face f : faces) {
            f.escalaY(sy, referenciay);
        }
    }

    public void escalaZ(double sz, int referenciaz) {
        for (Face f : faces) {
            f.escalaZ(sz, referenciaz);
        }
    }

    public void escalaGlobal(double escala, int referenciax, int referenciay, int referenciaz) {
        for (Face f : faces) {
            f.escalaGlobal(escala, referenciax, referenciay, referenciaz);
        }
    }

    public void rotacaoPlanoXY(double angulo, int referenciax, int referenciay, int referenciaz) {
        for (Face f : faces) {
            f.rotacaoPlanoXY(angulo, referenciax, referenciay, referenciaz);
        }
    }

    public void rotacaoPlanoYZ(double angulo, int referenciax, int referenciay, int referenciaz) {
        for (Face f : faces) {
            f.rotacaoPlanoYZ(angulo, referenciax, referenciay, referenciaz);
        }
    }

    public void rotacaoPlanoXZ(double angulo, int referenciax, int referenciay, int referenciaz) {
        for (Face f : faces) {
            f.rotacaoPlanoXZ(angulo, referenciax, referenciay, referenciaz);
        }
    }

    public void rotacaoQuaternio(double angulo, double nx, double ny, double nz) {
        for (Face f : faces) {
            f.rotacaoQuaternio(angulo, nx, ny, nz);
        }
    }

    public void reflexaoX(int referenciax) {
        for (Face f : faces) {
            f.reflexaoX(referenciax);
        }
    }

    public void reflexaoY(int referenciay) {
        for (Face f : faces) {
            f.reflexaoY(referenciay);
        }
    }

    public void reflexaoZ(int referenciaz) {
        for (Face f : faces) {
            f.reflexaoZ(referenciaz);
        }
    }

    public void desenharSolido(Graphics g) {
        SortByDepth(g);
        BackFaceCulling(g);

        for (int i = 0; i < 14; i++) {
            if (i == 0 || i == 1 || i == 2 || i == 4) {
                faces[i].fill(g, new Color((int) (50 * 0.6), (int) (250 * 0.6), (int) (150 * 0.6)));
            } else if (i == 5 || i == 7 || i == 9 || i == 12 || i == 13 || i == 11) {
                faces[i].fill(g, new Color((int) (50 * 0.8), (int) (250 * 0.8), (int) (150 * 0.8)));
            } else {
                faces[i].fill(g, new Color(50, 250, 150));
            }
            faces[i].desenhar(g);

        }

    }

    public void desenhar(Graphics g) {
        //BackFaceCulling(g);

        for (Face f : faces) {
            f.desenhar(g);
        }
    }

    public void BackFaceCulling(Graphics screen) {
        int[] v1 = new int[3];
        int[] v2 = new int[3];
        int[] normal = new int[3];

        for (int w = 0; w < 14; w++) {
            // Cross Product
            v1[0] = faces[w].vertices[1].getX() - faces[w].vertices[0].getX();
            v1[1] = faces[w].vertices[1].getY() - faces[w].vertices[0].getY();
            v1[2] = faces[w].vertices[1].getZ() - faces[w].vertices[0].getZ();
            v2[0] = faces[w].vertices[2].getX() - faces[w].vertices[1].getX();
            v2[1] = faces[w].vertices[2].getY() - faces[w].vertices[1].getY();
            v2[2] = faces[w].vertices[2].getZ() - faces[w].vertices[1].getZ();

            normal[0] = v1[1] * v2[2] - v1[2] * v2[1];
            normal[1] = v1[2] * v2[0] - v1[0] * v2[2];
            normal[2] = v1[0] * v2[1] - v1[1] * v2[0];

            // DotProduct uses POV vector 0,0,POV  as x1,y1,z1
            if ((0 * normal[0] + 0 * normal[1] - 500 * normal[2]) > 0) {
                faces[w].isVisible = true;
            } else {
                faces[w].isVisible = false;
            }
        }
    }

    public void SortByDepth(Graphics g) {
        int profundidade_temp;
        Face temp;

        for (int w = 0; w < 14; w++) {
            if (faces[w].nVertices == 3) {
                profundidade[w] = (faces[w].vertices[0].z + faces[w].vertices[1].z + faces[w].vertices[2].z) / 3;
            } else if (faces[w].nVertices == 4) {
                profundidade[w] = (faces[w].vertices[0].z + faces[w].vertices[1].z + faces[w].vertices[2].z + faces[w].vertices[3].z) / 4;
            }
        }
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 14; j++) {
                if (profundidade[i] < profundidade[j]) {
                    temp = faces[i];
                    faces[i] = faces[j];
                    faces[j] = temp;
                    profundidade_temp = profundidade[i];
                    profundidade[i] = profundidade[j];
                    profundidade[j] = profundidade_temp;
                }
            }
        }
    }
}
