package contact;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    @Test
    void shouldCreateValidContact() {
        Contact contact = new Contact(
                "1234567890",
                "John",
                "Doe",
                "1234567890",
                "123 Main Street"
        );

        assertEquals("1234567890", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main Street", contact.getAddress());
    }

    @Test
    void shouldNotAllowNullContactId() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact(null, "John", "Doe", "1234567890", "123 Main Street")
        );
    }

    @Test
    void shouldNotAllowContactIdLongerThanTen() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345678901", "John", "Doe", "1234567890", "123 Main Street")
        );
    }

    @Test
    void shouldNotAllowNullFirstName() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("123", null, "Doe", "1234567890", "123 Main Street")
        );
    }

    @Test
    void shouldNotAllowFirstNameLongerThanTen() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("123", "FirstnameTooLong", "Doe", "1234567890", "123 Main Street")
        );
    }

    @Test
    void shouldNotAllowNullLastName() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("123", "John", null, "1234567890", "123 Main Street")
        );
    }

    @Test
    void shouldNotAllowLastNameLongerThanTen() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("123", "John", "LastnameTooLong", "1234567890", "123 Main Street")
        );
    }

    @Test
    void shouldNotAllowPhoneWithNonDigits() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("123", "John", "Doe", "12345abcde", "123 Main Street")
        );
    }

    @Test
    void shouldNotAllowPhoneWithIncorrectLength() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("123", "John", "Doe", "123456789", "123 Main Street")
        );
    }

    @Test
    void shouldNotAllowNullAddress() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("123", "John", "Doe", "1234567890", null)
        );
    }

    @Test
    void shouldNotAllowAddressLongerThanThirty() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact(
                        "123",
                        "John",
                        "Doe",
                        "1234567890",
                        "This address is definitely way too long to be accepted"
                )
        );
    }

    @Test
    void shouldUpdateFirstName() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main Street");
        contact.setFirstName("Jane");
        assertEquals("Jane", contact.getFirstName());
    }

    @Test
    void shouldNotAllowInvalidFirstNameUpdate() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main Street");
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName(null));
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName("FirstnameTooLong"));
    }

    @Test
    void shouldUpdateLastName() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main Street");
        contact.setLastName("Smith");
        assertEquals("Smith", contact.getLastName());
    }

    @Test
    void shouldNotAllowInvalidLastNameUpdate() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main Street");
        assertThrows(IllegalArgumentException.class, () -> contact.setLastName(null));
        assertThrows(IllegalArgumentException.class, () -> contact.setLastName("LastnameTooLong"));
    }

    @Test
    void shouldUpdatePhone() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main Street");
        contact.setPhone("0987654321");
        assertEquals("0987654321", contact.getPhone());
    }

    @Test
    void shouldNotAllowInvalidPhoneUpdate() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main Street");
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone(null));
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone("123456789"));
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone("12345abcde"));
    }

    @Test
    void shouldUpdateAddress() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main Street");
        contact.setAddress("456 Oak Avenue");
        assertEquals("456 Oak Avenue", contact.getAddress());
    }

    @Test
    void shouldNotAllowInvalidAddressUpdate() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main Street");
        assertThrows(IllegalArgumentException.class, () -> contact.setAddress(null));
        assertThrows(IllegalArgumentException.class, () ->
                contact.setAddress("This address is definitely way too long to be accepted")
        );
    }
}
