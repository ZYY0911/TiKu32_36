package com.example.tiku32_36.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.tiku32_36.R;
import com.example.tiku32_36.bean.DTCX;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @LogIn Name win10
 * @Create by 张瀛煜 on 2020/8/10 at 20:58 ：）
 */
public class DTCXAdapter extends BaseExpandableListAdapter {
    private List<DTCX> dtcxes;

    public DTCXAdapter(List<DTCX> dtcxes) {
        this.dtcxes = dtcxes;
    }

    @Override
    public int getGroupCount() {
        return dtcxes.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return dtcxes.get(groupPosition).getSite().size();
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
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.dtcx_item_fu, parent, false);
            holderFu = new ViewHolderFu(convertView);
            convertView.setTag(holderFu);
        } else {
            holderFu = (ViewHolderFu) convertView.getTag();
        }
        DTCX dtcx = dtcxes.get(groupPosition);
        holderFu.itemTitle.setText(dtcx.getName());
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
        holderZi.itemTitle.setText(dtcxes.get(groupPosition).getSite().get(childPosition));
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    static
    class ViewHolderFu {
        @BindView(R.id.item_title)
        TextView itemTitle;

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
