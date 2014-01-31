package assignment1;

import java.util.Date;
import java.util.HashMap;
import java.util.Set;


public class CounterList {
	private HashMap<String, Counter> Counter_List = new HashMap<String, Counter>();
	private int size = 0;

	public HashMap<String, Counter> getCounter_List() {
		return Counter_List;
	}

	public void setCounter_List(HashMap<String, Counter> counter_List) {
		Counter_List = counter_List;
	}

	public int getSize() {
		return size;
	}
	
	public void rename(String name,String name2){
		Counter_List.put(name2, Counter_List.get(name));
		Counter_List.remove(name);
	}
	
	public Counter get(String key){
		return Counter_List.get(key);
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void add(String name){
		if (Counter_List.containsKey(name)){
			
		}else{
			Counter_List.put(name, new Counter(name,new Date(),0));
			size++;
		}
	}
	
	public Set<String> getkeys(){
		return Counter_List.keySet();
	}
	
	public void remove(String key){
		Counter_List.remove(key);
	}
}
