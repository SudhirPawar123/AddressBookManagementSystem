import java.util.ArrayList;
import java.util.List;

public class AddressBook {
    private String name;
    private List<Contact> contacts;

    AddressBook(String name){
        this.name=name;
        this.contacts=new ArrayList<>();
    }
    public String getName(){
        return name;
    }
    public void addContact(Contact contact){
        contacts.add(contact);
    }
}
