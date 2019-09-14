/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.io.FileSystemStorage;
import com.codename1.io.Util;
import com.codename1.ui.Button;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.spinner.Picker;
import com.mycompagny.Service.ServiceCommentaire;
import com.mycompagny.Service.ServiceReservation;
import com.mycompagny.Service.ServiceUtilisateur;
import com.mycompany.Entite.BonPlan;
import com.mycompany.Entite.Reservation;
import com.mycompany.Entite.Utilisateur;


/**
 *
 * @author sana
 */
public class Reserver {

    Form f;
    TextField tnom;
    TextField tetat;
    Button btnajout;
    private Picker dp;

    
    
    public Reserver(BonPlan bonPlan) {
        f = new Form("home");
        tnom = new TextField();
        //tetat = new TextField();
        btnajout = new Button("ajouter");
        
        dp=new Picker();
        f.add(tnom);
        f.add(dp);
       // f.add(tetat);
        f.add(btnajout);
        
        btnajout.addActionListener((e) -> {
            ServiceReservation ser = new ServiceReservation();
            //Reservation t = new Reservation(0, tnom.getText(), tetat.getText());
           // ser.ajoutReservation(t);
            
           Reservation re=new Reservation();
            System.out.println("BON PLAN = "+ bonPlan.toString());
           re.setId_bon_plan(bonPlan.getId());
           re.setId_bon_planeur(Utilisateur.getId());
           String nb=tnom.getText();
           re.setNbrCoupon(Integer.valueOf(nb));
           re.setStartdate(dp.getDate());
            //System.out.println(""+dp.getDate());
            
            
           ser.ajoutReservation(re);
        
           
           ////////////////////////////////////////
                                ServiceCommentaire servicCommentaire= new  ServiceCommentaire();
                                int idProfessionnel=servicCommentaire.getLoginAuteurByIdBonPlanReservation(1);
                                System.out.println(idProfessionnel);
                                Utilisateur professionnel=servicCommentaire.getAuteurById(idProfessionnel);
                                String usernamePro=professionnel.getUsername();
                                String nom=Utilisateur.getNom();
                                String prenom=Utilisateur.getPrenom();
                                String dateReservation=re.getStartdate().toString();
                                int nbPlaces=re.getNbrCoupon();
                                FileSystemStorage fs=FileSystemStorage.getInstance();
                                String fileName = fs.getAppHomePath()+"Reservation.pdf";
                                String url="http://127.0.0.1/bons_plans/crudCommentaire.php?type=reservationPdf&professionnel="+usernamePro+"&nom="+nom+"&prenom="+prenom+"&dateReservation="+dateReservation+"&nbPlaces="+nbPlaces;
                                Util.downloadUrlToFile(url, fileName, true);
                                Display.getInstance().execute(fileName);  
        });

    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    public TextField getTnom() {
        return tnom;
    }

    public void setTnom(TextField tnom) {
        this.tnom = tnom;
    }

}
