package net.firstproject.registration.model;

/**
 * Model class representing an employee's details.
 */
public class Employee {
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String city;
    private String state;
    private String contact;

    /**
     * Gets the first name of the employee.
     * 
     * @return The first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the employee.
     * 
     * @param firstName The first name to set.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name of the employee.
     * 
     * @return The last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the employee.
     * 
     * @param lastName The last name to set.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the username of the employee.
     * 
     * @return The username.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the username of the employee.
     * 
     * @param userName The username to set.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets the password of the employee.
     * 
     * @return The password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the employee.
     * 
     * @param password The password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the city of the employee.
     * 
     * @return The city.
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city of the employee.
     * 
     * @param city The city to set.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets the state of the employee.
     * 
     * @return The state.
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the state of the employee.
     * 
     * @param state The state to set.
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Gets the contact information of the employee.
     * 
     * @return The contact information.
     */
    public String getContact() {
        return contact;
    }

    /**
     * Sets the contact information of the employee.
     * 
     * @param contact The contact information to set.
     */
    public void setContact(String contact) {
        this.contact = contact;
    }
}
