package pfund.tpi.tetridroid.Bricks;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;

import java.util.Random;
import java.util.Vector;

import pfund.tpi.tetridroid.R;

/*
 * Titre :       Brick
 * Description : Classe qui gere les pièces du jeu, les fait tourner/se deplacer, s'arreter
 * Créateur :    Joël Pfund
 * Créé le :     30.04.2015
 * Modifié le :  13.05.2015
 */

public abstract class Brick {

    private int nbCoord = 4;
    public int[][] coordBrick = new int[nbCoord][];

    private int coordX, coordY;
    private String color;
    public int brickBackground;

    public Brick(int x , int y, String color) {
        this.coordX = x;
        this.coordY = y;
        this.color = color;
    }

    public Brick() {
        this.coordX = 5;
        this.coordY = 1;
    }

    private Random random = new Random();


    public Brick newBrick(){

        int nextBrick = random.nextInt(6);

        switch (nextBrick){
            case 0:
                brickBackground = R.drawable.bugdroidcyan;
                return new ShapeI();
            case 1:
                brickBackground = R.drawable.bugdroidblue;
                return new ShapeJ();
            case 2:
                brickBackground = R.drawable.bugdroidorange;
                return new ShapeL();
            case 3:
                brickBackground = R.drawable.bugdroidyellow;
                return new ShapeO();
            case 4:
                brickBackground = R.drawable.bugdroidgreen;
                return new ShapeS();
            case 5:
                brickBackground = R.drawable.bugdroidviolet;
                return new ShapeT();
            default:
                brickBackground = R.drawable.bugdroidred;
                return new ShapeZ();
        }
    }


   /*  Summary :   Deplace la brique en fonction de l'ordre qui lui est envoye.
                    -1 => vers la gauche
                    0  => vers le bas
                    +1 => vers la droite
   *   Param. :    La direction dans laquelle deplacer la forme
   *   Returns:    Nothing
   *   Exception : -
   */
    public void Positionning(byte move) {
        if (move == -1){
            for(int i = 0; i < coordBrick.length; i++) {
                coordBrick[i][0] += move;
            }
        } else if(move == 0){
            for(int i = 0; i < coordBrick.length; i++) {
                coordBrick[i][1] += move;
            }
        } else {
            for(int i = 0; i < coordBrick.length; i++) {
                coordBrick[i][0] += move;
            }
        }
    } // Positionning


