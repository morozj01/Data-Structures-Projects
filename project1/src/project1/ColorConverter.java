package project1;
import java.io.*;
import java.util.*;

/**
 * This class contains the main method for the color program, where it populates a ColorList
 * with values from a data file, accepts and validates user input, and displays color
 * information about user entered colors.
 * @author Justin Moroz
 * @version 9/19/2017
 *
 */
public class ColorConverter {

	public static void main(String[] args) throws Exception {
		//Create new File Object and open file specified Command Line Arg.
		//Create empty instance of ColorList
		File readme = new File(args[0]);
		Scanner input = new Scanner(readme);
		ColorList allColors=new ColorList();
		
		//Loop through every line of specified file, create Color Object for each 
		//line, and add this color object to ColorList instance
		while(input.hasNext()){
			String colorLine = input.nextLine();
			String[] split = colorLine.split(",");
			Color next = new Color(split[1].trim(),split[0]);
			allColors.add(next);
		}
		
		
		System.out.println("Welcome to the color converter class!");
		System.out.println("Please enter a hex string to begin");
		
		//Begin accepting user input
		Scanner userIn = new Scanner(System.in);
		String userString = new String();
		userString = userIn.nextLine();
		
		//Require user to enter "quit" in order to exit program loop
		while(!userString.equalsIgnoreCase("quit")){
			
			//Check validity of input
			if(!checkValidity(userString)){
				System.out.println("Invalid input, please try again");
				userString = userIn.nextLine();
				continue;
			}
			
			//Loop through created instance of of ColorList and check for an instance of Color
			//with the same Hex value as user entered string 
			boolean match = false;
			for (int x=0; x<=allColors.size()-1; x++){
				Color current = allColors.get(x);
				if(userString.equalsIgnoreCase(current.getHexValue())){
					System.out.println(current.toString());
					match = true;
					break;
					
				}
			}
			
			//Check if user entered string has matched to an object in the ColorList
			//If not, convert Hex String to RGB and output Hex String and (R,G,B) values
			if (!match){
				String red= Integer.toString(Integer.valueOf( userString.substring( 1, 3 ), 16 ));
			    String green= Integer.toString(Integer.valueOf( userString.substring( 3, 5 ), 16 ));
			    String blue=Integer.toString(Integer.valueOf( userString.substring( 5, 7 ), 16 ));
			    System.out.println(userString+" ("+red+",  "+green+",  "+blue+")");
				}
			
			//Accept another user input and continue loop
			System.out.println("Please enter another input, or enter 'quit' to quit");
			userString = userIn.nextLine();
		}
	
	//Output once user has entered quit and broke out of the loop
	System.out.println("Goodbye");
	}
	
	/**
	 * Checks the validity of a user entered string based on whether it is an 
	 * appropriate hexstring. 
	 * @param userString
	 * @return boolean
	 */
	public static boolean checkValidity(String userString){
		
		if(userString.charAt(0)!='#'|| userString.length()<7 || userString.length()>7){
			return false;
	}
		
		for (int x=1; x<userString.length()-1; x++){
			if(!Character.isDigit(userString.charAt(x)) && !Character.isLetter(userString.charAt(x))){
				return false;
			}	
			try {
				Integer.valueOf(userString.substring(1, 7),16);
			}
			catch (IllegalArgumentException e){
				return false;
			}
				
		
			
		}
		
		return true; 
	}
		
		
}