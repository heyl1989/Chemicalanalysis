package com.heyl.chemicalanalysis.model;

/**
 * Created by heyl on 2016/12/4.
 */

public class FramentEvent {
    private boolean ifClick;

    public FramentEvent(boolean ifClick) {
        this.ifClick = ifClick;
    }

    public boolean isIfClick() {
        return ifClick;
    }

    public void setIfClick(boolean ifClick) {
        this.ifClick = ifClick;
    }
}
