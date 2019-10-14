package br.com.digitalhouse.desafioandroid.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Recipe implements Parcelable {
    private String namePlate;
    private int photoPlate;
    private String detailPlate;


    public Recipe() {
    }

    public Recipe(String namePlate, int photoPlate, String detailPlate) {
        this.namePlate = namePlate;
        this.photoPlate = photoPlate;
        this.detailPlate = detailPlate;
    }

    protected Recipe(Parcel in) {
        namePlate = in.readString();
        photoPlate = in.readInt();
        detailPlate = in.readString();
    }

    public static final Creator<Recipe> CREATOR = new Creator<Recipe>() {
        @Override
        public Recipe createFromParcel(Parcel in) {
            return new Recipe(in);
        }

        @Override
        public Recipe[] newArray(int size) {
            return new Recipe[size];
        }
    };

    public String getNamePlate() {
        return namePlate;
    }

    public void setNamePlate(String namePlate) {
        this.namePlate = namePlate;
    }

    public int getPhotoPlate() {
        return photoPlate;
    }

    public void setPhotoPlate(int photoPlate) {
        this.photoPlate = photoPlate;
    }

    public String getDetailPlate() {
        return detailPlate;
    }

    public void setDetailPlate(String detailPlate) {
        this.detailPlate = detailPlate;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(namePlate);
        parcel.writeInt(photoPlate);
        parcel.writeString(detailPlate);
    }
}
