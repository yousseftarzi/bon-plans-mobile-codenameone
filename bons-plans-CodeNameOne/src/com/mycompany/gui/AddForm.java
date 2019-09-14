/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;


import com.codename1.messaging.Message;

import com.codename1.ui.Button;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.util.Resources;
import com.mycompagny.Service.ServiceReclamation;
import com.mycompany.Entite.Reclamation;


/**
 *
 * @author youssefc
 */
public class AddForm {
    Form f;
   
    TextField message;
    Button btnajout ;

    public AddForm(Resources theme) {
        f = new Form("home");
        message = new TextField();
        btnajout = new Button("reclamer");
                

        btnajout.setIcon(FontImage.createMaterial(FontImage.MATERIAL_TODAY, btnajout.getUnselectedStyle()));
        f.add(message);
        f.add(btnajout);

        btnajout.addActionListener((e) -> {
           ServiceReclamation ser = new ServiceReclamation();
            Reclamation t = new Reclamation(0, message.getText(),0,0);
            ser.ajouter(t);
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

    public TextField getmessage() {
        return message;
    }

    public void setmessage(TextField message) {
        this.message = message;
    }

    
}
