package project2;

/**
 * A class used to store various different Color objects
 * @extends OrderedLinkedList
 * @author Justin Moroz
 * @version 9/19/2017
 */
public class ColorList extends OrderedLinkedList<Color> {
	/**
	 * Constructor which creates an empty ColorList
	 */
	public ColorList(){
		super();
	}
	
	/**
	 * Returns the a Color object based on its color name data field.
	 * @param colorName
	 * @return Color object
	 */
	public Color getColorByName(String colorName){
		
		for (int x = 0; x<size(); x++ ){
			Color current = this.get(x);
			if (current.getName().equalsIgnoreCase(colorName)){
				return current;
			}
			
		}
		 return null;
	}
	
	/**
	 * Returns a Color object based on its Hex Value data field 
	 * @param colorHexValue
	 * @return Color Object 
	 */
	public Color getColorByHexValue(String colorHexValue){
		for (int x = 0; x<size(); x++ ){
			Color current = this.get(x);
			if (current.getHexValue().equalsIgnoreCase(colorHexValue)){
				return current;
			}
			
		}
		 return null;
		
	}
}
