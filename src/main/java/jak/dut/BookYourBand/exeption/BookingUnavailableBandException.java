package jak.dut.BookYourBand.exeption;

public class BookingUnavailableBandException extends RuntimeException{

    public BookingUnavailableBandException(final String message){
        super(message);
    }

}
