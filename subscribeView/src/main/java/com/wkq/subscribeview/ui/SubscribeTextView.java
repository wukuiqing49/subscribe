package com.wkq.subscribeview.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.wkq.subscribeview.R;
import com.wkq.subscribeview.databinding.LayoutSubscribeViewBinding;

public class SubscribeTextView extends FrameLayout implements TextWatcher, View.OnClickListener {
    //字体颜色
    private int textColor;
    //文字
    private String text;
    //背景
    private Drawable textBg;
    //字体大小
    private float textSize;
    private LayoutSubscribeViewBinding binding;

    public SubscribeTextView(Context context) {
        this(context, null);
    }

    public SubscribeTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SubscribeTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.subscribe);
        textColor = typedArray.getColor(R.styleable.subscribe_textColor, Color.BLACK);
        text = typedArray.getString(R.styleable.subscribe_textContet);
        textBg = typedArray.getDrawable(R.styleable.subscribe_spBackground);
        textSize = typedArray.getDimension(R.styleable.subscribe_textSize, 15);
        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.layout_subscribe_view, this, true);
        hideLoading();
        binding.tv.setText(text);
        binding.tv.addTextChangedListener(this);
        binding.root.setOnClickListener(this);
        binding.tv.setTextColor(textColor);
        binding.tv.setTextSize(textSize);
        setSpBackground(textBg);
    }


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        hideLoading();
    }

    @Override
    public void onClick(View v) {
        showLoading();
    }

    public void showLoading() {
        binding.pb.setVisibility(VISIBLE);
        binding.tv.setVisibility(GONE);
    }

    public void hideLoading() {
        binding.pb.setVisibility(GONE);
        binding.tv.setVisibility(VISIBLE);
    }

    public void setTextContet(String content) {
        hideLoading();
        binding.tv.setText(content);
    }

    public String geTextContet() {
        return binding.tv.getText() == null ? "" : binding.tv.getText().toString();
    }

    public void setSpBackground(Drawable res) {
        binding.root.setBackgroundDrawable(res);
    }

    public Drawable getSpBackground() {
        return binding.root.getBackground();
    }

    public  void setTextColor(int color){
        binding.tv.setTextColor(color);
    }
}
