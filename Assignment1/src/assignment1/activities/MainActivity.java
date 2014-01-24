package assignment1.activities;

import com.example.assignment1.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import assignment1.controller.SaveAndLoad;
import assignment1.model.Counter;

public class MainActivity extends Activity {
	private Button addCounterButton = null;
	private Button exitButton = null;
	private ListView listView = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		addCounterButton = (Button)findViewById(R.id.add_counter);
		exitButton = (Button)findViewById(R.id.exit);
		listView = (ListView)findViewById(R.id.listView1);
		addCounterButton.setOnClickListener(listener);
		exitButton.setOnClickListener(listener);
	}
	
	private View.OnClickListener listener = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Button button =(Button)v;
			switch (button.getId()){
			case R.id.add_counter:
				Intent addCounterIntent = new Intent();
				addCounterIntent.setClass(MainActivity.this, AddCounter.class);
				MainActivity.this.startActivity(addCounterIntent);
				break;
			case R.id.exit:
				finish();
				break;
			}
		}
	};
	
	
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		setContentView(R.layout.list_item);
		}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
