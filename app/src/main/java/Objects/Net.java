package Objects;

import android.os.Parcel;
import android.os.Parcelable;

public class Net implements Parcelable {

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator(){
        public Net createFromParcel(Parcel in){
            return new Net(in);
        }
        public Net[] newArray(int size){
            return new Net[size];
        }
    };

    private String name;
    private int ID;
    private Site site;

    public Net(String name, int ID ,Site site ){
        this.name = name;
        this.ID = ID;
        this.site = site;
    }

    public Net(Parcel in){

        this.ID = in.readInt();
        this.name = in.readString();
        this.site = (Site) in.readParcelable(Site.class.getClassLoader());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Site getSite() {
        return site;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeInt(this.ID);
        dest.writeParcelable(this.site,flags);
    }



}
