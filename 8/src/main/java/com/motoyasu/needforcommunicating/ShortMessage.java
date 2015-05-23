package com.motoyasu.needforcommunicating;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class ShortMessage extends ActionBarActivity {

    private EditText haoma;
    private EditText neirong;
    private Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_short_message);
        send= (Button) findViewById(R.id.send);
        send.setOnClickListener(new myListener());
    }

    private class myListener implements View.OnClickListener {

        public void onClick(View v) {
            haoma = (EditText) findViewById(R.id.haoma);
            neirong = (EditText) findViewById(R.id.neirong);
            String number = haoma.getText().toString();
            String content = neirong.getText().toString();
            SmsManager smsManager = SmsManager.getDefault();
            ArrayList<String> texts = smsManager.divideMessage(content);
            for (String text:texts) {
                smsManager.sendTextMessage(number, null, text, null, null);
            }
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_short_message, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
