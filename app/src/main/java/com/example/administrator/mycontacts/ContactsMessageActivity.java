package com.example.administrator.mycontacts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/10/31.
 */
public class ContactsMessageActivity extends AppCompatActivity{
    private EditText name,moble,qq,danwei,address;
    private User user;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("联系人信息");
        name = (EditText) findViewById(R.id.name);
        moble = (EditText) findViewById(R.id.mobile);
        qq = (EditText) findViewById(R.id.qq);
        danwei = (EditText) findViewById(R.id.danwei);
        address = (EditText) findViewById(R.id.address);
        Bundle localbundle =getIntent().getExtras();
        int id=localbundle.getInt("user_ID");
        ContactsTable ct=new ContactsTable(this);
        user=ct.getUserById(id);
        name.setText("姓名"+user.getName());
        moble.setText("电话"+user.getMobile());
        qq.setText("QQ"+user.getQq());
        danwei.setText("单位"+user.getDanwei());
        address.setText("地址"+user.getAddress());
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0,1,0,"返回");
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 1:
              finish();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
