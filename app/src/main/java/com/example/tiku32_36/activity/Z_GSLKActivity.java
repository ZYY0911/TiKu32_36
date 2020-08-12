package com.example.tiku32_36.activity;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.android.volley.VolleyError;
import com.example.tiku32_36.R;
import com.example.tiku32_36.adapter.GSKLAdapter;
import com.example.tiku32_36.bean.GSLK;
import com.example.tiku32_36.bean.News;
import com.example.tiku32_36.net.VolleyLo;
import com.example.tiku32_36.net.VolleyTo;
import com.example.tiku32_36.util.MyUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @LogIn Name win10
 * @Create by 张瀛煜 on 2020/8/12 at 9:16 ：）
 */
public class Z_GSLKActivity extends BaseActivity {
    @BindView(R.id.title1)
    TextView title1;
    @BindView(R.id.view_flipper)
    ViewFlipper viewFlipper;
    @BindView(R.id.expand_list_view)
    ExpandableListView expandListView;
    private List<News> news;
    private List<GSLK> gslks;

    @Override
    public int getLayout() {
        return R.layout.gslk_layout;
    }

    @Override
    public String setTitle() {
        return "高速路况";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        setVolley_News();
        setVolley_Road();
        expandListView.setGroupIndicator(null);
    }

    private void setVolley_Road() {
        VolleyTo volleyTo = new VolleyTo();
        volleyTo.setUrl("get_roads")
                .setJsonObject("UserName", "user1")
                .setVolleyLo(new VolleyLo() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        gslks = new Gson().fromJson(jsonObject.optJSONArray(MyUtils.ROWS).toString()
                                , new TypeToken<List<GSLK>>() {
                                }.getType());
                        expandListView.setAdapter(new GSKLAdapter(gslks));
                    }

                    @Override
                    public void onErrorResponse(VolleyError volleyError) {

                    }
                }).start();
    }


    private void setVolley_News() {
        VolleyTo volleyTo = new VolleyTo();
        volleyTo.setUrl("get_news")
                .setJsonObject("UserName", "user1")
                .setVolleyLo(new VolleyLo() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        news = new Gson().fromJson(jsonObject.optJSONArray(MyUtils.ROWS).toString()
                                , new TypeToken<List<News>>() {
                                }.getType());
                        setFlipper();
                    }

                    @Override
                    public void onErrorResponse(VolleyError volleyError) {

                    }
                }).start();
    }

    private void setFlipper() {
        for (int i = 0; i < news.size(); i++) {
            final News news1 = news.get(i);
            TextView textView = new TextView(this);
            textView.setText(news1.getTitle());
            textView.setTextColor(Color.BLACK);
            textView.setTextSize(30);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showMsg(news1.getTitle(), news1.getMessage());
                }
            });
            viewFlipper.addView(textView);
        }
        viewFlipper.startFlipping();
    }

    private void showMsg(String title, String msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.setPositiveButton("确定", null);
        builder.create().show();
    }
}
