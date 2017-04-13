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

	public Food() {
		id = Parser.iD++;
		name = null;
		group = null;
		energie = new LinkedList<>();
		macro = new LinkedList<>();
		vitamins = new LinkedList<>();
		minerals = new LinkedList<>();
	}

	@Override
	public String toString() {
		return "ID: " + this.getId() +"\nNome: " + this.getName() + "\nGrupo: " + getGroup() +  "Energias\n" + this.energie.toString() +"\nMacroconstituintes\n" + this.macro.toString() + "\nVitaminas\n" + this.vitamins.toString() + "\nMinerais\n" + this.minerals.toString();
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getGroup() {
		return group;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
