package com.example.tp1;

import android.os.Bundle;
import android.app.Activity;
import android.text.format.Time;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.*;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button btn = (Button) findViewById(R.id.button1);
        btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String  msgNomPrenom = ((EditText) (findViewById(R.id.editText1))).getText().toString();
				String  Ville = ((EditText) (findViewById(R.id.editText3))).getText().toString();
				int  day = ((DatePicker) (findViewById(R.id.datePicker1))).getDayOfMonth();
				int  month = ((DatePicker) (findViewById(R.id.datePicker1))).getMonth();
				int  year = ((DatePicker) (findViewById(R.id.datePicker1))).getYear();
				month += 1;
				
				String msg = msgNomPrenom + " " + Ville + " " + day + "/" + month + "/" + year;
				
				Toast toast = Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT);
				toast.show();
			}
		});

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void addComponent(){
    	/*View v = new View(getApplicationContext());
    	ViewGroup.addView(v);*/
	}
	
	public void raz(){
		((EditText) findViewById(R.id.editText1)).setText("");
		((EditText) findViewById(R.id.editText3)).setText("");
		Time now = new Time();
		now.setToNow();
		((DatePicker) findViewById(R.id.datePicker1)).updateDate(now.year, now.month, now.monthDay);

	}
    
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	// Handle item selection
        switch (item.getItemId()) {
            //case R.id.action_settings:
                //newGame();
                //return true;
            case R.id.raz:
            	raz();
                return true;
            case R.id.addComponent:
                addComponent();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    
}
