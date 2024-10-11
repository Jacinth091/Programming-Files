public class Account {
    private String accountNo;
    private String status;
    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;
    private String age;
    private String dateOfBirth;
    private String nationality;
    private String phoneNumber;
    private String email;
    private String address;
    private double balance;

    public Account(){

    }

    public Account(String firstName, String middleName, String lastName, String accountNo,
                   String status,  String suffix, String age, String dateOfBirth,
                   String nationality, String phoneNumber, String email,
                   String address, double balance) {
        this.accountNo = accountNo;
        this.status = status;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.suffix = suffix;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
        this.nationality = nationality;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.balance = balance;
    }

// Getters

    public String getAccountNo() {
        return accountNo;
    }

    public String getStatus() {
        return status;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSuffix() {
        return suffix;
    }

    public String getAge() {
        return age;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getNationality() {
        return nationality;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public double getBalance() {
        return balance;
    }
}
