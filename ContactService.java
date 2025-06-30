package contact;
import java.util.HashMap;

public class ContactService {

    // This HashMap stores all contacts using contactId as the key
    private HashMap<String, Contact> contacts = new HashMap<>();

    // Add a new contact if ID is unique
    public void addContact(Contact contact) {
        if (contact == null || contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Contact is null or contact ID already exists.");
        }
        contacts.put(contact.getContactId(), contact);
    }

    // Delete contact by ID
    public void deleteContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID not found.");
        }
        contacts.remove(contactId);
    }

    // Update first name
    public void updateFirstName(String contactId, String newFirstName) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact ID not found.");
        }
        contact.setFirstName(newFirstName);
    }

    // Update last name
    public void updateLastName(String contactId, String newLastName) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact ID not found.");
        }
        contact.setLastName(newLastName);
    }

    // Update phone number
    public void updatePhoneNumber(String contactId, String newPhoneNumber) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact ID not found.");
        }
        contact.setPhoneNumber(newPhoneNumber);
    }

    // Update address
    public void updateAddress(String contactId, String newAddress) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact ID not found.");
        }
        contact.setAddress(newAddress);
    }

    // Optional: Get contact for testing
    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }
}