package com.mybuddy.mybuddy;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
				int count=0;
				if (a.getText().length() == 0) {count+=1;}
				if (b.getText().length() == 0) {count+=1;}
				if (c.getText().length() == 0) {count+=1;}
				if (A.getText().length() == 0) {count+=1;}
				if (B.getText().length() == 0) {count+=1;}
				if (C.getText().length() == 0) {count+=1;}
				if (count!=3) {
			        Toast.makeText(TriangleSolver.this, "Please enter 3 parameters",
			            Toast.LENGTH_SHORT).show();return;}
				//SSS
				if (a.getText().length() != 0 && b.getText().length() != 0 && c.getText().length() != 0) {
					i = Double.parseDouble(a.getText().toString());
					j = Double.parseDouble(b.getText().toString());
					k = Double.parseDouble(c.getText().toString());
					A.setText(Double.toString((180/Math.PI)*Math.acos((j*j+k*k-i*i)/(2*j*k))));
					B.setText(Double.toString((180/Math.PI)*Math.acos((k*k+i*i-j*j)/(2*k*i))));
					C.setText(Double.toString((180/Math.PI)*Math.acos((i*i+j*j-k*k)/(2*i*j))));
				}
				//SAS
				else if (a.getText().length() != 0 && C.getText().length() != 0 && b.getText().length() != 0){
					i = Double.parseDouble(a.getText().toString());
					j = Double.parseDouble(b.getText().toString());
					n = Double.parseDouble(C.getText().toString());
					c.setText(Double.toString(Math.sqrt(i*i+j*j-2*i*j*Math.cos(n*Math.PI/180))));
					k=Double.parseDouble(c.getText().toString());
					A.setText(Double.toString((180/Math.PI)*Math.acos((j*j+k*k-i*i)/(2*j*k))));
					l = Double.parseDouble(A.getText().toString());
					B.setText(Double.toString(180-n-l));
				}
				else if (b.getText().length() != 0 && A.getText().length() != 0 && c.getText().length() != 0){
					j = Double.parseDouble(b.getText().toString());
					k = Double.parseDouble(c.getText().toString());
					l = Double.parseDouble(A.getText().toString());
					a.setText(Double.toString(Math.sqrt(j*j+k*k-2*j*k*Math.cos(l*Math.PI/180))));
					i=Double.parseDouble(a.getText().toString());
					B.setText(Double.toString((180/Math.PI)*Math.acos((k*k+i*i-j*j)/(2*k*i))));
					m = Double.parseDouble(B.getText().toString());
					C.setText(Double.toString(180-l-m));
				}
				else if (c.getText().length() != 0 && B.getText().length() != 0 && a.getText().length() != 0){
					i = Double.parseDouble(a.getText().toString());
					k = Double.parseDouble(c.getText().toString());
					m = Double.parseDouble(B.getText().toString());
					b.setText(Double.toString(Math.sqrt(k*k+i*i-2*k*i*Math.cos(m*Math.PI/180))));
					j=Double.parseDouble(b.getText().toString());
					C.setText(Double.toString((180/Math.PI)*Math.acos((i*i+j*j-k*k)/(2*i*j))));
					n = Double.parseDouble(C.getText().toString());
					A.setText(Double.toString(180-m-n));
				}
				//SSA
				else if (a.getText().length() != 0 && b.getText().length() != 0 && A.getText().length() != 0) {
					i = Double.parseDouble(a.getText().toString());
					j = Double.parseDouble(b.getText().toString());
					l = Double.parseDouble(A.getText().toString());
					double d = j*Math.sin(l*Math.PI/180)/i;
					if (d>1) {
						Toast.makeText(TriangleSolver.this, "The given parameters do not determine a triangle",
				            Toast.LENGTH_SHORT).show();
					}
					else if (d==1){
						B.setText(Double.toString(90));
						C.setText(Double.toString(90-l));
						c.setText(Double.toString(i*Math.sin((90-l)*Math.PI/180)/Math.sin(l*Math.PI/180)));
					}
					else {
						if (i<j) {
							Toast.makeText(TriangleSolver.this, "The given parameters do not determine a unique triangle",
						            Toast.LENGTH_SHORT).show();
						}
						else {
							B.setText(Double.toString((180/Math.PI)*Math.asin(d)));
							C.setText(Double.toString(180-l-(180/Math.PI)*Math.asin(d)));
							c.setText(Double.toString(i*Math.sin((180-l-(180/Math.PI)*Math.asin(d))*Math.PI/180)/Math.sin(l*Math.PI/180)));
						}
					}
				}
				else if (a.getText().length() != 0 && b.getText().length() != 0 && B.getText().length() != 0) {
					i = Double.parseDouble(a.getText().toString());
					j = Double.parseDouble(b.getText().toString());
					m = Double.parseDouble(B.getText().toString());
					double d = i*Math.sin(m*Math.PI/180)/j;
					if (d>1) {
						Toast.makeText(TriangleSolver.this, "The given parameters do not determine a triangle",
				            Toast.LENGTH_SHORT).show();
					}
					else if (d==1){
						A.setText(Double.toString(90));
						C.setText(Double.toString(90-m));
						c.setText(Double.toString(j*Math.sin((90-m)*Math.PI/180)/Math.sin(m*Math.PI/180)));
					}
					else {
						if (j<i) {
							Toast.makeText(TriangleSolver.this, "The given parameters do not determine a unique triangle",
						            Toast.LENGTH_SHORT).show();
						}
						else {
							A.setText(Double.toString((180/Math.PI)*Math.asin(d)));
							C.setText(Double.toString(180-m-(180/Math.PI)*Math.asin(d)));
							c.setText(Double.toString(j*Math.sin((180-m-(180/Math.PI)*Math.asin(d))*Math.PI/180)/Math.sin(m*Math.PI/180)));
						}
					}
				}
				else if (b.getText().length() != 0 && c.getText().length() != 0 && B.getText().length() != 0) {
					j = Double.parseDouble(b.getText().toString());
					k = Double.parseDouble(c.getText().toString());
					m = Double.parseDouble(B.getText().toString());
					double d = k*Math.sin(m*Math.PI/180)/j;
					if (d>1) {
						Toast.makeText(TriangleSolver.this, "The given parameters do not determine a triangle",
				            Toast.LENGTH_SHORT).show();
					}
					else if (d==1){
						C.setText(Double.toString(90));
						A.setText(Double.toString(90-m));
						a.setText(Double.toString(j*Math.sin((90-m)*Math.PI/180)/Math.sin(m*Math.PI/180)));
					}
					else {
						if (j<k) {
							Toast.makeText(TriangleSolver.this, "The given parameters do not determine a unique triangle",
						            Toast.LENGTH_SHORT).show();
						}
						else {
							C.setText(Double.toString((180/Math.PI)*Math.asin(d)));
							A.setText(Double.toString(180-m-(180/Math.PI)*Math.asin(d)));
							a.setText(Double.toString(j*Math.sin((180-m-(180/Math.PI)*Math.asin(d))*Math.PI/180)/Math.sin(m*Math.PI/180)));
						}
					}
				}
				else if (b.getText().length() != 0 && c.getText().length() != 0 && C.getText().length() != 0) {
					j = Double.parseDouble(b.getText().toString());
					k = Double.parseDouble(c.getText().toString());
					n = Double.parseDouble(C.getText().toString());
					double d = j*Math.sin(n*Math.PI/180)/k;
					if (d>1) {
						Toast.makeText(TriangleSolver.this, "The given parameters do not determine a triangle",
				            Toast.LENGTH_SHORT).show();
					}
					else if (d==1){
						B.setText(Double.toString(90));
						A.setText(Double.toString(90-n));
						a.setText(Double.toString(k*Math.sin((90-n)*Math.PI/180)/Math.sin(n*Math.PI/180)));
					}
					else {
						if (k<j) {
							Toast.makeText(TriangleSolver.this, "The given parameters do not determine a unique triangle",
						            Toast.LENGTH_SHORT).show();
						}
						else {
							B.setText(Double.toString((180/Math.PI)*Math.asin(d)));
							A.setText(Double.toString(180-n-(180/Math.PI)*Math.asin(d)));
							a.setText(Double.toString(k*Math.sin((180-n-(180/Math.PI)*Math.asin(d))*Math.PI/180)/Math.sin(n*Math.PI/180)));
						}
					}
				}
				else if (c.getText().length() != 0 && a.getText().length() != 0 && C.getText().length() != 0) {
					k = Double.parseDouble(c.getText().toString());
					i = Double.parseDouble(a.getText().toString());
					n = Double.parseDouble(C.getText().toString());
					double d = i*Math.sin(n*Math.PI/180)/k;
					if (d>1) {
						Toast.makeText(TriangleSolver.this, "The given parameters do not determine a triangle",
				            Toast.LENGTH_SHORT).show();
					}
					else if (d==1){
						A.setText(Double.toString(90));
						B.setText(Double.toString(90-n));
						b.setText(Double.toString(k*Math.sin((90-n)*Math.PI/180)/Math.sin(n*Math.PI/180)));
					}
					else {
						if (k<i) {
							Toast.makeText(TriangleSolver.this, "The given parameters do not determine a unique triangle",
						            Toast.LENGTH_SHORT).show();
						}
						else {
							A.setText(Double.toString((180/Math.PI)*Math.asin(d)));
							B.setText(Double.toString(180-n-(180/Math.PI)*Math.asin(d)));
							b.setText(Double.toString(k*Math.sin((180-n-(180/Math.PI)*Math.asin(d))*Math.PI/180)/Math.sin(n*Math.PI/180)));
						}
					}
				}
				else if (c.getText().length() != 0 && a.getText().length() != 0 && A.getText().length() != 0) {
					k = Double.parseDouble(c.getText().toString());
					i = Double.parseDouble(a.getText().toString());
					l = Double.parseDouble(A.getText().toString());
					double d = k*Math.sin(l*Math.PI/180)/i;
					if (d>1) {
						Toast.makeText(TriangleSolver.this, "The given parameters do not determine a triangle",
				            Toast.LENGTH_SHORT).show();
					}
					else if (d==1){
						C.setText(Double.toString(90));
						B.setText(Double.toString(90-l));
						b.setText(Double.toString(i*Math.sin((90-l)*Math.PI/180)/Math.sin(l*Math.PI/180)));
					}
					else {
						if (i<k) {
							Toast.makeText(TriangleSolver.this, "The given parameters do not determine a unique triangle",
						            Toast.LENGTH_SHORT).show();
						}
						else {
							C.setText(Double.toString((180/Math.PI)*Math.asin(d)));
							B.setText(Double.toString(180-l-(180/Math.PI)*Math.asin(d)));
							b.setText(Double.toString(i*Math.sin((180-l-(180/Math.PI)*Math.asin(d))*Math.PI/180)/Math.sin(l*Math.PI/180)));
						}
					}
				}
				//ASA
				else if (A.getText().length() != 0 && b.getText().length() != 0 && C.getText().length() != 0){
					l = Double.parseDouble(A.getText().toString());
					j = Double.parseDouble(b.getText().toString());
					n = Double.parseDouble(C.getText().toString());
					B.setText(Double.toString(180-l-n));
					a.setText(Double.toString(j*Math.sin(l*Math.PI/180)/Math.sin((180-l-n)*Math.PI/180)));
					c.setText(Double.toString(j*Math.sin(n*Math.PI/180)/Math.sin((180-l-n)*Math.PI/180)));
				}
				else if (B.getText().length() != 0 && c.getText().length() != 0 && A.getText().length() != 0){
					m = Double.parseDouble(B.getText().toString());
					k = Double.parseDouble(c.getText().toString());
					l = Double.parseDouble(A.getText().toString());
					C.setText(Double.toString(180-m-l));
					b.setText(Double.toString(k*Math.sin(m*Math.PI/180)/Math.sin((180-m-l)*Math.PI/180)));
					a.setText(Double.toString(k*Math.sin(l*Math.PI/180)/Math.sin((180-m-l)*Math.PI/180)));
				}
				else if (C.getText().length() != 0 && a.getText().length() != 0 && B.getText().length() != 0){
					n = Double.parseDouble(C.getText().toString());
					i = Double.parseDouble(a.getText().toString());
					m = Double.parseDouble(B.getText().toString());
					A.setText(Double.toString(180-n-m));
					c.setText(Double.toString(i*Math.sin(n*Math.PI/180)/Math.sin((180-n-m)*Math.PI/180)));
					b.setText(Double.toString(i*Math.sin(m*Math.PI/180)/Math.sin((180-n-m)*Math.PI/180)));
				}
				//AAS
				else if (A.getText().length() != 0 && B.getText().length() != 0 && a.getText().length() != 0) {
					l = Double.parseDouble(A.getText().toString());
					m = Double.parseDouble(B.getText().toString());
					i = Double.parseDouble(a.getText().toString());
					C.setText(Double.toString(180-l-m));
					n = Double.parseDouble(C.getText().toString());
					c.setText(Double.toString(i*Math.sin(n*Math.PI/180)/Math.sin((180-n-m)*Math.PI/180)));
					b.setText(Double.toString(i*Math.sin(m*Math.PI/180)/Math.sin((180-n-m)*Math.PI/180)));
				}
				else if (A.getText().length() != 0 && B.getText().length() != 0 && b.getText().length() != 0) {
					l = Double.parseDouble(A.getText().toString());
					m = Double.parseDouble(B.getText().toString());
					j = Double.parseDouble(b.getText().toString());
					C.setText(Double.toString(180-l-m));
					n = Double.parseDouble(C.getText().toString());
					a.setText(Double.toString(j*Math.sin(l*Math.PI/180)/Math.sin((180-l-n)*Math.PI/180)));
					c.setText(Double.toString(j*Math.sin(n*Math.PI/180)/Math.sin((180-l-n)*Math.PI/180)));
				}
				else if (B.getText().length() != 0 && C.getText().length() != 0 && b.getText().length() != 0) {
					m = Double.parseDouble(B.getText().toString());
					n = Double.parseDouble(C.getText().toString());
					j = Double.parseDouble(b.getText().toString());
					A.setText(Double.toString(180-m-n));
					l = Double.parseDouble(A.getText().toString());
					a.setText(Double.toString(j*Math.sin(l*Math.PI/180)/Math.sin((180-l-n)*Math.PI/180)));
					c.setText(Double.toString(j*Math.sin(n*Math.PI/180)/Math.sin((180-l-n)*Math.PI/180)));
				}
				else if (B.getText().length() != 0 && C.getText().length() != 0 && c.getText().length() != 0) {
					m = Double.parseDouble(B.getText().toString());
					n = Double.parseDouble(C.getText().toString());
					k = Double.parseDouble(c.getText().toString());
					A.setText(Double.toString(180-m-n));
					l = Double.parseDouble(A.getText().toString());
					b.setText(Double.toString(k*Math.sin(m*Math.PI/180)/Math.sin((180-m-l)*Math.PI/180)));
					a.setText(Double.toString(k*Math.sin(l*Math.PI/180)/Math.sin((180-m-l)*Math.PI/180)));
				}
				else if (C.getText().length() != 0 && A.getText().length() != 0 && c.getText().length() != 0) {
					n = Double.parseDouble(C.getText().toString());
					l = Double.parseDouble(A.getText().toString());
					k = Double.parseDouble(c.getText().toString());
					B.setText(Double.toString(180-n-l));
					m = Double.parseDouble(B.getText().toString());
					b.setText(Double.toString(k*Math.sin(m*Math.PI/180)/Math.sin((180-m-l)*Math.PI/180)));
					a.setText(Double.toString(k*Math.sin(l*Math.PI/180)/Math.sin((180-m-l)*Math.PI/180)));
				}
				else if (C.getText().length() != 0 && A.getText().length() != 0 && a.getText().length() != 0) {
					n = Double.parseDouble(C.getText().toString());
					l = Double.parseDouble(A.getText().toString());
					i = Double.parseDouble(a.getText().toString());
					B.setText(Double.toString(180-n-l));
					m = Double.parseDouble(B.getText().toString());
					c.setText(Double.toString(i*Math.sin(n*Math.PI/180)/Math.sin((180-n-m)*Math.PI/180)));
					b.setText(Double.toString(i*Math.sin(m*Math.PI/180)/Math.sin((180-n-m)*Math.PI/180)));
				}
				else {
					Toast.makeText(TriangleSolver.this, "The given parameters do not determine a unique triangle",
				            Toast.LENGTH_SHORT).show();
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
