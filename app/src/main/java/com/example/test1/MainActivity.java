package com.example.test1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button login=(Button)findViewById(R.id.bt_login);
        Button idea=(Button)findViewById(R.id.bt_idea);
        login.setOnClickListener(this);
        idea.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.bt_idea:
                showIdea();
                break;
            case R.id.bt_login:
                showLogin();
                break;
            default:
                break;
        }
    }
    private void showLogin(){
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("登陆");
        View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.dialog_edt,null,false);
        builder.setView(view);
        final Dialog dialog = builder.create();
        final EditText userName=(EditText)view.findViewById(R.id.edt_username);
        final EditText userPassword=(EditText)view.findViewById(R.id.edt_password);
        Button confirm = (Button) view.findViewById(R.id.confirm);
        Button cancel = (Button) view.findViewById(R.id.cancel);
        // 设置button的点击事件及获取editview中的文本内容
        confirm.setOnClickListener(new android.view.View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                   if (!userName.getText().toString().equals("abc")) {
                       Toast.makeText(MainActivity.this, "用户名错误", Toast.LENGTH_SHORT).show();
                    } else if (!userPassword.getText().toString().equals("123")) {
                        Toast.makeText(MainActivity.this, "密码错误", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
                    }
                }

        });
        // 取消按钮
        cancel.setOnClickListener(new android.view.View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                dialog.dismiss();
            }
        });
        dialog.show();
    }
    private void showIdea(){
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("提示");
        builder.setMessage("请点击登陆按钮登陆，用户名：abc 密码：123");
        builder.setNegativeButton("关闭",new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
            }
        });
        builder.create().show();
    }
}
