package com.mybuddy.mybuddy;

import android.os.Bundle;
import android.app.ListActivity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {
	
	String classes[]={"PeriodicTable","AufbauPrinciple","PolyatomicIonsList","ValenceElectronsChart","Biodiversity","PhysicalConstants","PhysicsFormulae","QuadraticEquationSolver","LinearSystemInTwoVariablesSolver","LinearSystemInThreeVariablesSolver","TriangleSolver"};
    @Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		String clicked = l.getItemAtPosition(position).toString();
		Class<?> nextClass = null;
		try {
			nextClass = Class.forName("com.mybuddy.mybuddy."+clicked);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Intent nav=new Intent(MainActivity.this,nextClass);
		startActivity(nav);
	}


	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setListAdapter(new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, classes));
        ListView listView=getListView();
        listView.setTextFilterEnabled(true);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
