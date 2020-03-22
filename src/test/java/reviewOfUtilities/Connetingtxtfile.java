package reviewOfUtilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Connetingtxtfile{


    public static void main( String[] args ) throws FileNotFoundException {
        File file = new File ("/Users/sevim/Desktop/Git.txt");
        Scanner scanner = new Scanner (file);
        while ( scanner.hasNext () ) {
            System.out.println (scanner.nextLine ());
        }

    }
}
