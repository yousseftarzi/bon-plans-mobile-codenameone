/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompagny.Service;

import com.codename1.components.ImageViewer;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.Entite.Reclamation;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author youssefc
 */
public class ServiceReclamation {

    public ServiceReclamation() {
    }
    
    
    
              public void ajouter(Reclamation  ta) {
        
                  
                  ConnectionRequest con = new ConnectionRequest();
        String Url = "http://127.0.0.1/BonPlanMobile/ajouter.php?type=ajout&message="+ta.getMessage()+"&Idsource=1"+"&etat=0";
        //String Url = "http://127.0.0.1/BonPlanMobile/crud.php?type=ajout&nom="+ta.getNom()+"&adress="+ta.getAdress()+"&auteur="+ta.getAuteur()+"&nbre="+ta.getNombredecoupon()+"&image="+ta.getImg()+"";
        con.setUrl(Url);

        System.out.println("tt");

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
              
              
              public Container getList2(Resources theme) {
                  System.err.println("1");
                                  Container conall=new Container(new BoxLayout(BoxLayout.Y_AXIS));

        ArrayList<Reclamation> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://127.0.0.1/BonPlanMobile/aff.php");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();
                
                try {
                    //renvoi une map avec clé = root et valeur le reste
                    Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println("roooooot:" +tasks.get("root"));

                    List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");

                    for (Map<String, Object> obj : list) {
                        Reclamation task = new Reclamation();
                        float id = Float.parseFloat(obj.get("id").toString());
                        
                        task.setId((int) id);
                        task.setMessage(obj.get("message").toString());
                                           System.err.println("2");

                        Image img;
                        ImageViewer imgv;
                        if ((int)Float.parseFloat(obj.get("etat").toString())==0)
                        {
                         img=theme.getImage("red.png");
                          imgv=new ImageViewer(img);
                        }
                        else {
                          img=theme.getImage("green.png");
                        imgv=new ImageViewer(img);
                        }
                        Label msg=new Label(obj.get("message").toString());
                                         Container cont=new Container(new BoxLayout(BoxLayout.X_AXIS));

                        cont.add(msg);
                        cont.add(imgv);
                        conall.add(cont);
//                        task.setId_source((int) id);
                        listTasks.add(task);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
                          System.err.println("3");

        return conall;
    }
              
              
              
}
