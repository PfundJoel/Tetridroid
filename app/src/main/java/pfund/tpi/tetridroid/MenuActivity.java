package pfund.tpi.tetridroid;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

/*
    Titre :       MenuActivity
    Description : Classe qui contient notamment la gestion du menu principal
    Créateur :    Joël Pfund
    Créé le :     30.04.2015
    Modifié le :  30.04.2015

 */
public class MenuActivity extends ActionBarActivity {

    // List View who'll show the menu content
    private ListView myListView;

    private String PLAY_SOLO = "Mode Solo";
    private String PLAY_VERSUS = "Mode Versus";
    private String OPTION = "Options de jeu";
    private String QUIT = "Quitter";
    private String TEXTMENU = "textMenu";
    private String IMAGE = "img";


    // On launch this view
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        myListView = (ListView) findViewById(R.id.mylistview);

        // Create a list who'll contain the the element to show in the listview
        ArrayList<HashMap<String, String>> listMenu = new ArrayList<HashMap<String, String>>();

        HashMap<String, String> map;

        // Create the "Solo" item and put it in the ArrayList
        map = new HashMap<String, String>();

        map.put(TEXTMENU, PLAY_SOLO);
        map.put(IMAGE, String.valueOf(R.drawable.play));

        listMenu.add(map);

        // Create the "Versus" item and put it in the ArrayList
        map = new HashMap<String, String>();

        map.put(TEXTMENU, PLAY_VERSUS);
        map.put(IMAGE, String.valueOf(R.drawable.versus));

        listMenu.add(map);

        // Create the "Option" item and put it in the ArrayList
        map = new HashMap<String, String>();

        map.put(TEXTMENU, OPTION) ;
        map.put(IMAGE, String.valueOf(R.drawable.setting));

        listMenu.add(map);

        // Create the "Quit" item and put it in the ArrayList
        map = new HashMap<String, String>();

        map.put(TEXTMENU, QUIT);
        map.put(IMAGE, String.valueOf(R.drawable.quit));

        listMenu.add(map);

        // Create a SimpleAdapter who'll put all the item of the ArrayList in the view "menu_view"
        SimpleAdapter mSchedule = new SimpleAdapter(this.getBaseContext(),
                listMenu, R.layout.menu_view,
                new String[] {IMAGE, TEXTMENU},
                new int[] {R.id.img, R.id.textMenu});

        myListView.setAdapter(mSchedule);

        //Add an event listener on the tiles
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            @SuppressWarnings("unchecked")
            public void onItemClick(AdapterView<?> adapt, View view, int position, long id) {
                //take the HashMap content
                HashMap<String, String> map = (HashMap<String, String>) myListView.getItemAtPosition(position);
                if (map.get(TEXTMENU) == PLAY_SOLO) {
                    launchGame(view);
                    //launch the Game setting view;
                } else if (map.get(TEXTMENU) == PLAY_VERSUS) {
                    //launch the Game "Versus Mode" view;
                } else if (map.get(TEXTMENU) == OPTION) {
                    //launch the Option menu view;
                } else if (map.get(TEXTMENU) == QUIT) {
                    //quit the Game
                    System.exit(0);
                }
            }
        });
    }

    // Modèle de méthode pour lancer une autre activité

    private void launchGame(View view) {
    Intent intent = new Intent(this, GameGrid.class);
    startActivity(intent);
    }


    /*PAS BESOINS POUR L'INSTANT

    @Override
     public boolean onCreateOptionsMenu(Menu menu) {
     Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
     Handle action bar item clicks here. The action bar will
     automatically handle clicks on the Home/Up button, so long
     as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

    noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
}
