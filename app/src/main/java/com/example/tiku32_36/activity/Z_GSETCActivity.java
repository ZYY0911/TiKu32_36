package com.example.tiku32_36.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.tiku32_36.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @LogIn Name win10
 * @Create by 张瀛煜 on 2020/8/11 at 8:25 ：）
 */
public class Z_GSETCActivity extends BaseActivity {
    @BindView(R.id.title1)
    TextView title1;
    @BindView(R.id.layout_cz)
    LinearLayout layoutCz;
    @BindView(R.id.layout_ye)
    LinearLayout layoutYe;
    @BindView(R.id.layout_jl)
    LinearLayout layoutJl;

    @Override
    public int getLayout() {
        return R.layout.gsetc_layout;
    }

    @Override
    public String setTitle() {
        return "高速ETC";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.layout_cz, R.id.layout_ye, R.id.layout_jl})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.layout_cz:
                startActivity(new Intent(this,Z_ETCCZActivity.class));
                break;
            case R.id.layout_ye:
                startActivity(new Intent(this,Z_ETCYEActivity.class));
                break;
            case R.id.layout_jl:
                startActivity(new Intent(this,Z_CZJLActivity.class));
                break;
        }
    }
}
