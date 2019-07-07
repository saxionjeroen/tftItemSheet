package com.example.tftcheatsheet.model;

import android.util.Log;

import com.example.tftcheatsheet.R;

import java.util.HashSet;
import java.util.Set;

public class CompletedItem {
    private final String description;
    private final String name;
    private final int resId;
    private final int id;

    private final Item componentOne;
    private final Item componentTwo;


    private static Set<CompletedItem> completedItems = new HashSet<>();

    public CompletedItem(int id, String name, String description, int resId, Item componentOne, Item componentTwo) {
        this.id = id;
        this.description = description;
        this.name = name;
        this.resId = resId;
        this.componentOne = componentOne;
        this.componentTwo = componentTwo;

        componentOne.addEndItem(this);
        componentTwo.addEndItem(this);

        completedItems.add(this);
    }

    public String getName() {
        return name;
    }

    public int getResId() {
        return resId;
    }

    public String getDescription() {
        return description;
    }

    public Item getComponentOne() {
        return componentOne;
    }

    public Item getComponentTwo() {
        return componentTwo;
    }

    public int getId() {
        return id;
    }

    public static Set<CompletedItem> getCompletedItems() {
        return completedItems;
    }

    public String statDesc() {
        if (getComponentOne().getStatTypes() == StatTypes.NONE && getComponentTwo().getStatTypes() == StatTypes.NONE) {
            return "";
        } else if (getComponentOne().getStatTypes() == StatTypes.NONE) {
            return getComponentTwo().statDesc();
        } else if (getComponentTwo().getStatTypes() == StatTypes.NONE) {
            return getComponentOne().statDesc();
        }
        return "" + getComponentOne().statDesc() + ", " + getComponentTwo().statDesc();
    }

    public static CompletedItem getItemById(int id) {
        for (CompletedItem i : getCompletedItems()) {
            if (i.getId() == id) return i;
        }

        return null;
    }
}
