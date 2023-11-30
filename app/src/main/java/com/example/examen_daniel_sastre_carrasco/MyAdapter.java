package com.example.examen_daniel_sastre_carrasco;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends ArrayAdapter<String> {

    private final String[] titulos;

    private final int[] imagenes;
    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    public MyAdapter(Context context, String[] titulos,int[] imagenes) {
        super(context, R.layout.list_items, titulos);
        this.titulos = titulos;
        this.imagenes = imagenes;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_items, parent, false);
        }

        TextView textViewTitulo = convertView.findViewById(R.id.textViewTitulo);
        ImageView imageViewIcono = convertView.findViewById(R.id.imageViewIcono);

        textViewTitulo.setText(titulos[position]);
        imageViewIcono.setImageResource(imagenes[position]);
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(position);
                }
            }
        });

        return convertView;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}
