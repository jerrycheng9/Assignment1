package assignment1.activities;

import com.example.assignment1.R;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import assignment1.controller.SaveAndLoad;
import assignment1.model.Counter;
import assignment1.model.CounterList;

public class EditCounter extends Activity {
	private Button incre = null;
	private Button res = null;
	private Button ren = null;
	private Button sum = null;
	private Button del = null;
	private TextView tex = null;
	private TextView num = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_counter);
		incre = (Button)findViewById(R.id.increse);
		res = (Button)findViewById(R.id.reset);
		ren = (Button)findViewById(R.id.rename);
		sum = (Button)findViewById(R.id.sumarize);
		del = (Button)findViewById(R.id.delete);
		tex = (TextView)findViewById(R.id.textView1);
		num = (TextView)findViewById(R.id.num);
		CounterList counters = SaveAndLoad.loadFromFile(EditCounter.this);
		String name = getIntent().getExtras().getString("string");
		Counter counter = counters.get(name);
		tex.setText(name);
		num.setText(Integer.toString(counter.getAmount()));
		incre.setOnClickListener(listener);
		res.setOnClickListener(listener);
		ren.setOnClickListener(listener);
		sum.setOnClickListener(listener);
		del.setOnClickListener(listener);
	}
	
	private View.OnClickListener listener = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			CounterList counters = SaveAndLoad.loadFromFile(EditCounter.this);
			String name = getIntent().getExtras().getString("string");
			Counter counter = (Counter) counters.get(name);
			// TODO Auto-generated method stub
			Button button =(Button)v;
			switch (button.getId()){
			case R.id.increse:
				counter.setAmount(counter.getAmount()+1);
				SaveAndLoad.saveInFile(counters, EditCounter.this);
				num.setText(Integer.toString(counter.getAmount()));
				break;
			case R.id.reset:
				counter.setAmount(0);
				SaveAndLoad.saveInFile(counters, EditCounter.this);
				num.setText(Integer.toString(counter.getAmount()));
				break;
			case R.id.delete:
				counters.remove(name);
				SaveAndLoad.saveInFile(counters, EditCounter.this);
				finish();
				break;
			}
		}
	}; 
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.edit_counter, menu);
		return true;
	}

}
