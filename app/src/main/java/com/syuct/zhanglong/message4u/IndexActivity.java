package com.syuct.zhanglong.message4u;


import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Entity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import android.util.Log;
import android.view.View;

import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;
import com.syuct.zhanglong.Utils.GlobalData;
import com.syuct.zhanglong.bean.User;
import com.syuct.zhanglong.http.HttpUtils;
import com.syuct.zhanglong.http.Url;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

/**
 * 登录后的第一页莫非页面
 * 也叫主页面
 */
public class IndexActivity extends SlidingFragmentActivity {//这里继承的是SlidingFragmentActivity

    static String name;
    private TextView title;
    private SlidingMenu sm;//滑动菜单
    private Fragment leftFragment;//左侧视图
    static long back_pressed;
    private Fragment contentFragment;
    private Fragment mContent;
    private ImageButton topbutton;




    @Override
    public void onCreate(Bundle savedInstanceState) {//将protected变成public
        super.onCreate(savedInstanceState);



        Bundle data=getIntent().getExtras();
        name=data.getString("name");
        //GetNews s=new GetNews();
        //s.execute();

        setContentView(R.layout.activity_index);
        title=(TextView)findViewById(R.id.tv_top_center);
        title.setText(name);
        final Intent NewsDetail = new Intent(this,NewsDetailActivity.class);
        title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(NewsDetail);
                overridePendingTransition(R.anim.abc_slide_in_bottom, R.anim.abc_fade_out);
            }
        });


        setBehindContentView(R.layout.menu);//设置SlidingMenu的layout

        topbutton = (ImageButton) this.findViewById(R.id.topbutton);
        topbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggle();
            }
        });

        //设置默认的Fragment
        if (savedInstanceState == null) {
            contentFragment = GlobalData.friend;
        } else {
            //取出之前保存的contentFragment
            contentFragment = this.getFragmentManager().getFragment(savedInstanceState, "contentFragment");
        }
        this.getFragmentManager()
                .beginTransaction()
                .replace(R.id.main_frame, contentFragment)
                .commit();


        sm = getSlidingMenu();
        sm.setMode(SlidingMenu.LEFT);//设置SlidingMenu可以从左右两侧都可以滑出

        //左边的菜单
//		sm.setMenu(R.layout.left_menu_layout);//设置SlidingMenu显示的内容
        sm.setShadowDrawable(R.drawable.shadow);// 设置SlidingMenu和主页面交界部分的阴影图片


        sm.setTouchModeAbove(SlidingMenu.LEFT);//设置滑出slidingmenu范围
        sm.setShadowWidthRes(R.dimen.shadow_width);// 设置阴影部分的宽度
        sm.setBehindOffsetRes(R.dimen.main_width);//设置主界面的宽度


        leftFragment = new LeftFragment();//SlidingMenu需要显示的Fragment的实例

        this.getFragmentManager()//拿到Fragment的管理器
                //通过Fragment的管理器就可以切换Fragment
                .beginTransaction()//fragment的事物管理
                .replace(R.id.menu_frame, leftFragment)//参数1：layout的id，参数2：要显示的Fragment实例
                .commit();

    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //1.bundle
        //2.存放的ID
        //3.当前要保存的fragment的实例
        this.getFragmentManager().putFragment(outState,
                                              "contentFragment",
                                              contentFragment);
    }



    public void switchFragment(Fragment to) {
        if (contentFragment != to) {
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            if (!to.isAdded()) { // 先判断是否被add过
                transaction.hide(contentFragment).add(R.id.main_frame, to); // 隐藏当前的fragment，add下一个到Activity中
                transaction.commit();
            } else {
                transaction.hide(contentFragment).show(to); // 隐藏当前的fragment，显示下一个
                transaction.commit();
            }
            contentFragment = to;
        }
        sm.toggle();
    }


/*
    public void switchFragment2(Fragment f) {

        contentFragment = f;

        FragmentManager fm = getFragmentManager();
        FragmentTransaction tx = fm.beginTransaction();
        tx.hide(this);
        tx.add(R.id.main_frame , f, "f");

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_frame, f)
                .commit();

        sm.toggle();//动态开关，关闭SlidingMenu
    }*/

    @Override
    public void onBackPressed() {
        if (back_pressed + 2000 > System.currentTimeMillis()) {
            GlobalData.setUUID("2");
            super.onBackPressed();
        }
        else {
            Toast toast = Toast.makeText(IndexActivity.this,
                                       "再按一下退出",
                                        Toast.LENGTH_SHORT);
            toast.show();
            back_pressed = System.currentTimeMillis();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public class GetNews extends AsyncTask<Void,Void,String>{
        @Override
        protected String doInBackground(Void... params) {
            String result="";
            Url url=new Url();
            url.setPackege("system");
            url.setRequestMethod("getAd");

            HttpClient httpClient=new DefaultHttpClient();
            HttpGet httpGet=new HttpGet(url.getFinUrl());
            try{
                HttpResponse response=httpClient.execute(httpGet);
                if(response.getStatusLine().getStatusCode()==200){
                    result= EntityUtils.toString(response.getEntity());
                }
            }catch (Exception e){
                e.printStackTrace();
            }

            return result;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            name=s;
            super.onPostExecute(s);
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }
    }
}

