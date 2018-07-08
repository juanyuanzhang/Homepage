package com.example.juan.homepage;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    private Intent intent;
    private TextView tvtitle;
    private AlertDialog.Builder builder;
    private Dialog dialogSign;
    private Button start,stop;
    private ImageView pic;
    private AnimationDrawable anim;



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.home:

                    tvtitle.setText(R.string.title_home);

                    return true;
                case R.id.bmi:

                    tvtitle.setText(R.string.title_bmi);
                    return true;
                case R.id.sleep:

                    tvtitle.setText(R.string.title_sleep);
                    return true;
                case R.id.water:

                    tvtitle.setText(R.string.title_water);
                    return true;
                case R.id.timer:

                    tvtitle.setText(R.string.title_timer);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //動畫設置
        bindViews();
        Resources res = getResources();
        anim = (AnimationDrawable) res.getDrawable(R.drawable.ball);
        pic.setImageDrawable(anim);
        // anim.start();
        //anim = (AnimationDrawable) pic.getBackground();



        //首頁下方按鈕區宣告物件，和設定監聽事件
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        //取得自訂Layout_bartitle的TwxtVeiw物件，設定ToolBar的標題
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.bartitle,null);
        tvtitle =(TextView)view.findViewById(R.id.tvtitle);

        //設定ToolBar樣式
        android.support.v7.app.ActionBar actionBar = getSupportActionBar(); //
        actionBar.setDisplayShowTitleEnabled(false); //隱藏程式標題
        actionBar.setLogo(R.mipmap.icon_96); //設定左上Icon
        actionBar.setDisplayUseLogoEnabled(true);//顯示LOGO
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setCustomView(view); //設置自訂layout(view)來顯示中間標題
        actionBar.setDisplayShowCustomEnabled(true);


    }

    //取得MENU顯示MENU
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater =getMenuInflater();
        inflater.inflate(R.menu.toolbar,menu);
        return super.onCreateOptionsMenu(menu);
    }

    //MENU 按鈕動作判定
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.signin:
                //inflate目的是把自己設計xml的Layout轉成View，作用類似於findViewById，它用於一個沒有被載入或者想要動態
                //對於一個沒有被載入或者想要動態載入的界面，都需要使用LayoutInflater.inflate()來載入
                LayoutInflater inflaterIn = LayoutInflater.from(HomeActivity.this);
                final View viewIn = inflaterIn.inflate(R.layout.dialog_signin_out,null);
                builder = new AlertDialog.Builder(this);
                builder.setTitle("登入")
                        .setView(viewIn)
                        .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                EditText etid_sign = (EditText) viewIn.findViewById(R.id.etid_sign);
                                EditText etpass_sign = (EditText) viewIn.findViewById(R.id.etpass_sign);

                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                             @Override
                             public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                dialogSign= builder.create();
                dialogSign.show();
                break;
            case R.id.use:

                break;
            case R.id.set:

                break;
            case R.id.report:

                break;
            case R.id.version:

                break;
            case R.id.signout:
//                LayoutInflater inflaterOut = LayoutInflater.from(HomeActivity.this);
//                final View viewOut = inflaterOut.inflate(R.layout.dialog_signin_out,null);
//                EditText etid_sign = (EditText) viewOut.findViewById(R.id.etid_sign);
//                EditText etpass_sign = (EditText) viewOut.findViewById(R.id.etpass_sign);
                builder = new AlertDialog.Builder(this);
                builder.setTitle("登出")
                        .setMessage("確定要登出嗎?")
                        .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                dialogSign= builder.create();
                dialogSign.show();
                break;

        }
        return super.onOptionsItemSelected(item);
    }
    private void bindViews() {
        start = (Button) findViewById(R.id.start);
        stop = (Button) findViewById(R.id.stop);
        pic = (ImageView) findViewById(R.id.pic);
        start.setOnClickListener(this);
        stop.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.start:
                anim.start();
                break;
            case R.id.stop:
                anim.stop();
                break;
        }

    }
}