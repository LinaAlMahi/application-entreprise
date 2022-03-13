package com.example.projet_tp1.classes;

import java.io.Serializable;

public class Entreprise implements Serializable {
    private int id;
    private String nom;
    private String fondateur;
    private String secteurdactiv;
    private String siègesocial;
    private String num;
    private int logo;
    private static int comp=0;

    public Entreprise(String nom, String fondateur, String num,int logo, String secteurdactiv, String siègesocial) {
        this.id = ++comp;
        this.nom = nom;
        this.fondateur = fondateur;
        this.logo=logo;
        this.num=num;
        this.secteurdactiv = secteurdactiv;
        this.siègesocial = siègesocial;
    }

    public Entreprise() {
        id=++comp;
    }

    public int getId() {
        return id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getNom() {
        return nom;
    }

    public String getFondateur() {
        return fondateur;
    }



    public String getSecteurdactiv() {
        return secteurdactiv;
    }

    public int getLogo() {
        return logo;
    }

    public String getSiègesocial() {
        return siègesocial;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }

    public void setFondateur(String fondateur) {
        this.fondateur = fondateur;
    }



    public void setSecteurdactiv(String secteurdactiv) {
        this.secteurdactiv = secteurdactiv;
    }

    public void setSiègesocial(String siègesocial) {
        this.siègesocial = siègesocial;
    }

    @Override
    public String toString() {
        return "Entreprise{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", fondateur='" + fondateur + '\'' +
                ", secteurdactiv='" + secteurdactiv + '\'' +
                ", siègesocial='" + siègesocial + '\'' +
                ", num=" + num +
                ", logo=" + logo +
                '}';
    }
}

