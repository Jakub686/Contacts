package contacts;

import java.util.LinkedList;

public class Model {

    LinkedList<Contact> data = new LinkedList<>();

    public void add(Contact contact) {
        data.add(contact);
    }

    public void set(int index, Person person) {
        data.set(index, person);
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
