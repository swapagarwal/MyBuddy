package com.mybuddy.mybuddy;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class PolyatomicIonsList extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.common);
		
		
		WebView webview = (WebView)findViewById (R.id.webView1);
        webview.loadUrl("file:///android_asset/www/PolyatomicIonsList.html");
        webview.getSettings().setBuiltInZoomControls(true);
        webview.getSettings().setSupportZoom(true);
	}

}
