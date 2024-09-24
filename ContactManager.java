import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    String name;
    String phoneNumber;

    // Constructor
    Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone: " + phoneNumber;
    }
}

public class ContactManager {
    private ArrayList<Contact> contacts;
    private Scanner scanner;

    // Constructor
    public ContactManager() {
        contacts = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    // Method to add a contact
    public void addContact() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        contacts.add(new Contact(name, phoneNumber));
        System.out.println("Contact added.");
    }

    // Method to view all contacts
    public void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
            return;
        }
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }

    // Method to search for a contact
    public void searchContact() {
        System.out.print("Enter name to search: ");
        String name = scanner.nextLine();
        for (Contact contact : contacts) {
            if (contact.name.equalsIgnoreCase(name)) {
                System.out.println("Found: " + contact);
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    // Method to delete a contact
    public void deleteContact() {
        System.out.print("Enter name to delete: ");
        String name = scanner.nextLine();
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).name.equalsIgnoreCase(name)) {
                contacts.remove(i);
                System.out.println("Contact deleted.");
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    // Menu method for user commands
    public void menu() {
        String command;
        do {
            System.out.println("\nCommands: add, view, search, delete, exit");
            System.out.print("Enter command: ");
            command = scanner.nextLine().toLowerCase();

            switch (command) {
                case "add":
                    addContact();
                    break;
                case "view":
                    viewContacts();
                    break;
                case "search":
                    searchContact();
                    break;
                case "delete":
                    deleteContact();
                    break;
                case "exit":
                    System.out.println("Exiting the application.");
                    break;
                default:
                    System.out.println("Invalid command. Try again.");
            }
        } while (!command.equals("exit"));
        scanner.close();
    }

    // Main method
    public static void main(String[] args) {
        ContactManager contactManager = new ContactManager();
        contactManager.menu();
    }
}