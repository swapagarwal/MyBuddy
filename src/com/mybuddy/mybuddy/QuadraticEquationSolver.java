package com.mybuddy.mybuddy;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class QuadraticEquationSolver extends Activity{

	double i=0,j=0,k=0,l=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.quadratic_equation_solver);
		final EditText a = (EditText) findViewById(R.id.a);
		final EditText b = (EditText) findViewById(R.id.b);
		final EditText c = (EditText) findViewById(R.id.c);
		final TextView x1 = (TextView) findViewById(R.id.x1);
		final TextView x2 = (TextView) findViewById(R.id.x2);
		final TextView d = (TextView) findViewById(R.id.d);
		x1.setText("");
		x2.setText("");
		d.setText("");
		Button solve = (Button) findViewById(R.id.solve);
		solve.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				i = Double.parseDouble(a.getText().toString());
				j = Double.parseDouble(b.getText().toString());
				k = Double.parseDouble(c.getText().toString());
				l = j*j-4*i*k;
				if (l>=0){
					x1.setText("x1 = "+Double.toString((-j+Math.sqrt(l))/2));
					x2.setText("x2 = "+Double.toString((-j-Math.sqrt(l))/2));
				}
				else if (l<0){
					x1.setText("x1 = "+Double.toString(-j/2)+" + "+Double.toString(Math.sqrt(-l)/2)+" i");
					x2.setText("x2 = "+Double.toString(-j/2)+" - "+Double.toString(Math.sqrt(-l)/2)+" i");
				}
				//d.setText("Discriminant = "+Double.toString(l));
			}
		});
	}

}
