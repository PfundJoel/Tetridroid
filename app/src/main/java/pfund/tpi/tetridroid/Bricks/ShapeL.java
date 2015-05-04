package pfund.tpi.tetridroid.Bricks;

import android.graphics.Color;

/**
 * Titre :       ShapeL
 * Description : Classe qui gere la pièce en forme de L du jeu
 * Créateur :    Joël Pfund
 * Créé le :     30.04.2015
 * Modifié le :  01.05.2015
 */
public class ShapeL extends Brick {

    public ShapeL(){
        super(5, 1, Color.LTGRAY); // TODO : METTRE DU ORANGE

        this.vectorBrick.add(new Positionning(0, 0));
        this.vectorBrick.add(new Positionning(1, 0));
        this.vectorBrick.add(new Positionning(2, 0));
        this.vectorBrick.add(new Positionning(2, -1));
    }
}
