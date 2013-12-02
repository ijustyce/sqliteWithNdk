package com.ijustyce.safe;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		String file = this.getFilesDir().getPath()+"/friends.db";	
		String sql = "CREATE TABLE IF NOT EXISTS persons (id INTEGER PRIMARY KEY, name TEXT);";
		showToast(runSql(sql , file));
		
		sql = "insert into persons values(1,'杨春')";
		showToast(runSql(sql , file));
		
		sql = "insert into persons values(2,'杨春')";
		showToast(runSql(sql , file));
		
		sql = "delete from persons where id=1";
		showToast(runSql(sql , file));
		
		 sql = "UPDATE persons set name = '神仙' where ID=2;";
		 showToast(runSql(sql , file));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public native String runSql(String sql ,String file);
	
	static{
		System.loadLibrary("Safe");
	}
	
	private void showToast(String s){
		
		Toast.makeText(this, s , Toast.LENGTH_LONG).show();
	}

}
