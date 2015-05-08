package pfund.tpi.tetridroid.Bricks;

import android.graphics.Color;
import android.media.Image;

import pfund.tpi.tetridroid.R;

/**
 * Titre :       ShapeO
 * Description : Classe qui gere la pièce en forme de Z du jeu
 * Créateur :    Joël Pfund
 * Créé le :     30.04.2015
 * Modifié le :  01.05.2015
 */
public class ShapeZ extends Brick {

    public ShapeZ(){
        super(5, 1, "Red");

        this.vectorBrick.add(new Positionning(-1, -1));
        this.vectorBrick.add(new Positionning(0, -1));
        this.vectorBrick.add(new Positionning(0, 0));
        this.vectorBrick.add(new Positionning(1, 0));

    }
}
