package pfund.tpi.tetridroid.Bricks;

import java.util.Random;


/*
 * Title :       Brick
 * Description : Abstract that will manage the game pieces. It makes it turn, going down or stop
 * Creator :     Joel Pfund
 * Created :     30.04.2015
 * Modified :    30.05.2015
 */
public abstract class Brick {

    public int[][] coordBrick = new int[4][2];

    private int coordX = 4;
    private int coordY = 1;

    public int getCoordX(){
        return coordX;
    }
    public int getCoordY(){
        return coordY;
    }

    public void setCoordX(int CoordX){
        this.coordX = CoordX;
    }
    public void setCoordY(int CoordY){
        this.coordY = CoordY;
    }

    public int brickBackground;

    public Brick(int x , int y) {
        this.coordX = x;
        this.coordY = y;

    }

    // Constructeur vide
    public Brick() { }

    private Random random = new Random();

    /*  Summary :   Create a new brick with a shape
    *   Param. :    -
    *   Returns:    A brick to put on the game grid with a shape, a background and coordonates
    *   Exception : -
    */
    public Brick newBrick(){

        int nextBrick = random.nextInt(6);

        System.out.println("newBrick, initialisation de la shape");

        switch (nextBrick){
            case 0:
                return new ShapeI(){};
            case 1:
                return new ShapeJ(){};
            case 2:
                return new ShapeL(){};
            case 3:
                return new ShapeO(){};
            case 4:
                return new ShapeS(){};
            case 5:
                return new ShapeT(){};
            default:
                return new ShapeZ(){};
        }
    } // newBrick


    /*  Summary :   Move the brick in a direction who depends of the arg.
                     -1 = to the left
                      0 =  down
                      1 = to the right
    *   Param. :    An int for the direction
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
                coordBrick[i][1] ++;
            }
        } else {
            for(int i = 0; i < coordBrick.length; i++) {
                coordBrick[i][0] += move;
            }
        }
    } // Positionning


    /*  Summary :   Turn the brick on the left
    *   Param. :    The shape to make turn and the "state" of the shape
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



    /*  Summary :   Turn the brick on the right
    *   Param. :    The shape to make turn and the "state" of the shape
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
