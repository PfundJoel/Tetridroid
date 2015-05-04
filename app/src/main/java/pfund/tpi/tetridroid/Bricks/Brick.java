package pfund.tpi.tetridroid.Bricks;

import android.graphics.Color;
import java.util.Random;
import java.util.Vector;

/*
 * Titre :       Brick
 * Description : Classe qui gere les pièces du jeu, les fait tourner/se deplacer, s'arreter
 * Créateur :    Joël Pfund
 * Créé le :     30.04.2015
 * Modifié le :  01.05.2015
 */

public abstract class Brick {

    private int nbCoord = 4;
    public Vector vectorBrick = new Vector(nbCoord);

    private int coordX, coordY;
    private Color color;

    public Brick(int x, int y, int color) {
        this.coordX = x;
        this.coordY = y;
        // this.color = color; // TODO : Cast couleur / int
    }

    private Random random = new Random();

    public Brick newBrick(){

        int nextBrick = random.nextInt(6);

        switch (nextBrick){
            case 0: return new ShapeI();
            case 1: return new ShapeJ();
            case 2: return new ShapeL();
            case 3: return new ShapeO();
            case 4: return new ShapeS();
            case 5: return new ShapeT();
            default: return new ShapeZ();
        }
    }

    /* Définit la position de chaque élément/bouton de la pièce sur un axe X, Y par
        rapport à un point de référence

        Exemple: 0, -1 => X = 0, donc pas de déplacement latéral et Y = -1, donc un cran vers le haut
                 1,  0 => X = 1, donc un cran à droite et Y = 0 donc pas de déplacement de hauteur
    */
    public class Positionning {
        private int x, y;

        public Positionning(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }

        public Positionning getPlace(int coordX, int coordY) {
            int xCoord = Brick.this.coordX + this.x;
            int yCoord = Brick.this.coordY + this.y;

            return this.getPlace(xCoord, yCoord);
        }
    }
}
