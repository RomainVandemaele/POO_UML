package be.bf.uml.exception;


import be.bf.uml.utils.ColorText;

public class DateFutureException extends IllegalStateException {

    public DateFutureException() {
        super(ColorText.RED + "The date cannot be a future date" + ColorText.RESET);
    }
}
