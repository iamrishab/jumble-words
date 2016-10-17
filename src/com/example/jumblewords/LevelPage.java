package com.example.jumblewords;


import android.app.ListActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class LevelPage extends ListActivity {
	String c,n;
	TextView tv1;
	static MediaPlayer p;
	String[] s={"Level 1","Level 2","Level 3"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_level_page);
		
			p=MediaPlayer.create(this, R.raw.clicksound);
		
		ArrayAdapter<String> ad= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,s );
		setListAdapter(ad);
		Intent ri = getIntent();
		Bundle data= ri.getExtras();
		c= data.getString("c1");
		n= data.getString("n1");
		tv1=(TextView)findViewById(R.id.lp_tv1);
		tv1.setText("Welcome "+n);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.level_page, menu);
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
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		String s1=s[position];
		if(s1.equalsIgnoreCase("Level 1"))
		{
			p.start();
			Intent i = new Intent(this,GamePlay.class);
			i.putExtra("l1","level 1");
			i.putExtra("c1",c);
			i.putExtra("n1", n);
			startActivity(i);
			finish();
		}
		else if(s1.equalsIgnoreCase("Level 2"))
		{
			p.start();
			Intent i = new Intent(this,GamePlay.class);
			i.putExtra("l1", "level 2");
			i.putExtra("c1",c);
			i.putExtra("n1", n);
			startActivity(i);
			finish();
		}
		else if(s1.equalsIgnoreCase("Level 3"))
		{
			p.start();
			Intent i = new Intent(this,GamePlay.class);
			i.putExtra("l1","level 3");
			i.putExtra("c1",c);
			i.putExtra("n1", n);
			startActivity(i);
			finish();
		}
	}
}
