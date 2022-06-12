package contacts;

import java.util.LinkedList;
import java.util.Scanner;

public class SearchQuery {
    public void search(Model model){
        Scanner scanner = new Scanner(System.in);
        new View().showEnterSearchQuery();
        String input = scanner.nextLine();
        LinkedList<String> foundQuerys = new LinkedList<>();
        for(int i = 0; i<model.data.size();i++){
            if(model.getOnlyNameForSearching(i).contains(input)){
                foundQuerys.add(model.getOnlyNameForSearching(i));
            }
        }
        new View().showQueryList(foundQuerys);
    }
}
