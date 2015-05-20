package pfund.tpi.tetridroid;

import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;


public class OptionView extends Storage {

    public static final String PREFS_OPTIONS = "Tetridroid";

    SharedPreferences PlayerProfile;

    private String strOff = "Off";
    private String strOn = "On";

    private ListView OptionListView;

    private String TextMenu = "textOption";
    private String Value = "value";

    private String Music = "Musique du jeu";
    private String Sound = "Son dans le jeu";

    public String SP_Music = Music;
    public String SP_Sound = Sound;

    private boolean IsMusicOn = true;
    private boolean IsSoundOn = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_view);

        PlayerProfile = getSharedPreferences(PREFS_OPTIONS, 0);

        // Importe les SharedPreferences où sont stockés les préférences musique et son

        OptionListView = (ListView) findViewById(R.id.listviewsettings);

        // Liste qui contiendra les éléments de la ListView du menu
        ArrayList<HashMap<String, String>> listMenu = new ArrayList<HashMap<String, String>>();

        HashMap<String, String> map;

        map = new HashMap<String, String>();
        // Entrer les données qu'on récupérera dans la textview
        map.put(TextMenu, Music);
        if (PlayerProfile.getString(SP_Music, "").isEmpty()){
            map.put(Value, strOn);
            preferenceEditor(SP_Music, strOn);
        }
        else {
            map.put(Value, PlayerProfile.getString(SP_Music, ""));
        }

        // Ajouter  la HashMap dans le ArrayList
        listMenu.add(map);

        map = new HashMap<String, String>();
        // Entrer les données qu'on récupérera dans la textview
        map.put(TextMenu, Sound);
        if (PlayerProfile.getString(SP_Sound, "").isEmpty()){
            map.put(Value, strOn);
            preferenceEditor(SP_Sound, strOn);
        }
        else {
            map.put(Value, PlayerProfile.getString(SP_Sound, ""));
        }

        // Ajouter  la HashMap dans le ArrayList
        listMenu.add(map);

        //Création d'un SimpleAdapter va introduire les éléments  de listMenu dans la view affichageoption
        final SimpleAdapter mSchedule = new SimpleAdapter(this.getBaseContext(),
                listMenu, R.layout.option_menu_view,
                new String[] {TextMenu, Value},
                new int[] {R.id.textOption, R.id.value});

        OptionListView.setAdapter(mSchedule);


        //On met un écouteur d'évènement sur notre listView
        OptionListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            @SuppressWarnings("unchecked")
            public void onItemClick(AdapterView<?> adapt, View view, int position, long id) {
                //on récupère la HashMap
                HashMap<String, String> map = (HashMap<String, String>) OptionListView.getItemAtPosition(position);
                if (map.get(TextMenu) == Music) {

                    if (map.get(Value) == strOn) {
                        map.put(Value, strOff);
                        preferenceEditor(SP_Music, strOff);
                    } else {
                        map.put(Value, strOn);
                        preferenceEditor(SP_Music, strOn);
                    }
                }
                else {
                    if (map.get(Value) == strOn) {
                        map.put(Value, strOff);
                        preferenceEditor(SP_Sound, strOff);
                    } else {
                        map.put(Value, strOn);
                        preferenceEditor(SP_Sound, strOn);
                    }
                }
            }
        });
    } // onCreate

}
