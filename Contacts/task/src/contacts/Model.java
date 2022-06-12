package contacts;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class Model {

    LinkedList<Contact> data = new LinkedList<>();

    public void add(Contact contact) {
        data.add(contact);
    }

    public void set(int index,Contact contact){
        data.set(index,contact);
    }


    public String getOnlyName(int index) {
        String result = "";
        if(data.get(index) instanceof Person){
        Person person = (Person) data.get(index);
        result = person.showName();
        }
        if(data.get(index) instanceof Organization){
            Organization organization = (Organization) data.get(index);
            result = organization.showOrganizationName();
        }
        return result;
    }

    public String getPersonName(int index) {
        Person person = (Person) data.get(index);
        return person.showSurname();
    }

    public String getPersonSurname(int index) {
            Person person = (Person) data.get(index);
        return person.showSurname();
    }
    public String getBirthDate(int index) {
        Person person = (Person) data.get(index);
        return person.showBirthDate();
    }
    public String getGender(int index) {
        Person person = (Person) data.get(index);
        return person.showGender();
    }
    public LocalDateTime getCreatedPerson(int index) {
        Person person = (Person) data.get(index);
        return person.showCreated();
    }
    public String getPersonNumber(int index) {
        Person person = (Person) data.get(index);
        return person.showNumber();
    }
    public String getOrgnizationNumber(int index) {
        Organization organization = (Organization) data.get(index);
        return organization.showNumber();
    }
    public String getOrganizationName(int index) {
        Organization organization = (Organization) data.get(index);
        return organization.showOrganizationName();
    }
    public LocalDateTime getCreatedOrganization(int index) {
        Organization organization = (Organization) data.get(index);
        return organization.showCreated();
    }
    public String getAddress(int index) {
        Organization organization = (Organization) data.get(index);
        return organization.showAddress();
    }
    public String getContactInfo(int index) {
        String result = "";
        if(data.get(index) instanceof Person){
            Person person = (Person) data.get(index);
            result = person.showInfo();
        }
        if(data.get(index) instanceof Organization){
            Organization organization = (Organization) data.get(index);
            result = organization.showInfo();
        }
        return result;
    }



    public void remove(int index) {
        data.remove(index);
    }

}
