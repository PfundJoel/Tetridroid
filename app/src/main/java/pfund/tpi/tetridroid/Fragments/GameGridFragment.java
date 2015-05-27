package pfund.tpi.tetridroid.Fragments;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

import pfund.tpi.tetridroid.Bricks.Brick;
import pfund.tpi.tetridroid.Class.OnSwipeTouchListener;
import pfund.tpi.tetridroid.R;

/**
 * Titre :       GameGridFragment
 * Description : Classe qui gere le fragment de la grille de jeu qui s'affiche dans l'activite du jeu
 * Createur :    Joel Pfund
 * Cree le :     08.05.2015
 * Modifie le :  11.05.2015
 */
public class GameGridFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    private int ScreenWidth, ScreenHeight;
    private int GridWidth = 10;
    private int GridHeight = 23;
    public Button[][] ArrayButton;
    public GridLayout gridLayout;
    private ImageView nextBrickView;
    private ImageView holdBrickView;

    // Instanciation d'un nouveau fragment
    public static GameGridFragment newInstance() {
        GameGridFragment fragment = new GameGridFragment();

        return fragment;
    }

    public GameGridFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_game_grid, container, false);

        ArrayButton = new Button[GridHeight][GridWidth];

        getScreenSize();

        nextBrickView = (ImageView) v.findViewById(R.id.BrickNext);
        holdBrickView = (ImageView) v.findViewById(R.id.BrickHold);

        holdBrickView.setOnTouchListener(new OnSwipeTouchListener(getActivity()){

            public boolean onTouch(View v, MotionEvent event) {

                return gestureDetector.onTouchEvent(event);
            }

        });

        gridLayout = (GridLayout) v.findViewById(R.id.myGridLayout);

        // Remplissage de la grille de jeu avec les boutons de base
        for(int x = 0; x < GridHeight; x++) {
            for(int y = 0; y < GridWidth; y++) {

                ArrayButton[x][y] = new Button(getActivity());

                ArrayButton[x][y].setBackgroundResource(R.drawable.square);

                gridLayout.addView(ArrayButton[x][y]);

                setViewParams(ArrayButton[x][y]);
            }
        }

        gridLayout.setOnTouchListener(new OnSwipeTouchListener(getActivity()) {

            public void onSwipeTop() {
                Toast.makeText(getActivity(), "haut", Toast.LENGTH_SHORT).show();
            }

            public void onSwipeRight() {
                Toast.makeText(getActivity(), "droite", Toast.LENGTH_SHORT).show();
            }

            public void onSwipeLeft() {
                Toast.makeText(getActivity(), "gauche", Toast.LENGTH_SHORT).show();
            }

            public void onSwipeBottom() {
                Toast.makeText(getActivity(), "bas", Toast.LENGTH_SHORT).show();
            }

            public boolean onTouch(View v, MotionEvent event) {
                return gestureDetector.onTouchEvent(event);
            }
        });
        return v;
    }

    /*  Summary :   Controle de la grille de jeu pour chercher si des lignes sont completes
    *   Param. :    Nothing
    *   Returns:    Nothing
    *   Exception : -
    */
    // TODO : Pour la suite, chercher uniquement dans les lignes ou des pieces tombent quand ca sera fait => Economie de ressources & temps
    public void CheckLine(){

        int Counter = 0;
        ColorDrawable buttonColor;

        for (int LineNumber = 0; LineNumber < GridHeight; LineNumber++) {
            for (int y = 0; y < GridWidth; y++) {

                if (((ColorDrawable) ArrayButton[LineNumber][y].getBackground()).getColor() != Color.TRANSPARENT) {
                    Counter++;
                }

                if (Counter == GridWidth) {
                    DeleteLine(LineNumber);
                }
            }
        }
    } //CheckLine

    /*  Summary :   Effacer la ligne et faire descendre les pieces du dessus
    *   Param. :    Numero de la ligne a supprimer
    *   Returns:    Nothing
    *   Exception : -
    */
    // TODO: A controler pour les lignes multiples a supprimer
    public void DeleteLine(int LineNumber){

        ColorDrawable buttonColor;
        int Counter = 0;

        // Bouclie qui decale toutes les lignes vers le bas jusqu'a ce qu'ils n'y aient plus de boutons colores au dessus-d'elles
        do {
            Counter = 0;

            for (int x = 0; x < GridWidth; x++){
                if (((ColorDrawable)ArrayButton[LineNumber-1][x].getBackground()).getColor() == Color.TRANSPARENT){
                    Counter++;
                }
                ArrayButton[LineNumber][x].setBackgroundColor(((ColorDrawable) ArrayButton[LineNumber-1][x].getBackground()).getColor());
            }

            LineNumber --;

        } while (Counter < GridWidth);

    } //DeleteLine

    /*  Summary :   Ajout de ligne(s) au bas de la grille
    *   Param. :    Nombre de lignes a ajouter
    *   Returns:    Nothing
    *   Exception : -
    */
    public void AddLine(int NbLine){

        for (int LineNumber = 0; LineNumber < GridHeight; LineNumber++) {

            if(LineNumber == GridHeight-1) {

                CreateRandomLine(NbLine);
            }
            else{

                for (int y = 0; y < GridWidth; y++) {
                    ArrayButton[LineNumber][LineNumber].setBackgroundColor(((ColorDrawable) ArrayButton[LineNumber + 1][LineNumber].getBackground()).getColor());
                }
            }
        }
    } // AddLine


    /*  Summary :   Creer un nombre de lignes d'apres le chiffre passe en parametre de couleurs aleatoires
    *   Param. :    Nombre de lignes a ajouter
    *   Returns:    Nothing
    *   Exception : -
    */
    public void CreateRandomLine(int NbLineToAdd){

        Random random = new Random();
        int LineToDo;

        int randomHole = random.nextInt(9);

        for (int x = 0; x <= NbLineToAdd; x++){
            for (int y = 0; y < GridWidth; y++) {

                LineToDo = GridHeight-x;

                int randomNumber = random.nextInt(6);

                if (y == randomHole) {
                    ArrayButton[GridHeight][x].setBackgroundResource(R.drawable.square);
                }
                else{
                    switch (randomNumber) {
                        case 0:
                            ArrayButton[LineToDo][y].setBackgroundResource(R.drawable.bugdroidblue);
                            break;
                        case 1:
                            ArrayButton[LineToDo][y].setBackgroundResource(R.drawable.bugdroidcyan);
                            break;
                        case 2:
                            ArrayButton[LineToDo][y].setBackgroundResource(R.drawable.bugdroidyellow);
                            break;
                        case 3:
                            ArrayButton[LineToDo][y].setBackgroundResource(R.drawable.bugdroidred);
                            break;
                        case 4:
                            ArrayButton[LineToDo][y].setBackgroundResource(R.drawable.bugdroidgreen);
                            break;
                        case 5:
                            ArrayButton[LineToDo][y].setBackgroundResource(R.drawable.bugdroidviolet);
                            break;
                        case 6:
                            ArrayButton[LineToDo][y].setBackgroundResource(R.drawable.bugdroidorange);
                            break;
                    }
                }
            }
        }
    } // CreateRandomLine


    /*  Summary :   Lance la piece sur la grille de jeu en recuperant les coordonnees de la piece
    *               afin de faire changer la couleur des cases ou elle se trouve
    *   Param. :    la brique a afficher sur la grille
    *   Returns:    nothing
    *   Exception : -
    */
    public void launchNewBrick(Brick brick){
        int posX = 5;
        int posY = 1;

        int[][] position = brick.coordBrick;

        for (int i = 0; i < position.length; i++){
            ArrayButton[posX+position[i][0]][posY + position[i][1]].setBackgroundResource(brick.brickBackground);
        }
    } // launchNewBrick


    /*  Summary :   Lance la piece sur la grille de jeu en recuperant les coordonnees de la piece
    *               afin de faire changer la couleur des cases ou elle se trouve
    *   Param. :    la brique a afficher sur la grille
    *   Returns:    nothing
    *   Exception : -
    */
    public Brick createNextBrick(){

        Brick nextBrick = createNextBrick();

        switch(nextBrick.brickBackground){
            case R.drawable.bugdroidblue:
                nextBrickView.setBackgroundResource(R.drawable.brickblue);
                break;
            case R.drawable.bugdroidcyan:
                nextBrickView.setBackgroundResource(R.drawable.brickcyan);
                break;
            case R.drawable.bugdroidgreen:
                nextBrickView.setBackgroundResource(R.drawable.brickgreen);
                break;
            case R.drawable.bugdroidorange:
                nextBrickView.setBackgroundResource(R.drawable.brickorange);
                break;
            case R.drawable.bugdroidred:
                nextBrickView.setBackgroundResource(R.drawable.brickred);
                break;
            case R.drawable.bugdroidviolet:
                nextBrickView.setBackgroundResource(R.drawable.brickviolet);
                break;
            default:
                nextBrickView.setBackgroundResource(R.drawable.brickyellow);
                break;
        }
        return nextBrick;

    } // createNextBrick


    /*  Summary :   Set les parametres de taille des boutons dans la grille de jeu
    *   Param. :    Bouton auquel appliquer les reglages
    *   Returns:    Nothing
    *   Exception : -
    */
    public void setViewParams(Button button){

        int Margin = 1;

        GridLayout.LayoutParams ButtonParams = (GridLayout.LayoutParams) button.getLayoutParams();

        ButtonParams.height = (ScreenHeight*3/4 ) / GridHeight;
        ButtonParams.width = ButtonParams.height;

        ButtonParams.setMargins(Margin, Margin, Margin, Margin);

        button.setLayoutParams(ButtonParams);

    } // SetViewParams


    /*  Summary :   Set la taille de la grille de jeu
    *   Param. :    Nothing
    *   Returns:    Nothing
    *   Exception : -
    */
    public void getScreenSize(){

        Display display = getActivity().getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        ScreenWidth = size.x;
        ScreenHeight = size.y;

        System.out.println(ScreenWidth);
        System.out.println(ScreenHeight);

    } // getScreenSize


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onPause(){
        super.onPause();
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
