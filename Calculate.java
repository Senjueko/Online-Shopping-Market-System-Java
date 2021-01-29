import java.util.HashMap;

public class Calculate {

    public static HashMap<String,Double> hashMap; // This hashmap for store the prices

    public static void main(String[] args) {
        Shoppinglist.main(args);
        Pricelist.main(args);
        Hash();
        Print();
    }

    public static void Shop_outfive(Integer i){
        // This method for storing the data for customers whose buy 1 product(name,type,date,product,quantity)

        Shoppinglist.setName(Shoppinglist.data.get(i)[0]);
        Shoppinglist.setType(Shoppinglist.data.get(i)[1]);
        Shoppinglist.Dateofshopping(i);
        Pricelist.Dateofprice(i);
        Shoppinglist.setProduct1(Shoppinglist.data.get(i)[3]);
        Shoppinglist.setQuantity1(Integer.valueOf(Shoppinglist.data.get(i)[4]));
    }

    public static void Shop_outseven(Integer i){
        // This method for storing the data for customers whose buy 2 product(name,type,date,product,quantity)

        Shoppinglist.setName(Shoppinglist.data.get(i)[0]);
        Shoppinglist.setType(Shoppinglist.data.get(i)[1]);
        Shoppinglist.Dateofshopping(i);
        Pricelist.Dateofprice(i);
        Shoppinglist.setProduct1(Shoppinglist.data.get(i)[3]);
        Shoppinglist.setQuantity1(Integer.valueOf(Shoppinglist.data.get(i)[4]));
        Shoppinglist.setProduct2(Shoppinglist.data.get(i)[5]);
        Shoppinglist.setQuantity2(Integer.valueOf(Shoppinglist.data.get(i)[6]));
    }

    public static void Shop_outnine(Integer i){
        // This method for storing the data for customers whose buy 3 product(name,type,date,product,quantity)

        Shoppinglist.setName(Shoppinglist.data.get(i)[0]);
        Shoppinglist.setType(Shoppinglist.data.get(i)[1]);
        Shoppinglist.Dateofshopping(i);
        Pricelist.Dateofprice(i);
        Shoppinglist.setProduct1(Shoppinglist.data.get(i)[3]);
        Shoppinglist.setQuantity1(Integer.valueOf(Shoppinglist.data.get(i)[4]));
        Shoppinglist.setProduct2(Shoppinglist.data.get(i)[5]);
        Shoppinglist.setQuantity2(Integer.valueOf(Shoppinglist.data.get(i)[6]));
        Shoppinglist.setProduct3(Shoppinglist.data.get(i)[7]);
        Shoppinglist.setQuantity3(Integer.valueOf(Shoppinglist.data.get(i)[8]));
    }



    public static void Print(){
        // This method for print the outputs

        for (int i = 0; i < Shoppinglist.data.size(); i++){
            if (Shoppinglist.data.get(i).length == 5){
                Shop_outfive(i);
                Double total = hashMap.get(Shoppinglist.getProduct1()+Shoppinglist.getType()) * Integer.valueOf(Shoppinglist.getQuantity1());
                System.out.println("---" + Shoppinglist.getName() + "---");
                System.out.println(Shoppinglist.getProduct1() + "\t" + String.valueOf(hashMap.get(Shoppinglist.getProduct1()+Shoppinglist.getType())) + "\t" + Shoppinglist.getQuantity1() + "\t" + String.valueOf(total));
                System.out.println("Total" + "\t" + String.valueOf(total));
            }
            if (Shoppinglist.data.get(i).length == 7){
                Shop_outseven(i);
                Double total1 = hashMap.get(Shoppinglist.getProduct1()+Shoppinglist.getType()) * Integer.valueOf(Shoppinglist.getQuantity1());
                Double total2 = hashMap.get(Shoppinglist.getProduct2()+Shoppinglist.getType()) * Integer.valueOf(Shoppinglist.getQuantity2());
                Double total = total1 + total2;
                System.out.println("---" + Shoppinglist.getName() + "---");
                System.out.println(Shoppinglist.getProduct1() + "\t" + String.valueOf(hashMap.get(Shoppinglist.getProduct1()+Shoppinglist.getType())) + "\t" + Shoppinglist.getQuantity1() + "\t" + String.valueOf(total1));
                System.out.println(Shoppinglist.getProduct2() + "\t" + String.valueOf(hashMap.get(Shoppinglist.getProduct2()+Shoppinglist.getType())) + "\t" + Shoppinglist.getQuantity2() + "\t" + String.valueOf(total2));
                System.out.println("Total" + "\t" + String.valueOf(total));
            }
            if (Shoppinglist.data.get(i).length == 9){
                Shop_outnine(i);
                Double total1 = hashMap.get(Shoppinglist.getProduct1()+Shoppinglist.getType()) * Integer.valueOf(Shoppinglist.getQuantity1());
                Double total2 = hashMap.get(Shoppinglist.getProduct2()+Shoppinglist.getType()) * Integer.valueOf(Shoppinglist.getQuantity2());
                Double total3 = hashMap.get(Shoppinglist.getProduct3()+Shoppinglist.getType()) * Integer.valueOf(Shoppinglist.getQuantity3());
                Double total = total1 + total2 + total3;
                System.out.println("---" + Shoppinglist.getName() + "---");
                System.out.println(Shoppinglist.getProduct1() + "\t" + String.valueOf(hashMap.get(Shoppinglist.getProduct1()+Shoppinglist.getType())) + "\t" + Shoppinglist.getQuantity1() + "\t" + String.valueOf(total1));
                System.out.println(Shoppinglist.getProduct2() + "\t" + String.valueOf(hashMap.get(Shoppinglist.getProduct2()+Shoppinglist.getType())) + "\t" + Shoppinglist.getQuantity2() + "\t" + String.valueOf(total2));
                System.out.println(Shoppinglist.getProduct3() + "\t" + String.valueOf(hashMap.get(Shoppinglist.getProduct3()+Shoppinglist.getType())) + "\t" + Shoppinglist.getQuantity3() + "\t" + String.valueOf(total3));
                System.out.println("Total" + "\t" + String.valueOf(total));

            }
        }
    }

    public static void Hash(){
        // This method for matching the products and their prices

        HashMap<String,Double> hash = new HashMap<String, Double>();
        hashMap = hash;
        for (int i = 0; i < Pricelist.data.size(); i++){
            hashMap.put(String.valueOf(Pricelist.data.get(i)[0] + Pricelist.data.get(i)[1]),Double.valueOf(Pricelist.data.get(i)[4]));
        }
    }

}

