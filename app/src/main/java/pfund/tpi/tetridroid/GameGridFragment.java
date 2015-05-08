package pfund.tpi.tetridroid;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;

import java.util.Random;

/**
 * Titre :       GameGridFragment
 * Description : Classe qui gere le fragment de la grille de jeu qui s'affiche dans l'activité du jeu
 * Créateur :    Joël Pfund
 * Créé le :     08.05.2015
 * Modifié le :  08.05.2015
 */
public class GameGridFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private int ScreenWidth, ScreenHeight;
    private int GridWidth = 10;
    private int GridHeight = 23;
    private Button[][] ArrayButton;
    public GridLayout gridLayout;

    // Instanciation d'un nouveau fragment
    public static GameGridFragment newInstance(String param1, String param2) {
        GameGridFragment fragment = new GameGridFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public GameGridFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }

        ArrayButton = new Button[GridHeight][GridWidth];
        gridLayout = (GridLayout) getActivity().findViewById(R.id.myGridLayout);

        getScreenSize();

        for(int x = 0; x < GridHeight; x++) {
            for(int y = 0; y < GridWidth; y++) {

                ArrayButton[x][y] = new Button(getActivity());
                ArrayButton[x][y].setBackgroundColor(Color.RED);

                // TODO : Il est soit disant "NullPointerException"
                gridLayout.addView(ArrayButton[x][y]);

                setViewParams(ArrayButton[x][y]);
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game_grid, container, false);
    }

    /*  Summary :   Contrôle de la grille de jeu pour chercher si des lignes sont complètes
    *   Param. :    Nothing
    *   Returns:    Nothing
    *   Exception : -
    */
    // TODO : Pour la suite, chercher uniquement dans les lignes où des pièces tombent quand ça sera fait => Economie de ressources/temps
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

    /*  Summary :   Effacer la ligne et faire descendre les pièces du dessus
    *   Param. :    Numéro de la ligne à supprimer
    *   Returns:    Nothing
    *   Exception : -
    */
    // TODO: A contrôler pour les lignes multiples à supprimer
    public void DeleteLine(int LineNumber){

        ColorDrawable buttonColor;
        int Counter = 0;

        // Bouclie qui décale toutes les lignes vers le bas jusqu'à ce qu'ils n'y aient plus de boutons colorés au dessus-d'elles
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
    *   Param. :    Nombre de lignes à ajouter
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

    /*  Summary :   Créer un nombre de lignes d'après le chiffre passé en paramètre de couleurs aléatoires
    *   Param. :    Nombre de lignes à ajouter
    *   Returns:    Nothing
    *   Exception : -
    */
    public void CreateRandomLine(int NbLineToAdd){

        Random random = new Random();
        int LineToDo;

        for (int x = 0; x <= NbLineToAdd; x++){
            for (int y = 0; y < GridWidth; y++) {

                LineToDo = GridHeight-x;

                int randomHole = random.nextInt(9);
                int randomNumber = random.nextInt(6);

                if (y == randomHole) {
                    ArrayButton[GridHeight][x].setBackgroundColor(Color.TRANSPARENT);
                }
                else{
                    switch (randomNumber) {
                        case 0:
                            ArrayButton[LineToDo][y].setBackgroundColor(Color.BLUE);
                            break;
                        case 1:
                            ArrayButton[LineToDo][y].setBackgroundColor(Color.CYAN);
                            break;
                        case 2:
                            ArrayButton[LineToDo][y].setBackgroundColor(Color.YELLOW);
                            break;
                        case 3:
                            ArrayButton[LineToDo][y].setBackgroundColor(Color.RED);
                            break;
                        case 4:
                            ArrayButton[LineToDo][y].setBackgroundColor(Color.GREEN);
                            break;
                        case 5:
                            ArrayButton[LineToDo][y].setBackgroundColor(Color.MAGENTA);
                            break;
                        case 6:
                            ArrayButton[LineToDo][y].setBackgroundColor(Color.GRAY);
                            break;
                    }
                }
            }
        }
    } // CreateRandomLine

    /*  Summary :   Set les paramêtres de taille des boutons dans la grille de jeu
    *   Param. :    Bouton auquel appliquer les réglages
    *   Returns:    Nothing
    *   Exception : -
    */
    public void setViewParams(Button button){

        int Margin = 1;

        GridLayout.LayoutParams ButtonParams = (GridLayout.LayoutParams) button.getLayoutParams();

        ButtonParams.height = (ScreenHeight*3/4 ) / GridHeight;
        ButtonParams.width = ButtonParams.height;

        ButtonParams.setMargins(Margin, Margin, Margin, Margin);

        System.out.println("ButtonParams.height = "+ ButtonParams.height);

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
