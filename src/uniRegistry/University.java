package uniRegistry;
/**
 * The University class represents an institution with various attributes.
 * It includes methods to set and retrieve information about the university.
 */
public class University 
{
	// Declare private fields to store university information
	private String officialName;
    private String nickname;
    private String city;
    private String state;
    private int yearEstablished;
    private int studentBodySize;

    /**
     * Constructor to initialize the University object with provided information.
     * @param officialName The official name of the university.
     * @param nickname The nickname of the university.
     * @param city The city where the university is located.
     * @param state The state where the university is located.
     * @param yearEstablished The year the university was established.
     * @param studentBodySize The approximate size of the student body.
     */
    
    // Constructor to initialize the University object with provided information
    public University(String officialName, String nickname, String city, String state, int yearEstablished, int studentBodySize) 
    {
    	 // Assign the provided values to the respective fields
        this.officialName = officialName;
        this.nickname = nickname;
        this.city = city;
        this.state = state;
        this.yearEstablished = yearEstablished;
        this.studentBodySize = studentBodySize;
    }

   
    /**
     * Getter method to retrieve the official name of the university.
     * @return The official name of the university.
     */
    public String getOfficialName() 
    {
    	return officialName;
    }

    /**
     * Getter method to retrieve the nickname of the university.
     * @return The nickname of the university.
     */
    public String getNickname() 
    {
        return nickname;
    }

    /**
     * Getter method to retrieve the city where the university is located.
     * @return The city where the university is located.
     */
    public String getCity() 
    {
        return city;
    }

    /**
     * Getter method to retrieve the state where the university is located.
     * @return The state where the university is located.
     */
    public String getState() 
    {
        return state;
    }

    /**
     * Getter method to retrieve the year the university was established.
     * @return The year the university was established.
     */
    public int getYearEstablished() 
    {
        return yearEstablished;
    }

    /**
     * Getter method to retrieve the approximate size of the student body.
     * @return The approximate size of the student body.
     */
    public int getStudentBodySize() 
    {
        return studentBodySize;
    }
   
    
    /**
     * Setter method to update the official name of the university.
     * @param officialName The new official name of the university.
     */
    public void setOfficialName(String officialName) 
    {
        this.officialName = officialName;
    }

    /**
     * Setter method to update the nickname of the university.
     * @param nickname The new nickname of the university.
     */
    public void setNickname(String nickname) 
    {
        this.nickname = nickname;
    }

    /**
     * Setter method to update the city where the university is located.
     * @param city The new city where the university is located.
     */
    public void setCity(String city) 
    {
        this.city = city;
    }

    /**
     * Setter method to update the state where the university is located.
     * @param state The new state where the university is located.
     */
    public void setState(String state) 
    {
        this.state = state;
    }

    /**
     * Setter method to update the year the university was established.
     * @param yearEstablished The new year the university was established.
     */
    public void setYearEstablished(int yearEstablished) 
    {
        this.yearEstablished = yearEstablished;
    }

    /**
     * Setter method to update the approximate size of the student body.
     * @param studentBodySize The new approximate size of the student body.
     */
    public void setStudentBodySize(int studentBodySize) 
    {
        this.studentBodySize = studentBodySize;
    }
    
    /**
     * Override the toString method to provide a formatted representation of the University object.
     * @return Formatted string representation of the University object.
     */
    @Override
    public String toString() 
    {
        return "Official Name: " + officialName + "\n" +
               "Nickname: " + nickname + "\n" +
               "City: " + city + "\n" +
               "State: " + state + "\n" +
               "Year Established: " + yearEstablished + "\n" +
               "Student Body Size: " + studentBodySize + "\n";
    }
}



