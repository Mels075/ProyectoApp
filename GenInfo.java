//Realizado por: Melissa Fonseca Rodríguez
//Instituto Tecnológico de Costa Rica

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

public class GenInfo extends Fragment {
    View myView;

    String titulo   = "Nombre \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t Oficina";
    //Piso 1
    String fcoto    = "Fabián Coto Calvo \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t 107";
    String bodega   = "Bodega Electrónica \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t\t 113";
    //Piso 2
    String asocia   = "Asociación de Electrónica \t \t \t \t \t \t \t \t \t \t\t\t 214";
    String cbadilla = "Carlos Badilla Corrales \t \t \t \t \t \t \t \t \t \t \t \t \t \t 204";
    //Piso 3
    String jbarboza = "José Miguel Barboza Retana \t \t \t \t \t \t \t \t \t \t 321";
    String sbrenes  = "Sonia Brenes Hernández \t \t \t \t \t \t \t \t \t \t \t \t \t 304";
    String achacon  = "Alfonso Chacón Rodríguez \t \t \t \t \t \t \t \t \t \t \t \t 308";
    String achaves  = "Adolfo Chaves Jiménez \t \t \t \t \t \t \t \t \t \t \t \t \t \t 311";
    String acoto    = "Anibal Coto Cortés \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t 313";
    String advanzo  = "Adriana D'Avanzo Calderón \t \t \t \t \t \t \t \t \t \t \t 305";
    String rgarcia  = "Ronny García Ramírez \t \t \t \t \t \t \t \t \t \t \t \t \t \t 320";
    String einteriano= "Eduardo Interiano Salguero \t \t \t \t \t \t \t \t \t \t \t 309";
    String rmolina  = "Roberto Molina Robles \t \t \t \t \t \t \t \t \t \t \t \t \t \t 319";
    String amontoya = "Andrea Montoya Quesada \t \t \t \t \t \t \t \t \t \t \t \t 303";
    String fnavarro = "Francisco Navarro Henríquez \t \t \t \t \t \t \t \t \t \t 302";
    String rsoto    = "Ronald Soto Fallas \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t 307";
    String gtrejos  = "Grettel Trejos Salas \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t\t 314";
    //Piso 4
    String yarias   = "Yeiner Arias Esquivel \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t425";
    String jdiaz    = "José Alberto Díaz García \t \t \t \t \t \t \t \t \t \t \t \t \t413";
    String mihernandez= "Miguel Hernández Rivera \t \t \t \t \t \t \t \t \t \t \t \t \t411";
    String jjimenez = "Juan Carlos Jiménez Robles \t \t \t \t \t \t \t \t \t \t \t412";
    String dkohkemper= "Daniel Kohkemper Granados \t \t \t \t \t \t \t \t \t \t424";
    String cmeza    = "Carlos Meza Benavides \t \t \t \t \t \t \t \t \t \t \t \t \t403";
    String fmontes  = "Faustino Montes de Oca Murillo \t \t \t \t \t \t \t \t \t401";
    String smorales = "Sergio Morales Hernández \t \t \t \t \t \t \t \t \t \t \t \t402";
    String jperez   = "Javier Pérez Rodríguez \t \t \t \t \t \t \t \t \t \t \t \t \t\t421";
    String lrivas   = "Leonardo Rivas Arce \t \t \t \t \t \t \t \t \t \t \t \t \t \t\t408";
    String csalazar = "Carlos Salazar García \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t425";
    String hsanchez = "Hugo Sánchez Ortiz \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t417";
    String csegura  = "Carlos Mauricio Segura Quirós \t \t \t \t \t \t \t \t \t415";
    //Piso 5
    String iaraya   = "Iván Araya Meneses \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t 522";
    String sarriola = "Sergio Arriola Valverde \t \t \t \t \t \t \t \t \t \t \t \t \t \t 509";
    String jbrenes  = "Juan Carlos Brenes Torres \t \t \t \t \t \t \t \t \t \t \t \t 522";
    String acarrasquilla = "Arys Carrasquilla Batista \t \t \t \t \t \t \t \t \t \t \t \t \t 502";
    String jchaves  = "Juan Scott Chaves Noguera \t \t \t \t \t \t \t \t \t \t \t 523";
    String jcrespo  = "Juan Luis Crespo Mariño \t \t \t \t \t \t \t \t \t \t \t \t \t 516";
    String mahernandez= "Marvin Hernández Cisneros \t \t \t \t \t \t \t \t \t \t \t 521";
    String nhernandez= "Néstor Hernández Hostaller \t \t \t \t \t \t \t \t \t \t \t 513";
    String wmarin   = "William Marín Moreno \t \t \t \t \t \t \t \t \t \t \t \t \t \t 510";
    String gortiz   = "Gabriela Ortiz León \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t 515";
    String hphillips= "Hayden Phillips Brenes \t \t \t \t \t \t \t \t \t \t \t \t \t \t 506";
    String rrimolo  = "Renato Rímolo Donadio \t \t \t \t \t \t \t \t \t \t \t \t \t 508";
    String mvilchez = "Marta Vílchez Monge \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t 515";



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.gen_info, container,false);

        ArrayList<String> GentePiso1 = new ArrayList<String>();
        ArrayList<String> GentePiso2 = new ArrayList<String>();
        ArrayList<String> GentePiso3 = new ArrayList<String>();
        ArrayList<String> GentePiso4 = new ArrayList<String>();
        ArrayList<String> GentePiso5 = new ArrayList<String>();
        GentePiso1.add(titulo);
        GentePiso1.add(fcoto);
        GentePiso1.add(bodega);

        GentePiso2.add(titulo);
        GentePiso2.add(asocia);
        GentePiso2.add(cbadilla);

        GentePiso3.add(titulo);
        GentePiso3.add(jbarboza);
        GentePiso3.add(sbrenes);
        GentePiso3.add(achacon);
        GentePiso3.add(achaves);
        GentePiso3.add(acoto);
        GentePiso3.add(advanzo);
        GentePiso3.add(rgarcia);
        GentePiso3.add(einteriano);
        GentePiso3.add(rmolina);
        GentePiso3.add(amontoya);
        GentePiso3.add(fnavarro);
        GentePiso3.add(rsoto);
        GentePiso3.add(gtrejos);

        GentePiso4.add(titulo);
        GentePiso4.add(yarias);
        GentePiso4.add(jdiaz);
        GentePiso4.add(mihernandez);
        GentePiso4.add(jjimenez);
        GentePiso4.add(dkohkemper);
        GentePiso4.add(cmeza);
        GentePiso4.add(fmontes);
        GentePiso4.add(smorales);
        GentePiso4.add(jperez);
        GentePiso4.add(lrivas);
        GentePiso4.add(csalazar);
        GentePiso4.add(hsanchez);
        GentePiso4.add(csegura);

        GentePiso5.add(titulo);
        GentePiso5.add(iaraya);
        GentePiso5.add(sarriola);
        GentePiso5.add(jbrenes);
        GentePiso5.add(acarrasquilla);
        GentePiso5.add(jchaves);
        GentePiso5.add(jcrespo);
        GentePiso5.add(mahernandez);
        GentePiso5.add(nhernandez);
        GentePiso5.add(wmarin);
        GentePiso5.add(gortiz);
        GentePiso5.add(hphillips);
        GentePiso5.add(rrimolo);
        GentePiso5.add(mvilchez);

        ListView Lista = (ListView) myView.findViewById(R.id.ListaGente);

        String[] sitio = ((MainActivity)getActivity()).LeerDatosBeacons();
        String piso = sitio[0];
        if (piso == "1"){
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,GentePiso1);
            Lista.setAdapter(adapter);
        } else if (piso == "2"){
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,GentePiso2);
            Lista.setAdapter(adapter);
        } else if (piso == "3"){
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,GentePiso3);
            Lista.setAdapter(adapter);
        } else if (piso == "4"){
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,GentePiso4);
            Lista.setAdapter(adapter);
        } else if (piso == "5"){
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,GentePiso5);
            Lista.setAdapter(adapter);
        }

        return myView;
    }

}
