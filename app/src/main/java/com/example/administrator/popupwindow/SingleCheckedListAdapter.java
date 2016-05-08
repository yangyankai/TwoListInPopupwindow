package com.example.administrator.popupwindow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SingleCheckedListAdapter extends BaseAdapter {

    private String[] mData;
    private Context mContext;

    /**
     * the position in the data
     */
    private int mCheckedPosition = 0;

    public void setCheckedPosition(int position) {
        mCheckedPosition = position;
    }

    public void setData(String[] data) {
        mData = data;
        mCheckedPosition = 0;
    }


    public SingleCheckedListAdapter(Context context, String[] data) {
        mContext = context;
        mData = data;
    }

    @Override
    public int getCount() {
        return mData.length;
    }

    @Override
    public Object getItem(int position) {
        return mData[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        View view;

//        if (convertView == null) {//缓存在两级ListView连动中会错位，因此不使用
        view = LayoutInflater.from(mContext).inflate(R.layout.item_value_picker, null);
        holder = new ViewHolder();
        holder.name = (TextView) view.findViewById(R.id.textView1);
        view.setTag(holder);

//        } else {
//            view=convertView;
//            holder = (ViewHolder) view.getTag();
//        }

        setViewSelected((RelativeLayout) view, mCheckedPosition == position);
        holder.name.setText(mData[position]);
        return view;
    }

    class ViewHolder {
        TextView name;
    }

    private void setViewSelected(RelativeLayout view, boolean selected) {
        if (view != null) {
            if (selected) {
                view.setBackgroundColor(mContext.getResources().getColor(R.color.material_blue_grey_800));
            } else {
                view.setBackgroundColor(mContext.getResources().getColor(R.color.material_grey_50));
            }
        }
    }
}
