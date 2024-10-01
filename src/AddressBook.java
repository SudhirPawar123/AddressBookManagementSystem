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
    public void editContact(String editFirstName, String editLastName, Contact updatedContact) {
        for (Contact contact : contacts) {
            if (contact.getFirstName().equalsIgnoreCase(editFirstName) && contact.getLastName().equalsIgnoreCase(editLastName)) {
                contact.setAddress(updatedContact.getAddress());
                contact.setCity(updatedContact.getCity());
                contact.setState(updatedContact.getState());
                contact.setZip(updatedContact.getZip());
                contact.setPhoneNumber(updatedContact.getPhoneNumber());
                contact.setEmail(updatedContact.getEmail());
                break;
            }
        }
    }
    public List<Contact> getContacts() {
        return contacts;
    }

    @Override
    public String toString() {
        return "Address Book: " + name + "\nContacts:\n" + contacts;
    }

    public void deleteContact(String firstName, String lastName) {
        contacts.removeIf(contact -> contact.getFirstName().equalsIgnoreCase(firstName) && contact.getLastName().equalsIgnoreCase(lastName));
    }
}
