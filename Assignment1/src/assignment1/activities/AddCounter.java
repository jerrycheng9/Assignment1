package assignment1.activities;

import com.example.assignment1.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
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
		cancelButton.setOnClickListener(new cancelListener());
	}
	
	class addListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			String inputstr = input.getText().toString();
			Intent addIntent = new Intent();
			addIntent.putExtra("name",inputstr);
			finish();
		}
		
	}
	
	class cancelListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			finish();
		}
		
	}
}
