/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompagny.Service;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.Entite.Reservation;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;



/**
 *
 * @author sana
 */
public class ServiceReservation {

    public void ajoutReservation(Reservation ta) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/Ponblan/web/app_dev.php/addreservationmobile?iduser="+String.valueOf(ta.getId_bon_planeur())+"&idbp="+String.valueOf(ta.getId_bon_plan())+"&nbc="+String.valueOf(ta.getNbrCoupon())+"&date="+ta.getStartdate();
       
        
        con.setUrl(Url);

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println("okkkkkkk");
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
    

    public Container getList2() {
        ArrayList<Reservation> listReservations = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/Ponblan/web/app_dev.php/affichermobile");
        
           Container call=new Container(new BoxLayout(BoxLayout.Y_AXIS));

        con.setPost(false);
        String iduser=String.valueOf(2);
        con.addArgument("idb", iduser);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listReservations = getListReservation(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();
                
                try {
                    //renvoi une map avec clé = root et valeur le reste
                    Map<String, Object> Reservations = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println("roooooot:" +Reservations.get("reserv"));

                    List<Map<String, Object>> list = (List<Map<String, Object>>) Reservations.get("root");
   
   

                           System.out.println("momohamedo");

   
                    for (Map<String, Object> obj : list) {
                        Reservation res = new Reservation();
                            DateFormat readformat=new SimpleDateFormat(  "EEE MMM dd hh:mm:SS z yyyy");
   
    DateFormat writeFormat = new SimpleDateFormat("dd-MM-yyyy");
                        
                        Map<String, Object> objdate=(Map<String, Object>)obj.get("startdate");
                         
                            double obd=Double.parseDouble(objdate.get("timestamp").toString());
                            Date d1=new Date((int)obd*1000L);
                             Date fdm;
                        
                       
                        try {
                            fdm=readformat.parse(d1.toString());
                            String mydate=writeFormat.format(fdm);
                        System.out.println("momo"+mydate);
                        } catch (ParseException ex) {
                        }
                            
                        
                       // float id = Float.parseFloat(obj.get("id").toString());
                        Map<String, Object> objbp=( Map<String, Object>)obj.get("idBonPlan");
                        
                        String titre=objbp.get("titre").toString();
                                                    String mydate=writeFormat.format(d1);
                        System.out.println(""+mydate);
                     /*   System.out.println(objdate.get("timestamp").toString());
                        
                        Date d1=new Date(dr*1000L);
                        String dtsr=d1.toString();
                        Date fdm;
                        
                       
                            fdm=readformat.parse("Thu Apr 12 23:00:00 GMT 2018");
                            String mydate=writeFormat.format(fdm);
                         
                        System.out.println(mydate);*/
                     Label date =new Label(""+mydate);
Label Titre =new Label(titre);

                       // Reservation.setId((int) id);
                        //Reservation.setStartdate();
                        float nb=Float.parseFloat(obj.get("nbrCoupon").toString());
                      res.setNbrCoupon((int)nb);
                      Label nbcoup =new Label(""+nb);
Container c=new Container(new BoxLayout(BoxLayout.Y_AXIS));
c.add(Titre);
c.add(date);
c.add(nbcoup);
call.add(c);
                      

                    }
                } catch (IOException ex) {
                } 
               
                /*
                 catch (ParseException ex) {
                    System.out.println(ex);
                        }
                */
                       

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return call;
    }

}
