package com.emilg1101.closingcard;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by emilg1101 on 01.02.18.
 * ClosingCard
 */

public class ClosingCard extends CardView {

    private ImageView closeImageView;

    private TextView titleTextView;

    private Button button;

    private View rootView;

    private OnCloseListener onCloseListener = null;
    private OnButtonClickListener onButtonClickListener = null;

    private Theme buttonTheme = Theme.GREEN;

    private int layout = 0;
    private int closeColor = R.color.iron;
    private int backgroundColor = R.color.white;

    private float elevation = 3f;
    private float cornerRadius = 10f;

    private boolean buttonVisible = false;
    private boolean buttonEnabled = true;

    private String title = "TITLE";
    private String buttonText = "BUTTON";

    public ClosingCard(Context context) {
        super(context);
        init(context);
    }

    public ClosingCard(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ClosingCard(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        rootView = inflate(context, R.layout.view_closing_card, this);

        closeImageView = rootView.findViewById(R.id.closeImageView);

        titleTextView = rootView.findViewById(R.id.titleTextView);

        button = rootView.findViewById(R.id.button);

        closeImageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                close();
            }
        });

        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onButtonClickListener != null) {
                    onButtonClickListener.onClick();
                }
            }
        });

        update();
    }

    @SuppressLint("ResourceAsColor")
    private void update() {
        setBackgroundColor(backgroundColor);
        setCardElevation(elevation);
        setRadius(cornerRadius);
        setTitle(title);
        setFocusable(false);
        setClickable(false);
        setCloseIconColor(closeColor);
        setLayout(layout);
        setButtonTheme(buttonTheme);
        setButtonText(buttonText);
        setButtonEnabled(buttonEnabled);
        setButtonVisible(buttonVisible);
    }

    public void setTitle(String title) {
        titleTextView.setText(title);
    }

    @SuppressLint("ResourceType")
    public void setBackgroundColor(int color) {
        color = getContext().getResources().getColor(color);
        super.setCardBackgroundColor(color);
    }

    public void setCornerRadius(float radius) {
        setRadius(radius);
    }

    public void setLayout(int layout) {
        if (layout == 0) return;
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layoutRootView = layoutInflater.inflate(layout, null);

        ViewGroup viewGroup = (ViewGroup) rootView;
        viewGroup = (ViewGroup) viewGroup.getChildAt(0);
        viewGroup = (ViewGroup) viewGroup.getChildAt(1);
        viewGroup.addView(layoutRootView);
    }

    public void setButtonTheme(Theme theme) {
        setButtonTextColor(theme.textColor);
        setButtonBackgroundColor(theme.backgroundColor);
    }

    public void setButtonTextColor(int color) {
        button.setTextColor(color);
    }

    public void setButtonTextColor(ColorStateList colors) {
        button.setTextColor(colors);
    }

    public void setButtonBackgroundColor(int color) {
        button.setBackgroundColor(color);
    }

    public void setButtonBackgroundResource(int resid) {
        button.setBackgroundResource(resid);
    }

    public void setButtonText(String text) {
        button.setText(text);
    }

    public void setButtonVisible(boolean visible) {
        button.setVisibility(visible? VISIBLE : GONE);
    }

    public void setButtonEnabled(boolean enabled) {
        button.setEnabled(enabled);
    }

    @Deprecated
    public void setTextSize(float size) {
        titleTextView.setTextSize(size);
    }

    public void setCloseIconColor(int resid) {
        closeImageView.setColorFilter(getContext().getResources().getColor(resid));
    }

    public void setOnCloseListener(OnCloseListener closeListener) {
        this.onCloseListener = closeListener;
    }

    public void setOnButtonClickListener(OnButtonClickListener buttonClickListener) {
        this.onButtonClickListener = buttonClickListener;
    }

    public Button getButton() {
        return button;
    }

    public void close() {
        if (onCloseListener != null) {
            onCloseListener.onClose(rootView);
        }
    }

    public Builder newBuilder() {
        return new Builder();
    }

    public interface OnCloseListener {
        void onClose(View view);
    }

    public interface OnButtonClickListener {
        void onClick();
    }

    public class Builder {

        private Builder() {

        }

        public Builder setTitle(String title) {
            ClosingCard.this.title = title;
            return this;
        }

        public Builder setLayout(int layout) {
            ClosingCard.this.layout = layout;
            return this;
        }

        public Builder setElevation(float elevation) {
            ClosingCard.this.elevation = elevation;
            return this;
        }

        public Builder setCornerRadius(float radius) {
            ClosingCard.this.cornerRadius = radius;
            return this;
        }

        public Builder setButton(String text, OnButtonClickListener onButtonClickListener) {
            ClosingCard.this.buttonVisible = true;
            if (text != null) ClosingCard.this.buttonText = text;
            ClosingCard.this.onButtonClickListener = onButtonClickListener;
            return this;
        }

        public Builder setButton(String text, Theme theme, OnButtonClickListener onButtonClickListener) {
            if (theme != null) ClosingCard.this.buttonTheme = theme;
            return setButton(text, onButtonClickListener);
        }

        public Builder setButtonEnabled(boolean enabled) {
            ClosingCard.this.buttonEnabled = enabled;
            return this;
        }

        public Builder setCloseColor(int res) {
            ClosingCard.this.closeColor = res;
            return this;
        }

        public Builder setOnCloseListener(OnCloseListener onCloseListener) {
            ClosingCard.this.onCloseListener = onCloseListener;
            return this;
        }

        public ClosingCard build() {
            ClosingCard.this.update();
            return ClosingCard.this;
        }
    }
}