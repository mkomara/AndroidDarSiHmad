package Objects;

import android.os.Parcel;
import android.os.Parcelable;



import java.util.Date;

public class Data implements Parcelable {

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator(){
        public Data createFromParcel(Parcel in){
            return new Data(in);
        }
        public Data[] newArray(int size){
            return new Data[size];
        }
    };



    private Net net;
    private User user;
    private double precipatationMM;
    private double rh;
    private double tempCelcius;
    private double minWet450;
    private double minWet460;
    private double iwsCounts;
    private double pulseCountsPort4;
    private double pulseCountsPort5;
    private Date MeasurementTime;

    public Data(Net p_net, User p_user, double p_mm, double p_rh,double p_tempCelcius, double p_mw450, double p_mw460, double p_iwsCounts, double p_pulseCountsPort4, double p_pulseCountsPort5,
                Date p_measurementTime){
        this.net = p_net;
        this.user = p_user;
        this.precipatationMM=p_mm;
        this.rh=p_rh;
        this.tempCelcius=p_tempCelcius;
        this.minWet450=p_mw450;
        this.minWet460=p_mw460;
        this.iwsCounts=p_iwsCounts;
        this.pulseCountsPort4 = p_pulseCountsPort4;
        this.pulseCountsPort5=p_pulseCountsPort5;
        this.MeasurementTime=p_measurementTime;
    }

    public Data(Parcel in){
        this.net = (Net)in.readParcelable(Net.class.getClassLoader());
        this.user = (User)in.readParcelable(User.class.getClassLoader());
        this.precipatationMM = in.readDouble();
        this.rh = in.readDouble();
        this.tempCelcius=in.readDouble();
        this.minWet450 = in.readDouble();
        this.minWet460 = in.readDouble();
        this.iwsCounts = in.readDouble();
        this.pulseCountsPort4 = in.readDouble();
        this.pulseCountsPort5 = in.readDouble();
        this.MeasurementTime = in.readParcelable(Date.class.getClassLoader());
    }

    public Net getNet() {
        return net;
    }

    public void setNet(Net net) {
        this.net = net;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getPrecipatationMM() {
        return precipatationMM;
    }

    public void setPrecipatationMM(double precipatationMM) {
        this.precipatationMM = precipatationMM;
    }

    public double getRh() {
        return rh;
    }

    public void setRh(double rh) {
        this.rh = rh;
    }

    public double getTempCelcius() {
        return tempCelcius;
    }

    public void setTempCelcius(double tempCelcius) {
        this.tempCelcius = tempCelcius;
    }

    public double getMinWet450() {
        return minWet450;
    }

    public void setMinWet450(double minWet450) {
        this.minWet450 = minWet450;
    }

    public double getMinWet460() {
        return minWet460;
    }

    public void setMinWet460(double minWet460) {
        this.minWet460 = minWet460;
    }

    public double getIwsCounts() {
        return iwsCounts;
    }

    public void setIwsCounts(double iwsCounts) {
        this.iwsCounts = iwsCounts;
    }

    public double getPulseCountsPort4() {
        return pulseCountsPort4;
    }

    public void setPulseCountsPort4(double pulseCountsPort4) {
        this.pulseCountsPort4 = pulseCountsPort4;
    }

    public double getPulseCountsPort5() {
        return pulseCountsPort5;
    }

    public void setPulseCountsPort5(double pulseCountsPort5) {
        this.pulseCountsPort5 = pulseCountsPort5;
    }

    public Date getMeasurementTime() {
        return MeasurementTime;
    }

    public void setMeasurementTime(Date measurementTime) {
        MeasurementTime = measurementTime;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.net,flags);
        dest.writeParcelable(this.user,flags);
        dest.writeDouble(this.precipatationMM);
        dest.writeDouble(this.rh);
        dest.writeDouble(this.tempCelcius);
        dest.writeDouble(this.minWet450);
        dest.writeDouble(this.minWet460);
        dest.writeDouble(this.iwsCounts);
        dest.writeDouble(this.pulseCountsPort4);
        dest.writeDouble(this.pulseCountsPort5);
        dest.writeSerializable(this.MeasurementTime);
    }
}
