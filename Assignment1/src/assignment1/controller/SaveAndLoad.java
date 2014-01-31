package assignment1.controller;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import android.content.Context;
import android.content.SharedPreferences;
import assignment1.model.Counter;


public class SaveAndLoad {
	private static final String FILENAME = "COUNTER";
	static Gson gson = new Gson();
	private static List<Counter> counters = new ArrayList<Counter>();
	
	public static void saveInFile(Counter counter,Context context){
		counters.add(counter);
		String tojson = gson.toJson(counters);
		SharedPreferences save = context.getSharedPreferences(FILENAME,0);
		save.edit().putString("json", tojson).commit();
	}
	
	public static  String loadFromFile(Context context){
		SharedPreferences load = context.getSharedPreferences(FILENAME, 0);
		String fromjson = load.getString("json", "");
		return fromjson;
	}
}
