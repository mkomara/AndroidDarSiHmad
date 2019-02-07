package Objects;

import android.os.Parcel;
import android.os.Parcelable;

public class Site implements Parcelable {

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator(){
        public Site createFromParcel(Parcel in){
            return new Site(in);
        }
        public Site[] newArray(int size){
            return new Site[size];
        }
    };


    private int ID;
    private String name;



    public Site(int ID, String name){
        this.ID = ID;
        this.name = name;
    }

    public Site(Parcel in){
        this.ID=in.readInt();
        this.name=in.readString();
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.ID);
        dest.writeString(this.name);
    }
}
