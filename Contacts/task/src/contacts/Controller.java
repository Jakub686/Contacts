package contacts;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Controller {
    public void run(Model model) {

        boolean endCondition = true;

        while (endCondition) {
            endCondition = mainMenu(model, endCondition);
        }
    }

    private boolean mainMenu(Model model, boolean endCondition) {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        new View().showMenuEnterAction();
        String action = scanner.nextLine();
        switch (action) {
            case "add": {
                add(model);
                break;
            }
            case "list": {
                MenuList.list(model);

                break;
            }
            case "search": {
                new MenuSearchQuery().search(model);
                break;
            }
            case "count": {
                new View().showAmount(model);
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

    public void serach(Model model) {
        Scanner scanner = new Scanner(System.in);
        new View().showEnterSearchQuery();

        new View().showList(model);
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


}

