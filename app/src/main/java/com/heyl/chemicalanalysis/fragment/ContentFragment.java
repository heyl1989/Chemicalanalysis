package com.heyl.chemicalanalysis.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.heyl.chemicalanalysis.ContentActivity;
import com.heyl.chemicalanalysis.R;
import com.heyl.chemicalanalysis.adapter.ContentAdapter;
import com.heyl.chemicalanalysis.base.BaseFragment;
import com.heyl.chemicalanalysis.dao.GeneralDao;
import com.heyl.chemicalanalysis.model.ContentModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContentFragment extends BaseFragment {

    private View view;
    private ListView lvContent;
    private List<ContentModel> mList = new ArrayList();
    private ContentAdapter contentAdapter;

    public ContentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_content, container, false);
        initView();
        return view;
    }

    private void initView() {
        lvContent = (ListView) view.findViewById(R.id.lv_content);
        contentAdapter = new ContentAdapter(context, mList);
        lvContent.setAdapter(contentAdapter);

        initData();
    }

    private void initData() {
        mList.addAll(GeneralDao.gereralData());
        contentAdapter.notifyDataSetChanged();
    }

}
