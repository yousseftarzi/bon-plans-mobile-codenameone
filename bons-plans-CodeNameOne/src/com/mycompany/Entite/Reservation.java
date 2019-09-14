/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entite;

import java.util.Date;

/**
 *
 * @author sana
 */
public class Reservation {
   private int id;
   private int id_bon_planeur;
   private int 	id_bon_plan;
   private Date  startdate;
   private int nbrCoupon;
   private String titrebonplan;
 
    public Reservation(int id, int id_bon_planeur, int id_bon_plan, Date startdate, int nbrCoupon) {
        this.id = id;
        this.id_bon_planeur = id_bon_planeur;
        this.id_bon_plan = id_bon_plan;
        this.startdate = startdate;
        this.nbrCoupon = nbrCoupon;
    }

    public Reservation() {
    }

    public int getId() {
        return id;
    }

    public int getId_bon_planeur() {
        return id_bon_planeur;
    }

    public int getId_bon_plan() {
        return id_bon_plan;
    }

    public Date getStartdate() {
        return startdate;
    }

    public int getNbrCoupon() {
        return nbrCoupon;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_bon_planeur(int id_bon_planeur) {
        this.id_bon_planeur = id_bon_planeur;
    }

    public void setId_bon_plan(int id_bon_plan) {
        this.id_bon_plan = id_bon_plan;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public void setNbrCoupon(int nbrCoupon) {
        this.nbrCoupon = nbrCoupon;
    }

    public String getTitrebonplan() {
        return titrebonplan;
    }

    public void setTitrebonplan(String titrebonplan) {
        this.titrebonplan = titrebonplan;
    }

    @Override
    public String toString() {
        return "Reservation{" + ", titrebonplan=" + titrebonplan  + ", startdate=" + startdate + ", nbrCoupon=" + nbrCoupon +  '}';
    }

    

   

    
           
}
