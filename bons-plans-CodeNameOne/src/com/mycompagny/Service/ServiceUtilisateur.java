/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompagny.Service;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.MultipartRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.Entite.BonPlan;
import com.mycompany.Entite.Commentaire;
import com.mycompany.Entite.Utilisateur;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author amir
 */

public class ServiceUtilisateur {
    
    
//    public ArrayList<Commentaire> getComments(int idBonPlan) 
//     {
//         System.out.println("1com");
//        ArrayList<Commentaire> listComments = new ArrayList<>();
//        ConnectionRequest con = new ConnectionRequest();
//        con.setUrl("http://127.0.0.1/BonPlanMobile/crudCommentaire.php?type=afficher&idBonPlan="+idBonPlan);
// System.out.println("2com");
//        con.addResponseListener(new ActionListener<NetworkEvent>() {
//            @Override
//            public void actionPerformed(NetworkEvent evt) {
//                JSONParser jsonp;                
//                jsonp = new JSONParser();
//                try {
//                    //renvoi une map avec clé = root et valeur le reste
//                    Map<String, Object> mapCpmments = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
//System.out.println("3com");
//                    List<Map<String, Object>> listOfMaps = (List<Map<String, Object>>) mapCpmments.get("root");
//
//                    for (Map<String, Object> obj : listOfMaps) {
//                        Commentaire comment = new Commentaire();
//                        float id = Float.parseFloat(obj.get("id").toString());
//                        float idAuteur = Float.parseFloat(obj.get("id_auteur").toString());
//                        String contenu = obj.get("contenu").toString();
//                        String date=obj.get("date_creation").toString();
//
//                        comment.setId((int) id);
//                        comment.setIdAuteur((int) idAuteur);
//                        comment.setContenu(contenu);
//                        comment.setDateCreation(date);
//                        
//                        listComments.add(comment);
//
//                    }
//                } catch (IOException ex) {
//                    System.out.println(ex);
//                } 
//
//            }
//        });
//        NetworkManager.getInstance().addToQueueAndWait(con);
//        return listComments;
//    }
//    
    
     public ArrayList<Utilisateur> Login(Utilisateur utilisateur) {
        String Url = "http://127.0.0.1/BonPlanMobile/login.php?type=verifLogin&login="+utilisateur.getUsername()+"&password="+utilisateur.getPassword();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl(Url);
        ArrayList<Utilisateur> listUser = new ArrayList<>();
        System.out.println("FONCTION");

//            String str = new String(con.getResponseData());
//            System.out.println("LISTENER");
            con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp;                
                jsonp = new JSONParser();
                try {
                    //renvoi une map avec clé = root et valeur le reste
                    Map<String, Object> mapUser = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
System.out.println("actionPerformed");
                    List<Map<String, Object>> listOfMaps = (List<Map<String, Object>>) mapUser.get("root");

                    for (Map<String, Object> obj : listOfMaps) {
                        Utilisateur utilisateur = new Utilisateur();
                        float id = Float.parseFloat(obj.get("id").toString());
                        String username = (obj.get("username").toString());
                        String adresse  = obj.get("adresse").toString();
                        String photoDeProfil=obj.get("photo_de_profil").toString();
                        String nom=obj.get("nom").toString();
                        String prenom=obj.get("prenom").toString();
                        
                        
                        utilisateur.setId((int) id);
                        utilisateur.setUsername( username);
                        utilisateur.setAdresse(adresse);
                        utilisateur.setPhotoDeProfil(photoDeProfil);
                        utilisateur.setNom(nom);
                        utilisateur.setPrenom(prenom);
                        
                        System.out.println(utilisateur.getUsername()+" "+utilisateur.getAdresse()+ " ");
                        
                        listUser.add(utilisateur);

                    }
                } catch (IOException ex) {
                    System.out.println(ex);
                } 

            }
        });
            
        NetworkManager.getInstance().addToQueueAndWait(con);
        
return listUser;
    
}
     
}
