package com.example.projet_tp1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projet_tp1.adapter.EntrepriseAdapter;
import com.example.projet_tp1.classes.Entreprise;
import com.example.projet_tp1.service.EntrepriseService;

import java.io.Serializable;

public class ListEntrepriseActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView lv;
    EntrepriseService es;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_list_entreprise);


        lv = findViewById(R.id.liste);
        es = EntrepriseService.getInstance();
        es.create(new Entreprise("SKILLSAY","Amine Mohamed Guessous",
                "0675529132",R.drawable.shareimg,"Informatique","Casablanca"));
        es.create(new Entreprise("SYSPOWER ","Abdeslam Ahizoune",
                "0661070434", R.drawable.syspower,"Audit et Contrôle ","Rabat"));
        es.create(new Entreprise("AgenZ","MALIK BELKEZIZ",
                "0612091904", R.drawable.agenz,"Immobiliers","Casablanca"));
        es.create(new Entreprise("AC2i","Souria Oulad A.",
                "0537731165", R.drawable.technopark,"Management","Rabat"));
        es.create(new Entreprise("ALGORITE","Sara Loutfi",
                "0661637910", R.drawable.algorite,"Informatique","tanger"));
        es.create(new Entreprise("CRAFTSOFT","Rachid AITYAAZZA",
                "0662808322", R.drawable.logo1,"Informatique","Casablanca"));
        es.create(new Entreprise("ALIAS BLUE","Elhoussin GHANEM",
                "0668524414", R.drawable.alias,"Développement","Casablanca"));

            lv.setAdapter(new EntrepriseAdapter(es.findAll(),ListEntrepriseActivity.this));
            lv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        TextView idd = view.findViewById(R.id.id);

        Toast.makeText(this, idd.getText().toString(), Toast.LENGTH_SHORT).show();

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Choisir une option");
        alertDialogBuilder.setPositiveButton("Supprimer", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {

                es.delete(es.findById(Integer.parseInt(idd.getText().toString())));
                lv.setAdapter(new EntrepriseAdapter(es.findAll(),ListEntrepriseActivity.this));

            }
        });
        alertDialogBuilder.setNegativeButton("Details",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent =  new Intent(ListEntrepriseActivity.this,MainActivity.class);
                intent.putExtra("Entreprise", (Serializable) es.findById(Integer.parseInt(idd.getText().toString())));
                startActivity(intent);
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }
}