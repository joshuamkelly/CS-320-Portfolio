package contact;

import java.util.HashMap;
import java.util.Map;

public class ContactService {

    private final Map<String, Contact> contacts = new HashMap<>();

    public void addContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null.");
        }

        String contactId = contact.getContactId();

        if (contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID already exists.");
        }

        contacts.put(contactId, contact);
    }

    public void deleteContact(String contactId) {
        if (contactId == null) {
            throw new IllegalArgumentException("Contact ID cannot be null.");
        }

        contacts.remove(contactId);
    }

    public void updateContact(
            String contactId,
            String firstName,
            String lastName,
            String phone,
            String address
    ) {
        Contact contact = contacts.get(contactId);

        if (contact == null) {
            throw new IllegalArgumentException("Contact not found.");
        }

        if (firstName != null) {
            contact.setFirstName(firstName);
        }

        if (lastName != null) {
            contact.setLastName(lastName);
        }

        if (phone != null) {
            contact.setPhone(phone);
        }

        if (address != null) {
            contact.setAddress(address);
        }
    }

    // Helper for testing (optional but useful)
    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }
}
