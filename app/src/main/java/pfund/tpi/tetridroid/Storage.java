package pfund.tpi.tetridroid;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;


/**
 * Title :       Storage
 * Description : Classe qui g�re le stockage et la recuperation des informations pour le jeu
 *               (musique, son, briques lorsqu on quitte le jeu et qu on le reprend
 * Author :      Jo�l Pfund
 * Created :     20.04.2015
 * Modified :    21.05.2015
 */
public class Storage extends MenuActivity{

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
