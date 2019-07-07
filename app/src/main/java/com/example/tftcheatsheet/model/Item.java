package com.example.tftcheatsheet.model;

import com.example.tftcheatsheet.R;

import java.util.HashSet;
import java.util.Set;

public class Item {


    private final int id;
    private final String name;
    private final int resId;
    private final StatTypes statTypes;
    private final int statTypeAmount;

    private static Set<Item> items = new HashSet<>();
    private Set<CompletedItem> componentOf = new HashSet<>();

    public Item(int id, String name, int resId, StatTypes statTypes, int statTypeAmount) {
        this.id = id;
        this.name = name;
        this.resId = resId;
        this.statTypes = statTypes;
        this.statTypeAmount = statTypeAmount;

        items.add(this);
    }

    public String getName() {
        return name;
    }

    public int getResId() {
        return resId;
    }

    public StatTypes getStatTypes() {
        return statTypes;
    }

    public int getStatTypeAmount() {
        return statTypeAmount;
    }

    public static Set<Item> getItems() {
        return items;
    }

    boolean addEndItem(CompletedItem completedItem){
        int tempSize = componentOf.size();
        componentOf.add(completedItem);
        return tempSize + 1 == componentOf.size();
    }

    public int getId() {
        return id;
    }

    public Set<CompletedItem> getComponentOf() {
        return componentOf;
    }

    public static Item getItemById(int id){
        for(Item i: Item.getItems()){
            if (i.getId() == id) return i;
        }

        return null;
    }

    public String statDesc(){
        if (getStatTypes() == StatTypes.NONE){
            return "NONE" ;
        }
        return "" + this.getStatTypes().toString() + ": " + this.getStatTypeAmount();
    }

    @Override
    public String toString() {
        return
                "name='" + name ;
    }



}


