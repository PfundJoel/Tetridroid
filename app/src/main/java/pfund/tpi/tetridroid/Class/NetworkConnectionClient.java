package pfund.tpi.tetridroid.Class;

import android.app.Activity;
import android.content.Context;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import android.os.Bundle;

import java.net.InetAddress;

/*
 * Titre :       NetworkConnectionClient
 * Description : Manage wifi connections jor join other gamer in versus mode
 * Créateur :    Joel Pfund
 * Créé le :     25.05.2015
 * Modifié le :  27.05.2015
 */
public class NetworkConnectionClient extends Activity {
    private String SERVICE_NAME = "Tetridroid";
    private String SERVICE_TYPE = "_http._tcp.";

    private InetAddress hostAddress;
    private int hostPort;
    private NsdManager mNsdManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // set content view and other stuff
        System.out.println("Client etape 1");
        // NSD Stuff
        mNsdManager = (NsdManager) getSystemService(Context.NSD_SERVICE);
        mNsdManager.discoverServices(SERVICE_TYPE,
                NsdManager.PROTOCOL_DNS_SD, mDiscoveryListener);
    }

    @Override
    protected void onPause() {
        if (mNsdManager != null) {
            mNsdManager.stopServiceDiscovery(mDiscoveryListener);
        }
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mNsdManager != null) {
            mNsdManager.discoverServices(
                    SERVICE_TYPE, NsdManager.PROTOCOL_DNS_SD, mDiscoveryListener);
        }

    }

    @Override
    protected void onDestroy() {
        if (mNsdManager != null) {
            mNsdManager.stopServiceDiscovery(mDiscoveryListener);
        }
        super.onDestroy();
    }


    /*  Summary :   Create a DiscoveryListener to look if people around use same application for join a party
    *               and manage error
    *   Param. :    Nothing
    *   Returns:    NsdManager with connection infos
    *   Exception : -
    */
    NsdManager.DiscoveryListener mDiscoveryListener = new NsdManager.DiscoveryListener() {

        @Override
        public void onDiscoveryStarted(String regType) {
            System.out.println("Service discovery started");
        }

        @Override
        public void onServiceFound(NsdServiceInfo service) {

            System.out.println( "Service discovery success : " + service);
            System.out.println("Host = " + service.getServiceName());
            System.out.println("port = " + String.valueOf(service.getPort()));

            if (!service.getServiceType().equals(SERVICE_TYPE)) {
                // Service type is the string containing the protocol and
                // transport layer for this service.
                System.out.println("Unknown Service Type: " + service.getServiceType());
            } else if (service.getServiceName().equals(SERVICE_NAME)) {
                // The name of the service tells the user what they'd be
                // connecting to. It could be "Bob's Chat App".
                System.out.println("Same machine: " + SERVICE_NAME);
            } else {
                System.out.println("Diff Machine : " + service.getServiceName());
                // connect to the service and obtain serviceInfo
                mNsdManager.resolveService(service, mResolveListener);
            }
        }

        @Override
        public void onServiceLost(NsdServiceInfo service) {
            // When the network service is no longer available.
            // Internal bookkeeping code goes here.
            System.out.println("service lost" + service);
        }

        @Override
        public void onDiscoveryStopped(String serviceType) {
            System.out.println("Discovery stopped: " + serviceType);
        }

        @Override
        public void onStartDiscoveryFailed(String serviceType, int errorCode) {
            System.out.println("Discovery failed: Error code:" + errorCode);
            mNsdManager.stopServiceDiscovery(this);
        }

        @Override
        public void onStopDiscoveryFailed(String serviceType, int errorCode) {
            System.out.println("Discovery failed: Error code:" + errorCode);
            mNsdManager.stopServiceDiscovery(this);
        }
    };


    /*  Summary :   Create a ResolveListener to look if connection is established for set  host port and ip address
    *               and manage error
    *   Param. :    Nothing
    *   Returns:    NsdManager with host infos
    *   Exception : -
    */
    NsdManager.ResolveListener mResolveListener = new NsdManager.ResolveListener() {

        @Override
        public void onResolveFailed(NsdServiceInfo serviceInfo, int errorCode) {
            // Called when the resolve fails. Use the error code to debug.
            System.out.println("Resolve failed " + errorCode);
            System.out.println("serivce = " + serviceInfo);
        }

        @Override
        public void onServiceResolved(NsdServiceInfo serviceInfo) {
            System.out.println("Resolve Succeeded. " + serviceInfo);

            if (serviceInfo.getServiceName().equals(SERVICE_NAME)) {
                System.out.println("Same IP.");
                return;
            }

            // Obtain port and IP
            hostPort = serviceInfo.getPort();
            hostAddress = serviceInfo.getHost();
        }
    };
}
