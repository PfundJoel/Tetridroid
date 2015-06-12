package pfund.tpi.tetridroid.Class;

import android.app.Activity;
import android.content.Context;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import android.os.Bundle;

/*
 * Titre :       NetworkConnectionServer
 * Description : Manage the WiFi connections  for create a party in Versus mode
 * Cr�ateur :    Jo�l Pfund
 * Cr�� le :     24.05.2015
 * Modifi� le :  25.05.2015
 */
public class NetworkConnectionServer extends Activity {

    private String SERVICE_NAME = "Tetridroid";
    private String SERVICE_TYPE = "_http._tcp.";
    private NsdManager mNsdManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        System.out.println("Server etape 1");
        mNsdManager = (NsdManager) getSystemService(Context.NSD_SERVICE);
        registerService(9000);
    }

    @Override
    protected void onPause() {
        if (mNsdManager != null) {
            mNsdManager.unregisterService(mRegistrationListener);
        }
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mNsdManager != null) {
            registerService(9000);
        }
    }

    @Override
    protected void onDestroy() {
        if (mNsdManager != null) {
            mNsdManager.unregisterService(mRegistrationListener);
        }
        super.onDestroy();
    }


    /*  Summary :   Set informations for the connection
    *   Param. :    Application's port number
    *   Returns:    Nothing
    *   Exception : -
    */
    public void registerService(int port) {
        NsdServiceInfo serviceInfo = new NsdServiceInfo();
        serviceInfo.setServiceName(SERVICE_NAME);
        serviceInfo.setServiceType(SERVICE_TYPE);
        serviceInfo.setPort(port);

        mNsdManager.registerService(serviceInfo,
                NsdManager.PROTOCOL_DNS_SD,
                mRegistrationListener);
    }


    /*  Summary :   Create a RegisttationListener to look if people around joins the party and manage error
    *   Param. :    Nothing
    *   Returns:    NsdManager with connection infos
    *   Exception : -
    */
    NsdManager.RegistrationListener mRegistrationListener = new NsdManager.RegistrationListener() {

        @Override
        public void onServiceRegistered(NsdServiceInfo NsdServiceInfo) {
            String mServiceName = NsdServiceInfo.getServiceName();
            SERVICE_NAME = mServiceName;
            System.out.println("Registered name : " + mServiceName);
        }

        @Override
        public void onRegistrationFailed(NsdServiceInfo serviceInfo,
                                         int errorCode) {
            // Registration failed! Put debugging code here to determine
            // why.
        }

        @Override
        public void onServiceUnregistered(NsdServiceInfo serviceInfo) {
            // Service has been unregistered. This only happens when you
            // call
            // NsdManager.unregisterService() and pass in this listener.
            System.out.println("Service Unregistered : " + serviceInfo.getServiceName());
        }

        @Override
        public void onUnregistrationFailed(NsdServiceInfo serviceInfo,
                                           int errorCode) {
            // Unregistration failed. Put debugging code here to determine
            // why.
        }
    };
}
