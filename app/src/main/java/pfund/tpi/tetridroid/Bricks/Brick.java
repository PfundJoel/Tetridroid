package pfund.tpi.tetridroid.Bricks;

import java.util.Random;


/*
 * Titre :       Brick
 * Description : Classe qui gere les pièces du jeu, les fait tourner/se deplacer, s'arreter
 * Créateur :    Joël Pfund
 * Créé le :     30.04.2015
 * Modifié le :  24.05.2015
 */
public abstract class Brick {

    private int nbCoord = 4;
    public int[][] coordBrick = new int[nbCoord][];

    private int coordX = 5, coordY = 1;

    public int getCoordX(){
        return coordX;
    }

    public int getCoordY(){
        return coordY;
    }

    public int brickBackground;

    public Brick(int x , int y) {
        this.coordX = x;
        this.coordY = y;
    }
    // Constructeur vide
    public Brick() { }

    private Random random = new Random();

   /*  Summary :   Creer une nouvelle brique a mettre dans la case nextBrick puis a faire apparaitre sur le jeu
   *   Param. :    -
   *   Returns:    Une piece qui a une image de fond (couleur) et des coordonnees pour ses elements
   *   Exception : -
   */
    public Brick newBrick(){

        int nextBrick = random.nextInt(6);

        switch (nextBrick){
            case 0:
                return new ShapeI();
            case 1:
                return new ShapeJ();
            case 2:
                return new ShapeL();
            case 3:
                return new ShapeO();
            case 4:
                return new ShapeS();
            case 5:
                return new ShapeT();
            default:
                return new ShapeZ();
        }
    } // newBrick


   /*  Summary :   Deplace la brique en fonction de l'ordre qui lui est envoye.
                    -1 => vers la gauche
                    0  => vers le bas
                    +1 => vers la droite
   *   Param. :    La direction dans laquelle deplacer la forme
   *   Returns:    Nothing
   *   Exception : -
   */
    public void Positionning(int move) {
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
