package pfund.tpi.tetridroid.Activity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import pfund.tpi.tetridroid.Class.NetworkConnectionClient;
import pfund.tpi.tetridroid.Class.NetworkConnectionServer;
import pfund.tpi.tetridroid.Fragments.OpponentFragment;
import pfund.tpi.tetridroid.R;


public class VersusActivityMenu extends ActionBarActivity  {

    Button createPartyButton;
    Button joinPartyButton;

    int portNumber = 9000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_versus_menu);

        createPartyButton = (Button) findViewById(R.id.modeServerButton);
        createPartyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateNewServerParty();
            }
        });

        joinPartyButton = (Button) findViewById(R.id.modeClientButton);
        joinPartyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateNewClientParty();
            }
        });
    } // onCreate


    /*  Summary :   Controle que l'appareil est bien connecte au reseau
    *   Param. :    Nothing
    *   Returns:    Nothing
    *   Exception : -
    */
    private boolean checkConnection() {
        ConnectivityManager connection = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connection.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        }
        return false;
    } // checkConnection


    /*  Summary :   Lance le mode Versus en accueillant un autre joueur
    *   Param. :    Nothing
    *   Returns:    Nothing
    *   Exception : -
    */
    public void CreateNewServerParty(){

        if(checkConnection()){
            NetworkConnectionServer netConnect = new NetworkConnectionServer();
            Toast.makeText(this, "Nouvelle partie en mode server", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, "Vous n'êtes pas connecté au réseau. Connectez-vous et réessayez", Toast.LENGTH_LONG).show();
        }
    } // CreateNewServerParty


    /*  Summary :   Lance le mode Versus en rejoignant un autre joueur
    *   Param. :    Nothing
    *   Returns:    Nothing
    *   Exception : -
    */
    public void CreateNewClientParty(){
        if(checkConnection()){
            NetworkConnectionServer netConnect = new NetworkConnectionServer();
            Toast.makeText(this, "Nouvelle partie en mode client", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, "Vous n'êtes pas connecté au réseau. Connectez-vous et réessayez", Toast.LENGTH_LONG).show();
        }
    } // CreateNewClientParty

}
