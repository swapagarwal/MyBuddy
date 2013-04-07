package com.mybuddy.mybuddy;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class TriangleSolver extends Activity{

	double i=0,j=0,k=0,l=0,m=0,n=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.triangle_solver);
		final EditText a = (EditText) findViewById(R.id.a);
		final EditText b = (EditText) findViewById(R.id.b);
		final EditText c = (EditText) findViewById(R.id.c);
		final EditText A = (EditText) findViewById(R.id.A);
		final EditText B = (EditText) findViewById(R.id.B);
		final EditText C = (EditText) findViewById(R.id.C);
		Button solve = (Button) findViewById(R.id.solve);
		solve.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				i = Double.parseDouble(a.getText().toString());
				j = Double.parseDouble(b.getText().toString());
				k = Double.parseDouble(c.getText().toString());
				l = Double.parseDouble(A.getText().toString());
				m = Double.parseDouble(B.getText().toString());
				n = Double.parseDouble(C.getText().toString());
				//SSS
				if (i!=0 && j!=0 && k!=0){
					A.setText(Double.toString((180/Math.PI)*Math.acos((j*j+k*k-i*i)/(2*j*k))));
					B.setText(Double.toString((180/Math.PI)*Math.acos((k*k+i*i-j*j)/(2*k*i))));
					C.setText(Double.toString((180/Math.PI)*Math.acos((i*i+j*j-k*k)/(2*i*j))));
				}
				//SAS
				else if (i!=0 && n!=0 && j!=0){
					c.setText(Double.toString(Math.sqrt(i*i+j*j-2*i*j*Math.cos(n*Math.PI/180))));
					k=Double.parseDouble(c.getText().toString());
					A.setText(Double.toString((180/Math.PI)*Math.acos((j*j+k*k-i*i)/(2*j*k))));
					l = Double.parseDouble(A.getText().toString());
					B.setText(Double.toString(180-n-l));
				}
				else if (j!=0 && l!=0 && k!=0){
					a.setText(Double.toString(Math.sqrt(j*j+k*k-2*j*k*Math.cos(l*Math.PI/180))));
					i=Double.parseDouble(a.getText().toString());
					B.setText(Double.toString((180/Math.PI)*Math.acos((k*k+i*i-j*j)/(2*k*i))));
					m = Double.parseDouble(B.getText().toString());
					C.setText(Double.toString(180-l-m));
				}
				else if (k!=0 && m!=0 && i!=0){
					b.setText(Double.toString(Math.sqrt(k*k+i*i-2*k*i*Math.cos(m*Math.PI/180))));
					j=Double.parseDouble(b.getText().toString());
					C.setText(Double.toString((180/Math.PI)*Math.acos((i*i+j*j-k*k)/(2*i*j))));
					n = Double.parseDouble(C.getText().toString());
					A.setText(Double.toString(180-m-n));
				}
				//SSA
				//ASA
				//AAS
			}
		});
	}

}
