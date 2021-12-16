package com.add.a200483task4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

public class ExpandableAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<String> expandable_list_title;
    private HashMap<String, List<String>> expandable_list_detail;

    public ExpandableAdapter(Context context, List<String> expandable_list_title, HashMap<String, List<String>> expandable_list_detail) {
        this.context = context;
        this.expandable_list_title = expandable_list_title;
        this.expandable_list_detail = expandable_list_detail;
    }

    @Override
    public int getGroupCount() {
        return this.expandable_list_title.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return this.expandable_list_detail.get(this.expandable_list_title.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return this.expandable_list_title.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return this.expandable_list_detail.get(this.expandable_list_title.get(i)).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        String list_title = (String) getGroup(i);
        if (view == null){

            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.expandable_list_group, null);

        }

        TextView list_title_text_view = (TextView) view.findViewById(R.id.list_title);
        list_title_text_view.setText(list_title);

        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        final String expanded_list_text = (String) getChild(i, i1);
        if (view == null) {

            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.expandable_list_item, null);

        }

        TextView expandable_list_text_view = (TextView) view.findViewById(R.id.list_item);
        expandable_list_text_view.setText(expanded_list_text);

        return view;

    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
}
