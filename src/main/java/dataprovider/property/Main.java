package dataprovider.property;


public class Main {
    public static void main(String[] args) {

        PropertyUtility prop = PropertyUtility.load("src/main/resources/prop1.properties");
        prop.put("a", "a");
        prop.put("a", "b");
        prop.put("b", "b");
        prop.put("a", "c");

       // prop.remove("b");
      //  prop.update("a", "aa");

        System.out.println(prop.get("a"));
        prop.put("c","asdasdasd");


        prop.write();


    }
}
