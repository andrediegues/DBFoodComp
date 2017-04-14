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

	public void removeAllEmptySubComps() {
		for(int i = 0; i < this.energie.size(); i++){
			if(this.energie.get(i).subcomps.size() == 0){
				this.energie.get(i).setSubcomps(null);
			}
		}
		for(int i = 0; i < this.macro.size(); i++){
			if(this.macro.get(i).subcomps.size() == 0){
				this.macro.get(i).setSubcomps(null);
			}
		}
		for(int i = 0; i < this.vitamins.size(); i++){
			if(this.vitamins.get(i).subcomps.size() == 0){
				this.vitamins.get(i).setSubcomps(null);
			}
		}
		for(int i = 0; i < this.minerals.size(); i++){
			if(this.minerals.get(i).subcomps.size() == 0){
				this.minerals.get(i).setSubcomps(null);
			}
		}
	}
	
	
	
}
