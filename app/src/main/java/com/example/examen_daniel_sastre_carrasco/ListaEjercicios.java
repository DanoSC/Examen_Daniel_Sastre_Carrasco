package com.example.examen_daniel_sastre_carrasco;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListaEjercicios#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListaEjercicios extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    private ListView listview;
    private ArrayList<String> names;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private TextView Ejercicio1;
    private TextView Ejercicio2;
    private TextView Ejercicio3;
    private TextView Ejercicio4;

    public ListaEjercicios() {
        // Required empty public constructor
    }
    public static ListaEjercicios newInstance(String param1, String param2) {
        ListaEjercicios fragment = new ListaEjercicios();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);


        }
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View root =  inflater.inflate(R.layout.fragment_lista_ejercicios, container, false);
        listview = (ListView) root.findViewById(R.id.listView);
        // Datos de ejemplo
        String[] titulos = {"Ejercicio 1", "Ejercicio 2", "Ejercicio 3", "Ejercicio 4"};
        int[] imagenes = {R.drawable.corrercinta, R.drawable.nadar, R.drawable.jabalina,R.drawable.trampolin};
        // Crear y establecer el adaptador personalizado
        MyAdapter adapter = new MyAdapter(requireContext(), titulos, imagenes);
        listview.setAdapter(adapter);
        // Configurar el listener de clic en el adaptador
        adapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                FragmentTransaction fragmentTransaction;
                switch (position) {
                    case 0:
                        Ejercicio1 ejer1 = new Ejercicio1();
                        fragmentTransaction = getParentFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.fragmentContainerView,ejer1);
                        fragmentTransaction.commit();
                        break;
                    case 1:
                        Ejercicio2 ejer2 = new Ejercicio2();
                        fragmentTransaction = getParentFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.fragmentContainerView,ejer2);
                        fragmentTransaction.commit();
                        break;
                    case 2:
                        Ejercicio3 ejer3 = new Ejercicio3();
                        fragmentTransaction = getParentFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.fragmentContainerView,ejer3);
                        fragmentTransaction.commit();
                        break;
                    case 3:
                        Ejercicio4 ejer4 = new Ejercicio4();
                        fragmentTransaction = getParentFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.fragmentContainerView,ejer4);
                        fragmentTransaction.commit();
                        break;
                }
            }
        });

        listview.setAdapter(adapter);
        return root;
    }



}