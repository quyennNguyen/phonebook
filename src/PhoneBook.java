import java.util.*;

public class PhoneBook {
    public static Scanner scan = new Scanner(System.in);
    private final Map<String, String> book = new HashMap<>();

    private void addContact(String name, String phoneNumber) {
        if (book.containsKey(name.toUpperCase())) {
            System.out.println("Name already exists.");
            System.out.println("Would you like to replace the old contact? (y/n)");
            String option = scan.next();
            if (option.equalsIgnoreCase("y")) {
                book.put(name.toUpperCase(), phoneNumber);
                System.out.println("You have successfully added " + name.toUpperCase() + ": " + phoneNumber);
            }
        } else {
            book.put(name.toUpperCase(), phoneNumber);
            System.out.println("You have successfully added " + name.toUpperCase() + ": " + phoneNumber);
        }
    }

    private void deleteContact(String name) {
        if (book.isEmpty()) {
            System.out.println("Book is empty.");
        } else {
            String phoneNumber = book.remove(name.toUpperCase());
            if (phoneNumber == null) {
                System.out.println("Contact is not found.");
            } else {
                System.out.println("You have successfully removed " + name.toUpperCase() + ": " + phoneNumber);
            }
        }
    }

    private String getPhoneNumber(String name) {
        return book.get(name.toUpperCase());
    }

    private Set<Map.Entry<String, String>> getContacts() {
        System.out.println("List includes " + book.size() + " contact");
        return book.entrySet();
    }

    public void run() {
        System.out.println(" ~ Welcome to MyPhoneBook ~ ");
        int option = 0;

        do {
            System.out.println("MENU:"
                    + "\n - Pres (1) to add a new contact to the book"
                    + "\n - Pres (2) to delete a contact in the book"
                    + "\n - Press (3) to get phone number of a name"
                    + "\n - Press (4) to view all contacts in the book"
                    + "\n - Press (5) to exit");
            try {
                option = scan.nextInt();
                scan.nextLine();
            } catch (InputMismatchException e) {
                System.out.println(e);
                scan.nextLine();
                continue;
            }

            switch (option) {
                case 1 -> {
                    System.out.print("Enter name: ");
                    String name = scan.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scan.nextLine(); // how to allow only number??
                    addContact(name, phoneNumber);
                }
                case 2 -> {
                    System.out.print("Enter name: ");
                    String name = scan.nextLine();
                    deleteContact(name);
                }
                case 3 -> {
                    System.out.print("Enter name: ");
                    String name = scan.nextLine();
                    String phoneNumber = getPhoneNumber(name);
                    if (phoneNumber == null) {
                        System.out.println("Contact is not found.");
                    } else {
                        System.out.println(name.toUpperCase() + ": " + phoneNumber);
                    }
                }
                case 4 -> {
                    Set<Map.Entry<String, String>> contacts = getContacts();
                    for (Map.Entry<String, String> contact : contacts) {
                        System.out.println(contact);
                    }
                }
                case 5 -> System.out.println(" ~ Thank you for visiting ~ "
                        + "\n ~ See you again soon ~ ");
                default -> System.out.println("Option is not available.");
            }

        } while (option != 5);
    }
}