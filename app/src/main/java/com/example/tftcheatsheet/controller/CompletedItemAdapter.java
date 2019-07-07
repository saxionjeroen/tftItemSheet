package com.example.tftcheatsheet.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.tftcheatsheet.R;
import com.example.tftcheatsheet.model.CompletedItem;
import com.example.tftcheatsheet.model.Item;
import com.example.tftcheatsheet.view.ItemLayout;

import java.util.List;

public class CompletedItemAdapter extends ArrayAdapter<CompletedItem> {
    private LayoutInflater inflater;
    private List<CompletedItem> items;
    private Item item;

    public CompletedItemAdapter(Context context, List<CompletedItem> objects, Item item) {
        super(context, R.layout.set_item, objects);
        inflater = LayoutInflater.from(context);
        items = objects;
        this.item = item;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //return super.getView(position, convertView, parent);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.set_item, parent, false);
        }

        CompletedItem itemTemp = items.get(position);

        ItemLayout itemLayout = convertView.findViewById(R.id.ilItem);
        itemLayout.setItem(item, itemTemp);

        return convertView;
    }
}
