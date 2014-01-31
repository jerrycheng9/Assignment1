package assignment1.model;

import java.util.ArrayList;
import java.util.List;

public class CounterList {
	private List<Counter> Counter_List = new ArrayList<Counter>();
	private int size = 0;

	
	public List<Counter> getCounter_List() {
		return Counter_List;
	}

	public void setCounter_List(List<Counter> counter_List) {
		Counter_List = counter_List;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void add(Counter counter){
		Counter_List.add(counter);
		size++;
	}
	
	public List<Counter> remove(int index){
		List<Counter> another = new ArrayList<Counter>();
		for (int i = 0; i < size; i++){
			if (i == index){
				continue;
				
				}else{
					another.add(Counter_List.get(i));
					}
			}
		size--;
		Counter_List = another;
		return Counter_List;
		}
	public List<String> getName(){
		List<String> text = new ArrayList<String>();
		for (Counter counter : Counter_List){
			text.add(counter.getName());
		}
		return text;
	}
}
