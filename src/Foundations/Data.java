package Foundations;

// Node data
public class Data {
	private Integer contents = null;
	
	public Data(Integer arg) {
		this.contents = arg;
	}
	
	public Integer getData() { return this.contents;}
	public void setData(Integer inp) { this.contents = inp; }
	
	public String toString() { return contents.toString(); }
	
	public int compare(Data t) { 
		if(this.contents.intValue() == t.getData().intValue()) return 0;
		else if(this.contents.intValue() > t.getData().intValue()) return -1;
		return 1;
	}
}
