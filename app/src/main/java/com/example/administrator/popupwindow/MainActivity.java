package com.example.administrator.popupwindow;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;

public class MainActivity extends Activity {

    View view;
    PopupWindow pop;
    Button btnShowAsDrawDown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnShowAsDrawDown = (Button) findViewById(R.id.btnShowAsDrawDown);
        initPopupWindow();

        btnShowAsDrawDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!pop.isShowing()) {
                    pop.showAsDropDown(v);    // v 的左下角
//                    pop.showAsDropDown(v, 0, -160);  // v 左下角为原点 偏移（x,y）个向量单位
//                    View view = findViewById(R.id.main);
//                    pop.showAtLocation(view, Gravity.CENTER_HORIZONTAL, 0, 0);//view 的居中
                } else {
                    pop.dismiss();
                }
            }
        });

    }


    private void initPopupWindow() {
        view = this.getLayoutInflater().inflate(R.layout.popup_window, null);
        pop = new PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        pop.setOutsideTouchable(true);// 控制popupwindow点击屏幕其他地方消失    (注意：若 启动按钮 btnShowAsDrawDown在外部，点击之后不会消失，因为先dismiss，后isShowing为false，之后又会显示)
        pop.setBackgroundDrawable(new BitmapDrawable()); // 设置时才会点击外部消息
        pop.setFocusable(true); // 设置PopupWindow可获得焦点

//        view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                 TODO Auto-generated method stub
//                pop.dismiss();
//            }
//        });
        ValuePickerView valuePicker = (ValuePickerView) view.findViewById(R.id.valuePicker);
        valuePicker.initialize();
//        Button button1 = (Button) view.findViewById(R.id.btn_1);
//        button1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(), "1", Toast.LENGTH_SHORT).show();
//                pop.dismiss();
//            }
//        });


    }

}