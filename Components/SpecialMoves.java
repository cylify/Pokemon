import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SpecialMoves {
	private String name;
	private String status;
	private Double chance;

	/**
	 * Constructer
	 */
	public SpecialMoves(String name, String status, Double chance) {
		this.name = name;
		this.status = status;
		this.chance = chance;
	}

	
	/** 
	 * Read file
	 * @return ArrayList<SpecialMoves>
	 */
	public static ArrayList<SpecialMoves> readFile() {
		ArrayList<SpecialMoves> specialMoves = new ArrayList<>();
		Path filePath = Paths.get("Assets/", "special_status_pokemon.csv");
		String fileString = filePath.toString();
		try {
			File file = new File(fileString);
			Scanner in = new Scanner(file);
			while(in.hasNextLine()) {
				String line = in.nextLine();
				String temp[] = line.split(",");
				specialMoves.add(new SpecialMoves(temp[0], temp[1], 33.33));
			}
			in.close();
		} catch(FileNotFoundException e) {
			System.out.println("No such file found.");
		}
		return specialMoves;
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
	public String getStatus() {
		return status;
	}

	
	/** 
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}


	public Double getChance() {
		return chance;
	}


	public void setChance(Double chance) {
		this.chance = chance;
	}

}