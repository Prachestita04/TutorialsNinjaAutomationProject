package temp;

import java.util.Date;

public class GenerateEmail {
    public static void main(String[] args) {
        Date date = new Date();
        String dateString = date.toString();
        String replaceSpaceInDate = dateString.replaceAll("\\s","");
        String replaceColonInDate = replaceSpaceInDate.replaceAll("\\:","");
        System.out.println(replaceColonInDate+"@g.co");
    }
}
