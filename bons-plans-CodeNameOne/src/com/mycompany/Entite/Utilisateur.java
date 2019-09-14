/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entite;

/**
 *
 * @author Pc
 */
public class Utilisateur {
    
    private static int id;
    private static String username;
    private static String adresse;
    private static String photoDeProfil;
    private static String nom;
    private static String prenom;
    private static String password;



    public Utilisateur() {
    }

    public Utilisateur(int id) {
        this.id = id;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Utilisateur.id = id;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        Utilisateur.username = username;
    }

    public static String getAdresse() {
        return adresse;
    }

    public static void setAdresse(String adresse) {
        Utilisateur.adresse = adresse;
    }

    public static String getPhotoDeProfil() {
        return photoDeProfil;
    }

    public static void setPhotoDeProfil(String photoDeProfil) {
        Utilisateur.photoDeProfil = photoDeProfil;
    }

    public static String getNom() {
        return nom;
    }

    public static void setNom(String nom) {
        Utilisateur.nom = nom;
    }

    public static String getPrenom() {
        return prenom;
    }

    public static void setPrenom(String prenom) {
        Utilisateur.prenom = prenom;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        Utilisateur.password = password;
    }
    
    
}
