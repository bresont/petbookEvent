package idv.ben.petbook;



public class Activity {
    private String name;
    private String location_address;
    private String content;
    private double location_latitude;
    private double location_longitude;
    private String activity_date;
    private int    imgID;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation_address() {
        return location_address;
    }

    public void setLocation_address(String location_address) {
        this.location_address = location_address;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public double getLocation_latitude() {
        return location_latitude;
    }

    public void setLocation_latitude(double location_latitude) {
        this.location_latitude = location_latitude;
    }

    public double getLocation_longitude() {
        return location_longitude;
    }

    public void setLocation_longitude(double location_longitude) {
        this.location_longitude = location_longitude;
    }

    public String getActivity_date() {
        return activity_date;
    }

    public void setActivity_date(String activity_date) {
        this.activity_date = activity_date;
    }

    public int getImgID() {
        return imgID;
    }

    public void setImgID(int imgID) {
        this.imgID = imgID;
    }

    public Activity(String name, String location_address, String content , double location_latitude , double location_longitude , String activity_date, int imgID) {
        this.name = name;
        this.location_address = location_address;
        this.imgID = imgID;
        this.content = content;
        this.location_latitude = location_latitude;
        this.location_longitude = location_longitude;
    }


}
