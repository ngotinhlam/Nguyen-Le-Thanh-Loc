package nguyenlethanhloc.com.baomang;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    public static ListView lvNews;
    ArrayList<RSS> listRSS;
    String[] listTitleRSS;
    public static Adapter adapter;
    public ArrayAdapter adaperType;
    public static ArrayList<News> listNews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        createListRSS();
    }

    public void createListRSS() {
        listRSS = new ArrayList<>();
        listRSS.add(new RSS("Trang chủ", "https://vnexpress.net/rss/tin-moi-nhat.rss"));
        listRSS.add(new RSS("Thời sự", "https://vnexpress.net/rss/thoi-su.rss"));
        listRSS.add(new RSS("Thế giới", "https://vnexpress.net/rss/the-gioi.rss"));
        listRSS.add(new RSS("Kinh doanh", "https://vnexpress.net/rss/kinh-doanh.rss"));
        listRSS.add(new RSS("Startup", "https://vnexpress.net/rss/startup.rss"));
        listRSS.add(new RSS("Giải trí", "https://vnexpress.net/rss/giai-tri.rss"));
        listRSS.add(new RSS("Thể thao", "https://vnexpress.net/rss/the-thao.rss"));
        listRSS.add(new RSS("Pháp luật", "https://vnexpress.net/rss/phap-luat.rss"));
        listRSS.add(new RSS("Giáo dục", "https://vnexpress.net/rss/giao-duc.rss"));
        listRSS.add(new RSS("Sức khỏe", "https://vnexpress.net/rss/suc-khoe.rss"));
        listRSS.add(new RSS("Gia đình", "https://vnexpress.net/rss/gia-dinh.rss"));
        listRSS.add(new RSS("Du lịch", "https://vnexpress.net/rss/du-lich.rss"));
        listRSS.add(new RSS("Khoa học", "https://vnexpress.net/rss/khoa-hoc.rss"));
        listRSS.add(new RSS("Số hóa", "https://vnexpress.net/rss/so-hoa.rss"));
        listRSS.add(new RSS("Xe", "https://vnexpress.net/rss/oto-xe-may.rss"));
        listRSS.add(new RSS("Cộng đồng", "https://vnexpress.net/rss/cong-dong.rss"));
        listRSS.add(new RSS("Tâm sự", "https://vnexpress.net/rss/tam-su.rss"));
        listRSS.add(new RSS("Cười", "https://vnexpress.net/rss/cuoi.rss"));

        listTitleRSS = new String[listRSS.size()];
        for (int i = 0; i < listRSS.size(); i++) {
            listTitleRSS[i] = listRSS.get(i).getTitle();
        }

        adaperType = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listTitleRSS);
        spinner.setAdapter(adaperType);
    }

    public void initView() {
        spinner = (Spinner) findViewById(R.id.spinner);
        lvNews = (ListView) findViewById(R.id.lvNews);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                loadRSS(listRSS.get(i).getUrl());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        lvNews.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, DetailNews.class);
                intent.putExtra("link", listNews.get(i).getLink());
                startActivity(intent);
            }
        });
    }

    public void loadRSS(String url) {
        listNews = new ArrayList<>();
        new GetRSS(this).execute(url);
    }

}
