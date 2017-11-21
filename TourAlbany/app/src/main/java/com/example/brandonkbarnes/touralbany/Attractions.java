package com.example.brandonkbarnes.touralbany;

/**
 * Created by Brandon on 11/20/2017.
 */

public class Attractions {
    //Image reference source
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    //Attraction name
    private int mName;
    //Attraction hours
    private int mContact;
    //Attraction description
    private int mDescription;
    //Attraction location
    private int mLocation;

    private static final int NO_IMAGE_PROVIDED = -1;

    public Attractions(int name, int contact, int description, int imageResourceId, int location){
        mImageResourceId = imageResourceId;
        mName = name;
        mContact = contact;
        mDescription = description;
        mLocation = location;
    }

    public Attractions(int name, int contact, int description, int location){
        mName = name;
        mContact = contact;
        mDescription = description;
        mLocation = location;
    }

    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public int getName() {
        return mName;
    }

    public int getContact() {
        return mContact;
    }

    public int getDescription() {return mDescription;}

    public int getLocation() {return mLocation;}

    @Override
    public String toString() {
        return "Word{" +
                "mImageResourceId=" + mImageResourceId +
                ", mName='" + mName + '\'' +
                ", mContact='" + mContact + '\'' +
                ", mDescription='" + mDescription + '\'' +
                ", mLocation='" + mLocation + '\'' +
                '}';
    }
}
