package com.motoyasu.needforcommunicating;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Friends extends ActionBarActivity {
    private ListView listView;
//    private ArrayAdapter<String> name;
    private SimpleAdapter userData;
    private List<Map<String,Object>>dataList;
    private Button getcall;
    private Button getshortMessage;
    private Button getnewUser;
    private Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);

        mContext=this;
        getcall= (Button) findViewById(R.id.call);
        getnewUser= (Button) findViewById(R.id.newUser);
        getshortMessage= (Button) findViewById(R.id.shortMessage);

        getcall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Friends.this,Telephone.class);
                startActivity(intent);
            }

        });

        getshortMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Friends.this,ShortMessage.class);
                startActivity(intent);
            }
        });

        getnewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Friends.this, UserInterface.class);
                startActivity(intent);
            }
        });

        dataList=new ArrayList<Map<String,Object>>();
        listView= (ListView) findViewById(R.id.listView);
        userData=new SimpleAdapter(this,getData(),
                                    R.layout.item,
                                    new String[]{"image","text"},
                                    new int[]{R.id.imageView,
                                    R.id.textView});
        listView.setAdapter(userData);


    }

    private List<Map<String, Object>> getData(){
        String[]name={"Homker","Shakugan","Shirt Teen","Motoyasu"};
        int[] image={R.drawable.homker1,R.drawable.shakugan2,R.drawable.shirtteen1,R.drawable.motoyasu1};
        for(int i=0;i<20;i++)
        {
            Map<String, Object> map=new HashMap<String, Object>();
            if(i<4)map.put("image",image[i]);
            else map.put("image",R.drawable.touxiang);
            if(i<4)map.put("text",name[i]);
             else map.put("text","2333333");
            dataList.add(map);
        }
        return dataList;
    }







    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_friends, menu);
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
