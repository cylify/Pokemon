import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Move {
	private String name;
	private String type;
	private int dmg;

	public Move(String name, String type, int dmg) {
		this.name = name;
		this.type = type;
		this.dmg = dmg;
	}

	public static ArrayList<Move> readFile() {
		ArrayList<Move> moves = new ArrayList<>();
		try {
			File file = new File("C:/Users/mradi/Dropbox/Programming/Java/Grade 12 Computer Science/Unit 4/Pokemon/Assets/moves.csv");
			Scanner in = new Scanner(file);
			while(in.hasNextLine()) {
				String line = in.nextLine();
				String temp[] = line.split(",");
				moves.add(new Move(temp[0], temp[1], Integer.valueOf(temp[2])));
			}
			in.close();
		} catch(FileNotFoundException e) {
			System.out.println("No such file found.");
		}
		Player.mix(moves);
		return moves;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getDmg() {
		return dmg;
	}

	public void setDmg(int dmg) {
		this.dmg = dmg;
	}
}