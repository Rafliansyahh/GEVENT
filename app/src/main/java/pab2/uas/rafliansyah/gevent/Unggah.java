package pab2.uas.rafliansyah.gevent;

import android.os.Parcel;
import android.os.Parcelable;

public class Unggah implements Parcelable {
    private String id;
    private String namaevent;
    private String alamat;
    private String deskripsi;
    private String user_id;

    private String username;

    protected Unggah(Parcel in) {
        id = in.readString();
        namaevent = in.readString();
        alamat = in.readString();
        deskripsi = in.readString();
        user_id = in.readString();
        username = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(namaevent);
        dest.writeString(alamat);
        dest.writeString(deskripsi);
        dest.writeString(user_id);
        dest.writeString(username);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Unggah> CREATOR = new Creator<Unggah>() {
        @Override
        public Unggah createFromParcel(Parcel in) {
            return new Unggah(in);
        }

        @Override
        public Unggah[] newArray(int size) {
            return new Unggah[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNamaevent() {
        return namaevent;
    }

    public void setNamaevent(String namaevent) {
        this.namaevent = namaevent;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
