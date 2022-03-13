package com.example.projet_tp1.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.projet_tp1.R;
import com.example.projet_tp1.classes.Entreprise;

import java.util.List;

public class EntrepriseAdapter extends BaseAdapter {

    private List<Entreprise> entreprises;
    private LayoutInflater inflater;

    public EntrepriseAdapter(List<Entreprise> entreprises, Activity activity) {
        this.entreprises = entreprises;
        this.inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return entreprises.size();
    }

    @Override
    public Object getItem(int i) {
        return entreprises.get(i);
    }

    @Override
    public long getItemId(int i) {
        return entreprises.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null)
            view = inflater.inflate(R.layout.item_entreprise, null);

        TextView id= view.findViewById(R.id.id);
        TextView nom = view.findViewById(R.id.nom);
        TextView siègesocial = view.findViewById(R.id.siègesocial);
        TextView num = view.findViewById(R.id.num);
        ImageView image = view.findViewById(R.id.image);
        ImageView image1 = view.findViewById(R.id.imageView1);
        ImageView image2 = view.findViewById(R.id.imageView2);

        id.setText(getItemId(i)+"");
        nom.setText(entreprises.get(i).getNom());
        num.setText(entreprises.get(i).getNum());
        siègesocial.setText(entreprises.get(i).getSiègesocial());
        image.setImageResource(entreprises.get(i).getLogo());
        image1.setImageResource(R.drawable.lieu);
        image2.setImageResource(R.drawable.telephone);
        return view;
    }
}
