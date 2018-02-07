//Primer fragmento o ventana que se puede accesar en la aplicación desde el menú, en esta ventana se tiene la información de registro

// También en esta ventana se debe conectar con el servidor para que realice la verificación de los datos y se procede a interpretar la acción a realizar a partir de si se encuentra el usuario en el registro

package com.estimote.proximitycontent;

import android.app.Fragment;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

import static android.webkit.ConsoleMessage.MessageLevel.LOG;

public class FirstFragment extends Fragment {
    View myView;
    Button boton_reg;
    EditText user;
    EditText password;
    TextView lolo;
    String registrado="N";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.first_layout,container,false);

        boton_reg = (Button) myView.findViewById(R.id.button_reg);
        user = (EditText) myView.findViewById(R.id.user);
        password = (EditText) myView.findViewById(R.id.password);
        lolo = (TextView) myView.findViewById(R.id.registro);

        boton_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //new ConsultarDatos().execute("http://172.18.31.210/Servidor/login.php?user="+user.getText().toString()+"&pass="+password.getText().toString());
                //new ConsultarDatos().execute("http://172.18.31.210/Servidor/APP/tutorial/consulta.php?id="+user.getText().toString());
                new ConsultarDatos().execute("http://172.21.255.67/Servidor/consulta.php?user="+user.getText().toString()+"&tel="+password.getText().toString());

                if ("S".equals(registrado)){
                    Toast.makeText(getActivity(),"Registrado",Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(getActivity(),"NC",Toast.LENGTH_SHORT).show();
                }
                ((MainActivity)getActivity()).writedata(registrado);

                Log.d("dato",registrado);

            }
        });

        return myView;
    }



    private class ConsultarDatos extends AsyncTask<String, Void, String> {
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

            JSONArray ja = null;
            try {
                ja = new JSONArray(result);
                registrado = ja.getString(0);
                if ("S".equals(registrado)){
                lolo.setText("JYAN");}else{lolo.setText(ja.getString(0));}

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    private String downloadUrl(String myurl) throws IOException {
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
