package project.miage.geomeetingv2;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Ilias on 07/11/2018.
 */

public class Contact implements Parcelable{

    private String nom, telephone;


    public Contact(String name, String phoneNumber) {
        this.nom = name;
        this.telephone = telephone;
    }

    public Contact() {

    }

    protected Contact(Parcel in) {
        nom = in.readString();
        telephone = in.readString();
    }

    public static final Creator<Contact> CREATOR = new Creator<Contact>() {
        @Override
        public Contact createFromParcel(Parcel in) {
            return new Contact(in);
        }

        @Override
        public Contact[] newArray(int size) {
            return new Contact[size];
        }
    };

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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nom);
        parcel.writeString(telephone);
    }
}
