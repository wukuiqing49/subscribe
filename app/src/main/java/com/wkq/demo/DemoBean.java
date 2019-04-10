package com.wkq.demo;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

public class DemoBean extends BaseObservable {
    private  String content;

  private   boolean show;

    @Bindable
    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
        notifyPropertyChanged(BR.show);

    }
    @Bindable
    public String getContent() {
        return content;
    }


    public void setContent(String content) {
        this.content = content;
        notifyPropertyChanged(BR.content);
    }
}
