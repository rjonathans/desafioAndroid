package br.com.digitalhouse.desafioandroid.models;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Restaurant implements Parcelable {

    private int photoRestaurant;
    private String nameRestaurant;
    private String address;
    private String hour;
    private List<Recipe> listRecipe;

    public Restaurant() {
    }

    public Restaurant(int photoRestaurant, String nameRestaurant, String address, String hour, List<Recipe> listRecipe) {
        this.photoRestaurant = photoRestaurant;
        this.nameRestaurant = nameRestaurant;
        this.address = address;
        this.hour = hour;
        this.listRecipe = listRecipe;
    }

    protected Restaurant(Parcel in) {
        photoRestaurant = in.readInt();
        nameRestaurant = in.readString();
        address = in.readString();
        hour = in.readString();
    }

    public static final Creator<Restaurant> CREATOR = new Creator<Restaurant>() {
        @Override
        public Restaurant createFromParcel(Parcel in) {
            return new Restaurant(in);
        }

        @Override
        public Restaurant[] newArray(int size) {
            return new Restaurant[size];
        }
    };

    public int getPhotoRestaurant() {
        return photoRestaurant;
    }

    public void setPhotoRestaurant(int photoRestaurant) {
        this.photoRestaurant = photoRestaurant;
    }

    public String getNameRestaurant() {
        return nameRestaurant;
    }

    public void setNameRestaurant(String nameRestaurant) {
        this.nameRestaurant = nameRestaurant;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public List<Recipe> getListRecipe() {
        return listRecipe;
    }

    public void setListRecipe(List<Recipe> listRecipe) {
        this.listRecipe = listRecipe;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(photoRestaurant);
        parcel.writeString(nameRestaurant);
        parcel.writeString(address);
        parcel.writeString(hour);
    }

}
