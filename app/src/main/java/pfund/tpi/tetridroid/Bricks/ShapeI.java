package pfund.tpi.tetridroid.Bricks;


import pfund.tpi.tetridroid.R;

/**
 * Titre :       ShapeI
 * Description : Classe qui gere la barre droite du jeu
 * Créateur :    Joël Pfund
 * Créé le :     30.04.2015
 * Modifié le :  24.05.2015
 */
public class ShapeI extends Brick{

    public ShapeI() {
        super(5, 1);

        this.coordBrick[0][0] = -1;        this.coordBrick[0][1] = 0;
        this.coordBrick[1][0] = 0;        this.coordBrick[1][1] = 0;
        this.coordBrick[2][0] = 1;        this.coordBrick[2][1] = 0;
        this.coordBrick[3][0] = 2;        this.coordBrick[3][1] = 0;

        brickBackground = R.drawable.bugdroidcyan;
    }
}
