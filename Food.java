import java.util.LinkedList;

public class Food {
	Integer id;
	String name;
	String group;
	LinkedList<Comp> energie;
	LinkedList<Comp> macro;
	LinkedList<Comp> vitamins;
	LinkedList<Comp> minerals;
	
	Food(String n, String g, LinkedList<Comp> e, LinkedList<Comp> mac, LinkedList<Comp> v, LinkedList<Comp> min){
		name = n;
		group = g;
		energie = e;
		macro = mac;
		vitamins = v;
		minerals = min;
	}

	public String getGroup() {
		return group;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Food [getGroup()=" + getGroup() + ", getId()=" + getId() + ", getName()=" + getName()
				+ ", getEnergie()=" + getEnergie().toString() + ", getMacro()=" + getMacro().toString() + ", getVitamins()=" + getVitamins().toString()
				+ ", getMinerals()=" + getMinerals().toString() + "]";
	}

	public String getName() {
		return name;
	}

	public LinkedList<Comp> getEnergie() {
		return energie;
	}

	public LinkedList<Comp> getMacro() {
		return macro;
	}

	public LinkedList<Comp> getVitamins() {
		return vitamins;
	}

	public LinkedList<Comp> getMinerals() {
		return minerals;
	}
	
	
	
}
