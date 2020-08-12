package com.example.tiku32_36.activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.example.tiku32_36.R;
import com.example.tiku32_36.net.VolleyLo;
import com.example.tiku32_36.net.VolleyTo;
import com.example.tiku32_36.util.MyUtils;

import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @LogIn Name win10
 * @Create by 张瀛煜 on 2020/8/12 at 8:55 ：）
 */
public class Z_ETCYEActivity extends BaseActivity {
    @BindView(R.id.title1)
    TextView title1;
    @BindView(R.id.et_bh)
    EditText etBh;
    @BindView(R.id.tv_ye)
    TextView tvYe;
    @BindView(R.id.bt_submit)
    Button btSubmit;

    @Override
    public int getLayout() {
        return R.layout.etcye_layout;
    }

    @Override
    public String setTitle() {
        return "ETC余额";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        change.setImageResource(R.mipmap.back);
        etBh.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!TextUtils.isEmpty(tvYe.getText())) {
                    tvYe.setText("");
                }
            }
        });
    }

    @OnClick(R.id.bt_submit)
    public void onViewClicked() {
        if (TextUtils.isEmpty(etBh.getText())) {
            MyUtils.showDialog(this, "编号不能为空");
            return;
        }
        VolleyTo volleyTo = new VolleyTo();
        volleyTo.setUrl("get_balance_b")
                .setJsonObject("UserName", "user1")
                .setJsonObject("number", etBh.getText().toString())
                .setDialog(this)
                .setVolleyLo(new VolleyLo() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        if (jsonObject.optString("RESULT").equals("S")) {
                            tvYe.setText(jsonObject.optString("balance") + "元");
                        } else {
                            MyUtils.showDialog(Z_ETCYEActivity.this, "没有查询到" + etBh.getText().toString() + "号车");
                            tvYe.setText("");
                        }
                    }

                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        MyUtils.showDialog(Z_ETCYEActivity.this, "没有查询到" + etBh.getText().toString() + "号车");
                        tvYe.setText("");
                    }
                }).start();
    }
}
