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
		subcomps = null;
	}
	public Comp(String n, float v, String u, LinkedList<Comp> sc){
		name = n;
		value = v;
		unity = u;
		subcomps = sc;
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
