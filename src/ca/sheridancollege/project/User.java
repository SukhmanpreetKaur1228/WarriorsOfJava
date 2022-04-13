package ca.sheridancollege.project;

/**
 *
 * @author Sukhmanpreet Kaur, Apr 12, 2022
 * @author Harkiat Bonkra, Apr 12, 2022
 */
public class User extends Player{
    private String firstName;
    private String lastName;
    @Override
    public void play() {
        //This method will be implemented soon
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    
}
