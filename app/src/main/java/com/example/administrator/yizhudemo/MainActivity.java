package com.example.administrator.yizhudemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.yizhudemo.fragments.DataFragment;
import com.example.administrator.yizhudemo.fragments.MoreFragment;
import com.example.administrator.yizhudemo.fragments.RfidFragment;
import com.example.administrator.yizhudemo.fragments.WifiFragment;

public class MainActivity extends FragmentActivity {
    private TextView txt_title,
                        txt_left,
                       txt_right;
    private ImageView img_back,
                       img_right;

    private ImageView[] imagebuttons;
    private TextView[] textviews;


    private Fragment[] fragments;
    private DataFragment datafragment;
    private RfidFragment rfidfragment;
    private WifiFragment wififragment;
    private MoreFragment morefragment;

    private int index;
    private int currentTabIndex;// 当前fragment的index

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_title=(TextView)findViewById(R.id.txt_title);
        txt_left=(TextView)findViewById(R.id.txt_left);
        txt_right=(TextView)findViewById(R.id.txt_right);

        img_back=(ImageView)findViewById(R.id.img_back);
        img_right=(ImageView)findViewById(R.id.img_right);


        datafragment=new DataFragment();
        rfidfragment=new RfidFragment();
        wififragment=new WifiFragment();
        morefragment=new MoreFragment();
        imagebuttons = new ImageView[4];
        imagebuttons[0] = (ImageView) findViewById(R.id.ib_rfid);
        imagebuttons[1] = (ImageView) findViewById(R.id.ib_data);
        imagebuttons[2] = (ImageView) findViewById(R.id.ib_wifi);
        imagebuttons[3] = (ImageView) findViewById(R.id.ib_more);
        imagebuttons[0].setSelected(true);

        textviews = new TextView[4];
        textviews[0] = (TextView) findViewById(R.id.tv_rfid);
        textviews[1] = (TextView) findViewById(R.id.tv_data);
        textviews[2] = (TextView) findViewById(R.id.tv_wifi);
        textviews[3] = (TextView) findViewById(R.id.tv_more);
        textviews[0].setTextColor(0xFF45C01A);


        fragments=new Fragment[]{rfidfragment,datafragment,wififragment,morefragment};
        // 添加显示第一个fragment

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container,rfidfragment)
                .add(R.id.fragment_container,datafragment)
                .add(R.id.fragment_container,wififragment)
                .add(R.id.fragment_container,morefragment)
                .hide(datafragment)
                .hide(wififragment)
                .hide(morefragment)
                .show(rfidfragment)
                .commit();
    }


    public void onTabClicked(View view){
        img_right.setVisibility(View.GONE);
        img_back.setVisibility(View.GONE);
        switch (view.getId()){
            case R.id.re_rfid:
                img_right.setVisibility(View.VISIBLE);
                index=0;
                txt_title.setText("阅读标签");
                img_right.setImageResource(R.drawable.icon_add);


                break;

            case R.id.re_data:
                index=1;
                txt_title.setText("数据统计");

                img_right.setVisibility(View.VISIBLE);
                img_right.setImageResource(R.drawable.icon_titleaddfriend);


                break;

            case R.id.re_wifi:
                index=2;

                txt_title.setText("WIFI传送");


                break;
            case R.id.re_more:
                index=3;
                img_back.setVisibility(View.VISIBLE);

                txt_title.setText("更多");
        }
        if (currentTabIndex!=index){
            FragmentTransaction trx = getSupportFragmentManager()
                    .beginTransaction();
            trx.hide(fragments[currentTabIndex]);
            if (!fragments[index].isAdded()) {
                trx.add(R.id.fragment_container, fragments[index]);
            }
            trx.show(fragments[index]).commit();
        }
        imagebuttons[currentTabIndex].setSelected(false);
        // 把当前tab设为选中状态
        imagebuttons[index].setSelected(true);
        textviews[currentTabIndex].setTextColor(0xFF999999);
        textviews[index].setTextColor(0xFF45C01A);
        currentTabIndex = index;
    }
}
