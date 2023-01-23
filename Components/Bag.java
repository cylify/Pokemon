import java.util.HashMap;
import java.util.Map.Entry;

public class Bag {
	protected static HashMap<String, String> bag;

	public Bag() {
		bag = new HashMap<>();
		bag = fillBag();
	}

	public HashMap<String,String> fillBag() {
		HashMap<String,String> bag = new HashMap<>() {
			{
				put("Antidote", "Poison");
				put("Awakening", "Sleep");
				put("Burn Heal", "Burn");
				put("Full Heal", "All");
				put("Ice Heal", "Frozen");
				put("Paralyze Heal", "Paralysis");
				put("Persim Berry", "Confusion");
			}
		};
		return bag;
	}

	public String getPotion(String currentStatus) {
		for(Entry<String, String> entry : bag.entrySet()) {
			if(currentStatus.equals(entry.getValue())) {
				return entry.getKey();
			}
		}
		return null;
	}

	// return version
	public <K> HashMap<K, K> removePotion(K potion, HashMap<K, K> bag) {
		bag.remove(potion);
		return bag;
	}

	// void version
	public <K> void removePotion(K potion) {
		bag.remove(potion);
	}

	// .. test which is more useful between void version and return version

	@Override
	public String toString() {
		String StringOfBag = "";
		for(Entry<String, String> entry : bag.entrySet()) {
			StringOfBag += entry.getKey() + ", " + entry.getValue() + ".\n";
		}
		return StringOfBag;
	}

	public static void main(String[] args) {
		Bag bag = new Bag();
		System.out.println(bag);
		bag.removePotion("Antidote", Bag.bag);
		System.out.println(bag);
	}

}