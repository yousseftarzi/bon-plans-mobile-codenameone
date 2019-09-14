/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;

/**
 *
 * @author youssefc
 */
public class BonPlan {
    private int id;
    private int idCategorie;
    private String titre;
    private String adresse;
    private String description; 
    private String image;
    private String loginAuteur;
    private String typeAuteur;
    private int etatCoupon;
    private Date dateCreation;
    private double note;

    public BonPlan() {
        
    }

    public BonPlan(int idCategorie,String titre, String adresse, String description, String image, String loginAuteur, String typeAuteur, int etatCoupon) {
        this.idCategorie=idCategorie;
        this.titre = titre;
        this.adresse = adresse;
        this.description = description;
        this.image = image;
        this.loginAuteur = loginAuteur;
        this.typeAuteur = typeAuteur;
        this.etatCoupon = etatCoupon;  
    }

    public BonPlan(String titre, String adresse, String description, String typeAuteur, int etatCoupon, Date dateCreation, double note) {
        this.titre = titre;
        this.adresse = adresse;
        this.description = description;
        this.typeAuteur = typeAuteur;
        this.etatCoupon = etatCoupon;
        this.dateCreation = dateCreation;
        this.note = note;
    }

    
    
    public BonPlan(int idCategorie, String titre, String adresse, String description, String image, String loginAuteur, String typeAuteur, int etatCoupon, Date dateCreation, double note) {
        this.idCategorie = idCategorie;
        this.titre = titre;
        this.adresse = adresse;
        this.description = description;
        this.image = image;
        this.loginAuteur = loginAuteur;
        this.typeAuteur = typeAuteur;
        this.etatCoupon = etatCoupon;
        this.dateCreation = dateCreation;
        this.note = note;
    }

    public BonPlan(int idCategorie, String titre, String adresse, String description, String image, String loginAuteur, String typeAuteur) {
        this.idCategorie = idCategorie;
        this.titre = titre;
        this.adresse = adresse;
        this.description = description;
        this.image = image;
        this.loginAuteur = loginAuteur;
        this.typeAuteur = typeAuteur;
    }
    
    

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLoginAuteur() {
        return loginAuteur;
    }

    public void setLoginAuteur(String loginAuteur) {
        this.loginAuteur = loginAuteur;
    }

    public String getTypeAuteur() {
        return typeAuteur;
    }

    public void setType_auteur(String type_auteur) {
        this.typeAuteur = type_auteur;
    }

    public int getEtatCoupon() {
        return etatCoupon;
    }

    public void setEtatCoupon(int etatCoupon) {
        this.etatCoupon = etatCoupon;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }
  
}
