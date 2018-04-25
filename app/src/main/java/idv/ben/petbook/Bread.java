package idv.ben.petbook;



public class Bread {
    private String name;
    private String time;
    private int imgID;
    private String place;

    public Bread(String name, String time, int imgID , String place) {
        this.name = name;
        this.time = time;
        this.imgID = imgID;
        this.place = place;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getImgID() {
        return imgID;
    }

    public void setImgID(int imgID) {
        this.imgID = imgID;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
