package com.example.tftcheatsheet.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.tftcheatsheet.R;
import com.example.tftcheatsheet.model.Item;
import com.example.tftcheatsheet.view.ItemLayout;

import java.util.List;

public class ItemListAdapter extends ArrayAdapter<Item> {
    private LayoutInflater inflater;
    private List<Item> items;

    public ItemListAdapter(Context context, List<Item> objects) {
        super(context, R.layout.set_item, objects);
        inflater = LayoutInflater.from(context);
        items = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //return super.getView(position, convertView, parent);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.set_item, parent, false);
        }

        Item itemTemp = items.get(position);

        ItemLayout itemLayout = convertView.findViewById(R.id.ilItem);
        itemLayout.setItem(itemTemp, null);

        return convertView;
    }
}
