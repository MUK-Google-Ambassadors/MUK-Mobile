package gsa.muk.app;

import gsa.muk.app.adapter.RssAdapter;
import gsa.muk.app.service.EventsRssService;
import java.util.List;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockActivity;

public class EventsActivity extends SherlockActivity implements
		OnItemClickListener {

	private ListView listView;
	private ProgressBar progressBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		getSupportActionBar().setTitle("Events");
		setContentView(R.layout.list_view);
		progressBar = (ProgressBar) findViewById(R.id.progressBar);
		listView = (ListView) findViewById(R.id.listView);
		listView.setOnItemClickListener(this);
		startService();
	}

	private void startService() {
		// String type = this.getArguments().getString("type");

		Intent intent = new Intent(this, EventsRssService.class);
		intent.putExtra(EventsRssService.RECEIVER, resultReceiver);
		this.startService(intent);

	}

	/**
	 * Once the {@link EventsRssService} finishes its task, the result is sent
	 * to this ResultReceiver.
	 */
	private final ResultReceiver resultReceiver = new ResultReceiver(
			new Handler()) {
		@SuppressWarnings("unchecked")
		@Override
		protected void onReceiveResult(int resultCode, Bundle resultData) {
			List<RssItem> items = (List<RssItem>) resultData
					.getSerializable(EventsRssService.ITEMS);
			if (items != null) {
				RssAdapter adapter = new RssAdapter(EventsActivity.this, items);
				listView.setAdapter(adapter);
			} else {
				Toast.makeText(EventsActivity.this,
						"An error occured while downloading the rss feed.",
						Toast.LENGTH_LONG).show();
			}
			progressBar.setVisibility(View.GONE);
			listView.setVisibility(View.VISIBLE);
		};
	};

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		RssAdapter adapter = (RssAdapter) parent.getAdapter();
		RssItem item = (RssItem) adapter.getItem(position);
		Uri uri = Uri.parse(item.getLink());
		Intent intent = new Intent(EventsActivity.this, WebViewActivity.class);
		intent.putExtra("url", uri.toString());
		intent.putExtra("title", item.getTitle());
		startActivity(intent);
	}

}
