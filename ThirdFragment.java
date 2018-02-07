//Realizado por: Melissa Fonseca Rodríguez
//Instituto Tecnológico de Costa Rica

package com.estimote.proximitycontent;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class ThirdFragment extends Fragment{
    View myView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.third_layout,container,false);
        ImageView piso_comp = (ImageView) myView.findViewById(R.id.piso_comp);

        String[] sitio = ((MainActivity)getActivity()).LeerDatosBeacons();
        String piso = sitio[0];
        if (piso == "1"){
            piso_comp.setImageResource(R.drawable.piso1comp);
        } else if (piso == "2"){
            piso_comp.setImageResource(R.drawable.piso2comp);
        } else if (piso == "3"){
            piso_comp.setImageResource(R.drawable.piso3comp);
        } else if (piso == "4"){
            piso_comp.setImageResource(R.drawable.piso4comp);
        } else if (piso == "5"){
            piso_comp.setImageResource(R.drawable.piso5comp);
        }

        return myView;
    }
}
