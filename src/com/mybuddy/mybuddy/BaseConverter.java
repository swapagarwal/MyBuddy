package com.mybuddy.mybuddy;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class BaseConverter extends Activity{
	private EditText text;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.base_converter);
		text = (EditText) findViewById(R.id.editText1);
	}

	public void onClick(View view) {
	    switch (view.getId()) {
	    case R.id.button1:
	      RadioButton binButton = (RadioButton) findViewById(R.id.radio0);
	      RadioButton decButton = (RadioButton) findViewById(R.id.radio1);
	      RadioButton octButton = (RadioButton) findViewById(R.id.radio2);
	      //RadioButton hexButton = (RadioButton) findViewById(R.id.radio3);
	      RadioButton tobinButton = (RadioButton) findViewById(R.id.radio4);
	      RadioButton todecButton = (RadioButton) findViewById(R.id.radio5);
	      RadioButton tooctButton = (RadioButton) findViewById(R.id.radio6);
	      RadioButton tohexButton = (RadioButton) findViewById(R.id.radio7);
	      if (text.getText().length() == 0) {
	        Toast.makeText(this, "Please enter a valid number",
	            Toast.LENGTH_LONG).show();
	        return;
	      }

	      
	      if (binButton.isChecked()) 
	      {		
	    	  Integer inputValue = Integer.parseInt(text.getText().toString());
	    	  if(todecButton.isChecked())
	    	  {
		        text.setText(String
		            .valueOf(convertBinaryToDecimal(inputValue)));
	    	  }
	    	  if(tooctButton.isChecked())
	    	  {
	    		  Integer t = convertBinaryToDecimal(inputValue);
	    		  
		        text.setText(String
		            .valueOf(convertDecimalToOctal(t)));
	    	  }
	    	  if(tohexButton.isChecked())
	    	  {
	    		  Integer t = convertBinaryToDecimal(inputValue);
	    		  
			        text.setText((convertDecimalToHexadecimal(t)));
	    	  }
	      } 
	      else if (octButton.isChecked()) 
	      {
	    	  Integer inputValue = Integer.parseInt(text.getText().toString());
	    	  if(todecButton.isChecked())
	    	  {
		        text.setText(String
		            .valueOf(convertOctalToDecimal(inputValue)));
	    	  }
	    	  if(tobinButton.isChecked())
	    	  {
	    		  Integer t = convertOctalToDecimal(inputValue);
	    		  
		        text.setText(String
		            .valueOf(convertDecimalToBinary(t)));
	    	  }
	    	  if(tohexButton.isChecked())
	    	  {
	    		  Integer t = convertOctalToDecimal(inputValue);
	    		  
			        text.setText((convertDecimalToHexadecimal(t)));
	    	  }
	      } 
	      else if(decButton.isChecked()){
	    	  Integer inputValue = Integer.parseInt(text.getText().toString());
	    	  if(tobinButton.isChecked()){
	        text.setText(String
	            .valueOf(convertDecimalToBinary(inputValue)));
	      }
	    	  else if(tooctButton.isChecked()){
	  	        text.setText(String
	  	            .valueOf(convertDecimalToOctal(inputValue)));
	  	        }
	    	  else if(tohexButton.isChecked()){
	  	        text.setText(
	  	            (convertDecimalToHexadecimal(inputValue)));
	    	  }
	      }
	      else  
	      {
	    	  String inputValue = String.valueOf(text.getText().toString());
	    	  if(todecButton.isChecked())
	    	  {
		        text.setText(String
		            .valueOf(convertHexadecimalToDecimal(inputValue)));
	    	  }
	    	  if(tobinButton.isChecked())
	    	  {
	    		  Integer t = convertHexadecimalToDecimal(inputValue);
	    		  
		        text.setText(String
		            .valueOf(convertDecimalToBinary(t)));
	    	  }
	    	  if(tooctButton.isChecked())
	    	  {
	    		  Integer t = convertHexadecimalToDecimal(inputValue);
	    		  
			        text.setText((convertDecimalToOctal(t)));
	    	  }
	      } 
	      break;
	    }
	  }

	  private Integer convertBinaryToDecimal(Integer binary) {
	    Integer temp = binary,d,decimal=0;
	    for(Integer i=0;temp>0;i++){
	    	d=temp%10;
	    	Double db=d*(Math.pow(2,i));
	    	decimal+=db.intValue();
	    	temp/=10;
	    }
	    return decimal;
	  }
	  private Integer convertOctalToDecimal(Integer binary) {
		    Integer temp = binary,d,decimal=0;
		    for(Integer i=0;temp>0;i++){
		    	d=temp%10;
		    	Double db=d*(Math.pow(8,i));
		    	decimal+=db.intValue();
		    	temp/=10;
		    }
		    return decimal;
		  }
	  private Integer convertHexadecimalToDecimal(String hex) {
		    Integer decimal=0,t;
		    String temp = hex;
		    Character d;
		    for(Integer i=temp.length()-1;i>=0;i--){
		    	d=temp.charAt(temp.length()-i-1);
		    	if(d=='A'){t=10;}
		    	else if(d=='B'){t=11;}
		    	else if(d=='C'){t=12;}
		    	else if(d=='D'){t=13;}
		    	else if(d=='E'){t=14;}
		    	else if(d=='F'){t=15;}
		    	else { t = Character.getNumericValue(d);}
		    	Double db=t*(Math.pow(16,i));
		    	decimal+=db.intValue();
		    }
		    return decimal;
		  }
	  

	  private Integer convertDecimalToBinary(Integer decimal) {
		  Integer binary=0;
		  for(int i=0;decimal>0;i++){
			  Double t=(Math.pow(10,i));
			  binary+=(decimal%2)*(t.intValue());
			  decimal/=2;
		  }
		  
	    return binary;
	  }
	  private Integer convertDecimalToOctal(Integer decimal) {
		  Integer binary=0;
		  for(int i=0;decimal>0;i++){
			  Double t=(Math.pow(10,i));
			  binary+=(decimal%8)*(t.intValue());
			  decimal/=8;
		  }
		  
	    return binary;
	  }
	  private String convertDecimalToHexadecimal(Integer decimal) {
		  String Hexadecimal="",temp = null;
		  while(decimal>0){
			 Integer t = decimal%16;
			 if(t>9){
				 switch(t){
				 case 10: temp="A";break;
				 case 11: temp="B";break;
				 case 12: temp="C";break;
				 case 13: temp="D";break;
				 case 14: temp="E";break;
				 case 15: temp="F";break;
				 }
			 }
			 else
				 temp=t.toString();
		  Hexadecimal+=(temp);
		  decimal/=16;
		  
		  }
		  String reverse = new StringBuffer(Hexadecimal).
				  reverse().toString();
	    return reverse;
	  }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
