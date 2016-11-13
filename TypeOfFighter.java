import java.util.Scanner;

/**
 * Simple HelloWorld program (clear of Checkstyle and FindBugs warnings).
 *
 * @author P. Bucci
 */
public final class main {

    /**
     * Default constructor--private to prevent instantiation.
     */
    private main() {
        // no code needed here
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments; unused here
     */
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in); // Reading from System.in

        double myAttack = reader.nextDouble();
        TypeOfFighter myType = TypeOfFighter.grass;
        double myHealth = (Math.pow(100 - myAttack, 2) / (30 + myAttack)) * 10;

        double attackOpponent = Math.round(Math.random() * 100);
        double healthOpponent = (Math.pow(100 - attackOpponent, 2)
                / (30 + attackOpponent)) * 10;
        TypeOfFighter typeOpponent = TypeOfFighter
                .randomEnum(TypeOfFighter.class);

        System.out.println(attackOpponent);
        System.out.println(typeOpponent);
        System.out.println(healthOpponent);

    }

}
