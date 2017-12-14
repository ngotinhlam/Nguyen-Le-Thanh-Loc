package nguyenlethanhloc.com.baomang;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by thanhlong on 11/11/2017.
 */

public class Adapter extends BaseAdapter {

    LayoutInflater inflater;
    ArrayList<News> list;
    Context context;

    public Adapter(Activity activity, ArrayList<News> list) {
        this.inflater = activity.getLayoutInflater();
        this.list = list;
        context = activity;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.item_news, null);

        //Ánh xạ
        ImageView ivImage = (ImageView) view.findViewById(R.id.ivImage);
        TextView tvTitle = (TextView) view.findViewById(R.id.tvTitle);

        //Lấy đối tượng News
        News news = list.get(i);

        //Gán dữ liệu
        Picasso.with(context).load(news.getUrlImage()).into(ivImage);
        tvTitle.setText(news.getTitle());

        return view;
    }
}
