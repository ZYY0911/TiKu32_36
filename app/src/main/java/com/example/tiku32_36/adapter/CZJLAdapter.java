package com.example.tiku32_36.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.tiku32_36.R;
import com.example.tiku32_36.bean.CZJL;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @LogIn Name win10
 * @Create by 张瀛煜 on 2020/8/12 at 9:06 ：）
 */
public class CZJLAdapter extends ArrayAdapter<CZJL> {
    public CZJLAdapter(@NonNull Context context, @NonNull List<CZJL> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.czjl_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        CZJL czjl = getItem(position);
        holder.itemBh.setText(czjl.getCarId());
        holder.itemCp.setText(czjl.getCp());
        holder.itemJe.setText(czjl.getJe() + "");
        holder.itemSj.setText(czjl.getSj());
        return convertView;
    }

    static
    class ViewHolder {
        @BindView(R.id.item_bh)
        TextView itemBh;
        @BindView(R.id.item_cp)
        TextView itemCp;
        @BindView(R.id.item_je)
        TextView itemJe;
        @BindView(R.id.item_sj)
        TextView itemSj;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
