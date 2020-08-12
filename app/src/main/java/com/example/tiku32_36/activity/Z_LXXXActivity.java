package com.example.tiku32_36.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.example.tiku32_36.R;
import com.example.tiku32_36.adapter.LXXXAdapter;
import com.example.tiku32_36.bean.LXZC;
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
 * @Create by 张瀛煜 on 2020/8/12 at 15:05 ：）
 */
public class Z_LXXXActivity extends BaseActivity {
    @BindView(R.id.title1)
    TextView title1;
    @BindView(R.id.gird_view)
    GridView girdView;
    private List<LXZC> lxzcs;


    @Override
    public int getLayout() {
        return R.layout.lxxx_layout;
    }

    @Override
    public String setTitle() {
        return "旅行信息";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        setVolley();
    }

    private void setVolley() {
        VolleyTo volleyTo = new VolleyTo();
        volleyTo.setUrl("get_scenic_spot")
                .setJsonObject("UserName", "user1")
                .setVolleyLo(new VolleyLo() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        lxzcs = new Gson().fromJson(jsonObject.optJSONArray(MyUtils.ROWS).toString()
                                , new TypeToken<List<LXZC>>() {
                                }.getType());
                        setGidrView();
                    }

                    @Override
                    public void onErrorResponse(VolleyError volleyError) {

                    }
                }).start();
    }

    private void setGidrView() {
        girdView.setAdapter(new LXXXAdapter(this, lxzcs));
        girdView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Z_LXXXActivity.this, Z_XXXXActivity.class);
                intent.putExtra("infos", lxzcs.get(position));
                startActivity(intent);
            }
        });
    }
}
