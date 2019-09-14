/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entite;

/**
 *
 * @author sana
 */
public class BonPlan {
   private String nom;
int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    int nombredecoupon;
    String adress;
    int auteur;
    String img;
    String desc;

    public BonPlan() {
    }

    public BonPlan(int auteur, String nom, String adress,int nombredecoupon,String img) {
        this.auteur = auteur;
        this.nom = nom;
        this.adress=adress;
        this.nombredecoupon=nombredecoupon;
        this.img=img;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getNombredecoupon() {
        return nombredecoupon;
    }

    public void setNombredecoupon(int nombredecoupon) {
        this.nombredecoupon = nombredecoupon;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getAuteur() {
        return auteur;
    }

    public void setAuteur(int auteur) {
        this.auteur = auteur;
    }
   

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

   

    @Override
    public String toString() {
        return "Task{" + "auteur=" + auteur + ", nom=" + nom + '}';
    }
           
}
