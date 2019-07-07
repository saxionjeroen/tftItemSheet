package com.example.tftcheatsheet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.tftcheatsheet.controller.ItemListAdapter;
import com.example.tftcheatsheet.model.CompletedItem;
import com.example.tftcheatsheet.model.Item;
import com.example.tftcheatsheet.model.StatTypes;
import com.example.tftcheatsheet.view.ItemLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView itemLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemLayout = findViewById(R.id.lvItems);
        itemLayout.setAdapter(new ItemListAdapter(this.getBaseContext(),new ArrayList<>(Item.toList())));

        itemLayout.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, Item.getItemById(position).getName(), Toast.LENGTH_SHORT).show();
                Item temp = Item.getItemById(position);
                if (temp!= null)
                {
                    Intent i = new Intent(getBaseContext(),CompletedItems.class);
                    i.putExtra("itemId", position);
                    startActivityForResult(i, 1234);
                }
            }
        });
    }

    static {
        Item bf = new Item(0,"B.F. Sword", R.drawable.bfsword, StatTypes.ATTACK_DAMAGE, 20);
        Item rb = new Item(1,"Recurve Bow", R.drawable.recurve, StatTypes.ATTACK_SPEED, 15);
        Item lr = new Item(2,"Needlessly Large Rod", R.drawable.rod, StatTypes.ABILITY_POWER, 20);
        Item tg = new Item(3,"Tear of the Goddess", R.drawable.tear, StatTypes.MANA, 20);
        Item cv = new Item(4,"Chain vest", R.drawable.chain, StatTypes.ARMOR, 20);
        Item nc = new Item(5,"Negatron Cloak", R.drawable.cloak, StatTypes.MAGIC_RESIST, 20);
        Item gb = new Item(6,"Gaint's belt", R.drawable.belt, StatTypes.HEALTH, 200);
        Item sp = new Item(7,"Spatula", R.drawable.spatula, StatTypes.NONE, 0);

        //bf
        new CompletedItem(0,"Infinity Edge", "Critical Strikes deal +100.0% damage.", R.drawable.infinity, bf, bf);
        new CompletedItem(1,"Sword of the Divine", "Each second, the wearer has a 5.0% chance to gain 100% Critical Strike. ", R.drawable.divine, bf, rb);
        new CompletedItem(2,"Hextech Gunblade", "Heal for 25% of all damage dealt.", R.drawable.gunblade, bf, lr);
        new CompletedItem(3,"Guardian Angel", "Revives champ with 500 HP.", R.drawable.angel, bf, cv);
        new CompletedItem(4,"Spear of Shojin", "After casting, gain 15% of max mana per attack.", R.drawable.shojin, bf, tg);
        new CompletedItem(5,"Youmuu’s Ghostblade", "Wearer is also an Assassin.", R.drawable.yoomuus, bf, sp);
        new CompletedItem(6,"The Bloodthirster", "Attacks heal for 35% of damage.", R.drawable.thirster, bf, nc);
        new CompletedItem(7,"Zeke's Herald", "Adjacent allies gain +10% Attack Speed.", R.drawable.zeke, bf, gb);

        //cv
        new CompletedItem(8,"Locket of the Iron Solari", "On start of combat, adjacent allies get 200 shield.", R.drawable.locket, cv, lr);
        new CompletedItem(9,"Thornmail", "Reflect 35% of damage taken from attacks.", R.drawable.thornmail, cv, cv);
        new CompletedItem(10,"Phantom Dancer", "Wearer dodges all Critical Strikes.", R.drawable.phantom, cv, rb);
        new CompletedItem(11,"Frozen Heart", "Adjacent enemies lose 20% Attack Speed.", R.drawable.heart, cv, tg);
        new CompletedItem(12,"Sword Breaker", "Attacks have a chance to disarm.", R.drawable.swordbreaker, cv, nc);
        new CompletedItem(13,"Red Buff", "Attacks burn for 2.5% max HP and disable healing.", R.drawable.buff, cv, gb);
        new CompletedItem(14,"Knight’s Vow", "Wearer is also a Knight.", R.drawable.knightsvow, cv, sp);

        //gb
        new CompletedItem(15,"Titanic Hydra", "Attacks deal 10% of the wearer's max HP as splash.", R.drawable.titanic, gb, rb);
        new CompletedItem(16,"Morellonomicon", "Spells burn 2.5% of the enemy max HP per second.", R.drawable.nomicon, gb, lr);
        new CompletedItem(17,"Redemption", "On death heal all nearby allies for 1000 HP.", R.drawable.reemption, gb, tg);
        new CompletedItem(18,"Zephyr", "On start of combat banish an enemy.", R.drawable.zephyr, gb, nc);
        new CompletedItem(19,"Warmog's Armor", "Regenerate 3% max Health per second.", R.drawable.warmog, gb, gb);
        new CompletedItem(20,"Frozen Mallet", "Wearer is also a Glacial.", R.drawable.frozenmallet, gb, sp);

        //lr
        new CompletedItem(21,"Guinsoo's Rageblade", "Attacks give 3% Attack Speed. Stacks infinitely.", R.drawable.rageblade, lr, rb);
        new CompletedItem(22,"Rabadon's Deathcap", "Wearer's Ability Damage increased by 50%.", R.drawable.rabadon, lr, lr);
        new CompletedItem(23,"Yuumi", "Wearer is also a Sorcerer.", R.drawable.yuumi, lr, sp);
        new CompletedItem(24,"Ionic Spark", "Whenever an enemy casts a spell they take 200 damage.", R.drawable.spark, lr, nc);
        new CompletedItem(25,"Luden's Echo", "Deal 200 splash damage on ability hit.", R.drawable.luden, lr, tg);

        //nc
        new CompletedItem(26,"Hush", "Attacks have a high chance to Silence.", R.drawable.hush, nc, tg);
        new CompletedItem(27,"Cursed Blade", "Attacks have a low chance to Shrink (-1 enemy star level 1).", R.drawable.cursed, nc, rb);
        new CompletedItem(28,"Runaan's Hurricane", "Attacks hit additional enemies and deal 50% damage.", R.drawable.huricaan, nc, sp);
        new CompletedItem(29,"Dragon's Claw", "83% resistance to magic damage.", R.drawable.claw, nc, nc);

        //rd
        new CompletedItem(30,"Stattik Shiv", "Every 3rd attack deals 100 splash magical damage.", R.drawable.shiv, rb, tg);
        new CompletedItem(31,"Rapid Fire Cannon", "Attacks cannot be dodged. Attack Range is doubled.", R.drawable.cannon, rb, rb);
        new CompletedItem(32,"Blade of the Ruined King", "Wearer is also a Blademaster.", R.drawable.ruinedking, rb, sp);

        //tg
        new CompletedItem(33,"Darkin", "Wearer is also a Demon.", R.drawable.aatrox, sp, tg);
        new CompletedItem(34,"Seraph's Embrace", "Regain 20 mana each time a spell is cast.", R.drawable.seraph, tg, tg);

        //sp
        new CompletedItem(35,"Force of Nature", "Gain + team size.", R.drawable.nature, sp, sp);

    }

}
