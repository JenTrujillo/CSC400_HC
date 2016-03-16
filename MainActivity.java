package com.healthycocktails.trujillo.healthycocktails;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

    //Reference
    ListView menuItems;
    //Initialize Array
    String[] items = {"Bartending Guide", "Recipes", "Favorites", "My Recipes", "Info"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //List view name in Activity_main.xml is "menu_List"
        //menuItems = getListView();
        menuItems = (ListView)findViewById(R.id.menu_List);
        //Initialize adapter object
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(menuItems.getContext(), android.R.layout.simple_list_item_1, items);
        //menuItems.getContext or this, android.R.Layout.... (how it is going to appear), what it is going to appear
        menuItems.setAdapter(adapter);

        //calls method
        menuItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        //menuItems.setOnClickListener(onItemClick);


       // private AdapterView.OnItemClickListener onItemClick = new AdapterView.OnItemClickListener(){
            @Override
            //public void AdapterView.OnItemClickListener(AdapterView<?> parent, View v, int position, long id) {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {
                switch (position)
                {
                    case 0:
                        //Bartending Guide Item
                        Intent guideInt = new Intent(MainActivity.this, GuideActivity.class);
                        startActivity(guideInt);
                    case 1:
                        //Recipes Item
                        Intent recipesInt = new Intent(MainActivity.this, RecipesActivity.class);
                        startActivity(recipesInt);
                    case 2:
                        //Favorites Item
                        Intent favInt = new Intent(MainActivity.this, FavoriteActivity.class);
                        startActivity(favInt);
                    case 3:
                        //My Recipes Item
                        Intent myRecInt = new Intent(MainActivity.this, MyRecipesActivity.class);
                        startActivity(myRecInt);

                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
