package project.miage.geomeetingv2;

/**
 * Created by Ilias on 07/11/2018.
 */

public class Contact {

    private String nom, telephone;


    public Contact(String name, String phoneNumber) {
        this.nom = name;
        this.telephone = telephone;
    }

    public Contact() {

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }




}
