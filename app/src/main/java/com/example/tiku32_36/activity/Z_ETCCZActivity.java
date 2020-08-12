package com.example.tiku32_36.activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.example.tiku32_36.R;
import com.example.tiku32_36.bean.CZJL;
import com.example.tiku32_36.net.VolleyLo;
import com.example.tiku32_36.net.VolleyTo;
import com.example.tiku32_36.util.MyUtils;

import org.json.JSONObject;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @LogIn Name win10
 * @Create by 张瀛煜 on 2020/8/11 at 8:29 ：）
 */
public class Z_ETCCZActivity extends BaseActivity {
    @BindView(R.id.title1)
    TextView title1;
    @BindView(R.id.et_cp)
    EditText etCp;
    @BindView(R.id.et_money_10)
    TextView etMoney10;
    @BindView(R.id.et_money_50)
    TextView etMoney50;
    @BindView(R.id.et_money_100)
    TextView etMoney100;
    @BindView(R.id.et_je)
    EditText etJe;
    @BindView(R.id.bt_submit)
    Button btSubmit;

    @Override
    public int getLayout() {
        return R.layout.etccz_layout;
    }

    @Override
    public String setTitle() {
        return "ETC充值";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        change.setImageResource(R.mipmap.back);
        etJe.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!TextUtils.isEmpty(s)) {
                    if (s.toString().equals("0")) {
                        Toast.makeText(Z_ETCCZActivity.this, "不能输入0", Toast.LENGTH_SHORT).show();
                        etJe.setText("");
                    }
                    if (Integer.parseInt(s.toString()) > 999) {
                        MyUtils.showDialog(Z_ETCCZActivity.this, "只能输入1~999");
                        etJe.setText("999");
                        etJe.setSelection(3);
                    }
                }
            }
        });
    }

    @OnClick({R.id.et_money_10, R.id.et_money_50, R.id.et_money_100, R.id.bt_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.et_money_10:
                etJe.setText("10");
                break;
            case R.id.et_money_50:
                etJe.setText("50");
                break;
            case R.id.et_money_100:
                etJe.setText("100");
                break;
            case R.id.bt_submit:
                String Cp = etCp.getText().toString();
                if (TextUtils.isEmpty(Cp)) {
                    MyUtils.showDialog(this, "车牌号不能为空");
                    return;
                }
                if (TextUtils.isEmpty(etJe.getText())) {
                    MyUtils.showDialog(this, "充值金额不能为空");
                    return;
                }
                Cp = "鲁" + Cp.toUpperCase();
                VolleyTo volleyTo = new VolleyTo();
                final String finalCp = Cp;
                volleyTo.setUrl("set_balance")
                        .setJsonObject("UserName", "user1")
                        .setJsonObject("plate", Cp)
                        .setDialog(this)
                        .setJsonObject("balance", etJe.getText().toString())
                        .setVolleyLo(new VolleyLo() {
                            @Override
                            public void onResponse(JSONObject jsonObject) {
                                if (jsonObject.optString("RESULT").equals("S")) {
                                    MyUtils.showDialog(Z_ETCCZActivity.this, "充值成功");
                                    CZJL czjl = new CZJL();
                                    czjl.setCp(finalCp);
                                    czjl.setJe(Integer.parseInt(etJe.getText().toString()));
                                    czjl.setSj(MyUtils.SimpDate("yyyy.MM.dd", new Date()));
                                    czjl.setCarId(finalCp.substring(6));
                                    czjl.save();
                                    etCp.setText("");
                                    etJe.setText("");
                                } else {
                                    MyUtils.showDialog(Z_ETCCZActivity.this, "充值失败");
                                }
                            }

                            @Override
                            public void onErrorResponse(VolleyError volleyError) {
                                MyUtils.showDialog(Z_ETCCZActivity.this, "充值失败");
                            }
                        }).start();


                break;
        }
    }
}

