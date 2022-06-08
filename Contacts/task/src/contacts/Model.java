package contacts;

import java.util.LinkedList;

public class Model {

    LinkedList<Contact> data = new LinkedList<>();

    public LinkedList<Contact> getData() {
        return data;
    }

    public void add(Contact contact) {
        data.add(contact);
    }

    public void setPerson(int index, Person person) {
        data.set(index, person);
    }
    public void setOrganization(int index, Organization organization) {
        data.set(index, organization);
    }

    public Contact get(int index) {
        return data.get(index);
    }

    public String getOnlyName(int index) {
        String result = "";
        if(data.get(index) instanceof Person){
        Person person = (Person) data.get(index);
        result = person.showName();
        }
        if(data.get(index) instanceof Organization){
            Organization organization = (Organization) data.get(index);
            result = organization.showName();
        }
        return result;
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
