package contacts;

import java.util.HashMap;
import java.util.LinkedList;

public class Model {

    LinkedList<Contact> data = new LinkedList<>();

    public void add(Contact contact){
        data.add(contact);
    }
    public void set(int index,Contact contact){
        data.set(index,contact);
    }
    public Contact get(int index){
        return data.get(index);
    }
    public void remove(int index){
        data.remove(index);
    }
    public String getName(int index){
        Contact contact = data.get(index);
        return contact.getName();
    }
    public String getSurname(int index){
        Contact contact = data.get(index);
        return contact.getSurname();
    }
    public String getNumber(int index){
        Contact contact = data.get(index);
        return contact.getNumber();
    }
}
