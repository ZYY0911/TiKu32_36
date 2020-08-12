package com.example.tiku32_36.activity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.tiku32_36.R;
import com.example.tiku32_36.adapter.CZJLAdapter;
import com.example.tiku32_36.bean.CZJL;

import org.litepal.LitePal;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @LogIn Name win10
 * @Create by 张瀛煜 on 2020/8/12 at 9:01 ：）
 */
public class Z_CZJLActivity extends BaseActivity {
    @BindView(R.id.title1)
    TextView title1;
    @BindView(R.id.tv_total)
    TextView tvTotal;
    @BindView(R.id.list_view)
    ListView listView;
    @BindView(R.id.tv_empty)
    TextView tvEmpty;
    private List<CZJL> czjls;

    @Override
    public int getLayout() {
        return R.layout.czjl_layout;
    }

    @Override
    public String setTitle() {
        return "充值记录";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        change.setImageResource(R.mipmap.back);
        czjls = LitePal.findAll(CZJL.class);
        int money = 0;
        for (int i = 0; i < czjls.size(); i++) {
            money += czjls.get(i).getJe();
        }
        Collections.sort(czjls, new Comparator<CZJL>() {
            @Override
            public int compare(CZJL o1, CZJL o2) {
                return o2.getId()-o1.getId();
            }
        });
        tvTotal.setText("充值合计：" + money + "元");
        listView.setAdapter(new CZJLAdapter(this, czjls));
        listView.setEmptyView(tvEmpty);
    }
}
