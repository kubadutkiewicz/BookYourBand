package jak.dut.BookYourBand.Exeption;

public class BookingUnavailableBandException extends Throwable{

    public BookingUnavailableBandException(final String message){
        super(message);
    }
}
