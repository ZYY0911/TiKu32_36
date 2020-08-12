package com.example.tiku32_36.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.tiku32_36.R;
import com.example.tiku32_36.bean.LXZC;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @LogIn Name win10
 * @Create by 张瀛煜 on 2020/8/12 at 15:16 ：）
 */
public class Z_XXXXActivity extends BaseActivity {
    @BindView(R.id.title1)
    TextView title1;
    @BindView(R.id.left_image)
    ImageView leftImage;
    @BindView(R.id.item_msg)
    TextView itemMsg;
    @BindView(R.id.item_tel)
    TextView itemTel;
    @BindView(R.id.rating_bar)
    RatingBar ratingBar;
    private LXZC lxzc;

    @Override
    public int getLayout() {
        return R.layout.xxxx_layout;
    }

    @Override
    public String setTitle() {
        return "详细信息";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        lxzc = (LXZC) getIntent().getSerializableExtra("infos");
        leftImage.setImageResource(lxzc.getName().equals("故宫") ? R.mipmap.gugong1 : R.mipmap.gugong2);
        itemMsg.setText(lxzc.getPresentation());
        itemTel.setText(lxzc.getTel());
        ratingBar.setRating(Float.parseFloat(lxzc.getGrade()));
    }

    @OnClick(R.id.item_tel)
    public void onViewClicked() {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + lxzc.getTel()));
        startActivity(intent);
    }
}
