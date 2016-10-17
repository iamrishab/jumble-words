package com.example.jumblewords;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class EndScorePage extends Activity implements OnClickListener{
	
	TextView tv1,tv2,tv3;
	String n,c,l;
	int sc=0;
	Button b1,b2,b3,b4;
	SQLiteDatabase db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_end_score_page);
		
		tv1=(TextView)findViewById(R.id.esp_et1);
		tv2=(TextView)findViewById(R.id.esp_et2);
		tv3=(TextView)findViewById(R.id.esp_tv3);
		b1=(Button)findViewById(R.id.esp_b1);
		b2=(Button)findViewById(R.id.esp_b2);
		//b3=(Button)findViewById(R.id.esp_b3);
		//b4=(Button)findViewById(R.id.esp_b4);
		
		Intent i = getIntent();
		Bundle data= i.getExtras();
		sc=data.getInt("sc");
		c=data.getString("c1");
		l=data.getString("l1");
		n= data.getString("n1");
		tv1.setText("Congratulations \n"+n);
		tv2.setText("Your Score : "+sc);
		
		SharedPreferences sp= getSharedPreferences("jw_score", MODE_PRIVATE);
		int chs = sp.getInt("hs", 0);
		
		db= openOrCreateDatabase("JumbleWords",MODE_WORLD_READABLE, null);
		if(chs<=sc)
		{
			highestScore();
			tv3.setText("HIGHEST SCORE");
		}
		
		b1.setOnClickListener(this);
		/*b2.setOnClickListener(this);
		b3.setOnClickListener(this);*/
		b2.setOnClickListener(this);
		

	}

	void highestScore()
	{
		SharedPreferences sp= getSharedPreferences("jw_score", MODE_PRIVATE);
		Editor e =sp.edit();
		e.remove("hs");
		e.putInt("hs", sc);
		e.commit();
		
		String q="create table if not exists highscores(name varchar , score int, catg varchar,level varchar)";
		db.execSQL(q);
		String q1= "insert into highscores values('"+n+"',"+sc+",'"+c+"','"+l+"')";
		db.execSQL(q1);
	}
	
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
int id=v.getId();
		
		if(id==R.id.esp_b1)
		{
			Intent i=new Intent(this,Categories.class);
			i.putExtra("n1", n);
			startActivity(i);
			finish();
		}
		/*
		else if(id==R.id.esp_b2)
		{
			String aan = Intent.ACTION_SENDTO;
			String s = "sms:";
			String m="Just played the newly launched \nJumble Words Game\nDeveloped By: 3 Rebels\nIt was quite fun\nScored:\nYou must also try!!\nGet it on Google Play!!";
			Uri u = Uri.parse(s);
			Intent i = new Intent(aan,u);
			i.putExtra("sms_body", m);
			startActivity(i);
			finish();
		}
		
		else if(id==R.id.esp_b3)
		{
			String aan= Intent.ACTION_VIEW;
			Intent i = new Intent(aan,Uri.parse("http://www.google.com"));
			startActivity(i);
			finish();
		}
		*/
		else if(id==R.id.esp_b2)
		{
			finish();
		}

		
	}
}
