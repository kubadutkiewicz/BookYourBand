package jak.dut.BookYourBand.model;

import javax.persistence.*;

@Entity
@Table(name ="band")
public class Band {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bandName;
    private String location;
    private Double rating;

    public Band(String bandName, String location, Double rating) {
        this.bandName = bandName;
        this.location = location;
        this.rating = rating;
    }

    public Band() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Band{" +
                "id=" + id +
                ", bandName='" + bandName + '\'' +
                ", location='" + location + '\'' +
                ", rating=" + rating +
                '}';
    }
}
