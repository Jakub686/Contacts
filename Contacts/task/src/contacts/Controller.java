package contacts;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Controller {
    public void run(Model model) {

        boolean endCondition = true;

        while (endCondition) {
            endCondition = actions(model, endCondition);
        }
    }

    private boolean actions(Model model, boolean endCondition) {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
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
                    remove(index, model);
                }
                break;
            }
            case "edit": {
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
            case "info": {
                info(model);
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
        new View().showEnterTheTypePersonOrganization();
        String input = scanner.nextLine();
        if (input.equals("person")) {
            new View().showEntertheNameOfThePerson();
            String name = scanner.nextLine();

            new View().showEnterTheSurnameOfThePerson();
            String surname = scanner.nextLine();

            new View().showEnterTheBirthDate();
            String birthDate = scanner.nextLine();
            if (birthDate.equals("")) {
                new View().showBadBirthDate();
                birthDate = "[no data]";
            }
            new View().showEnterTheGender();
            String gender = scanner.nextLine();
            if (!(gender.equals("M") | gender.equals("m") | gender.equals("F") | gender.equals("f"))) {
                new View().showBadGender();
                gender = "[no data]";
            }

            new View().showEnterTheNumber();
            String number = scanner.nextLine();
            String numberValidated = new PhoneValidator().numberValidator(number);

            Person person = setPerson(name, surname, birthDate, gender, numberValidated, LocalDateTime.now(), LocalDateTime.now());
            model.add(person);
        }
        if (input.equals("organization")) {
            new View().showEnterTheOrganizationName();
            String organizationName = scanner.nextLine();
            new View().showEnterTheAddress();
            String address = scanner.nextLine();
            new View().showEnterTheNumber();
            String number = scanner.nextLine();
            String numberValidated = new PhoneValidator().numberValidator(number);
            Organization organization = setOrganization(numberValidated, organizationName, address, LocalDateTime.now(), LocalDateTime.now());
            model.add(organization);
        }

        new View().showTheRecordAdded();
    }

    public void edit(Model model) {
        Scanner scanner = new Scanner(System.in);

        new View().showList(model);
        new View().showSelectARecord();
        int record = scanner.nextInt() - 1;
        new EditTypeChecker().editContact(model, record);


    }

    public void info(Model model) {
        Scanner scanner = new Scanner(System.in);
        new View().showList(model);
        new View().showEnterIndexToShowInfo();
        int index = scanner.nextInt() - 1;
        new View().showContact(model, index);
    }

    private Person setPerson(String name, String surname, String birthDate, String gender, String number, LocalDateTime created, LocalDateTime lastEdit) {
        return new Person.Builder()
                .name(name)
                .surname(surname)
                .birthDate(birthDate)
                .gender(gender)
                .number(number)
                .created(created)
                .lastEdit(lastEdit)
                .build();
    }

    private Organization setOrganization(String number, String organizationName, String address, LocalDateTime created, LocalDateTime lastEdit) {
        return new Organization.Builder()
                .number(number)
                .organizationName(organizationName)
                .address(address)
                .created(created)
                .lastEdit(lastEdit)
                .build();
    }

    public void remove(int index, Model model) {
        model.remove(index - 1);
        new View().showTheRecordRemoved();
    }


}

