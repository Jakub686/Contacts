package contacts;

import java.awt.print.Book;

public class View {
    public void showEntertheNameOfThePerson() {
        System.out.println("Enter the name of the person:");
    }

    public void showEnterTheOrganizationName() {
        System.out.println("Enter the organization name:");
    }

    public void showEnterTheSurnameOfThePerson() {
        System.out.println("Enter the surname of the person:");
    }

    public void showEnterTheBirthDate() {
        System.out.println("Enter the birth date:");
    }

    public void showEnterTheGender() {
        System.out.println("Enter the gender (M, F):");
    }

    public void showEnterTheAddress() {
        System.out.println("Enter the address:");
    }

    public void showEnterTheNumber() {
        System.out.println("Enter the number:");
    }

    public void showWrongNumberFormat() {
        System.out.println("Wrong number format!");
    }

    public void showEnterNumber() {
        System.out.println("Enter number:");
    }

    public void showARecordCreated() {
        System.out.println("A record created!");
    }

    public void showEnterAction() {
        System.out.println("Enter action (add, remove, edit, count, info, exit):");
    }

    public void showAPhoneBookWithASingleRecordCreated() {
        System.out.println("A Phone Book with a single record created!");
    }

    public void showSelectARecord() {
        System.out.println("Select a record:");
    }

    public void showBadGender() {
        System.out.println("Bad gender!");
    }

    public void showBadBirthDate() {
        System.out.println("Bad birth date!");
    }

    public void showSelectAFieldPerson() {
        System.out.println("Select a field (name, surname, birth, gender, number):");
    }
    public void showSelectAFieldOrganization() {
        System.out.println("Select a field (organization name, address, number):");
    }

    public void showTheRecordAdded() {
        System.out.println("The record added.");
    }

    public void showTheRecordRemoved() {
        System.out.println("The record removed!");
    }

    public void showTheRecordUpdated() {
        System.out.println("The record updated");
    }

    public void showList(Model model) {
        for (int i = 0; i < model.data.size(); i++) {
            System.out.println(i + 1 + ". " + model.getOnlyName(i));
        }
    }
    public void showContact(Model model, int index) {
        if(model.data.get(index) instanceof Person) {

            System.out.println(model.getContactInfo(index));
        }
        if(model.data.get(index) instanceof Organization) {

            System.out.println(model.getContactInfo(index));
        }

    }

    public void showEnterIndexToShowInfo() {
        System.out.println("Enter index to show info:");
    }

    public void showEnterTheTypePersonOrganization() {
        System.out.println("Enter the type (person, organization):");
    }

    public void showNoRecordsToEdit() {
        System.out.println("No records to edit!");
    }

    public void showNoRecordsToRemove() {
        System.out.println("No records to remove!");
    }

    public void showAmount(Model model) {
        if (model.data.size() == 0) {
            System.out.println("The Phone Book has 0 records.");
        } else {
            System.out.println(model.data.size());
        }

    }

}
