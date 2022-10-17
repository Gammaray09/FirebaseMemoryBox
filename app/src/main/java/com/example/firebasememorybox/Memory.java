package com.example.firebasememorybox;

import android.os.Parcel;
import android.os.Parcelable;

public class Memory implements Parcelable {
    private int rating;
    private String name;
    private String desc;
    private String docID;

    public Memory(int rating, String name, String desc, String docID) {
        this.rating = rating;
        this.name = name;
        this.desc = desc;
        this.docID = docID;
    }

    public Memory(int rating, String name, String desc) {
        this.rating = rating;
        this.name = name;
        this.desc = desc;
        this.docID = "No docID yet";
    }


    public Memory() {
        rating = 0;
        name = "No name";
        desc = "No desc";
        this.docID = "No docID yet";
    }


    @Override
    public String toString() {
        return name;
    }

    public int getRating() {return rating;}
    public void setRating(int rating) {this.rating = rating;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getDesc() {return desc;}
    public void setDesc(String desc) {this.desc = desc;}
    public String getDocID() {return docID;}
    public void setDocID(String docID) {this.docID = docID;}

    public static final Parcelable.Creator<Memory> CREATOR = new
            Parcelable.Creator<Memory>() {

                @Override
                public Memory createFromParcel(Parcel parcel) {
                    return new Memory(parcel);
                }

                @Override
                public Memory[] newArray(int size) {
                    return new Memory[0];
                }
            };


    /** This is a "constructor" of sorts that is needed with the Parceable interface to
     * tell the intent how to create a Food object when it is received from the intent
     * basically it is setting each instance variable as a String or Int
     * if the instance variables were objects themselves you would need to do more complex * code.  We need to read in the String, double, and int data.
     *
     * @param parcel    the parcel that is received from the intent
     */
    // to avoid the errors, keep the orders of the parameters the same

    public Memory(Parcel parcel) {
        name = parcel.readString();
        rating = parcel.readInt();
        desc = parcel.readString();
        docID = parcel.readString();
    }


    /**
     * This is what is used when we send the Food object through an intent
     * It is also a method that is part of the Parceable interface and is needed
     * to set up the object that is being sent.  Then, when it is received, the
     * other Food constructor that accepts a Parcel reference can "unpack it"
     *
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(rating);
        dest.writeString(desc);
        dest.writeString(docID);
    }


    @Override
    public int describeContents() {
        return 0;
    }


}
