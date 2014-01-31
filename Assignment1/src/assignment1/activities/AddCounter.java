package assignment1.activities;


import java.util.Date;

import assignment1.controller.SaveAndLoad;
import assignment1.model.Counter;
import com.example.assignment1.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddCounter extends Activity{
	private Button cancelButton = null;
	private Button addButton = null;
	private EditText input = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_counter);
		input = (EditText)findViewById(R.id.input);
		addButton = (Button)findViewById(R.id.add);
		cancelButton = (Button)findViewById(R.id.cancel);
		cancelButton.setOnClickListener(listener);
		addButton.setOnClickListener(listener);
	}
	private View.OnClickListener listener = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Button button = (Button)v;
			switch (button.getId()) {
			case R.id.add:
				setResult(RESULT_OK);
				String text = input.getText().toString();
				Counter counter = new Counter(text, new Date() , "0");
				SaveAndLoad.saveInFile(counter);
				finish();
				break;
			case R.id.cancel:
				finish();
				break;
			}
			
		}
	};
}
