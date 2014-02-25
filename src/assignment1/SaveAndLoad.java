<<<<<<< HEAD:Assignment1/src/assignment1/controller/SaveAndLoad.java
package assignment1.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.google.gson.Gson;

import assignment1.model.Counter;
=======
package assignment1;

import com.google.gson.Gson;
import android.content.Context;
import android.content.SharedPreferences;
>>>>>>> 81a5615bc061790a6086e71da7cef8b8e09cd598:src/assignment1/SaveAndLoad.java


public class SaveAndLoad {
	private static final String FILENAME = "file.sav";
	static Gson gson = new Gson();
<<<<<<< HEAD:Assignment1/src/assignment1/controller/SaveAndLoad.java
	
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
=======
	//save function
	public static void saveInFile(CounterList counters,Context context){
		String tojson = gson.toJson(counters);
		SharedPreferences save = context.getSharedPreferences(FILENAME,0);
		save.edit().putString("json", tojson).commit();
	}
	//load function
	public static  CounterList loadFromFile(Context context){
		SharedPreferences load = context.getSharedPreferences(FILENAME, 0);
		String fromjson = load.getString("json", "");
		CounterList counterlist = gson.fromJson(fromjson, CounterList.class);
		return counterlist;
>>>>>>> 81a5615bc061790a6086e71da7cef8b8e09cd598:src/assignment1/SaveAndLoad.java
	}
}
