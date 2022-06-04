package contacts;

import java.util.Scanner;

public class Controller {
    public void run(Model model) {

        boolean endCondition = true;

        while (endCondition) {
            endCondition = actions(model,endCondition);
        }
    }

    private boolean actions(Model model, boolean endCondition) {
        Scanner scanner = new Scanner(System.in);
        new View().showEnterAction();
        String action = scanner.nextLine();
        switch (action) {
            case "add": {
                add(model);
                break;
            }
            case "remove": {
                if (model.data.size() == 0) {
                    new View().showNoRecordsToRemove();
                } else {
                    new View().showList(model);
                    new View().showSelectARecord();
                    int index = scanner.nextInt();
                    remove(index,model);
                }
                break;
            }
            case "edit": { ///
                if (model.data.size() == 0) {
                    new View().showNoRecordsToEdit();
                } else {
                    edit(model);
                }
                break;
            }
            case "count": {
                new View().showAmount(model);
                break;
            }
            case "list": {
                new View().showList(model);
                break;
            }
            case "exit": { ///
                endCondition = false;
                break;
            }
        }
        return endCondition;
    }

    public void add(Model model) {
        Scanner scanner = new Scanner(System.in);
        new View().showEntertheNameOfThePerson();
        String name = scanner.nextLine();

        new View().showEnterTheSurnameOfThePerson();
        String surname = scanner.nextLine();

        new View().showEnterTheNumber();
        String number = scanner.nextLine();

        Contact contact = new Contact.Builder()
                .name(name)
                .surname(surname)
                .number(number)
                .build();

        model.add(contact);
        new View().showTheRecordAdded();
    }

    public void edit(Model model) {
        Scanner scanner = new Scanner(System.in);
        Scanner scannerString = new Scanner(System.in);
        new View().showList(model);
        new View().showSelectARecord();
        int record = scanner.nextInt()-1;
        new View().showSelectAField();
        String field = scannerString.nextLine();
        //TODO need setter, przy wzorcu builder nie ma setterow przez co musze tworzyc trzy razy obiekt, zamiast utworzyc wczesniej obiek i pozniej uzyc setera zeby ustawic interesujace mnie pole

        switch (field){
            case "name":{
                new View().showEntertheNameOfThePerson();
                String name = scannerString.nextLine();
                Contact tempContact = new Contact.Builder()
                        .name(name)
                        .surname(model.getSurname(record))
                        .number(model.getNumber(record))
                        .build();
                model.set(record,tempContact);
                break;
            }
            case "surname":{
                new View().showEnterTheSurnameOfThePerson();
                String surname = scannerString.nextLine();
                Contact tempContact = new Contact.Builder()
                        .name(model.getName(record))
                        .surname(surname)
                        .number(model.getNumber(record))
                        .build();
                model.set(record,tempContact);
                break;
            }
            case "number":{
                new View().showEnterNumber();
                String number = scannerString.nextLine();
                Contact tempContact = new Contact.Builder()
                        .name(model.getName(record))
                        .surname(model.getSurname(record))
                        .number(number)
                        .build();
                model.set(record,tempContact);
                break;
            }
        }

    }

    public void remove(int index, Model model) {
        model.remove(index-1);
        new View().showTheRecordRemoved();
    }


}

