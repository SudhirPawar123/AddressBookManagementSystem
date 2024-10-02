import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBookSystem {
    private Map<String ,AddressBook> addressBooks;
    AddressBookSystem(){
        addressBooks=new HashMap<>();
    }
    public void  addAddressBook(String name){
        addressBooks.put(name,new AddressBook(name));
    }
    public AddressBook getAddressBook(String name){
        return this.addressBooks.get(name);
    }
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Management System..!");
        AddressBookSystem addressBookSystem=new AddressBookSystem();
        Scanner scanner=new Scanner(System.in);
        int choice;
        do{
            System.out.println("1. Add Address Book");
            System.out.println("2. Select Address Book");
            System.out.println("3. Display Address Books");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice){
                case 1: System.out.print("Enter Address Book name: ");
                    String addressBookName = scanner.nextLine();
                    addressBookSystem.addAddressBook(addressBookName);
                    break;
                case 2:
                    System.out.print("Enter Address Book name: ");
                    String bookName = scanner.nextLine();
                    AddressBook addressBook = addressBookSystem.getAddressBook(bookName);

                    if (addressBook == null) {
                        System.out.println("Address Book not found.");
                    } else {
                        manageContacts(addressBook, scanner);
                    }
                    break;
                case 3:
                    addressBookSystem.displayAddressBooks();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }while(choice!=0);
        scanner.close();
    }

    public void displayAddressBooks() {
        if (addressBooks.isEmpty()) {
            System.out.println("No Address Books available.");
        } else {
            for (String name : addressBooks.keySet()) {
                System.out.println(name);
            }
        }
    }

    private static void manageContacts(AddressBook addressBook, Scanner scanner) {
        int choice;
        do{
            System.out.println("\nManaging Address Book: " + addressBook.getName());
            System.out.println("1. Add Contact");
            System.out.println("2. Edit Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. Display Contacts");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice){
                case 1:
                     Contact contact=new Contact();
                    System.out.print("Enter First Name: ");
                    String firstName = scanner.nextLine();
                    contact.setFirstName(firstName);
                    System.out.print("Enter Last Name: ");
                    String lastName = scanner.nextLine();
                    contact.setLastName(lastName);
                    System.out.print("Enter Address: ");
                    String address = scanner.nextLine();
                    contact.setAddress(address);
                    System.out.print("Enter City: ");
                    String city = scanner.nextLine();
                    contact.setCity(city);
                    System.out.print("Enter State: ");
                    String state = scanner.nextLine();
                    contact.setState(state);
                    System.out.print("Enter Zip: ");
                    String zip = scanner.nextLine();
                    contact.setZip(zip);
                    System.out.print("Enter Phone Number: ");
                    String phoneNumber = scanner.nextLine();
                    contact.setPhoneNumber(phoneNumber);
                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();
                    contact.setEmail(email);
                    addressBook.addContact(contact);
                    System.out.println("Contact added successfully!");
                    break;
                case 2:
                    Contact updatedContact=new Contact();
                    System.out.print("Enter First Name: ");
                    String editFirstName = scanner.nextLine();
                    updatedContact.setFirstName(editFirstName);
                    System.out.print("Enter Last Name: ");
                    String editLastName = scanner.nextLine();
                    updatedContact.setLastName(editLastName);
                    System.out.print("Enter Address: ");
                    String editAddress = scanner.nextLine();
                    updatedContact.setAddress(editAddress);
                    System.out.print("Enter City: ");
                    String editCity = scanner.nextLine();
                    updatedContact.setCity(editCity);
                    System.out.print("Enter State: ");
                    String editState = scanner.nextLine();
                    updatedContact.setState(editState);
                    System.out.print("Enter Zip: ");
                    String editZip = scanner.nextLine();
                    updatedContact.setZip(editZip);
                    System.out.print("Enter Phone Number: ");
                    String editPhoneNumber = scanner.nextLine();
                    updatedContact.setPhoneNumber(editPhoneNumber);
                    System.out.print("Enter Email: ");
                    String editEmail = scanner.nextLine();
                    updatedContact.setEmail(editEmail);
                    addressBook.editContact(editFirstName, editLastName, updatedContact);
                    System.out.println("Contact updated successfully!");
                    break;
                case 3:
                    System.out.print("Enter First Name of contact to delete: ");
                    String delFirstName = scanner.nextLine();
                    System.out.print("Enter Last Name of contact to delete: ");
                    String delLastName = scanner.nextLine();
                    addressBook.deleteContact(delFirstName, delLastName);
                    System.out.println("Contact deleted successfully!");
                    break;
                case 4:
                    System.out.println(addressBook.getContacts());
                    break;

                case 0:
                    System.out.println("Returning to Main Menu...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        }while(choice!=0);
    }
}