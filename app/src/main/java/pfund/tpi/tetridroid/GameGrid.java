package pfund.tpi.tetridroid;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;


public class GameGrid extends ActionBarActivity {

    int GridWidth = 10;
    int GridHeight = 23;
    Button[][] ArrayButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_game);

        ArrayButton = new Button[GridHeight][GridWidth];

        for(int i = 0; i < GridHeight; i++) {
            for(int j = 0; j < GridWidth; j++) {
                ArrayButton[i][j] = new Button(this);
                ArrayButton[i][j].setBackgroundColor(Color.BLACK);
            }
        }
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_grid_game, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
