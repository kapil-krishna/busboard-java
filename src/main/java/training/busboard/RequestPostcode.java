package training.busboard;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RequestPostcode {

    public static String RequestPostcode() {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the Bus Stop finder! Input your postcode to find out the next 5 buses" +
                " arriving at your two nearest stops!");
        String postCode = input.nextLine();

        Pattern pattern = Pattern.compile("([Gg][Ii][Rr] 0[Aa]{2})|((([A-Za-z][0-9]{1,2})|(([A-Za-z][A-Ha-hJ-Yj-y][0-9]{1,2})|(([A-Za-z][0-9][A-Za-z])|([A-Za-z][A-Ha-hJ-Yj-y][0-9][A-Za-z]?))))\\s?[0-9][A-Za-z]{2})");
        Matcher matcher = pattern.matcher(postCode);

        while (!(matcher.matches())) {
            Scanner repeat = new Scanner(System.in);
            System.out.println("I'll need a valid postcode to work my magic.");
            postCode = repeat.nextLine();
        }
        return postCode;
    }
}
