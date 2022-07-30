package contacts;

import java.time.LocalDateTime;
import java.util.Scanner;

public class EditTypeChecker {

    Scanner scannerString = new Scanner(System.in);

    public void editContact(Model model, int index){

        if(model.data.get(index) instanceof Person) {

            Person person = (Person) model.data.get(index);

            new View().showSelectAFieldPerson();
            String field = scannerString.nextLine();

            switch (field) {
                case "name": {
                    new View().showEntertheNameOfThePerson();
                    String name = scannerString.nextLine();
                    person = new Person.Builder()
                            .name(name)
                            .surname(model.getPersonSurname(index))
                            .birthDate(model.getBirthDate(index))
                            .gender(model.getGender(index))
                            .number(model.getPersonNumber(index))
                            .created(model.getCreatedPerson(index))
                            .lastEdit(LocalDateTime.now())
                            .build();
                    model.set(index,person);

                    new View().showTheRecordUpdated();
                    new View().showTheRecordUpdated();
                    break;
                }
                case "surname": {
                    new View().showEnterTheSurnameOfThePerson();
                    String surName = scannerString.nextLine();
                    person = new Person.Builder()
                            .name(model.getOnlyName(index))
                            .surname(surName)
                            .birthDate(model.getBirthDate(index))
                            .gender(model.getGender(index))
                            .number(model.getPersonNumber(index))
                            .created(model.getCreatedPerson(index))
                            .lastEdit(LocalDateTime.now())
                            .build();
                    model.set(index,person);

                    new View().showTheRecordUpdated();
                    break;
                }
                case "birth": {
                    new View().showEnterTheBirthDate();
                    String birth = scannerString.nextLine();
                    person = new Person.Builder()
                            .name(model.getOnlyName(index))
                            .surname(model.getPersonSurname(index))
                            .birthDate(birth)
                            .gender(model.getGender(index))
                            .number(model.getPersonNumber(index))
                            .created(model.getCreatedPerson(index))
                            .lastEdit(LocalDateTime.now())
                            .build();
                    model.set(index,person);

                    new View().showTheRecordUpdated();
                    break;
                }
                case "gender": {
                    new View().showEnterTheSurnameOfThePerson();
                    String gender = scannerString.nextLine();
                    person = new Person.Builder()
                            .name(model.getOnlyName(index))
                            .surname(model.getPersonSurname(index))
                            .birthDate(model.getBirthDate(index))
                            .gender(gender)
                            .number(model.getPersonNumber(index))
                            .created(model.getCreatedPerson(index))
                            .lastEdit(LocalDateTime.now())
                            .build();
                    model.set(index,person);

                    new View().showTheRecordUpdated();
                    break;
                }
                case "number": {
                    new View().showEnterNumber();
                    String number = scannerString.nextLine();
                    String numberValidated = new PhoneValidator().numberValidator(number);
                    //TODO
                    person = new Person.Builder()
                            .name(model.getOnlyName(index))
                            .surname(model.getPersonSurname(index))
                            .birthDate(model.getBirthDate(index))
                            .gender(model.getGender(index))
                            .number(numberValidated)
                            .created(model.getCreatedPerson(index))
                            .lastEdit(LocalDateTime.now())
                            .build();
                    model.set(index,person);

                    new View().showTheRecordUpdated();
                    break;
                }
            }
        }

        if(model.data.get(index) instanceof Organization) {
            Organization organization = (Organization) model.data.get(index);
            new View().showSelectAFieldOrganization();
            String field = scannerString.nextLine();


            switch (field) {
                case "name": {
                    new View().showEnterTheOrganizationName();
                    String organizationName = scannerString.nextLine();
                    organization = new Organization.Builder()
                            .organizationName(organizationName)
                            .address(model.getAddress(index))
                            .number(model.getPersonNumber(index))
                            .created(model.getCreatedPerson(index))
                            .lastEdit(LocalDateTime.now())
                            .build();
                    model.set(index,organization);

                    new View().showTheRecordUpdated();
                    new View().showTheRecordUpdated();
                    break;
                }
                case "address": {
                    new View().showEnterTheAddress();
                    String address = scannerString.nextLine();
                    organization = new Organization.Builder()
                            .organizationName(model.getOrganizationName(index))
                            .address(address)
                            .number(model.getOrgnizationNumber(index))
                            .created(model.getCreatedOrganization(index))
                            .lastEdit(LocalDateTime.now())
                            .build();
                    model.set(index,organization);

                    new View().showTheRecordUpdated();
                    break;
                }
                case "number": {
                    new View().showEnterNumber();
                    String number = scannerString.nextLine();
                    String numberValidated = new PhoneValidator().numberValidator(number);
                    organization = new Organization.Builder()
                            .organizationName(model.getOrganizationName(index))
                            .address(model.getAddress(index))
                            .number(numberValidated)
                            .created(model.getCreatedOrganization(index))
                            .lastEdit(LocalDateTime.now())
                            .build();
                    model.set(index,organization);

                    new View().showTheRecordUpdated();
                    break;
                }
            }

        }
    }
}
