import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Items {
	private String name;
	private String healing;

	public Items(String name, String healing) {
		this.name = name;
		this.healing = healing;
	}
	
	public static ArrayList<Items> readFile() {
		ArrayList<Items> items = new ArrayList<>();
		try {
			File file = new File("potions.csv");
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

	
	public static void main(String[] args) {
	}


	public void setHealing(String healing) {
		this.healing = healing;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHealing() {
		return healing;
	}

}