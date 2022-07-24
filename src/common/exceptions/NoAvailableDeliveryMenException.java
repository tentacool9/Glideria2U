package src.common.exceptions;

public class NoAvailableDeliveryMenException extends Exception{
    public NoAvailableDeliveryMenException() {
        super("There aren't any available delivery men currently!");
    }
}
