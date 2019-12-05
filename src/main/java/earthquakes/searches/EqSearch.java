
package earthquakes.searches;



public class EqSearch {
    private int distance;
    private int minmag;
    private double lat;
    private double lon;
    private String location;



    public int getDistance(){
        return this.distance;
    }
    public int getMinmag(){
        return this.minmag;
    }

    public void setDistance(int Distance1){
        this.distance = Distance1;
    }

    public void setMinmag(int Minmag1){
        this.minmag = Minmag1;
    }

    public double getLat(){
        return this.lat;
    }
    public double getLon(){
        return this.lon;
    }
    public String getLocation(){
        return this.location;
    }

    public void setLat(double lat1){
        this.lat= lat1;
    }

    public void setLon(double lon1){
        this.lon = lon1;
    }

    public void setLocation(String location1){
        this.location = location1;
    }


}