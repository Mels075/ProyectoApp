package com.estimote.proximitycontent;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Help extends Fragment {
    View myView;
    String titulo = "Datos importantes:";
    String ingresar = "Al iniciar la aplicación usted deberá registrarse, con el fin de que pueda realizar abrir las puertas de los pisos";
    String registro = "Si no posee una cuenta válida deberá acceder a la página web disponible, solo en él podrá realizar una cuenta nueva";
    String menu = "En las opciones que muestra el menú se puede observar en cuál piso se encuentra a medida que se acerque o aleje de los beacons";
    String pisoact = "Piso Actual muestra el diagrama general del piso en el que se encuentra";
    String info = "En la sección información se encuentran la información las oficinas del piso en el que usted está ubicado";
    String moreinfo = "Para más información puede consultar a cualquiera de los desarrolladores, cuyos datos se encuentran en la seción Contactos";



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.help, container,false);

        ArrayList<String> ayuda = new ArrayList<String>();
        ayuda.add(titulo);
        ayuda.add(ingresar);
        ayuda.add(registro);
        ayuda.add(menu);
        ayuda.add(pisoact);
        ayuda.add(info);
        ayuda.add(moreinfo);

        ListView Lista = (ListView) myView.findViewById(R.id.Helpme);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,ayuda);
        Lista.setAdapter(adapter);


        return myView;
    }
}