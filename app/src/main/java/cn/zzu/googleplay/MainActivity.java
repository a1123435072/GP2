package cn.zzu.googleplay;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.astuetz.PagerSlidingTabStrip;

import cn.zzu.googleplay.factory.FragmentFactory;
import cn.zzu.googleplay.util.UIUtils;

/**
 * 主界面
 */
public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawLayout;
    private ActionBarDrawerToggle toggle;
    private ViewPager vp;
    private PagerSlidingTabStrip mTabs;
    private String mMainTitles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initActionBar();
        initView();
        intiactionBardrawToggle();

        initData();
    }

    private void initData() {
        //为viewpager设置适配器
        mMainTitles = UIUtils.getString(R.array.main_titles);
        vp.setAdapter(new MainPagerAdapter(getSupportFragmentManager()));
        mTabs.setViewPager(vp);

    }

    /**
     * pagerAdapter view
     *
     */
    class MainPagerAdapter extends FragmentPagerAdapter{



        public MainFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public  class  MainFragmentPagerAdapter e()

        //返回指定position页面的Fragment
        @Override
        public Fragment getItem(int position) {
            Fragment fragment = FragmentFactory.createFragment(position);
            return null;
        }

        /**
         * 决定viewpaget也是的综合
         * @return
         */
        @Override
        public int getCount() {
            if (mMainTitles!=null){
                return mMainTitles.length();
            }
            return 0;
        }

        /**
         * 必须复写这个方法,得到title
         * 是什么
         * @param position
         * @return
         */
        @Override
        public CharSequence getPageTitle(int position) {
            return mMainTitles[position];
        }
    }

    private void intiactionBardrawToggle() {
        toggle = new ActionBarDrawerToggle(this,mDrawLayout, R.string.open,R.string.close);
        //同步状态方法-->途欢默认回退部分的ui效果
        toggle.syncState();
        //监听 设置 drawlayout的监听//拖动的时候上面也 会跟着变化
        mDrawLayout.setDrawerListener(toggle);
    }

    private void initView() {
        mDrawLayout = (DrawerLayout) findViewById(R.id.main_drawer_layout);
        vp = (ViewPager) findViewById(R.id.main_vp);
        mTabs = (PagerSlidingTabStrip) findViewById(R.id.main_tabs);



    }

    private void initActionBar() {
        ActionBar supportActionBar = getSupportActionBar();//v4包中的action
        /**
         * 老师的方法
         */
        //supportActionBar.setCustomView();

        supportActionBar.setTitle("主标题");
        supportActionBar.setSubtitle("副标题");

        supportActionBar.setIcon(R.drawable.ic_launcher);
        supportActionBar.setIcon(R.mipmap.ic_action_call);

        supportActionBar.setDisplayShowHomeEnabled(true);

        //修改icon和local的优先级
        supportActionBar.setDisplayUseLogoEnabled(true);//默认是没用logo用的是icon

        //显示绘图部分
        supportActionBar.setDisplayHomeAsUpEnabled(true);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case android.R.id.home:
                //dianji toggle可以控制  打开和关闭
                toggle.onOptionsItemSelected(item);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
