package contact;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {

    @Test
    void shouldAddContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact(
                "123",
                "John",
                "Doe",
                "1234567890",
                "123 Main Street"
        );

        service.addContact(contact);

        Contact stored = service.getContact("123");
        assertNotNull(stored);
        assertEquals("123", stored.getContactId());
    }

    @Test
    void shouldNotAllowDuplicateContactId() {
        ContactService service = new ContactService();

        Contact contact1 = new Contact(
                "123",
                "John",
                "Doe",
                "1234567890",
                "123 Main Street"
        );

        Contact contact2 = new Contact(
                "123",
                "Jane",
                "Smith",
                "0987654321",
                "456 Oak Avenue"
        );

        service.addContact(contact1);

        assertThrows(IllegalArgumentException.class, () ->
                service.addContact(contact2)
        );
    }

    @Test
    void shouldDeleteContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact(
                "123",
                "John",
                "Doe",
                "1234567890",
                "123 Main Street"
        );

        service.addContact(contact);
        service.deleteContact("123");

        assertNull(service.getContact("123"));
    }

    @Test
    void shouldUpdateContactFields() {
        ContactService service = new ContactService();
        Contact contact = new Contact(
                "123",
                "John",
                "Doe",
                "1234567890",
                "123 Main Street"
        );

        service.addContact(contact);

        service.updateContact(
                "123",
                "Jane",
                "Smith",
                "0987654321",
                "456 Oak Avenue"
        );

        Contact updated = service.getContact("123");

        assertEquals("Jane", updated.getFirstName());
        assertEquals("Smith", updated.getLastName());
        assertEquals("0987654321", updated.getPhone());
        assertEquals("456 Oak Avenue", updated.getAddress());
    }

    @Test
    void shouldNotChangeContactIdOnUpdate() {
        ContactService service = new ContactService();
        Contact contact = new Contact(
                "123",
                "John",
                "Doe",
                "1234567890",
                "123 Main Street"
        );

        service.addContact(contact);

        service.updateContact(
                "123",
                "Jane",
                "Smith",
                "0987654321",
                "456 Oak Avenue"
        );

        Contact updated = service.getContact("123");

        assertEquals("123", updated.getContactId());
    }

    @Test
    void shouldThrowWhenUpdatingNonexistentContact() {
        ContactService service = new ContactService();

        assertThrows(IllegalArgumentException.class, () ->
                service.updateContact(
                        "999",
                        "Jane",
                        "Smith",
                        "0987654321",
                        "456 Oak Avenue"
                )
        );
    }
}
