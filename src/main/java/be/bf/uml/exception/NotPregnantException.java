package be.bf.uml.exception;

import be.bf.uml.utils.ColorText;

public class NotPregnantException extends Exception{
    public NotPregnantException() {
        super(ColorText.RED + "A woman cannot give birth if not pregnant" + ColorText.RESET);
    }
}
