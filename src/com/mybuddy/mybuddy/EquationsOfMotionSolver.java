package com.mybuddy.mybuddy;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EquationsOfMotionSolver extends Activity{

	double i=0,j=0,k=0,l=0,m=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.equations_of_motion_solver);
		final EditText u = (EditText) findViewById(R.id.u);
		final EditText vel = (EditText) findViewById(R.id.v);
		final EditText a = (EditText) findViewById(R.id.a);
		final EditText s = (EditText) findViewById(R.id.s);
		final EditText t = (EditText) findViewById(R.id.t);
		Button solve = (Button) findViewById(R.id.solve);
		solve.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				int count=0;
				if (u.getText().length() == 0) {count+=1;}
				if (vel.getText().length() == 0) {count+=1;}
				if (a.getText().length() == 0) {count+=1;}
				if (s.getText().length() == 0) {count+=1;}
				if (t.getText().length() == 0) {count+=1;}
				if (count!=2) {
			        Toast.makeText(EquationsOfMotionSolver.this, "Please enter 3 parameters",
			            Toast.LENGTH_SHORT).show();return;}
				//u,v,a
				if (u.getText().length() != 0 && vel.getText().length() != 0 && a.getText().length() != 0) {
					i = Double.parseDouble(u.getText().toString());
					j = Double.parseDouble(vel.getText().toString());
					k = Double.parseDouble(a.getText().toString());
					s.setText(Double.toString((j*j-i*i)/(2*k)));
					t.setText(Double.toString((j-i)/k));
				}
				//u,v,s
				else if (u.getText().length() != 0 && vel.getText().length() != 0 && s.getText().length() != 0) {
					i = Double.parseDouble(u.getText().toString());
					j = Double.parseDouble(vel.getText().toString());
					l = Double.parseDouble(s.getText().toString());
					a.setText(Double.toString((j*j-i*i)/(2*l)));
					k = Double.parseDouble(a.getText().toString());
					t.setText(Double.toString((j-i)/k));
				}
				//u,v,t
				else if (u.getText().length() != 0 && vel.getText().length() != 0 && t.getText().length() != 0) {
					i = Double.parseDouble(u.getText().toString());
					j = Double.parseDouble(vel.getText().toString());
					m = Double.parseDouble(t.getText().toString());
					a.setText(Double.toString((j-i)/m));
					k = Double.parseDouble(a.getText().toString());
					s.setText(Double.toString((j*j-i*i)/(2*k)));
				}
				//u,a,s
				else if (u.getText().length() != 0 && a.getText().length() != 0 && s.getText().length() != 0) {
					i = Double.parseDouble(u.getText().toString());
					k = Double.parseDouble(a.getText().toString());
					l = Double.parseDouble(s.getText().toString());
					vel.setText(Double.toString(Math.sqrt(i*i+2*k*l)));
					j = Double.parseDouble(vel.getText().toString());
					t.setText(Double.toString((j-i)/k));
				}
				//u,a,t
				else if (u.getText().length() != 0 && a.getText().length() != 0 && t.getText().length() != 0) {
					i = Double.parseDouble(u.getText().toString());
					k = Double.parseDouble(a.getText().toString());
					m = Double.parseDouble(t.getText().toString());
					vel.setText(Double.toString(i+k*m));
					j = Double.parseDouble(vel.getText().toString());
					s.setText(Double.toString((j*j-i*i)/(2*k)));
				}
				//u,s,t
				else if (u.getText().length() != 0 && s.getText().length() != 0 && t.getText().length() != 0) {
					i = Double.parseDouble(u.getText().toString());
					l = Double.parseDouble(s.getText().toString());
					m = Double.parseDouble(t.getText().toString());
					a.setText(Double.toString(2*(l-i*m)/(m*m)));
					k = Double.parseDouble(a.getText().toString());
					vel.setText(Double.toString(i+k*m));
				}
				//v,a,s
				else if (vel.getText().length() != 0 && a.getText().length() != 0 && s.getText().length() != 0) {
					j = Double.parseDouble(vel.getText().toString());
					k = Double.parseDouble(a.getText().toString());
					l = Double.parseDouble(s.getText().toString());
					u.setText(Double.toString(Math.sqrt(j*j-2*k*l)));
					i = Double.parseDouble(u.getText().toString());
					t.setText(Double.toString((j-i)/k));
				}
				//v,a,t
				else if (vel.getText().length() != 0 && a.getText().length() != 0 && t.getText().length() != 0) {
					j = Double.parseDouble(vel.getText().toString());
					k = Double.parseDouble(a.getText().toString());
					m = Double.parseDouble(t.getText().toString());
					u.setText(Double.toString(j-k*m));
					i = Double.parseDouble(u.getText().toString());
					s.setText(Double.toString((j*j-i*i)/(2*k)));
				}
				//v,s,t
				else if (vel.getText().length() != 0 && s.getText().length() != 0 && t.getText().length() != 0) {
					j = Double.parseDouble(vel.getText().toString());
					l = Double.parseDouble(s.getText().toString());
					m = Double.parseDouble(t.getText().toString());
					a.setText(Double.toString(-2*(l-j*m)/(m*m)));
					k = Double.parseDouble(a.getText().toString());
					u.setText(Double.toString(j-k*m));
				}
				//a,s,t
				else if (a.getText().length() != 0 && s.getText().length() != 0 && t.getText().length() != 0) {
					k = Double.parseDouble(a.getText().toString());
					l = Double.parseDouble(s.getText().toString());
					m = Double.parseDouble(t.getText().toString());
					u.setText(Double.toString((l-0.5*k*m*m)/m));
					i = Double.parseDouble(u.getText().toString());
					vel.setText(Double.toString(i+k*m));
				}
			}
		});
		Button reset = (Button) findViewById(R.id.reset);
		reset.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
				startActivity(getIntent());
			}
		});
	}
}
