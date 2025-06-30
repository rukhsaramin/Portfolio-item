package contact;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class ContactServiceTest {

    private ContactService service;

    @BeforeEach
    public void setUp() {
        service = new ContactService();
    }

    @Test
    public void testAddContactSuccessfully() {
        Contact contact = new Contact("001", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        assertEquals("John", service.getContact("001").getFirstName());
    }

    @Test
    public void testAddDuplicateContactID() {
        Contact contact1 = new Contact("002", "Alice", "Smith", "1111111111", "456 Oak St");
        Contact contact2 = new Contact("002", "Bob", "Brown", "2222222222", "789 Pine St");

        service.addContact(contact1);
        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(contact2);
        });
    }

    @Test
    public void testDeleteContactSuccessfully() {
        Contact contact = new Contact("003", "Mike", "White", "3333333333", "101 Birch St");
        service.addContact(contact);
        service.deleteContact("003");
        assertNull(service.getContact("003"));
    }

    @Test
    public void testDeleteNonExistentContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteContact("999");
        });
    }

    @Test
    public void testUpdateFirstName() {
        Contact contact = new Contact("004", "Old", "Name", "4444444444", "Update St");
        service.addContact(contact);
        service.updateFirstName("004", "New");
        assertEquals("New", service.getContact("004").getFirstName());
    }

    @Test
    public void testUpdateLastName() {
        Contact contact = new Contact("005", "Jane", "Old", "5555555555", "Change Ln");
        service.addContact(contact);
        service.updateLastName("005", "Updated");
        assertEquals("Updated", service.getContact("005").getLastName());
    }

    @Test
    public void testUpdatePhoneNumber() {
        Contact contact = new Contact("006", "Sara", "Lee", "6666666666", "Phone Ave");
        service.addContact(contact);
        service.updatePhoneNumber("006", "9999999999");
        assertEquals("9999999999", service.getContact("006").getPhoneNumber());
    }

    @Test
    public void testUpdateAddress() {
        Contact contact = new Contact("007", "Paul", "Walker", "7777777777", "Old Address");
        service.addContact(contact);
        service.updateAddress("007", "New Address 123");
        assertEquals("New Address 123", service.getContact("007").getAddress());
    }

    @Test
    public void testUpdateNonExistentContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateFirstName("999", "Ghost");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            service.updateLastName("999", "Person");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            service.updatePhoneNumber("999", "0000000000");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            service.updateAddress("999", "No One Lives Here");
        });
    }
}