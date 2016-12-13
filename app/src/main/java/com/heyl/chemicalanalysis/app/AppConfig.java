package com.heyl.chemicalanalysis.app;

import com.squareup.otto.Bus;

/**
 * Created by heyl on 2016/12/4.
 */

public class AppConfig {
    private static final Bus BUS = new Bus();
    public static Bus getInstance() {
        return BUS;
    }
}
