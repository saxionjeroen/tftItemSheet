package com.example.tftcheatsheet.view;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.tftcheatsheet.R;
import com.example.tftcheatsheet.model.CompletedItem;
import com.example.tftcheatsheet.model.Item;

public class ItemLayout extends LinearLayout {
    private TextView tvName;
    private TextView tvDesc;
    private TextView tvStats;
    private ImageView ivItem;

    private Item item;
    private CompletedItem completedItem;


    public ItemLayout(Context context) {
        super(context);
        init();
    }

    public ItemLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ItemLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public ItemLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }


    public void init() {
        LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.item_layout, this);

        tvName = findViewById(R.id.tvName2);
        tvDesc = findViewById(R.id.tvDesc);
        tvStats = findViewById(R.id.tvStats);
        ivItem = findViewById(R.id.ivItem);

        tvName.setText("eqweqewqwe");
        tvDesc.setText("eqweqewqwe");
        tvStats.setText("eqweqewqwe");
        ivItem.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.bfsword));
    }

    public void setItem(Item item, CompletedItem completedItem) {
        this.item = item;
        this.completedItem = completedItem;

        if (item != null) {
            tvName.setText(item.getName());
            tvDesc.setText("");
            tvStats.setText("" + item.statDesc());
            ivItem.setImageDrawable(ContextCompat.getDrawable(getContext(), item.getResId()));
        } else {
            tvName.setText(completedItem.getName());
            tvDesc.setText(completedItem.getDescription());
            tvStats.setText(completedItem.statDesc());
            ivItem.setImageDrawable(ContextCompat.getDrawable(getContext(), completedItem.getResId()));
        }
    }

}
