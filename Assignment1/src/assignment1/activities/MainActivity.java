package assignment1.activities;

import com.example.assignment1.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

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
		addCounterButton.setOnClickListener(new addCounterListener());
		exitButton.setOnClickListener(new exitListener());
	}
	
	class addCounterListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent addCounterIntent = new Intent();
			addCounterIntent.setClass(MainActivity.this, AddCounter.class);
			MainActivity.this.startActivity(addCounterIntent);
		}
		
	}
	
	class exitListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			finish();
		}
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
