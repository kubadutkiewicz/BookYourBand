package jak.dut.BookYourBand.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class BandBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;

    @OneToOne
    private Client client;

    @ManyToOne
    private Band band;

    public BandBooking(LocalDate date, Client client, Band band) {
        this.date = date;
        this.client = client;
        this.band = band;
    }

    public BandBooking() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Band getBand() {
        return band;
    }

    public void setBand(Band band) {
        this.band = band;
    }
}
