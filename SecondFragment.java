package com.estimote.proximitycontent;

import android.app.Fragment;
import android.media.Image;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.SimpleTimeZone;


public class SecondFragment extends Fragment{
    View myView;
    String permission = "S";
    TextView datos;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.second_layout,container,false);
        ImageButton but_open = (ImageButton) myView.findViewById(R.id.button_open);
        ImageView piso_act = (ImageView) myView.findViewById(R.id.piso_actual);
        ImageView circ = (ImageView) myView.findViewById(R.id.circverde);
        datos = (TextView) myView.findViewById(R.id.textViewP);

        String info =((MainActivity)getActivity()).readdata();  // Llama a función en el MainActivity en donde se tienen los datos del permiso de uso
        //Para saber en que piso me encuentro y poner la imagen que sea la correcta
        String[] sitio = ((MainActivity)getActivity()).LeerDatosBeacons();
        String piso = sitio[0];
        String puerta = sitio[1];

        circ.setVisibility(View.INVISIBLE);
        String[] lugar = ((MainActivity)getActivity()).LeerDatosBeacons();
        datos.setText(lugar[0]+lugar[1]);

        if ( permission.equals(info) ){
            but_open.setImageResource(R.drawable.botonverde);
            if (puerta == "2"){
                circ.setX(30);
                circ.setY(100);
            } else {
                circ.setX(150);
                circ.setY(100);
            }
            circ.setVisibility(View.VISIBLE);

            but_open.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getActivity(),"Presionado",Toast.LENGTH_SHORT).show();
                    String[] lugar = ((MainActivity)getActivity()).LeerDatosBeacons();
                    datos.setText(lugar[0]+lugar[1]);
                    new CargarDatos().execute("http://172.21.255.67/Servidor/registro.php?nombres="+lugar[0]+"&tel="+lugar[1]);
                }
            });
        }

        if (piso == "1"){
            piso_act.setImageResource(R.drawable.piso1);
        } else if (piso == "2"){
            piso_act.setImageResource(R.drawable.piso2);
        } else if (piso == "3"){
            piso_act.setImageResource(R.drawable.piso3);
        } else if (piso == "4"){
            piso_act.setImageResource(R.drawable.piso4);
        } else if (piso == "5"){
            piso_act.setImageResource(R.drawable.piso5);
        }

        return myView;
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

            Toast.makeText(getActivity(), "Se almacenaron los datos correctamente", Toast.LENGTH_LONG).show();

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
