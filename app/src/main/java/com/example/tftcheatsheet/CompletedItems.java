package com.example.tftcheatsheet;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.tftcheatsheet.controller.CompletedItemAdapter;
import com.example.tftcheatsheet.model.CompletedItem;
import com.example.tftcheatsheet.model.Item;
import com.example.tftcheatsheet.view.ItemLayout;

import java.util.ArrayList;
import java.util.List;

public class CompletedItems extends AppCompatActivity {

    private ItemLayout itemLayout;
    private ListView listView;
    private android.app.ActionBar actionBar;
    private Item item;
    private List<CompletedItem> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_completed_items);

        actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        itemLayout = findViewById(R.id.ilCItem);
        listView = findViewById(R.id.lvCItem);

        Intent intent = getIntent();
        if (intent != null) {
            int id = intent.getIntExtra("itemId", 8);
            if (id < 8) {
                item = Item.getItemById(id);
                itemLayout.setItem(item,null);
                list = new ArrayList<>(item.getComponentOf());
                listView.setAdapter(new CompletedItemAdapter(getBaseContext(), list, item));

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        CompletedItem.toList(item.getComponentOf()).get(position);
                        CompletedItem c = list.get(position);
                        Toast.makeText(CompletedItems.this, c.getName() + ": build from : " + c.getComponentTwo().getName() + " & " + c.getComponentOne().getName() , Toast.LENGTH_LONG).show();
                        finish();
                    }
                });
            }
        }


    }

}
