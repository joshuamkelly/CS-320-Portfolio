package contact;

public class Contact {

    private final String contactId;   // not updatable
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        validateContactId(contactId);
        validateFirstName(firstName);
        validateLastName(lastName);
        validatePhone(phone);
        validateAddress(address);

        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    // Getters
    public String getContactId() {
        return contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    // Setters for updatable fields (NOT contactId)
    public void setFirstName(String firstName) {
        validateFirstName(firstName);
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        validateLastName(lastName);
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        validatePhone(phone);
        this.phone = phone;
    }

    public void setAddress(String address) {
        validateAddress(address);
        this.address = address;
    }

    // Validation helpers
    private static void validateContactId(String contactId) {
        if (contactId == null || contactId.isBlank() || contactId.length() > 10) {
            throw new IllegalArgumentException("contactId must be non-null and <= 10 characters.");
        }
    }

    private static void validateFirstName(String firstName) {
        if (firstName == null || firstName.isBlank() || firstName.length() > 10) {
            throw new IllegalArgumentException("firstName must be non-null and <= 10 characters.");
        }
    }

    private static void validateLastName(String lastName) {
        if (lastName == null || lastName.isBlank() || lastName.length() > 10) {
            throw new IllegalArgumentException("lastName must be non-null and <= 10 characters.");
        }
    }

    private static void validatePhone(String phone) {
        if (phone == null || phone.length() != 10) {
            throw new IllegalArgumentException("phone must be non-null and exactly 10 digits.");
        }

        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                throw new IllegalArgumentException("phone must contain only digits.");
            }
        }
    }

    private static void validateAddress(String address) {
        if (address == null || address.isBlank() || address.length() > 30) {
            throw new IllegalArgumentException("address must be non-null and <= 30 characters.");
        }
    }
}
