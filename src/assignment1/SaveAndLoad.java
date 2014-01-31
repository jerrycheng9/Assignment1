package assignment1;

import com.google.gson.Gson;
import android.content.Context;
import android.content.SharedPreferences;


public class SaveAndLoad {
	private static final String FILENAME = "COUNTER";
	static Gson gson = new Gson();
	
	public static void saveInFile(CounterList counters,Context context){
		String tojson = gson.toJson(counters);
		SharedPreferences save = context.getSharedPreferences(FILENAME,0);
		save.edit().putString("json", tojson).commit();
	}
	
	public static  CounterList loadFromFile(Context context){
		SharedPreferences load = context.getSharedPreferences(FILENAME, 0);
		String fromjson = load.getString("json", "");
		CounterList counterlist = gson.fromJson(fromjson, CounterList.class);
		return counterlist;
	}
}
