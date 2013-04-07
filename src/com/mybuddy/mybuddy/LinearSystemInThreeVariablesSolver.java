package com.mybuddy.mybuddy;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LinearSystemInThreeVariablesSolver extends Activity{

	double e=0,f=0,g=0,h=0,i=0,j=0,k=0,l=0,m=0,n=0,o=0,p=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.linear_system_in_three_variables_solver);
		final EditText a1 = (EditText) findViewById(R.id.a1);
		final EditText b1 = (EditText) findViewById(R.id.b1);
		final EditText c1 = (EditText) findViewById(R.id.c1);
		final EditText d1 = (EditText) findViewById(R.id.d1);
		final EditText a2 = (EditText) findViewById(R.id.a2);
		final EditText b2 = (EditText) findViewById(R.id.b2);
		final EditText c2 = (EditText) findViewById(R.id.c2);
		final EditText d2 = (EditText) findViewById(R.id.d2);
		final EditText a3 = (EditText) findViewById(R.id.a3);
		final EditText b3 = (EditText) findViewById(R.id.b3);
		final EditText c3 = (EditText) findViewById(R.id.c3);
		final EditText d3 = (EditText) findViewById(R.id.d3);
		final TextView x = (TextView) findViewById(R.id.x);
		final TextView y = (TextView) findViewById(R.id.y);
		final TextView z = (TextView) findViewById(R.id.z);
		x.setText("");
		y.setText("");
		z.setText("");
		Button solve = (Button) findViewById(R.id.solve);
		solve.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				e = Double.parseDouble(a1.getText().toString());
				f = Double.parseDouble(b1.getText().toString());
				g = Double.parseDouble(c1.getText().toString());
				h = Double.parseDouble(d1.getText().toString());
				i = Double.parseDouble(a2.getText().toString());
				j = Double.parseDouble(b2.getText().toString());
				k = Double.parseDouble(c2.getText().toString());
				l = Double.parseDouble(d2.getText().toString());
				m = Double.parseDouble(a3.getText().toString());
				n = Double.parseDouble(b3.getText().toString());
				o = Double.parseDouble(c3.getText().toString());
				p = Double.parseDouble(d3.getText().toString());
				x.setText("x = "+Double.toString(det(f,g,h,j,k,l,n,o,p)/det(e,f,g,i,j,k,m,n,o)));
				y.setText("y = "+Double.toString(-det(e,g,h,i,k,l,m,o,p)/det(e,f,g,i,j,k,m,n,o)));
				z.setText("z = "+Double.toString(det(e,f,h,i,j,l,m,n,p)/det(e,f,g,i,j,k,m,n,o)));
			}
		});
	}
	public double det(double a1,double b1,double c1,double a2,double b2,double c2,double a3,double b3,double c3){
		return a1*(b2*c3-b3*c2)-b1*(a2*c3-a3*c2)+c1*(a2*b3-a3*b2);
	}
}
