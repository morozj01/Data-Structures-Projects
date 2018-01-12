package project2;

/**
 * This class represents a color, as defined by its CSS (R,G,B) value, its Hex Value, 
 * and if defined, its human readable name. 
 * @author Justin Moroz
 * @version 9/19/2017
 *  
 */
public class Color implements Comparable<Color> {
	
	private String colorHexValue = new String(); 
	private String colorName = new String();
	private int red;
	private int green;
	private int blue;

	/**
	 * Constructor that defines colorHexValue based on parameter.
	 * @param colorHexValue
	 */
	public Color(String colorHexValue){
		checkConstructArg(colorHexValue);
		this.colorHexValue = colorHexValue;
		this.red= Integer.valueOf( colorHexValue.substring( 1, 3 ), 16 );
        this.green= Integer.valueOf( colorHexValue.substring( 3, 5 ), 16 );
        this.blue=Integer.valueOf( colorHexValue.substring( 5, 7 ), 16 );
	}
		
	/**
	 * Constructor that defines colorHexValue, and colorName based on parameter.
	 * @param colorHexValue
	 * @param colorName
	 */
	
	public Color(String colorHexValue, String colorName){
		checkConstructArg(colorHexValue);
		this.colorName = colorName;
		this.colorHexValue = colorHexValue;
		this.red= Integer.valueOf( colorHexValue.substring( 1, 3 ), 16 );
        this.green= Integer.valueOf( colorHexValue.substring( 3, 5 ), 16 );
        this.blue=Integer.valueOf( colorHexValue.substring( 5, 7 ), 16 );
	}
	
	/**
	 * Constructor that defines RGB values from parameters and derives appropriate 
	 * colorHexValue. 
	 * @param red
	 * @param green
	 * @param blue
	 */
	public Color(int red, int green, int blue){
		if(red>=0 && red<=255){
			this.red = red;
			
		}
		else { throw new IllegalArgumentException(); }
		
		if(green>=0 && green<=255){
			this.green = green; 
			
		}
		else { throw new IllegalArgumentException(); }
		
		if(blue>=0 && blue<=255){
			this.blue = blue;
			
		}
		else { throw new IllegalArgumentException(); }
		
		String hexRed = Integer.toHexString(red);
		String hexGreen = Integer.toHexString(green);
		String hexBlue = Integer.toHexString(blue);
		
		this.colorHexValue = "#"+hexRed+hexGreen+hexBlue;
	}
	
	/**
	 * Checks for the validity of constructor arguments.
	 * @param colorHexArg
	 * @throws IllegalArgumentException
	 */
	
	public void checkConstructArg(String colorHexArg){
		if(colorHexArg.charAt(0) != '#'){
			throw new IllegalArgumentException(); 
		}
		
		else if(colorHexArg.length()<7 || colorHexArg.length()>7){
			throw new IllegalArgumentException();
		}
		
		else{
		for(int x=1; x<7; x++){
			if (!Character.isDigit(colorHexArg.charAt(x)) && !Character.isLetter(colorHexArg.charAt(x))){
				throw new IllegalArgumentException();
			}
		}		
	}	
}
	
	/**
	 * Overrides object equals() method to compare the Hex Values of two objects
	 * and return true if they are equal.
	 * @param Color compare
	 * @return boolean 
	 */
	public boolean equals(Color compare){
		if (this.colorHexValue.equalsIgnoreCase(compare.colorHexValue)){
			return true; 
		}
		else {
			return false;
		}
	}
	
	/**
	 * Used to compare the Hex Values of two Color Objects
	 * @param Color name
	 * @return int
	 */
	public int compareTo(Color name) {
		return colorHexValue.compareToIgnoreCase(name.colorHexValue);
	
	}
	
	/**
	 * Returns a formatted string which contains the object's Hex Value, RGB value,
	 * and if present color name
	 * @return String
	 */
	public String toString(){
		if (this.colorName != null){
		return this.colorHexValue + ","+ "("+Integer.toString(this.red)+", "+Integer.toString(this.green)+", "+Integer.toString(this.blue)+")"+", "+this.colorName;
	}
		else {
			return this.colorHexValue + ", "+ "("+Integer.toString(this.red)+", "+Integer.toString(this.green)+", "+Integer.toString(this.blue)+")";
		}
	}
	/*--------------- Accessor Methods -----------------*/
	
	/**
	 * Getter method
	 * @return int red
	 */
	public int getRed(){
		return this.red;
	}
	
	/**
	 * Getter method
	 * @return int green
	 */
	public int getGreen(){
		return this.green; 
	}
	
	/**
	 * Getter method
	 * @return int blue
	 */
	public int getBlue(){
		return this.blue;
	}
	
	/**
	 * Getter method 
	 * @return string colorName
	 */
	public String getName(){
		if(this.colorName!=null){
		return this.colorName;
		}
		else {return null;}
	}
	
	/**
	 * Getter method
	 * @return string colorHexValue
	 */
	public String getHexValue(){
		return this.colorHexValue; 
	}


	
	

}
