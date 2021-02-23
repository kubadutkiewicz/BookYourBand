package jak.dut.BookYourBand.dto;

import java.time.LocalDate;

public class BandBookingDto {

    private final LocalDate date;
    private final String bandName;

    public BandBookingDto(LocalDate date, String bandName) {
        this.date = date;
        this.bandName = bandName;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getBandName() {
        return bandName;
    }

    @Override
    public String toString() {
        return "BandBookingDto{" +
                "date='" + date + '\'' +
                ", bandName='" + bandName + '\'' +
                '}';
    }
}
