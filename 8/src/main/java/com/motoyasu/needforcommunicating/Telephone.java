package com.motoyasu.needforcommunicating;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Telephone extends ActionBarActivity {

    private Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12,btn13;
    private EditText editText=null;
    private Button button=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telephone);

        btn1= (Button) findViewById(R.id.button1);
        btn2= (Button) findViewById(R.id.button2);
        btn3= (Button) findViewById(R.id.button3);
        btn4= (Button) findViewById(R.id.button4);
        btn5= (Button) findViewById(R.id.button5);
        btn6= (Button) findViewById(R.id.button6);
        btn7= (Button) findViewById(R.id.button7);
        btn8= (Button) findViewById(R.id.button8);
        btn9= (Button) findViewById(R.id.button9);
        btn10= (Button) findViewById(R.id.button10);
        btn11= (Button) findViewById(R.id.button11);
        btn12= (Button) findViewById(R.id.button12);
        btn13= (Button) findViewById(R.id.button13);
        button= (Button) findViewById(R.id.dail);
        editText= (EditText) findViewById(R.id.editText);
        btn1.setOnClickListener(myListener2);
        btn2.setOnClickListener(myListener2);
        btn3.setOnClickListener(myListener2);
        btn4.setOnClickListener(myListener2);
        btn5.setOnClickListener(myListener2);
        btn6.setOnClickListener(myListener2);
        btn7.setOnClickListener(myListener2);
        btn8.setOnClickListener(myListener2);
        btn9.setOnClickListener(myListener2);
        btn10.setOnClickListener(myListener2);
        btn11.setOnClickListener(myListener2);
        btn12.setOnClickListener(myListener2);
        btn13.setOnClickListener(myListener2);

        button.setOnClickListener(new myListener1());


    }




    public View.OnClickListener myListener2 =new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.button1:
                    editText.append(btn1.getText().toString());
                    break;
                case R.id.button2:
                    editText.append(btn2.getText().toString());
                    break;
                case R.id.button3:
                    editText.append(btn3.getText().toString());
                    break;
                case R.id.button4:
                    editText.append(btn4.getText().toString());
                    break;
                case R.id.button5:
                    editText.append(btn5.getText().toString());
                    break;
                case R.id.button6:
                    editText.append(btn6.getText().toString());
                    break;
                case R.id.button7:
                    editText.append(btn7.getText().toString());
                    break;
                case R.id.button8:
                    editText.append(btn8.getText().toString());
                    break;
                case R.id.button9:
                    editText.append(btn9.getText().toString());
                    break;
                case R.id.button10:
                    editText.append(btn10.getText().toString());
                    break;
                case R.id.button11:
                    editText.append(btn11.getText().toString());
                    break;
                case R.id.button12:
                    editText.append(btn12.getText().toString());
                    break;
                case R.id.button13:
                    String s=editText.getText().toString();
                    if(s.length()==0){
                        editText.setText("");
                        break;
                    }
                    else{
                        editText.setText(s.substring(0,s.length()-1));
                        break;
                    }
                    default: break;
            }
        }
    };

    public class myListener1 implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            String number =editText.getText().toString();


            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:" + number));
            startActivity(intent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_telephone, menu);
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
