package pfund.tpi.tetridroid.Fragments;

import android.app.Activity;
import android.content.res.Resources;
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
 * Description : Class that manage the fragment where the grid is shown with the "next brick" and the "held brick"
 * Createur :    Joel Pfund
 * Cree le :     08.05.2015
 * Modifie le :  30.05.2015
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

    GridLayout.LayoutParams ButtonParams;

    public Button[][] getArrayButton() {
        return ArrayButton;
    }

    public static GameGridFragment newInstance() {
        GameGridFragment fragment = new GameGridFragment();
        return fragment;
    } // newInstance

    public GameGridFragment() { }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    } // onCreate

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

        // Put the empty button in the grid
        for(int x = 0; x < GridHeight; x++) {
            for(int y = 0; y < GridWidth; y++) {
                ArrayButton[x][y] = new Button(getActivity());
                ArrayButton[x][y].setBackgroundResource(R.drawable.square);

                gridLayout.addView(ArrayButton[x][y]);

                setViewParams(ArrayButton[x][y]);
            }
        }

        gridLayout.setOnTouchListener(new OnSwipeTouchListener(getActivity()) {

            public void onSwipeTop() { /* Nothing to do */ }
            public void onSwipeRight() {
                Toast.makeText(getActivity(), "droite", Toast.LENGTH_SHORT).show();
                // TODO Brick doit aller a droite
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
    } // onCreateView


    /*  Summary :   Check the game grid for see if one or some line are full
    *   Param. :    Nothing
    *   Returns:    Nothing
    *   Exception : -
    */
    public void CheckLine(){

        for (int LineNumber = 0; LineNumber < GridHeight; LineNumber++) {
            int Counter = 0;
            for (int y = 0; y < GridWidth; y++) {
                if (ArrayButton[LineNumber][y].getBackground().equals(R.drawable.square)) {
                    Counter++;
                }
                if (Counter == GridWidth) {
                    DeleteLine(LineNumber);
                }
            }
        }
    } //CheckLine


    /*  Summary :   Delete the line and make fall the line who are upper than the deleted line
    *   Param. :    Number of the line to delete
    *   Returns:    Nothing
    *   Exception : -
    */
    // TODO: A controler pour les lignes multiples a supprimer
    public void DeleteLine(int LineNumber){
        ColorDrawable buttonColor;
        int Counter = 0;

        // Loop that makes fall all the line upper than the deleted line. When the counter has same value that the grid width,
        // it means that there isn't any more thing to make fall
        do {
            Counter = 0;
            for (int x = 0; x < GridWidth; x++){
                if ((ArrayButton[LineNumber-1][x].getBackground()).equals(R.drawable.square)){
                    Counter++;
                }
                ArrayButton[LineNumber][x]
                        .setBackground(ArrayButton[LineNumber - 1][x].getBackground());
            }
            LineNumber --;
        } while (Counter < GridWidth);
    } //DeleteLine


    /*  Summary :   Add the number of line passed in parameter
    *   Param. :    Number of line to add
    *   Returns:    Nothing
    *   Exception : -
    */
    public void AddLine(int NbLine){
        for (int LineNumber = 0; LineNumber < GridHeight; LineNumber++) {
            if(LineNumber == GridHeight-1) {
                CreateRandomLine(NbLine);
            } else{
                for (int y = 0; y < GridWidth; y++) {
                    ArrayButton[LineNumber][LineNumber]
                            .setBackground(ArrayButton[LineNumber + 1][LineNumber].getBackground());
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
                    ArrayButton[GridHeight][x]
                            .setBackgroundResource(R.drawable.square);
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
    } // onAttach

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    } // onDetach

    @Override
    public void onPause(){
        super.onPause();
    } // onPause


    /**
     * Interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the Activity and potentially other Fragments contained in that
     * Activity.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    } // OnFragmentInteractionListener
}
