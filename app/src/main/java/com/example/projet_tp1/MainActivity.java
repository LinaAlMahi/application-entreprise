package com.example.projet_tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.projet_tp1.classes.Entreprise;

public class MainActivity extends AppCompatActivity {
TextView txnom,txnum,txfondateur,txsecteurdactiviter,txsiegesocial;
ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txnom = findViewById(R.id.txtnom);
        txnum = findViewById(R.id.txtnum);
        txfondateur = findViewById(R.id.txtfondateur);
        txsecteurdactiviter = findViewById(R.id.txtsecteurdactiviter);
        txsiegesocial = findViewById(R.id.txtsiegesocial);
        image = findViewById(R.id.image);

        if(getIntent().getExtras() != null) {
            Entreprise p = (Entreprise) getIntent().getSerializableExtra("Entreprise");
            txnom.setText(p.getNom());
            txnum.setText(p.getNum());
            txfondateur.setText(p.getFondateur());
            txsecteurdactiviter.setText(p.getSecteurdactiv());
            txsiegesocial.setText(p.getSiègesocial());
            image.setImageResource(p.getLogo());



        }
        }
}