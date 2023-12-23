package uniRegistry;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

/**
 * The UniversityList class manages a collection of University objects and provides methods
 * for adding, listing, searching, and saving universities.
 */

//Create a class named UniversityList
public class UniversityList 
{
	// Declare an ArrayList to store University objects and a default file path
	private ArrayList<University> universities = new ArrayList<>();
	
	/**
     * Method to prompt the user for university information and create a University object.
     * @param scanner The Scanner object for user input.
     * @return The newly created University object.
     */
	
    public University promptForUniversityInfo(Scanner scanner) 
    {
        System.out.print("Enter the official name of the university: ");
        String officialName = scanner.nextLine();
        
        // Check if a university with the same name already exists
        for (University u : universities) 
        {
            if (u.getOfficialName().equalsIgnoreCase(officialName)) 
            {
                System.out.println("University with the same name already exists. Cannot add.");
                return null;
            }
        }
        
        // Prompt for and collect university information
        System.out.print("Enter the nickname of the university: ");
        String nickname = scanner.nextLine();
        System.out.print("Enter the city where the university is located: ");
        String city = scanner.nextLine();
        System.out.print("Enter the state where the university is located: ");
        String state = scanner.nextLine();
        System.out.print("Enter the year the university was established: ");
        int yearEstablished = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter the approximate size of the student body: ");
        int studentBodySize = Integer.parseInt(scanner.nextLine());
        
        // Create and return a new University object
        return new University(officialName, nickname, city, state, yearEstablished, studentBodySize);
    }
    
    /**
     * Method to add a University object to the collection.
     * @param university The University object to be added.
     */
    
    public void addUniversity(University university) 
    {
        if (university != null) 
        {
            universities.add(university);
            System.out.println("University added successfully.");
        }
    }
    
    /**
     * Method to list all universities in the collection.
     */
    
    public void listUniversities() 
    {
        if (universities.isEmpty()) 
        {
            System.out.println("No universities in the collection.");
        } 
        else 
        {
            System.out.println("List of Universities:");
            for (University university : universities) 
            {
                System.out.println(university);
            }
        }
    }

    /**
     * Method to search for a university by official name or nickname.
     * @param searchName The name to search for.
     */
    
    public void searchUniversity(String searchName) 
    {
        boolean found = false;
        for (University university : universities) 
        {
            if (university.getOfficialName().equalsIgnoreCase(searchName) || university.getNickname().equalsIgnoreCase(searchName)) 
            {
                System.out.println("University found:");
                System.out.println(university);
                found = true;
                break;
            }
        }
        if (!found) 
        {
            System.out.println("University not found in the collection.");
        }
    }
    
    /**
     * Method to delete a university from the collection by official name.
     * @param officialName The official name of the university to delete.
     */
    
    public void deleteUniversity(String officialName) 
    {
        boolean found = false;
        for (University university : universities) 
        {
            if (university.getOfficialName().equalsIgnoreCase(officialName)) 
            {
                universities.remove(university);
                found = true;
                System.out.println("University deleted successfully.");
                break;
            }
        }
        if (!found) 
        {
            System.out.println("University not found in the collection.");
        }
    }

    /**
     * Method to save university data to a file with the given filename.
     * @param filename The name of the file to save data to.
     */
    
    public void saveToFile(String filename) 
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) 
        {
            for (University university : universities) 
            {
                String universityData = university.toString(); 
                writer.write(universityData);
                writer.newLine(); 
            }
            System.out.println("Data saved to " + filename);
        } catch (IOException e) 
        {
            e.printStackTrace();
            System.out.println("Error: Unable to save data to file.");
        }
    }

    /**
     * Method to load university data from a file with the given filename.
     * @param filename The name of the file to load data from.
     */
    
    public void loadFromFile(String filename) 
    {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) 
        {
            String line;
            while ((line = reader.readLine()) != null) 
            {
                // Split the line into data fields using a comma as the delimiter
                String[] data = line.split(",");

                // Check if there are exactly 6 data fields
                if (data.length == 6) 
                {
                    // Extract data fields and trim leading/trailing spaces
                    String officialName = data[0].trim();
                    String nickname = data[1].trim();
                    String city = data[2].trim();
                    String state = data[3].trim();
                    
                    // Parse integer values with error handling
                    int yearEstablished;
                    int studentBodySize;
                    try 
                    {
                        yearEstablished = Integer.parseInt(data[4].trim());
                        studentBodySize = Integer.parseInt(data[5].trim());
                    } 
                    catch (NumberFormatException e) 
                    {
                        System.out.println("Error: Invalid number format in data. Skipping line.");
                        continue; 
                        // Skip this line and continue with the next one
                    }

                    // Create a new University object and add it to the collection
                    University university = new University
                    		(
                    		officialName, 
                    		nickname, 
                    		city, 
                    		state, 
                    		yearEstablished, 
                    		studentBodySize
                    		);
                    universities.add(university);
                } 
                else 
                {
                    System.out.println("Error: Invalid data format in the file. Skipping line.");
                }
            }
        } 
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
            System.out.println("Error: File not found.");
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
            System.out.println("Error: Unable to read data from file.");
        }
        listUniversities();
    }

    // Method to display a list of available commands
    public void help() 
    {
        System.out.println("Commands:");
        System.out.println("list - List all universities");
        System.out.println("exit - Exit the program");
        System.out.println("add - Add a new university");
        System.out.println("delete - Delete a university");
        System.out.println("search - Search for a university");
        System.out.println("save - Save the list of universities to a file");
    }
    
    // Method to handle program exit
    public void exit() 
    {
        System.out.println("Exiting the program.");
    }
}



