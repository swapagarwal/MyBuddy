package com.mybuddy.mybuddy;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class EquationsOfMotionSolver extends Activity{

	char i;
	double m,n,o;
	EditText u,v,a,s,t;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.equations_of_motion_solver);
		
		RadioGroup selection=(RadioGroup)findViewById(R.id.radioGroup1);
		selection.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				switch(checkedId){
				case R.id.u:
					v=(EditText) findViewById(R.id.editText1);
					v.setHint("v");
					a=(EditText) findViewById(R.id.editText2);
					a.setHint("a");
					s=(EditText) findViewById(R.id.editText3);
					s.setHint("s");
					t=(EditText) findViewById(R.id.editText4);
					t.setHint("t");
					i='u';
					break;
				case R.id.v:
					u=(EditText) findViewById(R.id.editText1);
					u.setHint("u");
					a=(EditText) findViewById(R.id.editText2);
					a.setHint("a");
					s=(EditText) findViewById(R.id.editText3);
					s.setHint("s");
					t=(EditText) findViewById(R.id.editText4);
					t.setHint("t");
					i='v';
					break;
				case R.id.a:
					u=(EditText) findViewById(R.id.editText1);
					u.setHint("u");
					v=(EditText) findViewById(R.id.editText2);
					v.setHint("v");
					s=(EditText) findViewById(R.id.editText3);
					s.setHint("s");
					t=(EditText) findViewById(R.id.editText4);
					t.setHint("t");
					i='a';
					break;
				case R.id.s:
					u=(EditText) findViewById(R.id.editText1);
					u.setHint("u");
					v=(EditText) findViewById(R.id.editText2);
					v.setHint("v");
					a=(EditText) findViewById(R.id.editText3);
					a.setHint("a");
					t=(EditText) findViewById(R.id.editText4);
					t.setHint("t");
					i='s';
					break;
				case R.id.t:
					u=(EditText) findViewById(R.id.editText1);
					u.setHint("u");
					v=(EditText) findViewById(R.id.editText2);
					v.setHint("v");
					a=(EditText) findViewById(R.id.editText3);
					a.setHint("a");
					s=(EditText) findViewById(R.id.editText4);
					s.setHint("s");
					i='t';
					break;
				}
			}
		});
		Button b=(Button)findViewById(R.id.solve);
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				TextView t = (TextView)findViewById(R.id.textView1);
				switch(i){
				case 'u':
					m = Double.parseDouble(t.getText().toString());
					n = Double.parseDouble(a.getText().toString());
					o = Double.parseDouble(s.getText().toString());
					t.setText("u = "+Double.toString((o-0.5*n*m*m)/(m)));
					break;
				case 'v':
					//
					break;
				case 'a':
					//
					break;
				case 's':
					//
					break;
				case 't':
					//
					break;
				}
			}
		});
	}

}
