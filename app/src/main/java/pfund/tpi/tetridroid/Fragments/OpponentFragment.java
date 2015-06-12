package pfund.tpi.tetridroid.Fragments;

import android.app.Activity;
import android.graphics.Point;
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

import pfund.tpi.tetridroid.Class.OnSwipeTouchListener;
import pfund.tpi.tetridroid.R;


public class OpponentFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private int ScreenWidth, ScreenHeight;
    private int GridWidth = 10;
    private int GridHeight = 23;
    public Button[][] ArrayButton;
    public GridLayout gridLayout;
    private ImageView nextBrickView;
    private ImageView holdBrickView;

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;


    public static OpponentFragment newInstance(String param1, String param2) {
        OpponentFragment fragment = new OpponentFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    public OpponentFragment() { }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    } // onCreate


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_opponent, container, false);

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

        // Put the basic button in the grid
        for(int x = 0; x < GridHeight; x++) {
            for(int y = 0; y < GridWidth; y++) {
                ArrayButton[x][y] = new Button(getActivity());
                ArrayButton[x][y].setBackgroundResource(R.drawable.square);

                gridLayout.addView(ArrayButton[x][y]);

                setViewParams(ArrayButton[x][y]);
            }
        }
    return v;
    } // onCreateView


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


    /*  Summary :   Set the game grid button size
    *   Param. :    Button that we have to set the size
    *   Returns:    Nothing
    *   Exception : -
    */
    public void setViewParams(Button button){
        int Margin = 1;

        GridLayout.LayoutParams ButtonParams = (GridLayout.LayoutParams) button.getLayoutParams();

        ButtonParams.height = (ScreenHeight/2 ) / GridHeight;
        ButtonParams.width = ButtonParams.height;

        ButtonParams.setMargins(Margin, Margin, Margin, Margin);

        button.setLayoutParams(ButtonParams);
    } // SetViewParams


    /*  Summary :   Set the game grid size
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


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the Activity and potentially other Fragments contained in that
     * Activity.
     */
    public interface OnFragmentInteractionListener {
        public void onFragmentInteraction(Uri uri);
    }

}
