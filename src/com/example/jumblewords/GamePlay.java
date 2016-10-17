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
import android.widget.TextView;
import android.widget.Toast;

public class GamePlay extends Activity implements OnClickListener {
	TextView tv1,tv2,tv3,sh;
	Button b1,b2;
	EditText et1;
	String n="",c="",l="";
	int score=0,i=0,j=0;
	MediaPlayer p;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game_play);
		
			p=MediaPlayer.create(this, R.raw.button);
		
		tv1=(TextView)findViewById(R.id.gp_tv1);
		tv2=(TextView)findViewById(R.id.gp_tv2);
		tv3=(TextView)findViewById(R.id.gp_tv3);
		sh=(TextView)findViewById(R.id.gp_sh);
		b1=(Button)findViewById(R.id.gp_b1);
		b2=(Button)findViewById(R.id.gp_hint);
		et1=(EditText)findViewById(R.id.gp_et1);
		
		Intent ri = getIntent();
		Bundle data= ri.getExtras();
		n= data.getString("n1");
		c= data.getString("c1");
		l= data.getString("l1");
		tv3.setText("Welcome "+n);
		tv2.setText(c+" "+l);
		startGame();
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
		
		
	}

	public void startGame()
	{
		try
		{
		
		if(c.equalsIgnoreCase("animal")==true)
		{
			if(l.equalsIgnoreCase("level 1")==true)
			{
				if(j<=4)
				{
					if(i==4)
					{
						b1.setText("FINISH");
					}
					String ans=et1.getText().toString();
					if(i<=4)
					{
						tv1.setText(WordsDB.animal_q1[i]);
					}
					if(ans.equalsIgnoreCase(WordsDB.animal_a1[j]))
					{
						score=score+1;;
					}
				}
					
					i++; 
					et1.setText("");	
				}
			else if(l.equalsIgnoreCase("Level 2"))
			{
				if(j<=4)
				{
					if(i==4)
					{
						b1.setText("FINISH");
					}
					if(i<=4)
					{
						tv1.setText(WordsDB.animal_q2[i]);
					}
					String ans=et1.getText().toString();
					if(WordsDB.animal_a2[j].equalsIgnoreCase(ans))
					{
						score=score+1;
					}
				}
					
					i++;
					et1.setText("");
				}
			
			else if(l.equalsIgnoreCase("Level 3"))
			{
				if(j<=4)
				{
					if(i==4)
					{
						b1.setText("FINISH");
					}
					if(i<=4)
					{
						tv1.setText(WordsDB.animal_q3[i]);
					}
					String ans=et1.getText().toString();
					if(WordsDB.animal_a3[j].equalsIgnoreCase(ans))
					{
						score=score+1;
					}
				}
					
					i++;
					et1.setText("");
				}
			}
			
		
		else if(c.equalsIgnoreCase("biology"))
		{
			if(l.equalsIgnoreCase("Level 1"))
			{
				if(j<=4)
				{
					if(i==4)
					{
						b1.setText("FINISH");
					}
					if(i<=4)
					{
						tv1.setText(WordsDB.biology_q1[i]);
					}
					String ans=et1.getText().toString();
					if(WordsDB.biology_a1[j].equalsIgnoreCase(ans))
					{
						score=score+1;
					}
				}
				
					i++;
					et1.setText("");
				}
			
			else if(l.equalsIgnoreCase("Level 2"))
			{
				if(j<=4)
				{
					if(i==4)
					{
						b1.setText("FINISH");
					}
					if(i<=4)
					{
						tv1.setText(WordsDB.biology_q2[i]);
					}
					String ans=et1.getText().toString();
					if(WordsDB.biology_a2[j].equalsIgnoreCase(ans))
					{
						score=score+1;
					}
				}
					
					i++;
					et1.setText("");
				
			}
			else if(l.equalsIgnoreCase("Level 3"))
			{
				if(j<=4)
				{
					if(i==4)
					{
						b1.setText("FINISH");
					}
					if(i<=4)
					{
						tv1.setText(WordsDB.biology_q3[i]);
					}
					String ans=et1.getText().toString();
					if(WordsDB.biology_a3[j].equalsIgnoreCase(ans))
					{
						score=score+1;
					}
				}
				
					i++;
					et1.setText("");
				}
			
		}
		
		else if(c.equalsIgnoreCase("country"))
		{
			if(l.equalsIgnoreCase("Level 1"))
			{
				if(j<=4)
				{
					if(i==4)
					{
						b1.setText("FINISH");
					}
					if(i<=4)
					{
						tv1.setText(WordsDB.country_q1[i]);
					}
					String ans=et1.getText().toString();
					if(WordsDB.country_a1[j].equalsIgnoreCase(ans))
					{
						score=score+1;
					}
				}
				
					i++;
					et1.setText("");
				
			}
			else if(l.equalsIgnoreCase("Level 2"))
			{
				if(j<=4)
				{
					if(i==4)
					{
						b1.setText("FINISH");
					}
					if(i<=4)
					{
						tv1.setText(WordsDB.country_q2[i]);
					}
					String ans=et1.getText().toString();
					if(WordsDB.country_a2[j].equalsIgnoreCase(ans))
					{
						score=score+1;
					}
				}
				
					i++;
					et1.setText("");
				
			}
			else	if(l.equalsIgnoreCase("Level 3"))
			{
				if(j<=4)
				{
					if(i==4)
					{
						b1.setText("FINISH");
					}
					if(i<=4)
					{
						tv1.setText(WordsDB.country_q3[i]);
					}
					String ans=et1.getText().toString();
					if(WordsDB.country_a3[j].equalsIgnoreCase(ans))
					{
						score=score+1;
					}
				}
					
					i++;
					et1.setText("");
				}
			}
		
		
		else if(c.equalsIgnoreCase("elements"))
		{
			if(l.equalsIgnoreCase("Level 1"))
			{
				if(j<=4)
				{
					if(i==4)
					{
						b1.setText("FINISH");
					}
					if(i<=4)
					{
						tv1.setText(WordsDB.element_q1[i]);
					}
					String ans=et1.getText().toString();
					if(WordsDB.element_a1[j].equalsIgnoreCase(ans))
					{
						score=score+1;
					}
				}
					
					i++;
					et1.setText("");
				}
			
			else if(l.equalsIgnoreCase("Level 2"))
			{
				if(j<=4)
				{
					if(i==4)
					{
						b1.setText("FINISH");
					}
					if(i<=4)
					{
						tv1.setText(WordsDB.element_q2[i]);
					}
					String ans=et1.getText().toString();
					if(WordsDB.element_a2[j].equalsIgnoreCase(ans))
					{
						score=score+1;
					}
				}
					
					i++;
					et1.setText("");
				}
			
			else if(l.equalsIgnoreCase("Level 3"))
			{
				if(j<=4)
				{
					if(i==4)
					{
						b1.setText("FINISH");
					}
					if(i<=4)
					{
						tv1.setText(WordsDB.element_q3[i]);
					}
					String ans=et1.getText().toString();
					if(WordsDB.element_a3[j].equalsIgnoreCase(ans))
					{
						score=score+1;
					}
				}
					
					i++;
					et1.setText("");
				}
			}
		
		
		else if(c.equalsIgnoreCase("sports"))
		{
			if(l.equalsIgnoreCase("Level 1"))
			{
				if(j<=4)
				{
					if(i==4)
					{
						b1.setText("FINISH");
					}
					if(i<=4)
					{
						tv1.setText(WordsDB.sport_q1[i]);
					}
					
					String ans=et1.getText().toString();
					if(WordsDB.sport_a1[j].equalsIgnoreCase(ans))
					{
						score=score+1;
					}
				}
				
					i++;
					et1.setText("");
				
			}
			else	if(l.equalsIgnoreCase("Level 2"))
			{
				if(j<=4)
				{
					if(i==4)
					{
						b1.setText("FINISH");
					}
					if(i<=4)
					{
						tv1.setText(WordsDB.sport_q2[i]);
					}
					String ans=et1.getText().toString();
					if(WordsDB.sport_a2[j].equalsIgnoreCase(ans))
					{
						score=score+1;
					}
				}
					
					i++;
					et1.setText("");
				}
			
			else if(l.equalsIgnoreCase("Level 3"))
			{
				if(j<=4)
				{
					if(i==4)
					{
						b1.setText("FINISH");
					}
					if(i<=4)
					{
						tv1.setText(WordsDB.sport_q3[i]);
					}
					String ans=et1.getText().toString();
					if(WordsDB.sport_a3[j].equalsIgnoreCase(ans))
					{
						score=score+1;
					}
				}
				
					i++;
					et1.setText("");
				}
			}
		
		
		else if(c.equalsIgnoreCase("techno"))
		{
			if(l.equalsIgnoreCase("Level 1"))
			{
				if(j<=4)
				{
					if(i==4)
					{
						b1.setText("FINISH");
					}
					if(i<=4)
					{
						tv1.setText(WordsDB.robot_q1[i]);
					}
					
					String ans=et1.getText().toString();
					if(WordsDB.robot_a1[j].equalsIgnoreCase(ans))
					{
						score=score+1;
					}
				}
					
					i++;
					et1.setText("");
				}
			
			else if(l.equalsIgnoreCase("Level 2"))
			{
				if(j<=4)
				{
					if(i==4)
					{
						b1.setText("FINISH");
					}
					if(i<=4)
					{
						tv1.setText(WordsDB.robot_q2[i]);
					}
					String ans=et1.getText().toString();
					if(WordsDB.robot_a2[j].equalsIgnoreCase(ans))
					{
						score=score+1;
					}
				}
					
					i++;
					et1.setText("");
				
			}
			else if(l.equalsIgnoreCase("Level 3"))
			{
				if(j<=4)
				{
					if(i==4)
					{
						b1.setText("FINISH");
					}
					if(i<=4)
					{
						tv1.setText(WordsDB.robot_q3[i]);
					}
					String ans=et1.getText().toString();
					if(WordsDB.robot_a3[j].equalsIgnoreCase(ans))
					{
						score=score+1;
					}
				}
					
					i++;
					et1.setText("");
				}
			}
		
		
		}
		catch(Exception e)
		{
			
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game_play, menu);
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
protected void onDestroy() {
	// TODO Auto-generated method stub
	
	
	
	super.onDestroy();
}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int id= v.getId();
		if(id==R.id.gp_b1)
		{
		p.start();
		startGame();
		j++;
		
		if(j>4)
		{	
				Intent i=new Intent(this,EndScorePage.class);
				i.putExtra("sc", score);
				i.putExtra("n1", n);
				i.putExtra("c1", c);
				i.putExtra("l1", l);
				startActivity(i);  
				finish();
		}
		sh.setText("Starts With: ");
	}
		else if(id==R.id.gp_hint)
		{
			try
			{
			if(c.equalsIgnoreCase("animal")==true)
			{
				if(l.equalsIgnoreCase("level 1")==true)
				{
						sh.setText("Starts With : "+(WordsDB.animal_a1[j]).charAt(0));	
					}
	
				else if(l.equalsIgnoreCase("Level 2"))
				{
					sh.setText("Starts With : "+(WordsDB.animal_a2[j]).charAt(0));	
					}
				
				else if(l.equalsIgnoreCase("Level 3"))
				{
					sh.setText("Starts With : "+(WordsDB.animal_a3[j]).charAt(0));	
					}
			}
				
			
			else if(c.equalsIgnoreCase("biology"))
			{
				if(l.equalsIgnoreCase("Level 1"))
				{
					sh.setText("Starts With : "+(WordsDB.biology_a1[j]).charAt(0));	
					}
				
				else if(l.equalsIgnoreCase("Level 2"))
				{
					sh.setText("Starts With : "+(WordsDB.biology_a2[j]).charAt(0));	
					
				}
				else if(l.equalsIgnoreCase("Level 3"))
				{
					sh.setText("Starts With : "+(WordsDB.biology_a3[j]).charAt(0));	
					}
				
			}
			
			else if(c.equalsIgnoreCase("country"))
			{
				if(l.equalsIgnoreCase("Level 1"))
				{
					sh.setText("Starts With : "+(WordsDB.country_a1[j]).charAt(0));		
				}
				else if(l.equalsIgnoreCase("Level 2"))
				{
					sh.setText("Starts With : "+(WordsDB.country_a2[j]).charAt(0));		
					
				}
				else	if(l.equalsIgnoreCase("Level 3"))
				{
					sh.setText("Starts With : "+(WordsDB.country_a3[j]).charAt(0));		
					}
				}
			
			
			else if(c.equalsIgnoreCase("elements"))
			{
				if(l.equalsIgnoreCase("Level 1"))
				{
					sh.setText("Starts With : "+(WordsDB.element_a1[j]).charAt(0));		
					}
				
				else if(l.equalsIgnoreCase("Level 2"))
				{
					sh.setText("Starts With : "+(WordsDB.element_a2[j]).charAt(0));	
					}
				
				else if(l.equalsIgnoreCase("Level 3"))
				{
					sh.setText("Starts With : "+(WordsDB.element_a3[j]).charAt(0));	
					}
				}
			
			
			else if(c.equalsIgnoreCase("sports"))
			{
				if(l.equalsIgnoreCase("Level 1"))
				{
					sh.setText("Starts With : "+(WordsDB.sport_a1[j]).charAt(0));	
					
				}
				else	if(l.equalsIgnoreCase("Level 2"))
				{
					sh.setText("Starts With : "+(WordsDB.sport_a2[j]).charAt(0));	
					}
				
				else if(l.equalsIgnoreCase("Level 3"))
				{
					sh.setText("Starts With : "+(WordsDB.sport_a3[j]).charAt(0));	
				}
				}
			
			
			else if(c.equalsIgnoreCase("techno"))
			{
				if(l.equalsIgnoreCase("Level 1"))
				{
					sh.setText("Starts With : "+(WordsDB.robot_a1[j]).charAt(0));	
					}
				
				else if(l.equalsIgnoreCase("Level 2"))
				{
						sh.setText("Starts With : "+(WordsDB.robot_a2[j]).charAt(0));	
				}
				else if(l.equalsIgnoreCase("Level 3"))
				{
					sh.setText("Starts With : "+(WordsDB.robot_a3[j]).charAt(0));	
				}
			}
			
			}
			catch(Exception e)
			{
				
			}
		}
}
}

