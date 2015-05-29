package pfund.tpi.tetridroid.Bricks;


import pfund.tpi.tetridroid.R;

/**
 * Titre :       ShapeI
 * Description : Classe qui gere la barre droite du jeu
 * Créateur :    Joël Pfund
 * Créé le :     30.04.2015
 * Modifié le :  24.05.2015
 */
public abstract class ShapeI extends Brick{

    public ShapeI() {

        System.out.println("création de la pièce : " + getCoordX() +" "+ getCoordY());
        
        this.coordBrick[0][0] = getCoordX()  -1;        this.coordBrick[0][1] = getCoordY() + 0;
        this.coordBrick[1][0] = getCoordX() + 0;        this.coordBrick[1][1] = getCoordY() + 0;
        this.coordBrick[2][0] = getCoordX() + 1;        this.coordBrick[2][1] = getCoordY() + 0;
        this.coordBrick[3][0] = getCoordX() + 2;        this.coordBrick[3][1] = getCoordY() + 0;
        System.out.println(this.coordBrick[0][0] +" " +
                this.coordBrick[1][0] +" " +
                this.coordBrick[2][0] +" " +
                this.coordBrick[3][0] +" " +
                this.coordBrick[0][1] +" " +
                this.coordBrick[1][1] +" " +
                this.coordBrick[2][1] +" " +
                this.coordBrick[3][1]);

        brickBackground = R.drawable.bugdroidcyan;
    }
}
