package be.bf.uml.exception;

import be.bf.uml.utils.ColorText;

public class BeardLengthNumberException extends NumberFormatException{
    public BeardLengthNumberException() {
        super(ColorText.RED + "Beard length cannot be negative" + ColorText.RESET);
    }
}
