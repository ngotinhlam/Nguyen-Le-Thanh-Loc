package nguyenlethanhloc.com.baomang;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class DetailNews extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_news);

        webView = (WebView) findViewById(R.id.webView);

        String link = getIntent().getStringExtra("link");

        webView.loadUrl(link);
    }
}
