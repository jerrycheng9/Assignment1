package assignment1.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import android.content.Context;

public class save {
	private static final String FILENAME = "file.sav";
	private void saveInFile(String text, Date date, Context ctx) {
		FileOutputStream fos;
		try {
			fos = ctx.openFileOutput(FILENAME,Context.MODE_APPEND);
			fos.write(new String(date.toString() + " | " + text).getBytes());
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
