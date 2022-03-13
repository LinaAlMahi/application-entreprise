package com.example.projet_tp1.service;

import com.example.projet_tp1.classes.Entreprise;
import com.example.projet_tp1.dao.IDao;

import java.util.ArrayList;
import java.util.List;

public class EntrepriseService implements IDao<Entreprise> {
private List<Entreprise>entreprises;
private static EntrepriseService instance;
private EntrepriseService(){this.entreprises=new ArrayList<>();}

    @Override
    public boolean create(Entreprise o) {
        return entreprises.add(o);
    }

    @Override
    public boolean update(Entreprise o) {
        return false;
    }

    @Override
    public boolean delete(Entreprise o) {
        return entreprises.remove(o);
    }

    @Override
    public List<Entreprise> findAll() {
        return entreprises;
    }

    @Override
    public Entreprise findById(int id) {
    for(Entreprise e : entreprises){
        if(e.getId()==id)
            return e;
    }
        return null;
    }
    public synchronized static EntrepriseService getInstance(){
    if(instance==null)
        instance=new EntrepriseService();
    return instance;
    }
}
