package gsa.muk.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;

import com.actionbarsherlock.app.SherlockActivity;

public class WebViewActivity extends SherlockActivity{
	@SuppressLint("SetJavaScriptEnabled")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.web_view);
		 WebView webView = (WebView) findViewById(R.id.webView);
		webView.getSettings().setJavaScriptEnabled(true);
		Bundle extras = getIntent().getExtras();
		Log.e("passedurl", extras.getString("url"));
		if (extras != null) {
			getSupportActionBar().setTitle(extras.getString("title"));
			Log.e("passedurl", extras.getString("url"));
		webView.loadUrl(extras.getString("url"));
		}
	}

}
