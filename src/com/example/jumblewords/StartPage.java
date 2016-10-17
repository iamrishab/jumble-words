package com.example.jumblewords;

import com.example.jumblewords.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.graphics.PorterDuff;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.*;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.TableLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.Toast;

public class StartPage extends Activity implements android.view.View.OnClickListener,android.content.DialogInterface.OnClickListener{
	
			static MediaPlayer p,p1;
			Button b1,b2,b3;
			RelativeLayout screen;
			SQLiteDatabase db;
			String c;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start_page);
		
		b1=(Button)findViewById(R.id.sp_b1);
		b2=(Button)findViewById(R.id.sp_b2);
		b3=(Button)findViewById(R.id.sp_b3);
		screen= (RelativeLayout)findViewById(R.id.sp_screen);
		
		db= openOrCreateDatabase("JumbleWords",MODE_WORLD_READABLE, null);
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
		b3.setOnClickListener(this);
		
		if(p==null)
		{
			p=MediaPlayer.create(this, R.raw.allinfashion);
			p.start();
			p.setLooping(true);
		}
			p1=MediaPlayer.create(this, R.raw.button);
		
				
	}
	
	@Override
	protected void onRestart() {
	// TODO Auto-generated method stub
	super.onRestart();
	SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
	boolean mu = sp.getBoolean("music", true);
	c=sp.getString("bg", "Background 1");
	if(mu == true)
	{
		p.start();
		p.setLooping(true);
	}
	if(mu==false)
	{
		p.start();
		p.pause();
	}
	if(c.equalsIgnoreCase("Background 1"))
	{
		screen.setBackgroundResource(R.drawable.bg1);
	}
	else if(c.equalsIgnoreCase("Background 2"))
	{
		screen.setBackgroundResource(R.drawable.bg2);
	}
	else if(c.equalsIgnoreCase("Background 3"))
	{
		screen.setBackgroundResource(R.drawable.bg3);
	}
	else if(c.equalsIgnoreCase("Background 4"))
	{
		screen.setBackgroundResource(R.drawable.bg4);
	}
	else if(c.equalsIgnoreCase("Background 5"))
	{
		screen.setBackgroundResource(R.drawable.bg5);
	}
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.start_page, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.sp_ch1) {
			//About App
			AlertDialog.Builder bd = new AlertDialog.Builder(this);
			bd.setTitle("About My App");
			bd.setMessage("Developed By : The Rebels\nJumble Word Game\nMinimum requirement\nAndroid version 4.2.2\nJelly Bean");
			bd.setPositiveButton("OK", null);
			AlertDialog d= bd.create();
			d.show();
			
		}
		
		else if(id==R.id.sp_ch2)
		{
			startActivity(new Intent(this,SettingPage.class));
		}
		
		else if(id==R.id.sp_ch3)
		{ // ACTION BAR ICON TITLE
			showExitConfirmDialog();
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(DialogInterface dialog, int which) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int id=v.getId();
		if(id==R.id.sp_b1)
		{
			p1.start();
			startActivity(new Intent(this,UserSelect.class));
		}
		else if(id==R.id.sp_b2)
		{
			p1.start();
			AlertDialog.Builder b= new AlertDialog.Builder(this);
			b.setTitle("INSTRUCTIONS");
			b.setIcon((R.drawable.ic_launcher));
			b.setMessage("Select Any Category and level\nOf your choice\nAnd guess the answer\nClick on HINT button if required.");
			b.setPositiveButton("OK", null);
			
			AlertDialog d= b.create();
			d.show();
		}
		else if(id==R.id.sp_b3)
		{
			p1.start();
			String q= "select * from highscores";
			Cursor ob= db.rawQuery(q, null);
			String records= "NAME\tSCORE\t\tCATG.\t\t\tLEVEL\n-----------------------------------------------------";
			while(ob.moveToNext()==true)
			{
				String n= ob.getString(0);
				String s= ob.getString(1);
				String c= ob.getString(2);
				String l= ob.getString(3);
				records+="\n"+n+"\t\t"+s+"\t\t\t\t"+c+"\t\t"+l;
			}
			showData(records);
		}
	}
	
	void showData(String records)
	{
		AlertDialog.Builder b= new AlertDialog.Builder(this);
		b.setTitle("High Scores");
		b.setIcon((R.drawable.ic_launcher));
		b.setMessage(records);
		b.setPositiveButton("OK", null);
		
		AlertDialog d= b.create();
		d.show();
	}
	
	void showExitConfirmDialog()
	{
		AlertDialog.Builder b= new AlertDialog.Builder(this);
		b.setTitle("EXIT APP");
		b.setMessage("Are You Sure To Exit?");
		b.setIcon(android.R.drawable.ic_delete);
		b.setPositiveButton("YES", new android.content.DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		b.setNegativeButton("NO", null);
		AlertDialog d= b.create();
		d.show();
	}
}
