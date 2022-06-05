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
        //TODO if number is correct
        String numberValidated = numberValidator(number);


        Contact contact = setContact(name, surname, numberValidated);

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

        switch (field){
            case "name":{
                new View().showEntertheNameOfThePerson();
                String name = scannerString.nextLine();
                model.set(record, setContact(name, model.getSurname(record), model.getNumber(record)));
                new View().showTheRecordUpdated();
                break;
            }
            case "surname":{
                new View().showEnterTheSurnameOfThePerson();
                String surname = scannerString.nextLine();
                Contact tempContact = setContact(model.getName(record), surname, model.getNumber(record));
                model.set(record,tempContact);
                new View().showTheRecordUpdated();
                break;
            }
            case "number":{
                new View().showEnterNumber();
                String number = scannerString.nextLine();
                String numberValidated = numberValidator(number);

                Contact tempContact = setContact(model.getName(record), model.getSurname(record), numberValidated);
                model.set(record,tempContact);
                new View().showTheRecordUpdated();
                break;
            }
        }
    }

    private Contact setContact(String name, String surname, String number) {
        return new Contact.Builder()
                .name(name)
                .surname(surname)
                .number(number)
                .build();
    }

    public void remove(int index, Model model) {
        model.remove(index-1);
        new View().showTheRecordRemoved();
    }
    
    public String numberValidator(String num){
        String result = "";
        boolean numberCheck = (num.matches("^(\\+\\d{1}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{3}[- .]?\\w{4}$")
                |num.matches("(.\\([a-zA-Z]{7}\\))")|num.matches("(.\\([a-zA-Z]{7}\\))")|num.matches("(.\\([a-zA-Z]{5}\\))") | num.matches("^([0-9]{3}) ([0-9]{2})-([a-zA-Z]{4})-([0-9]{2})")|num.matches("^([0-9]{3}) \\(\\d{2}\\)-([0-9]{2})-([0-9]{2})")|num.matches("^([0-9]{3}) ([0-9]{2})-([a-zA-Z]{2})-([0-9]{2})")|num.matches("^\\+\\d{1} \\d{2}$")|num.matches("^\\d{1}$")|num.matches("^\\d{3}$")|num.matches("\\(\\d{3}\\)")|num.matches("^([0-9]{3}) ([a-zA-Z]{3})$")|num.matches("^([0-9]{3})-\\(\\d{3}\\)$")|num.matches("^\\(\\d{3}\\) ([0-9]{3})$")|num.matches("^\\(\\d{3}\\) ([0-9]{3})-([0-9]{3})$")|num.matches("^\\(\\d{3}\\)-([0-9]{3}) ([0-9]{3})$")|num.matches("^([0-9]{3})-\\(\\d{3}\\)$")|num.matches("^([0-9]{3}) \\(\\d{3}\\) ([0-9]{3})$")|num.matches("^([0-9]{3})-\\(\\d{3}\\)-([0-9]{3})$")|num.matches("^([0-9]{3})-([a-zA-Z]{3})$")|num.matches("^([0-9]{3}) ([0-9]{3}) ([a-zA-Z]{3})$")|num.matches("^([0-9]{3}) ([0-9]{3})-([0-9]{3})$")|num.matches("^([0-9]{3})-([0-9]{3})-([a-zA-Z]{3})$")|num.matches("^([0-9]{3})-([0-9]{3}) ([0-9]{3})$"));
        if(numberCheck==true){
            result = num;
        }else {
            new View().showWrongNumberFormat();
            result = "[no number]";
        }

        
        return result;
    }


}

