package project1;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * A class used to store various different Color objects
 * @extends ArrayList
 * @author Justin Moroz
 * @version 9/19/2017
 */
public class ColorList extends ArrayList<Color> {
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
		Iterator<Color> iter = this.iterator();
		while (iter.hasNext()){
			Color current = iter.next();
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
		Iterator<Color> iter = this.iterator();
		while (iter.hasNext()){
			Color current = iter.next();
			if (current.getHexValue().equalsIgnoreCase(colorHexValue)){
				return current;
			}
			
		}
		 return null;
		
	}
}
