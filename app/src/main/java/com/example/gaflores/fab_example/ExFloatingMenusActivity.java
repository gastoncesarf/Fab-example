package com.example.gaflores.fab_example;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

import java.util.ArrayList;
import java.util.List;

public class ExFloatingMenusActivity extends AppCompatActivity {

    private FloatingActionButton fab1;
    private FloatingActionButton fab2;
    private FloatingActionButton fab3;

    private FloatingActionButton fab12;
    private FloatingActionButton fab22;
    private FloatingActionButton fab32;

    private List<FloatingActionMenu> menus = new ArrayList<>();
    private Handler mUiHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex_floating_menus_activity);

        ListView lv = (ListView) findViewById(R.id.lst);
        List<String> your_array_list = new ArrayList<String>();
        for(int i = 0; i < 50; i++){
            your_array_list.add(Integer.toString(i));
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                your_array_list );

        lv.setAdapter(arrayAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(view.getContext(), Integer.toString(position), Toast.LENGTH_SHORT).show();
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final FloatingActionMenu menu1 = (FloatingActionMenu) findViewById(R.id.menu1);

        final View.OnClickListener menuListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),v.toString(),Toast.LENGTH_SHORT).show();
            }
        };
        final FloatingActionButton fab01 = (FloatingActionButton) findViewById(R.id.fb_01);
        final FloatingActionButton fab02 = (FloatingActionButton) findViewById(R.id.fb_02);
        final FloatingActionButton fab03 = (FloatingActionButton) findViewById(R.id.fb_03);
        fab01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "FAB_1 clicked!", Toast.LENGTH_SHORT).show();
            }
        });
        fab02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "FAB_2 clicked!", Toast.LENGTH_SHORT).show();
            }
        });
        fab03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "FAB_3 clicked!", Toast.LENGTH_SHORT).show();
            }
        });
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Button clicked!", Toast.LENGTH_SHORT).show();
            }
        });

        final Drawable fabMenuBackground = menu1.getBackground();
        menu1.setOnMenuToggleListener(new FloatingActionMenu.OnMenuToggleListener() {
            @Override
            public void onMenuToggle(boolean opened) {
                if (opened) {
                    Toast.makeText(getApplicationContext(), "Open", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Close", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
