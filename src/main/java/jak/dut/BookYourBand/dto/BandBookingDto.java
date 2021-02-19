package jak.dut.BookYourBand.dto;

public class BandBookingDto {

    private final String date;
    private final String bandName;

    public BandBookingDto(String date, String bandName) {
        this.date = date;
        this.bandName = bandName;
    }

    public String getDate() {
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
