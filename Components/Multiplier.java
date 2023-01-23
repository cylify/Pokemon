import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Multiplier {
	public float dmgMult;
	
	public Multiplier(float dmgMult) {
		this.dmgMult = dmgMult;
	}


	public ArrayList<String> readFile() {
		ArrayList<String> mults = new ArrayList<>();
		try {
			File file = new File("Pokemon/Assets/multiplier.csv");
			Scanner in = new Scanner(file);
			while(in.hasNextLine()) {
				String line = in.nextLine();
				mults.add(line);
			}
			in.close();
		} catch(FileNotFoundException e) {
			System.out.println("No such file found.");
		}
		return mults;
	}
}