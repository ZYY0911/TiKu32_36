package com.example.tiku32_36.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tiku32_36.R;
import com.example.tiku32_36.util.ImageListener;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @LogIn Name win10
 * @Create by 张瀛煜 on 2020/8/10 at 21:03 ：）
 */
public class Z_DTGHActivity extends BaseActivity {
    @BindView(R.id.title1)
    TextView title1;
    @BindView(R.id.image_view)
    ImageView imageView;

    @Override
    public int getLayout() {
        return R.layout.dtgh_layout;
    }

    @Override
    public String setTitle() {
        return "地铁规划";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        imageView.setOnTouchListener(new ImageListener(imageView));
    }
}
