package contacts;

import java.util.LinkedList;
import java.util.Scanner;

public class EditTypeChecker {

    LinkedList<Contact> data = new Model().getData();
    Scanner scannerString = new Scanner(System.in);
;

    public void editContact(Model model, int index){

        if(data.get(index) instanceof Person) {
            Person person = (Person) data.get(index);
            new View().showSelectAField();
            String field = scannerString.nextLine();


            switch (field) {
                case "name": {
                    new View().showEntertheNameOfThePerson();
                    String name = scannerString.nextLine();
                    //model.set(record, setContact(name, model.getSurname(record), model.getNumber(record)));
                    new View().showTheRecordUpdated();
                    break;
                }
                case "surname": {
                    new View().showEnterTheSurnameOfThePerson();
                    String surname = scannerString.nextLine();
                    new View().showTheRecordUpdated();
                    break;
                }
                case "number": {
                    new View().showEnterNumber();
                    String number = scannerString.nextLine();
                    String numberValidated = new PhoneValidator().numberValidator(number);
                    model.setPerson(index,person.setNumber(numberValidated));
                    new View().showTheRecordUpdated();
                    break;
                }
            }
        }

    }
}
