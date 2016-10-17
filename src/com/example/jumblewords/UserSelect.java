package com.example.jumblewords;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserSelect extends Activity implements OnClickListener{
	
	Button b1;
	EditText et1;
	static MediaPlayer p;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_select);
		
			p=MediaPlayer.create(this, R.raw.button);
		
		b1=(Button)findViewById(R.id.us_b1);
		et1=(EditText)findViewById(R.id.us_et1);
		
		SharedPreferences sp= getSharedPreferences("user", MODE_PRIVATE);
		String sv = sp.getString("nm","");
		et1.setText(sv);
		
		b1.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.user_select, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		String s= et1.getText().toString();
		if(s.equals("") || s.equals(" "))
		{
			Toast.makeText(this, "Please enter your name!!", 100).show();
		}
		else
		{
			SharedPreferences sp= getSharedPreferences("user", MODE_PRIVATE);
			Editor e =sp.edit();
			e.putString("nm",s);
			e.commit();
			
			Intent i = new Intent(this,Categories.class);
			i.putExtra("n1",s);
			startActivity(i);
			finish();
		}
	}
	
}
