package pfund.tpi.tetridroid.Class;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/*
 * Titre :       OnSwipeTouchListener
 * Description : Gere les gestes qui sont fait sur l'ecran pour savoir dans quelle direction ils vont
 * Créateur :    Joël Pfund
 * Créé le :     24.05.2015
 * Modifié le :  24.05.2015
 */
public class OnSwipeTouchListener implements View.OnTouchListener {

    public final GestureDetector gestureDetector;

    public OnSwipeTouchListener (Context context){
        gestureDetector = new GestureDetector(context, new GestureListener());
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }

    private final class GestureListener extends GestureDetector.SimpleOnGestureListener {

        // Nombre de pixel a Swiper
        private static final int SWIPE_THRESHOLD = 50;
        private static final int SWIPE_VELOCITY_THRESHOLD = 100;

        /*  Summary :   des qu'il y a un appui
        *   Param. :    event
        *   Returns:    un booleen si l'user a appuye
        *   Exception : -
        */
        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }

        /*  Summary :
        *   Param. :    -
        *   Returns:    booleen
        *   Exception : -
        */
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            boolean result = false;
            try {
                float diffY = e2.getY() - e1.getY();
                float diffX = e2.getX() - e1.getX();
                if (Math.abs(diffX) > Math.abs(diffY)) {
                    if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                        if (diffX > 0) {
                            onSwipeRight();
                        } else {
                            onSwipeLeft();
                        }
                    }
                    result = true;
                }
                else if (Math.abs(diffY) > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
                    if (diffY > 0) {
                        onSwipeBottom();
                    } else {
                        onSwipeTop();
                    }
                }
                result = true;

            } catch (Exception exception) {
                exception.printStackTrace();
            }
            return result;
        }
    }

    public void onSwipeRight() {
    }

    public void onSwipeLeft() {
    }

    public void onSwipeTop() {
    }

    public void onSwipeBottom() {
    }
}
