package assignment1;

<<<<<<< HEAD:Assignment1/src/assignment1/activities/MainActivity.java
import com.example.assignment1.R;

=======
import java.util.ArrayList;
import java.util.List;
import com.example.assignment1.R;
import android.widget.AdapterView.OnItemClickListener;
>>>>>>> 81a5615bc061790a6086e71da7cef8b8e09cd598:src/assignment1/MainActivity.java
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
<<<<<<< HEAD:Assignment1/src/assignment1/activities/MainActivity.java
import assignment1.controller.SaveAndLoad;
import assignment1.model.Counter;
=======

>>>>>>> 81a5615bc061790a6086e71da7cef8b8e09cd598:src/assignment1/MainActivity.java

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
	//Listener for Button 
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
<<<<<<< HEAD:Assignment1/src/assignment1/activities/MainActivity.java
		setContentView(R.layout.list_item);
		}

=======
		CounterList counters = SaveAndLoad.loadFromFile(MainActivity.this);
		if (counters != null){
			List<String> list = new ArrayList<String>(counters.getkeys());
			//Use Bubble Sort. Sort Automatically.
			for (int i = 0; i < list.size(); i++){
				for (int j = 1; j < (list.size() - i); j++){
					if (counters.get(list.get(j-1)).getAmount() < counters.get(list.get(j)).getAmount()){
						String temp = list.get(j-1);
						list.set(j-1, list.get(j));
						list.set(j, temp);
					}
				}
			}
			//Set Adapter.
			listView.setAdapter(new ArrayAdapter<String>(this, R.layout.list_item,list));
			listView.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1,int arg2, long arg3) {
					// TODO Auto-generated method stub
					String selectitem =(String) listView.getItemAtPosition(arg2);
					Intent intent = new Intent(MainActivity.this,EditCounter.class);
					intent.putExtra("string", selectitem);
					startActivity(intent);
				}
			});
		}
	}
>>>>>>> 81a5615bc061790a6086e71da7cef8b8e09cd598:src/assignment1/MainActivity.java


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
