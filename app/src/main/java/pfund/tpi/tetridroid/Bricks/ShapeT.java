package pfund.tpi.tetridroid.Bricks;

import android.graphics.Color;

/**
 * Titre :       ShapeT
 * Description : Classe qui gere la pièce en forme de T du jeu
 * Créateur :    Joël Pfund
 * Créé le :     30.04.2015
 * Modifié le :  01.05.2015
 */
public class ShapeT extends Brick{

    public ShapeT(){
        super(5, 1, "Violet");

        this.vectorBrick.add(new Positionning(-1, 0));
        this.vectorBrick.add(new Positionning(0, -1));
        this.vectorBrick.add(new Positionning(0, 0));
        this.vectorBrick.add(new Positionning(1, 0));
    }
}
