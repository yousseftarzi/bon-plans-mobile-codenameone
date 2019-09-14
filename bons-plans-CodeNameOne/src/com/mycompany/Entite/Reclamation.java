/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entite;

/**
 *
 * @author youssefc
 */
public class Reclamation {
    private  int id;
    private String message;
    private int id_source;

 private int etat;

    public Reclamation() {
    }

    public Reclamation(int id, String message, int id_source, int etat) {
        this.id = id;
        this.message = message;
        this.id_source = id_source;
        this.etat = etat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getId_source() {
        return id_source;
    }

    public void setId_source(int id_source) {
        this.id_source = id_source;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "id=" + id + ", message=" + message + ", id_source=" + id_source + ", etat=" + etat + '}';
    }
 
    
}
