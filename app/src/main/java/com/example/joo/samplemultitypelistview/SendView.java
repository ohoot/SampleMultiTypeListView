package com.example.joo.samplemultitypelistview;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Joo on 2016-01-14.
 */
public class SendView extends FrameLayout {
    public SendView(Context context) {
        super(context);
        init();
    }

    ImageView iconView;
    TextView  messageView;
    SendData data;

    private void init() {
        inflate(getContext(), R.layout.view_send, this);
        iconView = (ImageView) findViewById(R.id.image_icon);
        messageView = (TextView) findViewById(R.id.text_message);
    }

    public void setData(SendData data) {
        this.data = data;
        iconView.setImageResource(data.iconId);
        messageView.setText(data.message);
    }
}
