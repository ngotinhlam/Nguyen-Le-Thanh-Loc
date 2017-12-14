package nguyenlethanhloc.com.baomang;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ArrayAdapter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by thanhlong on 11/11/2017.
 */

public class GetRSS extends AsyncTask<String, Void, Document> {

    Activity activity;

    public GetRSS(Activity activity) {
        this.activity = activity;
    }

    @Override
    protected Document doInBackground(String... strings) {
        Document document = null;
        try {
            document = Jsoup.connect(strings[0]).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return document;
    }

    @Override
    protected void onPostExecute(Document document) {
        Elements elements = document.select("item");
        for (Element element : elements) {
            String title = element.select("title").text();
            String link = element.select("link").text();
            String descriptionHTML = element.select("description").text();
            String urlImage = Jsoup.parse(descriptionHTML).select("img").get(0).attr("src");
            MainActivity.listNews.add(new News(title, link, urlImage));
        }
        MainActivity.adapter = new Adapter(activity, MainActivity.listNews);
        MainActivity.lvNews.setAdapter(MainActivity.adapter);
    }
}
