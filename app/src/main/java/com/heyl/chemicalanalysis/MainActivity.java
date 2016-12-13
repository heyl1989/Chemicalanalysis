package com.heyl.chemicalanalysis;

import android.content.res.Resources;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.ImageView;

import com.heyl.chemicalanalysis.app.AppConfig;
import com.heyl.chemicalanalysis.base.BaseActivity;
import com.heyl.chemicalanalysis.fragment.ContentFragment;
import com.heyl.chemicalanalysis.fragment.DrawerFragment;
import com.heyl.chemicalanalysis.model.FramentEvent;
import com.heyl.chemicalanalysis.view.DrawerArrowDrawable;
import com.squareup.otto.Subscribe;

import static android.view.Gravity.START;

public class MainActivity extends BaseActivity {

    public DrawerArrowDrawable drawerArrowDrawable;
    private float offset;
    private boolean flipped;
    private DrawerLayout drawer;

    @Override
    protected void initView() {
        AppConfig.getInstance().register(this);
        setContentView(R.layout.activity_main);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        final ImageView imageView = (ImageView) findViewById(R.id.drawer_indicator);
        final Resources resources = getResources();

        drawerArrowDrawable = new DrawerArrowDrawable(resources);
        drawerArrowDrawable.setStrokeColor(resources.getColor(R.color.white));
        imageView.setImageDrawable(drawerArrowDrawable);

        drawer.setDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override public void onDrawerSlide(View drawerView, float slideOffset) {
                offset = slideOffset;

                // Sometimes slideOffset ends up so close to but not quite 1 or 0.
                if (slideOffset >= .995) {
                    flipped = true;
                    drawerArrowDrawable.setFlip(flipped);
                } else if (slideOffset <= .005) {
                    flipped = false;
                    drawerArrowDrawable.setFlip(flipped);
                }

                drawerArrowDrawable.setParameter(offset);
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                if (drawer.isDrawerVisible(START)) {
                    drawer.closeDrawer(START);
                } else {
                    drawer.openDrawer(START);
                }
            }
        });

        initFragment();

    }

    /**
     * 初始化Fragment
     */
    private void initFragment() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = supportFragmentManager
                .beginTransaction();
        transaction.replace(R.id.drawer_content,new DrawerFragment());
        transaction.replace(R.id.view_content,new ContentFragment());
        transaction.commit();
    }

    @Subscribe
    public void onOttoEvent(FramentEvent event){
        if(event.isIfClick()){
            drawer.closeDrawer(START);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppConfig.getInstance().unregister(this);
    }
}
