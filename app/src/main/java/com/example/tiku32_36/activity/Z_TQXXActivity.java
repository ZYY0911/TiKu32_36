package com.example.tiku32_36.activity;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.example.tiku32_36.R;
import com.example.tiku32_36.adapter.TQXXAdapter;
import com.example.tiku32_36.bean.TQXX;
import com.example.tiku32_36.net.VolleyLo;
import com.example.tiku32_36.net.VolleyTo;
import com.example.tiku32_36.util.MyUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @LogIn Name win10
 * @Create by 张瀛煜 on 2020/8/12 at 15:21 ：）
 */
public class Z_TQXXActivity extends BaseActivity {
    @BindView(R.id.title1)
    ImageView title1;
    @BindView(R.id.iv_image)
    ImageView ivImage;
    @BindView(R.id.tv_date)
    TextView tvDate;
    @BindView(R.id.tv_wd)
    TextView tvWd;
    @BindView(R.id.gird_view)
    GridView girdView;
    private List<TQXX> tqxxes;
    private List<String> time;
    private String arr[] = {"周天", "周一", "周二", "周三", "周四", "周五", "周六"};
    private String arr1[] = {"今天", "明天", "后天"};

    @Override
    public int getLayout() {
        return R.layout.tqxx_layout;
    }

    @Override
    public String setTitle() {
        return "天气信息";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        time = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        for (int i = 0; i < 6; i++) {
            if (i < 3) {
                time.add(calendar.get(Calendar.DAY_OF_MONTH)+"日("+arr1[i]+")");
            }else {
                time.add(calendar.get(Calendar.DAY_OF_MONTH)+"日("+arr[calendar.get(Calendar.DAY_OF_WEEK) -1]+")");
            }
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }
        tvDate.setText(MyUtils.SimpDate("yyyy年M月dd日 E", new Date()));
        setVolley(true);
    }

    private void setVolley(final boolean is) {
        VolleyTo volleyTo = new VolleyTo();
        volleyTo.setUrl("get_weather_info")
                .setJsonObject("UserName", "user1")
                .setVolleyLo(new VolleyLo() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        if (is) {
                            tqxxes = new Gson().fromJson(jsonObject.optJSONArray(MyUtils.ROWS).toString()
                                    , new TypeToken<List<TQXX>>() {
                                    }.getType());
                            tqxxes.remove(0);
                            girdView.setAdapter(new TQXXAdapter(Z_TQXXActivity.this, tqxxes,time));
                        }
                        String weatherType = jsonObject.optString("weather");
                        switch (weatherType) {
                            case "晴":
                                ivImage.setImageResource(R.mipmap.taiyang);
                                break;
                            case "小雨":
                                ivImage.setImageResource(R.mipmap.xiaoyu);
                                break;
                            case "阴":
                                ivImage.setImageResource(R.mipmap.yin);
                                break;
                        }
                        tvWd.setText(jsonObject.optString("temperature") + "度");
                    }

                    @Override
                    public void onErrorResponse(VolleyError volleyError) {

                    }
                }).start();
    }

    @OnClick(R.id.title1)
    public void onViewClicked() {
        setVolley(false);
    }
}
