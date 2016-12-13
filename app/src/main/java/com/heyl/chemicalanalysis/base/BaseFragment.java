package com.heyl.chemicalanalysis.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

/**
 * Created by heyl on 2016/12/4.
 */

public class BaseFragment extends Fragment {


    protected FragmentActivity context;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity();
    }

    protected  void showTost(String str){
        Toast.makeText(context,str,Toast.LENGTH_SHORT).show();
    }
}
