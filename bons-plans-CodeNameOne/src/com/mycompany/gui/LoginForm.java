/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.SpanButton;
import com.codename1.io.MultipartRequest;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Tabs;
import com.codename1.ui.TextField;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.util.Resources;
import com.mycompagny.Service.ServiceAbonnement;
import com.mycompagny.Service.ServiceReclamation;
import com.mycompagny.Service.ServiceUtilisateur;
import com.mycompany.Entite.Reclamation;
import com.mycompany.Entite.Utilisateur;
import java.util.ArrayList;

/**
 *
 * @author amir
 */
public class LoginForm {
    Form f;
   
    TextField username,password;
    Button btnconnexion ;
    MultipartRequest con = new MultipartRequest();
    
    public LoginForm(Resources theme){
        
          f = new Form("Connection");
        username = new TextField();
        password = new TextField();
        btnconnexion = new Button("Se connecter");
                

        btnconnexion.setIcon(FontImage.createMaterial(FontImage.MATERIAL_TODAY, btnconnexion.getUnselectedStyle()));
        f.add(username);
        f.add(password);
        f.add(btnconnexion);
        btnconnexion.addActionListener((e) -> {
           ServiceUtilisateur serviceUtilisateur = new ServiceUtilisateur();
           Utilisateur utilisateur = new Utilisateur();
           utilisateur.setUsername(username.getText());
           utilisateur.setPassword(password.getText());
           
           ArrayList<Utilisateur> listUtilisateur = new ArrayList<>();
           
           listUtilisateur=serviceUtilisateur.Login(utilisateur);
            System.out.println(listUtilisateur.size());
            System.out.println(utilisateur.getUsername());
            System.out.println(utilisateur.getPassword());
           if (listUtilisateur.isEmpty())
           {
               System.out.println("no login");
           }
           else 
           {
               
               Utilisateur.setId(listUtilisateur.get(0).getId());
               Utilisateur.setUsername(listUtilisateur.get(0).getUsername());
               Utilisateur.setPhotoDeProfil(listUtilisateur.get(0).getPhotoDeProfil());
               Utilisateur.setAdresse(listUtilisateur.get(0).getAdresse());
               Utilisateur.setNom(listUtilisateur.get(0).getNom());
               Utilisateur.setPrenom(listUtilisateur.get(0).getPrenom());
               Affichage a=new Affichage(theme);
       Container caff=a.getC();

       AffichageReservation affreservation=new AffichageReservation();
        Container reser=affreservation.getF();
        Affichage_reclama aff=new Affichage_reclama(theme);
        Container ReclamContainer=aff.getC();
        
        AffichageAbonnement ab=new AffichageAbonnement(theme);
       Container abonnementContainer=ab.getC();
Form hi = new Form(new LayeredLayout());

   EncodedImage enc = EncodedImage.createFromImage(theme.getImage("addicon.png"),true);

   Image img=URLImage.createToStorage(enc, "ff", "dd");
hi.getToolbar().addCommandToRightBar("",img , (ev)->{      AjoutForm h = new AjoutForm();
       h.getF().show();
          });
 
         hi.getToolbar().addCommandToRightBar("chart",null , (ev)->{      ChartForm ch=new ChartForm();
       
          });


Container container1 = BoxLayout.encloseY(new Label("Profile"),
        new Label("You can put anything here"));



Tabs tb = new Tabs() {
    @Override
    protected Component createTab(String title, Image icon) { 
        SpanButton custom = new SpanButton(title);
        custom.setIcon(icon);
        custom.setUIID("Container");
        custom.setTextUIID("Tab");
        custom.setIconPosition(BorderLayout.NORTH);
        custom.setIconUIID("Tab");
        return custom;
    }

    @Override
    protected void setTabSelectedIcon(Component tab, Image icon) {
        ((SpanButton)tab).setPressedIcon(icon); 
    }

    protected void selectTab(Component tab) { 
    }

    @Override
    protected void bindTabActionListener(Component tab, ActionListener l) {
        ((SpanButton)tab).addActionListener(l);
    }
};
tb.setTabUIID(null);
tb.addTab("Acceuil",  caff);
tb.addTab("Reclam", ReclamContainer);
tb.addTab("Reservation",reser);
tb.addTab("Following", abonnementContainer);


tb.getTabsContainer().setScrollableX(false); 

hi.add(BorderLayout.CENTER, tb);

hi.show();


        Utilisateur utilisateuractif = new Utilisateur(1);
        ServiceAbonnement serviceAbonnement = new ServiceAbonnement();
          
        serviceAbonnement.afficherNotifications(utilisateuractif);
    
           }
//                     Message m = new Message("Body of message");
//
//Display.getInstance().sendMessage(new String[] {"youssef.rebai@esprit.tn"}, "Reclamation", m);

        
    });
                
                }
    
     public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

}
