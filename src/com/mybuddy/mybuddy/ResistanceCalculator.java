package com.mybuddy.mybuddy;

import android.os.Bundle;
import android.app.Activity;
import android.content.res.Resources;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class ResistanceCalculator extends Activity{
	private String colour1,colour2,colour3,colour4;
	private Spinner spinner1,spinner2,spinner3,spinner4;
	private TextView text;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.resistance_calculator);
		
		spinner1 = (Spinner) findViewById(R.id.color1_spinner);
		ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,R.array.colors,android.R.layout.simple_spinner_item);
		adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner2 = (Spinner) findViewById(R.id.color2_spinner);
		ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,R.array.colors,android.R.layout.simple_spinner_item);
		adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner3 = (Spinner) findViewById(R.id.color3_spinner);
		ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,R.array.colors,android.R.layout.simple_spinner_item);
		adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner4 = (Spinner) findViewById(R.id.color4_spinner);
		ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this,R.array.tolerance,android.R.layout.simple_spinner_item);
		adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner1.setAdapter(adapter1);
		spinner2.setAdapter(adapter2);
		spinner3.setAdapter(adapter3);
		spinner4.setAdapter(adapter4);
	}
	public void calculate_resistance(View view)
	{
		text=(TextView) findViewById(R.id.editText1);
		int i,c1,c2,c3,c4;
		long resis;
		Double d;
		c1=c2=c3=c4=10;
		colour1=spinner1.getSelectedItem().toString();
		colour2=spinner2.getSelectedItem().toString();
		colour3=spinner3.getSelectedItem().toString();
		colour4=spinner4.getSelectedItem().toString();
		Resources res = getResources();
		String[] all_colors = res.getStringArray(R.array.colors);
		String[] toleran = res.getStringArray(R.array.tolerance);
		for(i=0;i<10;i++)
		{
			if(colour1.compareTo(all_colors[i])==0)
				c1=i;
			if(colour2.compareTo(all_colors[i])==0)
				c2=i;
			if(colour3.compareTo(all_colors[i])==0)
				c3=i;
		}
		for(i=0;i<3;i++)
			if(colour4.compareTo(toleran[i])==0)
				c4=i;
		d=((c1*10)+c2)*Math.pow(10,c3);
		resis=d.intValue();
		if(c4==0)
			text.setText(String.valueOf(resis)+"±5%");
		if(c4==1)
			text.setText(String.valueOf(resis)+"±10%");
		if(c4==2)
			text.setText(String.valueOf(resis)+"±20%");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
