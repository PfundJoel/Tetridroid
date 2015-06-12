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

import pfund.tpi.tetridroid.Class.NetworkConnectionServer;
import pfund.tpi.tetridroid.R;


/*
    Title :       VersusActivityMenu
    Summary :     Class that contains the activity in Versus mode menu for chose if we want to join or create a party and the pseudo
    Creator :     Joel Pfund
    Created :     24.04.2015
    Modified :    30.05.2015
 */
public class VersusActivityMenu extends ActionBarActivity  {

    Button createPartyButton;
    Button joinPartyButton;
    Button goBackButton;

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

        goBackButton = (Button) findViewById((R.id.backButton));
        goBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    } // onCreate


    /*  Summary :   Control if the tablet is well connected to the network
    *   Param. :    Nothing
    *   Returns:    A true if it's connected
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


    /*  Summary :   Create the party and wait for an opponent
    *   Param. :    Nothing
    *   Returns:    Nothing
    *   Exception : -
    */
    public void CreateNewServerParty(){

        if(checkConnection()){
            NetworkConnectionServer netConnect = new NetworkConnectionServer();
            Toast.makeText(this, "Nouvelle partie en mode server", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, VersusActivity.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(this, "Vous n'êtes pas connecté au réseau. Connectez-vous et réessayez", Toast.LENGTH_LONG).show();
        }
    } // CreateNewServerParty


    /*  Summary :   Join a party created by another gamer
    *   Param. :    Nothing
    *   Returns:    Nothing
    *   Exception : -
    */
    public void CreateNewClientParty(){
        if(checkConnection()){
            NetworkConnectionServer netConnect = new NetworkConnectionServer();
            Toast.makeText(this, "Nouvelle partie en mode client", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, VersusActivity.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(this, "Vous n'êtes pas connecté au réseau. Connectez-vous et réessayez", Toast.LENGTH_LONG).show();
        }
    } // CreateNewClientParty
}
