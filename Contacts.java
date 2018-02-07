package com.estimote.proximitycontent;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class Contacts extends Fragment {
    View myView;

    String melissa = "Melissa Fonseca Rodríguez \n\n\t\t\t\t\t\t\t\t\t\t\t\t mfonsecarodriguez83@gmail.com\n";
    String dayhana = "Dayhana Sánchez Jiménez \n\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t dayhana.sj@gmail.com\n";
    String marco   = "Marco Oviedo Hernández \n\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t marcov2811@gmail.com\n";
    String johan   = "Johan Arrieta Solórzano \n\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t johnarso@gmail.com \n";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.contacts, container,false);
        ArrayList<String> Contactos = new ArrayList<String>();

        Contactos.add(johan);
        Contactos.add(melissa);
        Contactos.add(marco);
        Contactos.add(dayhana);

        ListView Lista = (ListView) myView.findViewById(R.id.ListaContactos);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,Contactos);
        Lista.setAdapter(adapter);

        return myView;
    }
}
