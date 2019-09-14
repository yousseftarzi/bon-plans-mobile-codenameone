/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.mycompagny.Service.ServiceReservation;
import com.mycompany.Entite.BonPlan;
import com.mycompany.Entite.Reservation;
import java.util.ArrayList;

/**
 *
 * @author sana
 */
public class AffichageReservation {

    Form f;
    SpanLabel lb;
    Container lis ;
    public AffichageReservation() {
        
        f = new Form();
        lb = new SpanLabel("");
        f.add(lb);
        BonPlan bonPlan = new BonPlan();
        bonPlan.setId(1);
        
        ServiceReservation serviceReservation=new ServiceReservation();
         lis=serviceReservation.getList2();
          f.getToolbar().addCommandToRightBar("back", null, (ev)->{ Reserver h=new Reserver(bonPlan);
          h.getF().show();
          });
    }

    public    Container getF() {
        return lis;
    }

    public void setF(Container f) {
        this.lis = f;
    }

}
