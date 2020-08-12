package com.example.tiku32_36.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tiku32_36.R;
import com.example.tiku32_36.bean.LXZC;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @LogIn Name win10
 * @Create by 张瀛煜 on 2020/8/12 at 15:08 ：）
 */
public class LXXXAdapter extends ArrayAdapter<LXZC> {
    public LXXXAdapter(@NonNull Context context, @NonNull List<LXZC> objects) {
        super(context, 0, objects);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.lxzs_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        LXZC lxzc = getItem(position);
        holder.leftImage.setImageResource(lxzc.getName().equals("故宫") ? R.mipmap.gugong1 : R.mipmap.gugong2);
        holder.itemTitle.setText(lxzc.getName());
        holder.itemPrice.setText("票价￥" + lxzc.getPrice());
        return convertView;
    }

    static
    class ViewHolder {
        @BindView(R.id.left_image)
        ImageView leftImage;
        @BindView(R.id.item_title)
        TextView itemTitle;
        @BindView(R.id.item_price)
        TextView itemPrice;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
