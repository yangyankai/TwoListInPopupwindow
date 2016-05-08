package com.example.administrator.popupwindow;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.Map;

// 自定义两级联动 listView

public class ValuePickerView extends LinearLayout {

    private Context mContext;

    private View view;
    private ListView lvLeft, lvRight;

    private String[] summaries = DataProvider.summaries;
    private Map<String, String[]> details = DataProvider.details;

    private int mPosLeft = 0;
    private String mCurLeft;
    private int mPosRight = 0;
    private String mCurRight;
    public OnClickListener mListener;

    public void setButtonOnClickListener(OnClickListener listener) {
        this.mListener = listener;
    }

    public ValuePickerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ValuePickerView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        mContext = context;
        initData();
    }

    public void initialize() {
//        if (view == null) {
            initView();
//        } else {//if (view.getVisibility() == GONE) {
//            view.setVisibility(VISIBLE);
//        } //else if (view.getVisibility() == VISIBLE) {
//            view.setVisibility(GONE);
//        }
    }


    //	得到数据
    private void initData() {

        int len = summaries.length;

        for (int i = 0; i < len; i++) {

            String summary = summaries[i];

            if (summary.equals(mCurLeft)) {
                mPosLeft = i;
                break;
            }

        }

        if (mPosLeft >= 0) {
            String summary = summaries[mPosLeft];
            String[] right = details.get(summary);
            int lenOfRight = right.length;

            for (int j = 0; j < lenOfRight; j++) {

                String detail = right[j];

                if (mCurRight != null && detail.equals(mCurRight)) {
                    mPosRight = j;
                    break;
                }
            }
        }


        Log.v(this.getClass().getName(), "mCurLeft = " + mCurLeft + " | mPosLeft = " + mPosLeft);
        Log.v(this.getClass().getName(), "mCurRight= " + mCurRight + " | mPosRight " + mPosRight);
    }

    private void initView() {
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.custom_twofold_listview, this);

        lvLeft = (ListView) view.findViewById(R.id.lvLeft);
        lvRight = (ListView) view.findViewById(R.id.lvRight);

        final SingleCheckedListAdapter lAdapter = new SingleCheckedListAdapter(mContext, summaries);
        lvLeft.setAdapter(lAdapter);

        String[] rights = new String[]{};
        if (mPosLeft >= 0 && mPosRight >= 0) {
            rights = details.get(summaries[mPosLeft]);
        }

        final SingleCheckedListAdapter rAdapter = new SingleCheckedListAdapter(mContext, rights);
        lvRight.setAdapter(rAdapter);
//
        lvLeft.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View view, int position, long id) {

                Log.e("yyk", "ItemClick");
                mCurRight = null;
                lAdapter.setCheckedPosition(position);
                lAdapter.notifyDataSetChanged();
                rAdapter.notifyDataSetChanged();
                mPosLeft = position;
                rAdapter.setData(details.get(summaries[mPosLeft]));
            }
        });

        lvRight.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View view, int position, long id) {
                rAdapter.setCheckedPosition(position);
                rAdapter.notifyDataSetChanged();
                mCurRight = details.get(summaries[mPosLeft])[position];

                if (mListener != null) {
                    mListener.onClick(arg0);
                }
            }
        });

    }

    public String getLeftVaue() {
        if (mPosLeft >= 0) {
            return summaries[mPosLeft];
        } else {
            return "";
        }
    }

    public String getRightValue() {
        return mCurRight;
    }

}
