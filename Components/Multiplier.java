import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Multiplier {
    private static HashMap<String, ArrayList<Double>> multipliers;

    public Multiplier() {
        multipliers = new HashMap<>();
        multipliers = readFile();
    }

    public ArrayList<Double> getMultipliers(String type) {
        return multipliers.getOrDefault(type, new ArrayList<>());
    }

	public static HashMap<String, ArrayList<Double>> readFile() {
		HashMap<String, ArrayList<Double>> mults = new HashMap<>();
		try {
			File file = new File("C:/Users/mradi/Dropbox/Programming/Java/Grade 12 Computer Science/Unit 4/Pokemon/Assets/multiplier.csv");
			Scanner in = new Scanner(file);
			while(in.hasNextLine()) {
				String line = in.nextLine();
				String key = line.substring(0, line.indexOf(","));
				line.replace(line.substring(0, line.indexOf(",")), "");
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
	
	public static Double getMultiplier(Pokemon attacker, Pokemon defender) {
		return multipliers.get(attacker.getType()).get(Pokemon.toInteger(defender.getType()));
	}
}



