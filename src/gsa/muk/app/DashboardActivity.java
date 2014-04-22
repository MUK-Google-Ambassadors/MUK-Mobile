package gsa.muk.app;

import android.content.Intent;
import android.graphics.PixelFormat;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockActivity;

public class DashboardActivity extends SherlockActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dashboard);
		Typeface robotobold = Typeface.createFromAsset(getAssets(),
				"roboto_medium.ttf");
		Button news = (Button) findViewById(R.id.dashboard_button_news);
		news.setTypeface(robotobold);
		Button events = (Button) findViewById(R.id.dashboard_button_events);
		Button links = (Button) findViewById(R.id.dashboard_button_links);
		Button about = (Button) findViewById(R.id.dashboard_button_about);
		events.setTypeface(robotobold);
		links.setTypeface(robotobold);
		about.setTypeface(robotobold);

		// attach event handler to dash buttons
		DashboardClickListener dBClickListener = new DashboardClickListener();
		findViewById(R.id.dashboard_button_news).setOnClickListener(
				dBClickListener);
		findViewById(R.id.dashboard_button_events).setOnClickListener(
				dBClickListener);
		findViewById(R.id.dashboard_button_links).setOnClickListener(
				dBClickListener);
		findViewById(R.id.dashboard_button_about).setOnClickListener(
				dBClickListener);

	};

	private class DashboardClickListener implements OnClickListener {
		public void onClick(View v) {
			Intent i = null;
			switch (v.getId()) {
			case R.id.dashboard_button_news:
				i = new Intent(DashboardActivity.this, NewsActivity.class);
				break;
			case R.id.dashboard_button_events:
				i = new Intent(DashboardActivity.this, EventsActivity.class);
				break;
			case R.id.dashboard_button_links:
				Toast.makeText(getApplicationContext(), "Oops! Links still under construction!", 
						   Toast.LENGTH_LONG).show();
				break;
			case R.id.dashboard_button_about:
				i = new Intent(DashboardActivity.this, AboutActivity.class);
				break;
			default:
				break;
			}
			if (i != null) {
				startActivity(i);
			}
		}

	}

	@Override
	public void onAttachedToWindow() {

		super.onAttachedToWindow();

		Window window = getWindow();

		window.setFormat(PixelFormat.RGBA_8888);

	}
}