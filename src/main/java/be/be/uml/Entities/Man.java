package be.be.uml.Entities;

public class Man extends Person{

    private int beardLength = 3;


    public Man(String firstName) {
        super(firstName);
    }

    public Man(String firstName, String lastName) {
        super(firstName, lastName);
    }


    public Man(String firstName, String lastName, int beardLength) {
        super(firstName, lastName);
        this.beardLength = beardLength;
    }

    public int getBeardLength() {
        return beardLength;
    }

    public void setBeardLength(int beardLength) {
        if(beardLength < 0) return;
        this.beardLength = beardLength;
    }

    public void shave() {

    }



}
