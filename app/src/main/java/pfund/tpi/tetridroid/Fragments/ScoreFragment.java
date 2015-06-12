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
 * Title :       ScoreFragment
 * Summary :     Class of the fragment that manage score and high score of the player
 * Creator :     Joël Pfund
 * Created :     11.05.2015
 * Modified :    13.05.2015
 */
public class ScoreFragment extends Fragment {

    private TextView scoreView;
    private TextView highScoreView;
    Level level = new Level();

    private OnFragmentInteractionListener mListener;

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
        View v = inflater.inflate(R.layout.fragment_score, container, false);

        scoreView = (TextView) v.findViewById(R.id.TextViewScore);
        highScoreView = (TextView) v.findViewById(R.id.TextViewHighScore);

        return v;
    }


    /*  Summary :   change the value in the textView with new score
    *   Param. :    int : new score
    *   Returns:    Nothing
    *   Exception : -
    */
    public void updateScore(int score){
        scoreView.setText(score);
    }


    /*  Summary :   change the value in the textView with new score
    *   Param. :    int : new highScore
    *   Returns:    Nothing
    *   Exception : -
    */
    public void updateHighScore(int highScore){
        highScoreView.setText(highScore);
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
     * to the Activity and potentially other Fragments contained in that
     * Activity.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
