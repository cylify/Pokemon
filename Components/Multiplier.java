import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Multiplier {
    private static HashMap<String, ArrayList<Double>> multipliers;

	/**
	 * Constructer
	 */
    public Multiplier() {
        multipliers = new HashMap<>();
        multipliers = readFile();
    }

    
	/** 
	 * Get all multipliers for type
	 * @param type
	 * @return ArrayList<Double>
	 */
	public ArrayList<Double> getMultipliers(String type) {
        return multipliers.getOrDefault(type, new ArrayList<>());
    }

	
	/** 
	 * Read file
	 * @return HashMap<String, ArrayList<Double>>
	 */
	public static HashMap<String, ArrayList<Double>> readFile() {
		HashMap<String, ArrayList<Double>> mults = new HashMap<>();
		Path filePath = Paths.get("Assets/", "multiplier.csv");
		String fileString = filePath.toString();
		try {
			File file = new File(fileString);
			Scanner in = new Scanner(file);
			while(in.hasNextLine()) {
				String line = in.nextLine();
				String key = line.substring(0, line.indexOf(","));
				line = line.replace(line.substring(0, line.indexOf(",") + 1), "");
				ArrayList<Double> temp = new ArrayList<>();
				for(String s : line.split(",")) {
					temp.add(Double.valueOf(s));
				}
				mults.put(key, temp);
			}
			in.close();
		} catch(FileNotFoundException e) {
			System.out.println("No such file found.");
		}
		return mults;
	}
	
	
	/** 
	 * get specific multiplier for type 
	 * @param attacker
	 * @param defender
	 * @return Double
	 */
	public static Double getMultiplier(Pokemon attacker, Pokemon defender) {
		// get the multiplier
		Double mult = multipliers.get(attacker.getType()).get(Pokemon.toInteger(defender.getType()));
		return mult;
	}
}



