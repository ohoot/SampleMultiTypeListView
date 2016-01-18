package com.example.joo.samplemultitypelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    ListView messageView;
    EditText editText_msg;
    Button btn;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        messageView = (ListView) findViewById(R.id.listView);
        editText_msg = (EditText) findViewById(R.id.editText_msg);
        btn = (Button) findViewById(R.id.btn_send);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        final ChattingAdapter cAdapter = new ChattingAdapter();
        messageView.setAdapter(cAdapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int checkedId = radioGroup.getCheckedRadioButtonId();
                switch (checkedId) {
                    case R.id.radio_johnson :
                        ReceiveData rd = new ReceiveData();
                        rd.message = editText_msg.getText().toString();
                        rd.iconId = R.drawable.johnson;
                        cAdapter.add(rd);
                        break;

                    case R.id.radio_charles :
                        SendData sd = new SendData();
                        sd.message = editText_msg.getText().toString();
                        sd.iconId = R.drawable.charles;
                        cAdapter.add(sd);
                        break;

                    case R.id.radio_date :
                        default:
                            DateData dd = new DateData();
                            dd.message = new Date().toString();
                            cAdapter.add(dd);
                            break;
                }
                editText_msg.setText("");
            }
        });
    }
}
