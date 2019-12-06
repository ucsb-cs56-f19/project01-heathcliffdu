package earthquakes.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Location {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long placeId;
    private String name;
    private double latitude;
    private double longitude;
    private String uid;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getPlaceId() { return placeId; }
    public void setPlaceId(Long newPlaceId) { this.placeId = newPlaceId; }
   
    public String getName() { return name; }
    public void setName (String newName) { this.name = newName; }

    public double getLatitude() { return latitude; }
    public void setLatitude (double newLat) { this.latitude = newLat; }

    public double getLongitude() { return longitude; }
    public void setLongitude (double newLon) { this.longitude = newLon; }

    public String getUid() { return uid; }
    public void setUid (String uid) { this.uid = uid; }
}

