package com.example.chenrun.myandroid;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText phoneNo;
    private EditText msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button sendMsg = (Button) findViewById(R.id.bt_sendMessage);
        phoneNo= (EditText) findViewById(R.id.et_phoneNumber);
        msg = (EditText) findViewById(R.id.et_messageBody);
        sendMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msgBody = msg.getText().toString();
                String phoneNum = phoneNo.getText().toString().trim();

                Intent intent = new Intent(Intent.ACTION_SENDTO,Uri.parse("smsto:"+phoneNum));
                intent.putExtra("sms_body",msgBody);
                startActivity(intent);
            }
        });
    }

    public void callPhone(View view){
        phoneNo = (EditText) findViewById(R.id.et_phoneNumber);
        String phoneNum = phoneNo.getText().toString().trim();
        if (phoneNum==null||phoneNum.isEmpty()){
            Toast.makeText(MainActivity.this, "对不起，电话不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:"+phoneNum));
        startActivity(intent);
    }
}
