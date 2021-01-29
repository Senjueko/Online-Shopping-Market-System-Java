import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Pricelist {

    private static String product; // Name of product
    private static String type; // Type of the product
    private static Integer day1; // First date's day
    private static Integer month1; // First date's month
    private static Integer year1; // First date's year
    private static Integer day2; // Second date's day
    private static Integer month2; // Second date's month
    private static Integer year2; // Second date's year
    private static Double price; // Price of the prdouct
    public static List<String[]> data; // The list for hold the txt's data


    public static String[] readfile(String path) {
        try {
            int i = 0;
            int length = Files.readAllLines(Paths.get(path)).size();
            String[] results = new String[length];
            for (String line : Files.readAllLines(Paths.get(path))) {
                results[i++] = line;
            }
            return results;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<String> main(String[] args) {
        // This method for keep data in the list

        String[] lines = readfile(args[1]);
        List<String[]> newlist = new ArrayList<>();
        for (String line : lines) {
            List<String[]> newlist2 = new ArrayList<>();
            newlist2.add(line.split("\t"));
            newlist.addAll(newlist2);
        }
        data = newlist;
        return null;
    }

    public static void Dateofprice(Integer i) {
        //This method for split the date as a day,month and year

        String date1 = String.valueOf(data.get(i)[2]);
        String date2 = String.valueOf(data.get(i)[3]);
        String[] Array1 = date1.split("\\.");
        String[] Array2 = date2.split("\\.");
        day1 = Integer.valueOf((Array1[0]));
        month1 = Integer.valueOf(Array1[1]);
        year1 = Integer.valueOf(Array1[2]);
        day2 = Integer.valueOf(Array2[0]);
        month2 = Integer.valueOf(Array2[1]);
        year2 = Integer.valueOf(Array2[2]);
    }
}
