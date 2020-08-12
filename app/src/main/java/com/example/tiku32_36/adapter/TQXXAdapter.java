package com.example.tiku32_36.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.tiku32_36.R;
import com.example.tiku32_36.bean.TQXX;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @LogIn Name win10
 * @Create by 张瀛煜 on 2020/8/12 at 15:43 ：）
 */
public class TQXXAdapter extends ArrayAdapter<TQXX> {
    List<String> strings;
    public TQXXAdapter(@NonNull Context context, @NonNull List<TQXX> objects,List<String> strings) {
        super(context, 0, objects);
        this.strings = strings;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.tqyb_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        TQXX tqxx = getItem(position);
        holder.itemRq.setText(strings.get(position));
        switch (tqxx.getWeather()) {
            case "晴":
                holder.itemImage.setImageResource(R.mipmap.taiyang);
                holder.bgColor.setBackgroundColor(Color.parseColor("#66BAF9"));
                break;
            case "小雨":
                holder.itemImage.setImageResource(R.mipmap.xiaoyu);
                holder.bgColor.setBackgroundColor(Color.parseColor("#66BAF9"));
                break;
            case "阴":
                holder.itemImage.setImageResource(R.mipmap.yin);
                holder.bgColor.setBackgroundColor(Color.parseColor("#8D8E90"));
                break;
        }
        holder.itemLx.setText(tqxx.getWeather());
        holder.itemWd.setText(tqxx.getInterval().replace("~", "/") + "℃");
        return convertView;
    }

    static
    class ViewHolder {
        @BindView(R.id.item_rq)
        TextView itemRq;
        @BindView(R.id.item_image)
        ImageView itemImage;
        @BindView(R.id.item_lx)
        TextView itemLx;
        @BindView(R.id.item_wd)
        TextView itemWd;
        @BindView(R.id.bg_color)
        LinearLayout bgColor;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
