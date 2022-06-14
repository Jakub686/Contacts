package contacts;

import java.awt.*;
import java.util.LinkedList;
import java.util.Scanner;

public class MenuSearchQuery {
    public void search(Model model){
        boolean endCondition = true;
        do {
            Scanner scanner = new Scanner(System.in);
            new View().showEnterSearchQuery();
            String inputSearch = scanner.nextLine();
            LinkedList<String> foundQueries = new LinkedList<>();

            for (int i = 0; i < model.data.size(); i++) {
                if (model.getOnlyNameForSearching(i).contains(inputSearch)) {
                    foundQueries.add(model.getOnlyNameForSearching(i));
                }
            }
            new View().showFoundResults(foundQueries);
            new View().showQueryList(foundQueries);
            System.out.println();
            new View().showSearchMenu();

            String inputAction = scanner.nextLine();
            boolean numberCheck = (inputAction.matches("^[0-9]{1}$")|inputAction.matches("^[0-9]{2}$")|inputAction.matches("^[0-9]{3}$"));

            if (numberCheck==true){
                new MenuRecord().infoSearch(model,inputAction);
                endCondition = false;
            }
            if(inputAction.equals("again")){
                endCondition = true;
            }
            if(inputAction.equals("back")){
                endCondition = false;
            }




        }while (endCondition);
    }


}
