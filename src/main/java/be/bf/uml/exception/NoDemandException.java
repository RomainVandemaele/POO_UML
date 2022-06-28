package be.bf.uml.exception;

import be.bf.uml.utils.ColorText;

public class NoDemandException extends RuntimeException {
    public NoDemandException() {
        super(ColorText.RED + "No demand in progress" + ColorText.RESET);
    }
}
