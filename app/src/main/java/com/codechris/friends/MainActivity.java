package com.codechris.friends;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Switch;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentManager fragmentManager = getSupportFragmentManager();
        if(fragmentManager.findFragmentById(android.R.id.content) == null){
            FriendsListFragment friendsListFragment = new FriendsListFragment();
            fragmentManager.beginTransaction().add(android.R.id.content, friendsListFragment).commit();
        }
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        Switch(item.getItemId()){
            case R.id.addRecord:
                Intent intent = new Intent(MainActivity.this, addActivity.class);
                startActivity(intent);
                break;
            case R.id.deleteDatabase:
               FriendsDialog dialog = new FriendsDialog();
                Bundle arg = new Bundle();
                arg.putString(FriendsDialog.DIALOG_TYPE, FriendsDialog.DELETE_DATABASE);
                dialog.setArguments();
                dialog.show(getSupportFragmentManager(), "delete-database");
                break;

            case R.id.searchRecords:
                Intent searchIntent = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(searchIntent);
        }


        return super.onOptionsItemSelected(item);
    }
}
