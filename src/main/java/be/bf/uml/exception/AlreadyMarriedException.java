package be.bf.uml.exception;

import be.bf.uml.utils.ColorText;

public class AlreadyMarriedException extends RuntimeException{

    public AlreadyMarriedException(){
        super(ColorText.RED + "You are already married" + ColorText.RESET);
    }
}
