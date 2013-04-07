package com.mybuddy.mybuddy;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LinearSystemInTwoVariablesSolver extends Activity{

	double i=0,j=0,k=0,l=0,m=0,n=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.linear_system_in_two_variables_solver);
		final EditText a1 = (EditText) findViewById(R.id.a1);
		final EditText b1 = (EditText) findViewById(R.id.b1);
		final EditText c1 = (EditText) findViewById(R.id.c1);
		final EditText a2 = (EditText) findViewById(R.id.a2);
		final EditText b2 = (EditText) findViewById(R.id.b2);
		final EditText c2 = (EditText) findViewById(R.id.c2);
		final TextView x = (TextView) findViewById(R.id.x);
		final TextView y = (TextView) findViewById(R.id.y);
		x.setText("");
		y.setText("");
		Button solve = (Button) findViewById(R.id.solve);
		solve.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				i = Double.parseDouble(a1.getText().toString());
				j = Double.parseDouble(b1.getText().toString());
				k = Double.parseDouble(c1.getText().toString());
				l = Double.parseDouble(a2.getText().toString());
				m = Double.parseDouble(b2.getText().toString());
				n = Double.parseDouble(c2.getText().toString());
				x.setText("x = "+Double.toString((-j*n+m*k)/(i*m-l*j)));
				y.setText("y = "+Double.toString((i*n-l*k)/(i*m-l*j)));
			}
		});
	}

}
