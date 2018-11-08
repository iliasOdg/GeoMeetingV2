package project.miage.geomeetingv2;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

/**
 * Created by Ilias on 07/11/2018.
 */

public class RendezVous {

    private ArrayList<Contact> destinataires;
    private String Date;
    private String heure;
    private LatLng lieu;

    public RendezVous(){}

    public RendezVous(ArrayList<Contact> destinataires, String date, String heure, LatLng lieu) {
        this.destinataires = destinataires;
        Date = date;
        this.heure = heure;
        this.lieu = lieu;
    }

    public ArrayList<Contact> getDestinataires() {
        return destinataires;
    }

    public void setDestinataires(ArrayList<Contact> destinataires) {
        this.destinataires = destinataires;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public LatLng getLieu() {
        return lieu;
    }

    public void setLieu(LatLng lieu) {
        this.lieu = lieu;
    }
}
