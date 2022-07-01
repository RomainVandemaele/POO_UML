package be.bf.uml;

import be.bf.uml.entities.Man;
import be.bf.uml.entities.Person;
import be.bf.uml.entities.Woman;
import be.bf.uml.utils.ColorText;

import java.util.ArrayList;
import java.util.Scanner;


/**
 * The type Dating form.
 */
public class DatingForm {

    private ArrayList<Man> men = new ArrayList<>();
    private ArrayList<Woman> women = new ArrayList<>();
    private Scanner myScanner = new Scanner(System.in);

    public DatingForm() {
        men.add(new Man("Jules","Cesar"));
        men.add(new Man("Brutus","Cesar"));
        men.add(new Man("Philippe","De Belgique"));

        women.add(new Woman("Cleopatre","D'Egypte"));
        women.add(new Woman("Sarah","Van der geeld"));
        women.add(new Woman("Lotte","Van amsterdam"));
    }


    public void startForm() {
        System.out.println("What are you interested in ?");
        System.out.println("1. Man");
        System.out.println("2. Woman");
        String choice = this.myScanner.nextLine();
        while (!choice.matches("[12]")) {
            System.out.println(ColorText.RED + "Error : invalid choice" + ColorText.RESET);
            choice = this.myScanner.nextLine();
        }
        ArrayList<Person> datingCandidates = new ArrayList<>() ;

        if(Integer.valueOf(choice)==1) {
            System.out.println("Our system is looking for a man");
            this.men.forEach( m -> datingCandidates.add(m));
        }else {
            System.out.println("Our system is looking for a woman");
            this.women.forEach( w -> datingCandidates.add(w));
        }
        ArrayList<Person> likedPeople = listPerson(datingCandidates);
        System.out.println(ColorText.MAGENTA + "You liked : " + ColorText.RESET);
        likedPeople.forEach(p -> System.out.printf("%s %s\n",p.getFirstName(),p.getLastName()));
        System.out.println("See you soon\n");
    }

    /**
     * @
     * @param datingCandidates
     * @return
     */
    public ArrayList<Person> listPerson(ArrayList<Person> datingCandidates) {
        ArrayList<Person> likedPeople = new ArrayList<>();
        int i = 0;
        while ( i < datingCandidates.size()) {
            Person candidate = datingCandidates.get(i);
            System.out.println("Push Q for quitting, 1 for like, 0 for dislike");
            System.out.printf("Candidate is : %s %s\n",candidate.getLastName(),candidate.getFirstName());
            String choice = this.myScanner.nextLine();
            while (! choice.matches("[01Q]")) {
                System.out.println(ColorText.RED + "Error : invalid choice" + ColorText.RESET);
                choice = this.myScanner.nextLine();
            }
            switch (choice) {
                case "Q" :
                    i = datingCandidates.size();
                    break;
                case "1" :
                    likedPeople.add(candidate);
                    break;
                default :
                    break;
            }
            ++i;
        }
        return likedPeople;
    }

}
