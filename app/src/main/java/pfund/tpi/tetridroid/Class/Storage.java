package pfund.tpi.tetridroid.Class;

import android.content.SharedPreferences;

import pfund.tpi.tetridroid.Activity.MenuActivity;


/**
 * Title :       Storage
 * Description : Class that store game informations and allow to take them back (Music, sound and game state)
 * Author :      Joël Pfund
 * Created :     20.04.2015
 * Modified :    21.05.2015
 */
public class Storage extends MenuActivity {

    public static final String PREFS_OPTIONS = "Tetridroid";
    public SharedPreferences PlayerProfile;

    public Storage() {

        /*try {
            PlayerProfile = getSharedPreferences(PREFS_OPTIONS, 0);

        } catch (NullPointerException e) {
            PreferenceManager.getDefaultSharedPreferences(this);

        }*/

    }

    /*  Summary :   stocke les valeurs dans les shared preferences afin d'etre gardee en memoire
    *   Param. :    la cle de la preference pour retrouver la valeur et la valeur qu'on veut sauvegarder
    *   Returns:    Nothing
    *   Exception : -
    */
    public void preferenceEditor(String key, String value){

        /*SharedPreferences.Editor editor = PlayerProfile.edit();

        editor.putString(key, value);
        editor.commit();*/
    } // preferenceEditor
}
