package contact;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    public void testValidContactCreation() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main Street");
        assertEquals("123", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhoneNumber());
        assertEquals("123 Main Street", contact.getAddress());
    }

    @Test
    public void testInvalidContactId() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "John", "Doe", "1234567890", "123 Main Street");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "John", "Doe", "1234567890", "123 Main Street");
        });
    }

    @Test
    public void testInvalidFirstName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", null, "Doe", "1234567890", "123 Main Street");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "VeryLongFirstName", "Doe", "1234567890", "123 Main Street");
        });
    }

    @Test
    public void testInvalidLastName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", null, "1234567890", "123 Main Street");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "VeryLongLastName", "1234567890", "123 Main Street");
        });
    }

    @Test
    public void testInvalidPhoneNumber() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "Doe", "123", "123 Main Street");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "Doe", null, "123 Main Street");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "Doe", "abcdefghij", "123 Main Street");
        });
    }

    @Test
    public void testInvalidAddress() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "Doe", "1234567890", null);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "Doe", "1234567890", "This address is definitely more than thirty characters long!");
        });
    }

    @Test
    public void testSettersUpdateSuccessfully() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main Street");

        contact.setFirstName("Jane");
        contact.setLastName("Smith");
        contact.setPhoneNumber("0987654321");
        contact.setAddress("456 Maple Ave");

        assertEquals("Jane", contact.getFirstName());
        assertEquals("Smith", contact.getLastName());
        assertEquals("0987654321", contact.getPhoneNumber());
        assertEquals("456 Maple Ave", contact.getAddress());
    }
}