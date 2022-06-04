package contacts;

import java.awt.print.Book;

public class View {
    public void showEntertheNameOfThePerson() {
        System.out.println("Enter the name of the person:");
    }


    public void showEnterTheSurnameOfThePerson() {
        System.out.println("Enter the surname of the person:");
    }

    public void showEnterTheNumber() {
        System.out.println("Enter the number:");
    }
    public void showEnterNumber() {
        System.out.println("Enter number:");
    }

    public void showARecordCreated() {
        System.out.println("A record created!");
    }

    public void showEnterAction() {
        System.out.println("Enter action (add, remove, edit, count, list, exit):");
    }

    public void showAPhoneBookWithASingleRecordCreated() {
        System.out.println("A Phone Book with a single record created!");
    }
    public void showSelectARecord() {
        System.out.println("Select a record:");
    }
    public void showSelectAField () {
        System.out.println("Select a field (name, surname, number):");
    }

    public void showTheRecordAdded() {
        System.out.println("The record added.");
    }
    public void showTheRecordRemoved() {
        System.out.println("The record removed!");
    }
    public void showList(Model model) {
        for(int i = 0 ; i< model.data.size(); i++){
            System.out.println(i+1+". " + model.getName(i)+" "+ model.getSurname(i)+ " " + model.getNumber(i));
        }
    }

    public void showNoRecordsToEdit() {
        System.out.println("No records to edit!");
    }
    public void showNoRecordsToRemove() {
        System.out.println("No records to remove!");
    }
    public void showAmount(Model model) {
        if(model.data.size()==0){
                System.out.println("The Phone Book has 0 records.");
        }else {
            System.out.println(model.data.size());
        }

    }

}
