/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompagny.Service;

import com.codename1.components.ImageViewer;
import com.codename1.components.InfiniteProgress;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.FileSystemStorage;
import com.codename1.io.JSONParser;
import com.codename1.io.MultipartRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.io.Util;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.URLImage.ImageAdapter;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.Layout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.Entite.Abonnement;
import com.mycompany.Entite.BonPlan;
import com.mycompany.Entite.Reservation;
import com.mycompany.gui.Reserver;
import com.mycompany.gui.SingleBonPlanGui;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 *
 * @author sana
 */
public class ServiceBonPlan {

    public void ajoutBonPlan(BonPlan ta,MultipartRequest con) {
        String Url = "http://127.0.0.1/BonPlanMobile/crud.php?type=ajout&nom="+ta.getNom()+"&adress="+ta.getAdress()+"&auteur="+ta.getAuteur()+"&nbre="+ta.getNombredecoupon()+"&image="+ta.getImg()+"";
        con.setUrl(Url);

       // System.out.println("tt");

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
//                        System.out.println(str);

            //System.out.println("coco");
//            if (str.trim().equalsIgnoreCase("OK")) {
//                f2.setTitle(tlogin.getText());
//             f2.show();
//            }
//            else{
//            Dialog.show("error", "login ou pwd invalid", "ok", null);
//            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        


    }
    

    public Container getList2(Resources theme) {
                           
        
        Container container1All = new Container(new BoxLayout(BoxLayout.Y_AXIS));

        ArrayList<BonPlan> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://127.0.0.1/BonPlanMobile/affichageBonsPlans.php");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                ArrayList<BonPlan> listTasks = new ArrayList<>();
                JSONParser jsonp = new JSONParser();
                
                try {
                    //renvoi une map avec clé = root et valeur le reste
                    Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                   // System.out.println("roooooot:" +tasks.get("root"));

                    List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");

                    for (Map<String, Object> obj : list) {
                        BonPlan task = new BonPlan();
                        float id = Float.parseFloat(obj.get("login_auteur").toString());
                        int nbre = Integer.parseInt(obj.get("etat_coupon").toString());
                        task.setAuteur((int) id);
                        task.setAdress(obj.get("adresse").toString());
                        task.setImg(obj.get("image_name").toString());
                        task.setNom(obj.get("titre").toString());
                        task.setNombredecoupon(nbre);
                        Label titre=new Label("Titre"+obj.get("titre").toString());
                        Label lauteur=new Label(obj.get("login_auteur").toString());
                        Label adresse=new Label("Adresse"+obj.get("adresse").toString());
                        Label nbr=new Label(obj.get("etat_coupon").toString());
                        Image imgholder ;
         Image img ;
         EncodedImage enc;
                        System.out.println(task.getImg());
          String imgurl="http://localhost/BonPlanMobile/uploads/"+task.getImg();

    imgholder=theme.getImage("wait.png");
    enc = EncodedImage.createFromImage(imgholder,true);

    img=URLImage.createToStorage(enc, imgurl, imgurl);
                                ImageViewer imgv=new ImageViewer(img);
             
                         Button singleBonPlanButton=new Button("Plus details");
                        singleBonPlanButton.addActionListener((e) -> {
                            try {
                                SingleBonPlanGui singleBonPlan=new SingleBonPlanGui((int) id,task,theme);
                                singleBonPlan.getForm().show();
                            } catch (IOException ex) {
                                System.out.println(ex);
                            }

        });
                        
                        Button reserverButton= new Button("Reserver");
                        reserverButton.addActionListener((e)->
                            {
                                Reserver rese = new Reserver(task) ;
                                rese.getF().show();
                                
                                
                            }
                        );
                        
                        Button abonnementButton= new Button ();
                        //System.out.println("------------------");
                        //System.out.println(id);
    
                        Abonnement abonnement=new Abonnement(1, (int) id);
                        ServiceAbonnement serviceAbonnement= new ServiceAbonnement();
                        
                       
                            Container container = new Container(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER_ABSOLUTE));
                            Container container1 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                            Container container2 = new Container(new BoxLayout(BoxLayout.X_AXIS));

                            serviceAbonnement.afficherButtonAbonnement(container1, abonnementButton, abonnement);
                            
container1.add(titre);
container1.add(adresse);
container1.add(reserverButton);
container1.add(abonnementButton);
container2.add(singleBonPlanButton);


    container.add(BorderLayout.WEST, imgv);
        container.add(BorderLayout.CENTER, container1);

    container.add(BorderLayout.SOUTH, container2);
    
                        
//                        Container c=new Container();
//                        c.addAll(titre,lauteur,adresse,nbr);
                  container1All.add(container);
                        
                        
                        

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return container1All;
    }

}
