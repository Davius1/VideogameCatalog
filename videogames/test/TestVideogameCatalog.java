package videogames.test;

//@author DAVIUS1

import java.util.Scanner;
import videogames.service.*;


public class TestVideogameCatalog {
    public static void main(String[] args) {
        var option = -1;
        var scanner = new Scanner(System.in);
        IVideogamesCatalog catalog = new VideogameCatalogImpl();
        
        
        while(option != 0){
            System.out.println("Select an option: \n"
            + "1. Start videogame catalog\n"
            + "2. Add videogame\n"
            + "3. List videogames\n"
            + "4. Search videogames\n"
            + "0. Exit");
            option = Integer.parseInt(scanner.nextLine());
            
            switch(option){
                case 1:
                    catalog.StartVideogameCatalog();
                    break;
                case 2:
                    System.out.println("Type the name of the videogame");
                    var videogameName = scanner.nextLine();
                    catalog.addVideogame(videogameName);
                    break;
                case 3:
                    catalog.VideogameList();
                    break;
                case 4:
                    System.out.println("Type the name of the videogame to search it");
                    var search = scanner.nextLine();
                    catalog.VideogameSearch(search);
                    break;
                case 0:
                    System.out.println("See you net time!");
                    break;
                default:
                    System.out.println("Option not allowed");
                    break;
                    
            }
        }
    }
}
