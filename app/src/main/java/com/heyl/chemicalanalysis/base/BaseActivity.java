package com.heyl.chemicalanalysis.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

/**
 * Created by heyl on 2016/12/4.
 */

public abstract class BaseActivity extends FragmentActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    protected abstract void initView();

    /**
     * 吐司
     */
    protected void showTost(String str){
        Toast.makeText(this,str,Toast.LENGTH_SHORT).show();
    }
}
