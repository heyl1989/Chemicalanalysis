package com.heyl.chemicalanalysis.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.heyl.chemicalanalysis.R;
import com.heyl.chemicalanalysis.model.ContentModel;

import java.util.List;


/**
 * Created by heyl on 2016/12/4.
 */
public class ContentAdapter extends BaseAdapter {

    private Context context;
    private List<ContentModel> list;

    public ContentAdapter(Context context, List<ContentModel> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup group) {
        ViewHolder viewHolder;
        if (null == view) {
            view = LayoutInflater.from(context).inflate(R.layout.item_content, null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.tv_text.setText(list.get(i).getTitle());

        return view;
    }

    class ViewHolder {
        TextView tv_text;

        public ViewHolder(View view) {
            tv_text = (TextView) view.findViewById(R.id.tv_text);
        }
    }
}
