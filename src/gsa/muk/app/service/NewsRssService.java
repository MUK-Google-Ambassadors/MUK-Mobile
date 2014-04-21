package gsa.muk.app.service;

import gsa.muk.app.RssItem;
import gsa.muk.app.RssParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.URL;
import java.util.List;

import org.xmlpull.v1.XmlPullParserException;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.util.Log;

public class NewsRssService extends IntentService{

	private static final String RSS_LINK = "http://news.mak.ac.ug/rss.xml";
    public static final String ITEMS = "items";
    public static final String RECEIVER = "receiver";
    public static final String TAG = "NewsRssServices";
 
    public NewsRssService() {
        super("NewsRssService");
    }
 
    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d("INFO", "Service started");
        List<RssItem> rssItems = null;
        try {
            RssParser parser = new RssParser();
            rssItems = parser.parse(getInputStream(RSS_LINK));
        } catch (XmlPullParserException e) {
            Log.w(e.getMessage(), e);
        } catch (IOException e) {
            Log.w(e.getMessage(), e);
        } catch(Exception e){
        	Log.e(TAG, "" + e.getStackTrace());
        	
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable(ITEMS, (Serializable) rssItems);
        ResultReceiver receiver = intent.getParcelableExtra(RECEIVER);
        receiver.send(0, bundle);
    }
 
    public InputStream getInputStream(String link) {
        try {
            URL url = new URL(link);
            return url.openConnection().getInputStream();
        } catch (IOException e) {
            Log.w("INFO", "Exception while retrieving the input stream", e);
            return null;
        }
    }
}
