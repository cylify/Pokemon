import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Items {
	private String name;
	private String healing;

	public Items(String name, String healing) {
		this.name = name;
		this.healing = healing;
	}
	
	
	/** 
	 * Read file
	 * @return ArrayList<Items>
	 */
	public static ArrayList<Items> readFile() {
		ArrayList<Items> items = new ArrayList<>();
		Path filePath = Paths.get("Assets/", "potions.csv");
		String fileString = filePath.toString();
		try {
			File file = new File(fileString);
			Scanner in = new Scanner(file);
			while(in.hasNextLine()) {
				String line = in.nextLine();
				String[] temp = line.split(",");
				items.add(new Items(temp[0], temp[1]));
			}
			in.close();
		} catch(FileNotFoundException e) {
			System.out.println("No such file found.");
		}
		return items;
	}


	
	/** 
	 * @param healing
	 */
	public void setHealing(String healing) {
		this.healing = healing;
	}

	
	/** 
	 * @return String
	 */
	public String getName() {
		return name;
	}

	
	/** 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	
	/** 
	 * @return String
	 */
	public String getHealing() {
		return healing;
	}

}