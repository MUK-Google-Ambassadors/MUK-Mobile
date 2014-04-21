package gsa.muk.app;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockActivity;

public class AboutActivity extends SherlockActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about);
		getSupportActionBar().setTitle("About");
		Typeface roboto = Typeface.createFromAsset(getAssets(), "roboto.ttf");
		TextView tv = (TextView) findViewById(R.id.copyright);
		tv.setText("This app is an initiative by the Google Student Ambassadors at Makerere University.\nAll the code is open-source and anyone can contribute."
				+ "Find the repository on GitHub at http://github.com/atimothee/muk_android_app.\nEmail any suggestions to: muk_gsas@googlegroups.com\nAll feedback is welcome!");
		tv.setTypeface(roboto);
	}
}
