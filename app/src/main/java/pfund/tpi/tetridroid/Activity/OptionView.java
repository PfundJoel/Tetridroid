package pfund.tpi.tetridroid.Activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

import pfund.tpi.tetridroid.R;
import pfund.tpi.tetridroid.Class.Storage;


/*
    Title :       OptionView
    Summary :     Class that contains the option of the game (sounds and music)
    Creator :     Joel Pfund
    Created :     24.04.2015
    Modified :    27.05.2015
 */
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

        // Import SharedPreferences for see if if the app has to activate sound and / or music
        PlayerProfile = getSharedPreferences(PREFS_OPTIONS, 0);

        OptionListView = (ListView) findViewById(R.id.listviewsettings);

        // List who'll contain the ListView elements for the menu
        ArrayList<HashMap<String, String>> listMenu = new ArrayList<HashMap<String, String>>();

        HashMap<String, String> map;

        map = new HashMap<String, String>();
        // Enter the data that we'll take back for the TextView
        map.put(TextMenu, Music);
        if (PlayerProfile.getString(SP_Music, "").isEmpty()){
            map.put(Value, strOn);
            preferenceEditor(SP_Music, strOn);
        }
        else {
            map.put(Value, PlayerProfile.getString(SP_Music, ""));
        }

        // Add the HashMap in the ArrayList
        listMenu.add(map);

        map = new HashMap<String, String>();

        // Enter the data that we'll take back for put into the textView
        map.put(TextMenu, Sound);
        if (PlayerProfile.getString(SP_Sound, "").isEmpty()){
            map.put(Value, strOn);
            preferenceEditor(SP_Sound, strOn);
        }
        else {
            map.put(Value, PlayerProfile.getString(SP_Sound, ""));
        }

        // Add the HashMap in the ArrayList
        listMenu.add(map);

        // Create a simple adapter who'll introduce the element of ListMenu in the OptionView
        final SimpleAdapter mSchedule = new SimpleAdapter(this.getBaseContext(),
                listMenu, R.layout.option_menu_view,
                new String[] {TextMenu, Value},
                new int[] {R.id.textOption, R.id.value});

        OptionListView.setAdapter(mSchedule);

        // Put an event listener on the list view
        OptionListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            @SuppressWarnings("unchecked")
            public void onItemClick(AdapterView<?> adapt, View view, int position, long id) {

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
