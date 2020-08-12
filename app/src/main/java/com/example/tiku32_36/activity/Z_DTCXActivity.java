package com.example.tiku32_36.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.example.tiku32_36.R;
import com.example.tiku32_36.adapter.DTCXAdapter;
import com.example.tiku32_36.bean.DTCX;
import com.example.tiku32_36.net.VolleyLo;
import com.example.tiku32_36.net.VolleyTo;
import com.example.tiku32_36.util.MyUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @LogIn Name win10
 * @Create by 张瀛煜 on 2020/8/10 at 20:53 ：）
 */
public class Z_DTCXActivity extends BaseActivity {
    @BindView(R.id.title1)
    TextView title1;
    @BindView(R.id.expand_list_view)
    ExpandableListView expandListView;
    private List<DTCX> dtcxes;

    @Override
    public int getLayout() {
        return R.layout.dtcx_layout;
    }

    @Override
    public String setTitle() {
        return "地铁查询";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        title1.setText("地铁规划");
        setVolley();
        change.setImageResource(R.mipmap.back);
        expandListView.setGroupIndicator(null);
    }

    private void setVolley() {
        VolleyTo volleyTo = new VolleyTo();
        volleyTo.setUrl("get_metro")
                .setJsonObject("UserName", "user1")
                .setVolleyLo(new VolleyLo() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        dtcxes = new Gson().fromJson(jsonObject.optJSONArray(MyUtils.ROWS).toString()
                                , new TypeToken<List<DTCX>>() {
                                }.getType());
                        setListView();
                    }

                    @Override
                    public void onErrorResponse(VolleyError volleyError) {

                    }
                }).start();
    }

    private void setListView() {
        expandListView.setAdapter(new DTCXAdapter(dtcxes));
    }

    @OnClick(R.id.title1)
    public void onViewClicked() {
        startActivity(new Intent(this,Z_DTGHActivity.class));
    }
}

