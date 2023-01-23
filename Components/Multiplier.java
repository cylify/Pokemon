import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Multiplier {
	public float dmgMult;
	
	public Multiplier(float dmgMult) {
		this.dmgMult = dmgMult;
	}

	public static HashMap<String, Double> getMults(ArrayList<String> mults) {
		HashMap<String, Double> allMults = new HashMap<>();
		for(int i = 0; i < mults.size(); ++i) {
			String temp[] = mults.get(i).split(",");
			String currName = temp[0];
			for(int j = 1; j < temp.length; ++j) {
				allMults.put(currName + String.valueOf(j), Double.valueOf(temp[j]));
			}	
		}
		return allMults;
	}

	public static ArrayList<String> readFile() {
		ArrayList<String> mults = new ArrayList<>();
		try {
			File file = new File("C:/Users/mradi/Dropbox/Programming/Java/Grade 12 Computer Science/Unit 4/Pokemon/Assets/multiplier.csv");
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

	public static int DmgDealt(Player p1, Player p2) {
		int ans = (int)(2 * (p1.pokemonBag.get(0).getMoves()[0].getDmg() * Double.valueOf((p1.pokemonBag.get(0).getAttack()/p2.pokemonBag.get(0).getDefense())/50) + 2) * 0.625 * 5);
		return ans;
	}

	public static void main(String[] args) {
		Player p1 = new HumanPlayer();
		Player p2 = new HumanPlayer();
		int ans = DmgDealt(p1, p2);
		System.out.println(ans);

		ArrayList<String> kndf = readFile();
		HashMap<String, Double> nid = getMults(kndf);
		System.out.println(nid); 

	}	

}