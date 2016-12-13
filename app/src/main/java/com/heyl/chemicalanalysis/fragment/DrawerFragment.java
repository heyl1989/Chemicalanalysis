package com.heyl.chemicalanalysis.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andexert.library.RippleView;
import com.heyl.chemicalanalysis.MainActivity;
import com.heyl.chemicalanalysis.R;
import com.heyl.chemicalanalysis.app.AppConfig;
import com.heyl.chemicalanalysis.base.BaseFragment;
import com.heyl.chemicalanalysis.model.FramentEvent;

/**
 * A simple {@link Fragment} subclass.
 */
public class DrawerFragment extends BaseFragment {


    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_drawer,container,false);
        initView();
        return view;
    }

    private void initView() {
        RippleView rvGeneral = (RippleView)view.findViewById(R.id.rv_general);
        rvGeneral.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {
            @Override
            public void onComplete(RippleView rippleView) {
                AppConfig.getInstance().post(new FramentEvent(true));
            }
        });
        RippleView rvWater = (RippleView)view.findViewById(R.id.rv_water);
        rvWater.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {
            @Override
            public void onComplete(RippleView rippleView) {
                AppConfig.getInstance().post(new FramentEvent(true));
            }
        });
        RippleView rvSolid = (RippleView)view.findViewById(R.id.rv_solid);
        rvSolid.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {
            @Override
            public void onComplete(RippleView rippleView) {
                AppConfig.getInstance().post(new FramentEvent(true));
            }
        });
    }

}
