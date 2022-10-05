import java.io.FileNotFoundException;
import java.util.*;

public class ProductManager {

    public static void main(String[] args) {
        try {
            Map<String, TreeSet<Product>> productsMap = ProductImporter.readFile("/Users/mdziuba/IdeaProjects/maps2v2/src/products.csv");
            String category = readCategory();
            printCategoryStats(productsMap, category);
        } catch (FileNotFoundException e ) {
            System.err.println("File not found ");

        }
    }

    private static void printCategoryStats(Map<String, TreeSet<Product>> productsMap, String category) {
          TreeSet<Product> products = productsMap.get(category);

          if (products == null) {
              System.out.println("There are no products of " + category + " category");
          }
          else{
              printAll(products);
              printAvgPrice(products);
              printExpensiveAndCheapestProduct(products);
          }

          }

    private static void printExpensiveAndCheapestProduct(TreeSet<Product> products) {
        System.out.println("Cheapest product: " + products.first());
        System.out.println("Most expensive Product: " + products.last());

    }

    private static  void printAvgPrice(Set<Product> products) {
        double sum=0;
        for (Product product : products) {
            sum += product.getPrice();
        }
        System.out.printf("Average price: "+ "%5.2f%n",(sum/products.size()));

    }

    private static void printAll(Set<Product> products) {
        for (Product product : products) {
            System.out.println(product );
            
        }
    }

    private static String readCategory() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please provide products category: ");
        return scanner.nextLine();

    }
}
