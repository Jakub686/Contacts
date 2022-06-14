package contacts;

import java.util.Scanner;

public class MenuRecord {
    public void infoSearch(Model model, String inputAction) {
        Scanner scanner = new Scanner(System.in);
        boolean endCondition = true;
        do {
            int inputActionInt = Integer.parseInt(inputAction);
            int index = inputActionInt - 1;
            new View().showContact(model, index);

            System.out.println();
            new View().showRecordEnterAction();
            String action = scanner.nextLine();

            switch (action) {
                case "edit": {
                    //new View().showSelectAFieldToEdit();
                    edit(model,index);
                    break;
                }
                case "delete": {
                    delete(index, model);
                    endCondition = false;
                    break;
                }
                case "menu": {
                    endCondition = false;
                }
                break;
            }

        } while (endCondition);

    }

    public void edit(Model model,int index) { ;

        int record = index;
        new EditTypeChecker().editContact(model, record);
    }

    public void delete(int index, Model model) {
        model.remove(index);
        new View().showTheRecordRemoved();
    }
}
