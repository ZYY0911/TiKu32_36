package com.example.tiku32_36.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.tiku32_36.R;
import com.example.tiku32_36.bean.GSLK;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @LogIn Name win10
 * @Create by 张瀛煜 on 2020/8/12 at 14:53 ：）
 */
public class GSKLAdapter extends BaseExpandableListAdapter {
    private List<GSLK> gslks;

    public GSKLAdapter(List<GSLK> gslks) {
        this.gslks = gslks;
    }

    @Override
    public int getGroupCount() {
        return gslks.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return gslks.get(groupPosition).getSite().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return null;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return null;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        ViewHolderFu holderFu;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.gslk_item_fu, parent, false);
            holderFu = new ViewHolderFu(convertView);
            convertView.setTag(holderFu);
        } else {
            holderFu = (ViewHolderFu) convertView.getTag();
        }
        GSLK gslk = gslks.get(groupPosition);
        holderFu.itemNum.setText(gslk.getRoadid() + "\r\n" + gslk.getRoad());
        holderFu.itemRoad.setText(gslk.getRoad());
        holderFu.itemState.setText(gslk.getType());
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ViewHolderZi holderZi;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.dtcx_item_zi, parent, false);
            holderZi = new ViewHolderZi(convertView);
            convertView.setTag(holderZi);
        } else {
            holderZi = (ViewHolderZi) convertView.getTag();
        }
        List<String> strings = gslks.get(groupPosition).getSite();
        holderZi.itemTitle.setText(strings.get(childPosition));
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    static
    class ViewHolderFu {
        @BindView(R.id.item_num)
        TextView itemNum;
        @BindView(R.id.item_road)
        TextView itemRoad;
        @BindView(R.id.item_state)
        TextView itemState;

        ViewHolderFu(View view) {
            ButterKnife.bind(this, view);
        }
    }

    static
    class ViewHolderZi {
        @BindView(R.id.item_title)
        TextView itemTitle;

        ViewHolderZi(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
