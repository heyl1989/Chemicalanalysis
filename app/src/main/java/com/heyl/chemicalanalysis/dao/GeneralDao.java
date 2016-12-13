package com.heyl.chemicalanalysis.dao;

import com.heyl.chemicalanalysis.R;
import com.heyl.chemicalanalysis.app.MyApplication;
import com.heyl.chemicalanalysis.model.ContentModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by heyl on 2016/12/4.
 */

public class GeneralDao {

    public static List<ContentModel> gereralData(){
        List<ContentModel> list = new ArrayList<>();
        list.add(new ContentModel(MyApplication.getInstance().getResources().getString(R.string.reagent)));
        list.add(new ContentModel(MyApplication.getInstance().getResources().getString(R.string.water)));
        list.add(new ContentModel(MyApplication.getInstance().getResources().getString(R.string.solution)));
        list.add(new ContentModel(MyApplication.getInstance().getResources().getString(R.string.solid_solution)));
        list.add(new ContentModel(MyApplication.getInstance().getResources().getString(R.string.water_solution)));
        list.add(new ContentModel(MyApplication.getInstance().getResources().getString(R.string.water_bath)));
        list.add(new ContentModel(MyApplication.getInstance().getResources().getString(R.string.burn_dry)));
        list.add(new ContentModel(MyApplication.getInstance().getResources().getString(R.string.dry_filtration)));
        list.add(new ContentModel(MyApplication.getInstance().getResources().getString(R.string.about)));
        list.add(new ContentModel(MyApplication.getInstance().getResources().getString(R.string.weighing)));
        list.add(new ContentModel(MyApplication.getInstance().getResources().getString(R.string.other)));
        return list;
    }
}
