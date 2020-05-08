package com.uc.daiyeri;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    private String title, note;
    int id;

    public User(String title, String note) {
        this.title = title;
        this.note = note;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.note);
        dest.writeInt(this.id);
    }

    protected User(Parcel in) {
        this.title = in.readString();
        this.note = in.readString();
        this.id = in.readInt();
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
