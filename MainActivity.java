//Realizado por: Melissa Fonseca Rodríguez
//Instituto Tecnológico de Costa Rica

package com.estimote.proximitycontent;

import android.app.FragmentManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.estimote.coresdk.common.requirements.SystemRequirementsChecker;
import com.estimote.proximitycontent.estimote.BeaconID;
import com.estimote.proximitycontent.estimote.EstimoteCloudBeaconDetailsFactory;
import com.estimote.proximitycontent.estimote.ProximityContentManager;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private static final String TAG = "MainActivity";
    String data_reg;
    String reg_piso;
    String reg_puerta;

    private ProximityContentManager beaconR2B1;
    private ProximityContentManager beaconR2B2;
    private ProximityContentManager beaconR2B3;
    private ProximityContentManager beaconR1B1;
    private ProximityContentManager beaconR1B2;
    private ProximityContentManager beaconR1B3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StrictMode.ThreadPolicy p = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(p);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.relativeLayout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Beacons
        beaconR2B2 = new ProximityContentManager(this, Arrays.asList(
                new BeaconID("B9407F30-F5F8-466E-AFF9-25556B57FE6A", 2, 1), //No existe
                new BeaconID("B9407F30-F5F8-466E-AFF9-25556B57FE6D", 2, 2),
                new BeaconID("B9407F30-F5F8-466E-AFF9-25556B57FE6A", 2, 3)), //No existe
                new EstimoteCloudBeaconDetailsFactory());
        beaconR2B3 = new ProximityContentManager(this, Arrays.asList(
                new BeaconID("B9407F30-F5F8-466E-AFF9-25556B57FE6A", 2, 1), //No existe
                new BeaconID("B9407F30-F5F8-466E-AFF9-25556B57FE6A", 2, 2), //No existe
                new BeaconID("B9407F30-F5F8-466E-AFF9-25556B57FE6D", 2, 3)),
                new EstimoteCloudBeaconDetailsFactory());
        beaconR2B1 = new ProximityContentManager(this, Arrays.asList(
                new BeaconID("B9407F30-F5F8-466E-AFF9-25556B57FE6A", 2, 2), //No existe
                new BeaconID("B9407F30-F5F8-466E-AFF9-25556B57FE6D", 2, 1),
                new BeaconID("B9407F30-F5F8-466E-AFF9-25556B57FE6A", 2, 3)), //No existe
                new EstimoteCloudBeaconDetailsFactory());
        beaconR1B1 = new ProximityContentManager(this, Arrays.asList(
                new BeaconID("B9407F30-F5F8-466E-AFF9-25556B57FE6D", 1, 1),
                new BeaconID("B9407F30-F5F8-466E-AFF9-25556B57FE6A", 1, 2), //No existe
                new BeaconID("B9407F30-F5F8-466E-AFF9-25556B57FE6A", 1, 3)), //No existe
                new EstimoteCloudBeaconDetailsFactory());
        beaconR1B2 = new ProximityContentManager(this, Arrays.asList(
                new BeaconID("B9407F30-F5F8-466E-AFF9-25556B57FE6A", 1, 1), //No existe
                new BeaconID("B9407F30-F5F8-466E-AFF9-25556B57FE6D", 1, 2),
                new BeaconID("B9407F30-F5F8-466E-AFF9-25556B57FE6A", 1, 3)), //No existe
                new EstimoteCloudBeaconDetailsFactory());
        beaconR1B3 = new ProximityContentManager(this, Arrays.asList(
                new BeaconID("B9407F30-F5F8-466E-AFF9-25556B57FE6A", 1, 1), //No existe
                new BeaconID("B9407F30-F5F8-466E-AFF9-25556B57FE6A", 1, 2), //No existe
                new BeaconID("B9407F30-F5F8-466E-AFF9-25556B57FE6D", 1, 3)),
                new EstimoteCloudBeaconDetailsFactory());

        beaconR2B1.setListener(new ProximityContentManager.Listener() {
            @Override
            public void onContentChanged(Object r2b1) {
                if (r2b1 != null) {
                    GuardarDatosBeacons("1","1");
                }
            }
        });
        beaconR2B3.setListener(new ProximityContentManager.Listener() {
            @Override
            public void onContentChanged(Object r2b3) {
                if (r2b3 != null) {
                    GuardarDatosBeacons("3","1");
                }
            }
        });
        beaconR2B2.setListener(new ProximityContentManager.Listener() {
            @Override
            public void onContentChanged(Object r2b2) {
                if (r2b2 != null) {
                    GuardarDatosBeacons("2","1");
                }
            }
        });
        beaconR1B1.setListener(new ProximityContentManager.Listener() {
            @Override
            public void onContentChanged(Object r2b1) {
                if (r2b1 != null) {
                    GuardarDatosBeacons("4","1");
                }
            }
        });
        beaconR1B2.setListener(new ProximityContentManager.Listener() {
            @Override
            public void onContentChanged(Object r2b1) {
                if (r2b1 != null) {
                    GuardarDatosBeacons("4","2");
                }
            }
        });
        beaconR1B3.setListener(new ProximityContentManager.Listener() {
            @Override
            public void onContentChanged(Object r2b1) {
                if (r2b1 != null) {
                    GuardarDatosBeacons("5","1");
                }
            }
        });


        //Tengo que escribir en login para usuario y contraseña
        //Se toman los datos de login Si o No
        //Escribir en guardar_en_txt.php para los pisos y puerta

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.relativeLayout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentManager fragmentManager = getFragmentManager();

        if (id == R.id.nav_first_layout) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new FirstFragment())
                    .commit();
        } else if (id == R.id.nav_second_layout) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new SecondFragment())
                    .commit();
        } else if (id == R.id.nav_third_layout) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new ThirdFragment())
                    .commit();
        } else if (id == R.id.nav_fourth_layout) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new GenInfo())
                    .commit();
        } else if (id == R.id.nav_contactos) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new Contacts())
                    .commit();
        } else if (id == R.id.nav_ayuda) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new Help())
                    .commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.relativeLayout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (!SystemRequirementsChecker.checkWithDefaultDialogs(this)) {
            Log.e(TAG, "Can't scan for beacons, some pre-conditions were not met");
            Log.e(TAG, "Read more about what's required at: http://estimote.github.io/Android-SDK/JavaDocs/com/estimote/sdk/SystemRequirementsChecker.html");
            Log.e(TAG, "If this is fixable, you should see a popup on the app's screen right now, asking to enable what's necessary");
        } else {
            Log.d(TAG, "Starting ProximityContentManager content updates");
            beaconR2B1.startContentUpdates();
            beaconR2B2.startContentUpdates();
            beaconR2B3.startContentUpdates();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "Stopping ProximityContentManager content updates");
        beaconR2B1.stopContentUpdates();
        beaconR2B2.stopContentUpdates();
        beaconR2B3.stopContentUpdates();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        beaconR2B1.destroy();
        beaconR2B2.destroy();
        beaconR2B3.destroy();
    }

    public void GuardarDatosBeacons(String piso, String puerta){
        reg_piso = piso;
        reg_puerta = puerta;
    }

    public String[] LeerDatosBeacons(){
        String piso = reg_piso;
        String puerta = reg_puerta;
        return new String[] {piso,puerta};
    }

    public void writedata(String reg){
        data_reg = reg;

    }
    public String readdata(){
        String user = data_reg;
        return user;
    }

    public class CargarDatos extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {

            // params comes from the execute() call: params[0] is the url.
            try {
                return downloadUrl(urls[0]);
            } catch (IOException e) {
                return "Unable to retrieve web page. URL may be invalid.";
            }
        }
        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {

            //Toast.makeText(getApplicationContext(), "Se almacenaron los datos correctamente", Toast.LENGTH_LONG).show();

        }
    }
    public String downloadUrl(String myurl) throws IOException {
        Log.i("URL",""+myurl);
        myurl = myurl.replace(" ","%20");
        InputStream is = null;
        // Only display the first 500 characters of the retrieved
        // web page content.
        int len = 500;

        try {
            URL url = new URL(myurl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000 /* milliseconds */);
            conn.setConnectTimeout(15000 /* milliseconds */);
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            // Starts the query
            conn.connect();
            int response = conn.getResponseCode();
            Log.d("respuesta", "The response is: " + response);
            is = conn.getInputStream();

            // Convert the InputStream into a string
            String contentAsString = readIt(is, len);
            return contentAsString;

            // Makes sure that the InputStream is closed after the app is
            // finished using it.
        } finally {
            if (is != null) {
                is.close();
            }
        }
    }
    public String readIt(InputStream stream, int len) throws IOException, UnsupportedEncodingException {
        Reader reader = null;
        reader = new InputStreamReader(stream, "UTF-8");
        char[] buffer = new char[len];
        reader.read(buffer);
        return new String(buffer);
    }


}
