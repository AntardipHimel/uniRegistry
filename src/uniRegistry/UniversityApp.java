/*
 * uniRegistry---University Information System
 *
 * Project Overview
 *
 * This programming project focusing on linear data structures. 
 * The project involves creating a Java class to manage information 
 * related to universities. Users can perform various operations, 
 * including adding, listing, deleting, saving, and searching for universities 
 * in the system. Additional commands such as help and exit are also available.
 *
 * Class Details
 *
 * Each university in the list has the following fields:
 *
 * - Official name of the university
 * - Nickname for the university
 * - City where the university is located
 * - State where the university is located
 * - Year the university was established
 * - Approximate size of the student body
 *
 * Commands
 *
 * - **list:** List all the universities in the collection.
 * - **exit:** Exit the program.
 * - **add:** Add a new university to the list.
 * - **delete:** Delete a university from the list.
 * - **search:** Search for a university by name or nickname.
 * - **save:** Save the list to a text file.
 * - **help:** Display a help message with the available commands.
 *
 * 
 *
 *
 * Usage
 *
 * - Use the `add` command to add a new university.
 * - Use the `list` command to view all universities in the collection.
 * - Use the `delete` command to remove a university from the list.
 * - Use the `search` command to find a university by name or nickname.
 * - Use the `save` command to save the current list to a .txt file.
 * - Use the `help` command to display a list of available commands.
 * - Use the `exit` command to exit the program.
 *
 * 
 */

package uniRegistry;
import java.util.Scanner;
public class UniversityApp 
{
	public static void main(String[] args) 
	{
		// Create an instance of the UniversityList class
		UniversityList universityList = new UniversityList();
		
		// Initialize a scanner to read user input
	    Scanner scanner = new Scanner(System.in);
	    
	    String command;
	    
	    // Main command loop
	    while (true) 
	    {
	    	System.out.print("Enter a command: ");
	        command = scanner.nextLine().trim(); 
	        // Process user commands using a switch statement
	        switch (command)
	        {
	        case "help":
	        	universityList.help();
	        	break;
	        	
	        case "exit":
	        	universityList.exit();
	            scanner.close();
	            System.exit(0); 
	            break;
	            
	        case "add":
	        	 // Prompt the user for university information and add it to the list
	            University newUniversity = universityList.promptForUniversityInfo(scanner);
	            universityList.addUniversity(newUniversity);
	            break;
	            
	        case "list":
	        	// List all universities in the collection
	            universityList.listUniversities();
	            break;
	            
	        case "search":
	        	// Prompt the user for a name to search and search for a matching university
	            System.out.print("Enter a name to search: ");
	            String searchName = scanner.nextLine().trim();
	            universityList.searchUniversity(searchName);
	            break;
	            
	        case "save":
	        	// Save the current list of universities to a text file
	            universityList.saveToFile("saved.txt");
	            break;
	            
	        case "delete":
	        	 // Prompt the user for the official name to delete and delete the corresponding university
	            System.out.print("Enter the official name to delete: ");
	            String deleteName = scanner.nextLine().trim();
	            universityList.deleteUniversity(deleteName);
	            break;
	            
	        default:
	        	 // Display an error message for invalid commands
	            System.out.println("Invalid command. Type 'help' for a list of commands.");
	        }
	    }
	}
}

	



