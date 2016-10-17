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

public class Categories extends ListActivity{
	
	String s[] = {"Animal","Biology","Country","Elements","Sports","Technology"};
	String n;
	TextView tv1;
	static MediaPlayer p;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_categories);
		
			p=MediaPlayer.create(this, R.raw.clicksound);
		
		tv1=(TextView)findViewById(R.id.cat_tv1);
		ArrayAdapter<String> ad= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,s );
		setListAdapter(ad);
		Intent ri = getIntent();
		Bundle data= ri.getExtras();
		n= data.getString("n1");
		tv1.setText("Welcome "+n);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.categories, menu);
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
		
		if(s1.equalsIgnoreCase("animal"))
		{
			p.start();
			Intent i = new Intent(this,LevelPage.class);
			i.putExtra("c1","animal");
			i.putExtra("n1", n);
			startActivity(i);
			finish();
		}
		else if(s1.equalsIgnoreCase("biology"))
		{
			p.start();
			Intent i = new Intent(this,LevelPage.class);
			i.putExtra("c1","biology");
			i.putExtra("n1", n);
			startActivity(i);
			finish();
		}
		else if(s1.equalsIgnoreCase("country"))
		{
			p.start();
			Intent i = new Intent(this,LevelPage.class);
			i.putExtra("c1","country");
			i.putExtra("n1", n);
			startActivity(i);
			finish();
		}
		else if(s1.equalsIgnoreCase("elements"))
		{
			p.start();
			Intent i = new Intent(this,LevelPage.class);
			i.putExtra("c1","elements");
			i.putExtra("n1", n);
			startActivity(i);
			finish();
		}
		else if(s1.equalsIgnoreCase("sports"))
		{
			p.start();
			Intent i = new Intent(this,LevelPage.class);
			i.putExtra("c1","sports");
			i.putExtra("n1", n);
			startActivity(i);
			finish();
		}
		if(s1.equalsIgnoreCase("technology"))
		{
			p.start();
			Intent i = new Intent(this,LevelPage.class);
			i.putExtra("c1","techno");
			i.putExtra("n1", n);
			startActivity(i);
			finish();
		}
		
	}
}
