package be.bf.uml.exception;

import be.bf.uml.utils.ColorText;

public class MarryYourselfException extends RuntimeException{
    public MarryYourselfException() {
        super(ColorText.RED + "You cannot marry yourself" + ColorText.RESET);
    }
}
