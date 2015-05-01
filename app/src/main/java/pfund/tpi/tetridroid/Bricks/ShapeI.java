package pfund.tpi.tetridroid.Bricks;

import android.graphics.Color;

/**
 * Titre :       ShapeI
 * Description : Classe qui gere la barre droite du jeu
 * Créateur :    Joël Pfund
 * Créé le :     30.04.2015
 * Modifié le :  01.05.2015
 */
public class ShapeI extends Brick{

    public ShapeI() {
        super(5, 1, Color.CYAN);

        this.vectorBrick.add(new Positioning(-1, 0));
        this.vectorBrick.add(new Positioning(0, 0));
        this.vectorBrick.add(new Positioning(1, 0));
        this.vectorBrick.add(new Positioning(2, 0));
    }
}
