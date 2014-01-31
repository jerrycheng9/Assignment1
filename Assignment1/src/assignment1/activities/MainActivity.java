package assignment1.activities;


import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.example.assignment1.R;

import android.widget.AdapterView.OnItemClickListener;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import assignment1.model.Counter;
import assignment1.model.CounterList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

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
		Gson gson = new Gson();
		Bundle extras = getIntent().getExtras();
		if (extras != null){
			String fromjson = extras.getString("json");
			final CounterList counters = new CounterList();
			Type type = new TypeToken<List<Counter>>(){}.getType();
			List<Counter> counterlist = gson.fromJson(fromjson,type);
			for (Counter counter : counterlist){
				counters.add(counter);
			}
			final ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this, R.layout.list_item,counters.getName());
			listView.setAdapter(myAdapter);
			listView.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {
					// TODO Auto-generated method stub
					AlertDialog.Builder adb=new AlertDialog.Builder(MainActivity.this);
			        adb.setTitle("Delete?");
			        adb.setMessage("Are you sure you want to delete " + arg2);
			        final int positionToRemove = arg2;
			        adb.setNegativeButton("Cancel", null);
			        adb.setPositiveButton("Ok", new AlertDialog.OnClickListener() {
			            public void onClick(DialogInterface dialog, int which) {
			                counters.remove(positionToRemove);
			                myAdapter.notifyDataSetChanged();
			            }});
			        adb.show();
					
				}
				
			});
		}
		}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
