import java.util.LinkedList;

public class Comp {
	String name;
	float value;
	String unity;
	LinkedList<Comp> subcomps;
	
	public Comp(String n, float v, String u){
		name = n;
		value = v;
		unity = u;
		subcomps = new LinkedList<>();
	}
	@Override
	public String toString() {
		return "Nome: " + getName() + ",Valor" + getValue() + getUnity()
				+ "\nSubcomponentes" + getSubcomps().toString();
	}
	public String getName() {
		return name;
	}
	public float getValue() {
		return value;
	}
	public String getUnity() {
		return unity;
	}
	public LinkedList<Comp> getSubcomps() {
		return subcomps;
	}
}
