package com.example.administrator.mycontacts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/10/31.
 */
public class UpdateContactsActivity extends AppCompatActivity {
    private EditText name,moble,qq,danwei,address;
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit);
        name = (EditText) findViewById(R.id.name);
        moble = (EditText) findViewById(R.id.mobile);
        qq = (EditText) findViewById(R.id.qq);
        danwei = (EditText) findViewById(R.id.danwei);
        address = (EditText) findViewById(R.id.address);
        Bundle localbundle =getIntent().getExtras();
        int id=localbundle.getInt("user_ID");
        ContactsTable ct=new ContactsTable(this);
        user=ct.getUserById(id);
        name.setText(user.getName());
        moble.setText(user.getMobile());
        qq.setText(user.getQq());
        danwei.setText(user.getDanwei());
        address.setText(user.getAddress());
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0,1,0,"保存");
        menu.add(0,1,0,"返回");
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case 1:
               if(!name.getText().toString().trim().equals("")){
                   user.setName(name.getText().toString());
                   user.setMobile(moble.getText().toString());
                   user.setDanwei(danwei.getText().toString());
                   user.setQq(qq.getText().toString());
                   user.setAddress(address.getText().toString());
                   ContactsTable ct=new ContactsTable(this);
                   if(ct.updateUser(user)){
                       Toast.makeText(this,"修改成功！",Toast.LENGTH_LONG).show();
                   }else{
                       Toast.makeText(this,"修改失败！",Toast.LENGTH_LONG).show();
                   }
               }else{
                   Toast.makeText(this,"数据不能为空！",Toast.LENGTH_LONG).show();
               }
                break;
            case 2:
               finish();
                break;

            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}


