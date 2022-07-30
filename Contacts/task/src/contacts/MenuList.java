package contacts;

import java.util.Scanner;

public class MenuList {
    public static void list(Model model) {
        Scanner scanner = new Scanner(System.in);

        new View().showList(model);
        new View().showMenuList();

        String input = scanner.nextLine();
        if(input.equals("back")){

        }else {

            new MenuRecord().infoSearch(model,input);
        }



    }
}