   /*  Summary :   Tourne la piece dans le sens contraire des aiguilles d'une montre
   *   Param. :    La forme a faire tourner et le sens dans lequel elle est actuellement
   *   Returns:    Nothing
   *   Exception : -
   */
    public void turnLeft(char shape, int form){

        switch (shape) {
            case 'I':
                switch (form){
                    case 1:
                        form = 2;
                        coordBrick[0][0] += 1;
                        coordBrick[0][1] += 1;
                        coordBrick[2][0] -= 1;
                        coordBrick[2][1] -= 1;
                        coordBrick[3][0] -= 2;
                        coordBrick[3][1] -= 2;
                        break;
                    case 2:
                        form = 3;
                        coordBrick[0][0] += 1;
                        coordBrick[0][1] -= 1;
                        coordBrick[2][0] -= 1;
                        coordBrick[2][1] += 1;
                        coordBrick[3][0] -= 2;
                        coordBrick[3][1] += 2;
                        break;
                    case 3:
                        form = 4;
                        coordBrick[0][0] -= 1;
                        coordBrick[0][1] -= 1;
                        coordBrick[2][0] += 1;
                        coordBrick[2][1] += 1;
                        coordBrick[3][0] += 2;
                        coordBrick[3][1] += 2;
                        break;
                    case 4:
                        form = 1;
                        coordBrick[0][0] -= 1;
                        coordBrick[0][1] += 1;
                        coordBrick[2][0] += 1;
                        coordBrick[2][1] -= 1;
                        coordBrick[3][0] += 2;
                        coordBrick[3][1] -= 2;
                        break;
                }
                break;

            case 'J':
                switch (form){
                    case 1:
                        form = 2;
                        coordBrick[0][0] -= 1;
                        coordBrick[0][1] += 1;
                        coordBrick[2][0] -= 1;
                        coordBrick[2][1] -= 1;
                        coordBrick[3][0] -= 2;
                        coordBrick[3][1] -= 2;
                        break;
                    case 2:
                        form = 3;
                        coordBrick[0][0] += 1;
                        coordBrick[0][1] += 1;
                        coordBrick[2][0] -= 1;
                        coordBrick[2][1] += 1;
                        coordBrick[3][0] -= 2;
                        coordBrick[3][1] += 2;
                        break;
                    case 3:
                        form = 4;
                        coordBrick[0][0] += 1;
                        coordBrick[0][1] -= 1;
                        coordBrick[2][0] += 1;
                        coordBrick[2][1] += 1;
                        coordBrick[3][0] += 2;
                        coordBrick[3][1] += 2;
                        break;
                    case 4:
                        form = 1;
                        coordBrick[0][0] -= 1;
                        coordBrick[0][1] -= 1;
                        coordBrick[2][0] += 1;
                        coordBrick[2][1] -= 1;
                        coordBrick[3][0] += 2;
                        coordBrick[3][1] -= 2;
                        break;
                }
                break;

            case 'L':
                switch (form){
                    case 1:
                        form = 2;
                        coordBrick[0][0] += 2;
                        coordBrick[0][1] += 2;
                        coordBrick[1][0] += 1;
                        coordBrick[1][1] += 1;
                        coordBrick[3][0] -= 1;
                        coordBrick[3][1] += 1;
                        break;
                    case 2:
                        form = 3;
                        coordBrick[0][0] += 2;
                        coordBrick[0][1] -= 2;
                        coordBrick[1][0] += 1;
                        coordBrick[1][1] -= 1;
                        coordBrick[3][0] += 1;
                        coordBrick[3][1] += 1;
                        break;
                    case 3:
                        form = 4;
                        coordBrick[0][0] -= 2;
                        coordBrick[0][1] -= 2;
                        coordBrick[2][0] -= 1;
                        coordBrick[2][1] -= 1;
                        coordBrick[3][0] += 1;
                        coordBrick[3][1] -= 1;
                        break;
                    case 4:
                        form = 1;
                        coordBrick[0][0] -= 2;
                        coordBrick[0][1] += 2;
                        coordBrick[1][0] -= 1;
                        coordBrick[1][1] += 1;
                        coordBrick[3][0] -= 1;
                        coordBrick[3][1] -= 1;
                        break;
                }
                break;

            case 'O':
                break;

            case 'S':
                switch (form){
                    case 1:
                        form = 2;
                        coordBrick[0][0] += 1;
                        coordBrick[0][1] += 1;
                        coordBrick[2][0] -= 1;
                        coordBrick[2][1] += 1;
                        coordBrick[3][0] -= 2;
                        break;
                    case 2:
                        form = 1;
                        coordBrick[0][0] -= 1;
                        coordBrick[0][1] -= 1;
                        coordBrick[2][0] += 1;
                        coordBrick[2][1] -= 1;
                        coordBrick[3][0] += 2;
                        break;
                }
                break;

            case 'T':
                switch (form){
                    case 1:
                        form = 2;
                        coordBrick[0][0] += 1;
                        coordBrick[0][1] += 1;
                        coordBrick[1][0] -= 1;
                        coordBrick[1][1] += 1;
                        coordBrick[3][0] -= 1;
                        coordBrick[3][1] -= 1;
                        break;
                    case 2:
                        form = 3;
                        coordBrick[0][0] += 1;
                        coordBrick[0][1] -= 1;
                        coordBrick[1][0] += 1;
                        coordBrick[1][1] += 1;
                        coordBrick[3][0] -= 1;
                        coordBrick[3][1] += 1;
                        break;
                    case 3:
                        form = 4;
                        coordBrick[0][0] -= 1;
                        coordBrick[0][1] -= 1;
                        coordBrick[2][0] += 1;
                        coordBrick[2][1] -= 1;
                        coordBrick[3][0] += 1;
                        coordBrick[3][1] += 1;
                        break;
                    case 4:
                        form = 1;
                        coordBrick[0][0] -= 1;
                        coordBrick[0][1] += 1;
                        coordBrick[1][0] -= 1;
                        coordBrick[1][1] -= 1;
                        coordBrick[3][0] += 1;
                        coordBrick[3][1] -= 1;
                        break;
                }
                break;

            case 'Z':
                switch (form){
                    case 1:
                        form = 2;
                        coordBrick[0][0] += 2;
                        coordBrick[1][0] += 1;
                        coordBrick[1][1] += 1;
                        coordBrick[3][0] -= 1;
                        coordBrick[3][1] += 1;
                        break;
                    case 2:
                        form = 1;
                        coordBrick[0][0] -= 2;
                        coordBrick[1][0] -= 1;
                        coordBrick[1][1] -= 1;
                        coordBrick[3][0] += 1;
                        coordBrick[3][1] -= 1;
                        break;
                }
                break;
        }
    }// turnLeft


