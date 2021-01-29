import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Shoppinglist {

    private static String name; // Name of the customer
    private static String type; // His or Her type(gold,silver,bronze)
    private static String product1; // The first product has been bought
    private static String product2; // The second product has been bought
    private static String product3; // The third product has been bought
    private static Integer day; // The day has product been bought
    private static Integer month; // The month has product been bought
    private static Integer year; // The year has product been bought
    private static Integer quantity1; // The first quantity of product1
    private static Integer quantity2; // The second quantity of product2
    private static Integer quantity3; // The third quantity of product3
    public static List<String[]> data; // The list for hold the txt's data

    // Getter and Setters
    public static String getName() { return name; }
    public static void setName(String name) { Shoppinglist.name = name; }
    public static String getType() { return type; }
    public static void setType(String type) { Shoppinglist.type = type; }
    public static String getProduct1() { return product1; }
    public static void setProduct1(String product) { Shoppinglist.product1 = product; }
    public static String getProduct2() { return product2; }
    public static void setProduct2(String product2) { Shoppinglist.product2 = product2; }
    public static String getProduct3() { return product3; }
    public static void setProduct3(String product3) { Shoppinglist.product3 = product3; }
    public static Integer getDay() { return day; }
    public static void setDay(Integer day) { Shoppinglist.day = day; }
    public static Integer getMonth() { return month; }
    public static void setMonth(Integer month) { Shoppinglist.month = month; }
    public static Integer getYear() { return year;}
    public static void setYear(Integer year) { Shoppinglist.year = year; }
    public static Integer getQuantity1() { return quantity1; }
    public static void setQuantity1(Integer quantity) { Shoppinglist.quantity1 = quantity; }
    public static Integer getQuantity2() { return quantity2; }
    public static void setQuantity2(Integer quantity2) { Shoppinglist.quantity2 = quantity2; }
    public static Integer getQuantity3() { return quantity3; }
    public static void setQuantity3(Integer quantity3) { Shoppinglist.quantity3 = quantity3; }

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

        String[] lines = readfile(args[0]);
        List<String[]> newlist = new ArrayList<>();
        for (String line : lines) {
            List<String[]> newlist2 = new ArrayList<>();
            newlist2.add(line.split("\t"));
            newlist.addAll(newlist2);
        }
        data = newlist;
        return null;
    }

    public static void Dateofshopping(Integer q) {
        //This method for split the date as a day,month and year

        String date = String.valueOf(data.get(q)[2]);
        String[] Array = date.split("\\.");
        day = Integer.valueOf((Array[0]));
        month = Integer.valueOf(Array[1]);
        year = Integer.valueOf(Array[2]);


    }

}
