package assignment1.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.google.gson.Gson;

import assignment1.model.Counter;


public class SaveAndLoad {
	private static final String FILENAME = "file.sav";
	static Gson gson = new Gson();
	
	public static void saveInFile(Counter counter){
		String tojson = gson.toJson(counter);
		try{
			FileOutputStream fout = new FileOutputStream(FILENAME);
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(tojson);
			oos.close();
		}
		catch(IOException ioe) { ioe.printStackTrace();
		}
	}
	
	public static  Counter loadFromFile(){
		String fromjson = null;
		try{
			FileInputStream fin = new FileInputStream(FILENAME);
			ObjectInputStream ois = new ObjectInputStream(fin);
			fromjson = (String)ois.readObject();
			ois.close();
		}
		catch(ClassNotFoundException cnfe) { cnfe.printStackTrace(); }
		catch(IOException ioe) { ioe.printStackTrace(); }
		Counter counter = gson.fromJson(fromjson, Counter.class);
		return counter;
	}
}