    /*  Summary :   Tourne la piece dans le sens des aiguilles d'une montre
   *   Param. :    La forme a faire tourner et le sens dans lequel elle est actuellement
   *   Returns:    Nothing
   *   Exception : -
   */
    public void turnRight(char shape, int form){

        switch (shape) {
            case 'I':
                switch (form){
                    case 1:
                        form = 4;
                        coordBrick[0][0] += 1;
                        coordBrick[0][1] -= 1;
                        coordBrick[2][0] -= 1;
                        coordBrick[2][1] += 1;
                        coordBrick[3][0] -= 2;
                        coordBrick[3][1] += 2;
                        break;
                    case 2:
                        form = 3;
                        coordBrick[0][0] += 1;
                        coordBrick[0][1] += 1;
                        coordBrick[2][0] -= 1;
                        coordBrick[2][1] -= 1;
                        coordBrick[3][0] -= 2;
                        coordBrick[3][1] -= 2;
                        break;
                    case 3:
                        form = 2;
                        coordBrick[0][0] -= 1;
                        coordBrick[0][1] += 1;
                        coordBrick[2][0] += 1;
                        coordBrick[2][1] -= 1;
                        coordBrick[3][0] += 2;
                        coordBrick[3][1] -= 2;
                        break;
                    case 4:
                        form = 1;
                        coordBrick[0][0] -= 1;
                        coordBrick[0][1] -= 1;
                        coordBrick[2][0] += 1;
                        coordBrick[2][1] += 1;
                        coordBrick[3][0] += 2;
                        coordBrick[3][1] += 2;
                        break;
                }
                break;

            case 'J':
                switch (form){
                    case 1:
                        form = 4;
                        coordBrick[0][0] += 1;
                        coordBrick[0][1] += 1;
                        coordBrick[2][0] -= 1;
                        coordBrick[2][1] += 1;
                        coordBrick[3][0] -= 2;
                        coordBrick[3][1] += 2;
                        break;
                    case 2:
                        form = 3;
                        coordBrick[0][0] -= 1;
                        coordBrick[0][1] += 1;
                        coordBrick[2][0] -= 1;
                        coordBrick[2][1] -= 1;
                        coordBrick[3][0] -= 2;
                        coordBrick[3][1] -= 2;
                        break;
                    case 3:
                        form = 2;
                        coordBrick[0][0] -= 1;
                        coordBrick[0][1] -= 1;
                        coordBrick[2][0] += 1;
                        coordBrick[2][1] -= 1;
                        coordBrick[3][0] += 2;
                        coordBrick[3][1] -= 2;
                        break;
                    case 4:
                        form = 1;
                        coordBrick[0][0] += 1;
                        coordBrick[0][1] -= 1;
                        coordBrick[2][0] += 1;
                        coordBrick[2][1] += 1;
                        coordBrick[3][0] += 2;
                        coordBrick[3][1] += 2;
                        break;
                }
                break;

            case 'L':
                switch (form){
                    case 1:
                        form = 4;
                        coordBrick[0][0] += 2;
                        coordBrick[0][1] -= 2;
                        coordBrick[1][0] += 1;
                        coordBrick[1][1] -= 1;
                        coordBrick[3][0] += 1;
                        coordBrick[3][1] += 1;
                        break;
                    case 2:
                        form = 3;
                        coordBrick[0][0] += 2;
                        coordBrick[0][1] += 2;
                        coordBrick[1][0] += 1;
                        coordBrick[1][1] += 1;
                        coordBrick[3][0] -= 1;
                        coordBrick[3][1] += 1;
                        break;
                    case 3:
                        form = 2;
                        coordBrick[0][0] -= 2;
                        coordBrick[0][1] += 2;
                        coordBrick[2][0] -= 1;
                        coordBrick[2][1] += 1;
                        coordBrick[3][0] -= 1;
                        coordBrick[3][1] -= 1;
                        break;
                    case 4:
                        form = 1;
                        coordBrick[0][0] -= 2;
                        coordBrick[0][1] -= 2;
                        coordBrick[1][0] -= 1;
                        coordBrick[1][1] -= 1;
                        coordBrick[3][0] += 1;
                        coordBrick[3][1] -= 1;
                        break;
                }
                break;

            case 'O':
                break;

            case 'S':
                switch (form){
                    case 1:
                        form = 2;
                        coordBrick[0][0] += 1;
                        coordBrick[0][1] += 1;
                        coordBrick[2][0] -= 1;
                        coordBrick[2][1] += 1;
                        coordBrick[3][0] -= 2;
                        break;
                    case 2:
                        form = 1;
                        coordBrick[0][0] -= 1;
                        coordBrick[0][1] -= 1;
                        coordBrick[2][0] += 1;
                        coordBrick[2][1] -= 1;
                        coordBrick[3][0] += 2;
                        break;
                }
                break;

            case 'T':
                switch (form){
                    case 1:
                        form = 4;
                        coordBrick[0][0] += 1;
                        coordBrick[0][1] -= 1;
                        coordBrick[1][0] += 1;
                        coordBrick[1][1] += 1;
                        coordBrick[3][0] -= 1;
                        coordBrick[3][1] += 1;
                        break;
                    case 2:
                        form = 3;
                        coordBrick[0][0] += 1;
                        coordBrick[0][1] += 1;
                        coordBrick[1][0] -= 1;
                        coordBrick[1][1] += 1;
                        coordBrick[3][0] -= 1;
                        coordBrick[3][1] -= 1;
                        break;
                    case 3:
                        form = 2;
                        coordBrick[0][0] -= 1;
                        coordBrick[0][1] += 1;
                        coordBrick[2][0] -= 1;
                        coordBrick[2][1] -= 1;
                        coordBrick[3][0] += 1;
                        coordBrick[3][1] -= 1;
                        break;
                    case 4:
                        form = 1;
                        coordBrick[0][0] -= 1;
                        coordBrick[0][1] -= 1;
                        coordBrick[1][0] += 1;
                        coordBrick[1][1] -= 1;
                        coordBrick[3][0] += 1;
                        coordBrick[3][1] += 1;
                        break;
                }
                break;

            case 'Z':
                switch (form){
                    case 1:
                        form = 2;
                        coordBrick[0][0] += 2;
                        coordBrick[1][0] += 1;
                        coordBrick[1][1] += 1;
                        coordBrick[3][0] -= 1;
                        coordBrick[3][1] += 1;
                        break;
                    case 2:
                        form = 1;
                        coordBrick[0][0] -= 2;
                        coordBrick[1][0] -= 1;
                        coordBrick[1][1] -= 1;
                        coordBrick[3][0] += 1;
                        coordBrick[3][1] -= 1;
                        break;
                }
                break;
        }
    } // turnRight
}
