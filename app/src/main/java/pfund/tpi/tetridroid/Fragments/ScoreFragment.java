package pfund.tpi.tetridroid.Fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import pfund.tpi.tetridroid.Class.Level;
import pfund.tpi.tetridroid.R;


/**
 * Titre :       ScoreFragment
 * Description : Classe qui gere l'affichage du fragment qui gere les scores et le
 *               high score du joueur
 * Cr�ateur :    Jo�l Pfund
 * Cr�� le :     11.05.2015
 * Modifi� le :  13.05.2015
 */
public class ScoreFragment extends Fragment {

    private TextView scoreView;
    private TextView highScoreView;
    Level level = new Level();

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of this fragment
     */
    public static ScoreFragment newInstance() {
        ScoreFragment fragment = new ScoreFragment();

        return fragment;
    }

    public ScoreFragment() {
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
        return inflater.inflate(R.layout.fragment_score, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    public void updateScore(){

    }

    @Override
    public void onPause(){
        super.onPause();
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
