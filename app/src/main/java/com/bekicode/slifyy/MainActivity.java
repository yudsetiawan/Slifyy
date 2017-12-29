package com.bekicode.slifyy;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navigationView = (NavigationView) findViewById(R.id.navigation_view);

        //Mengatur Navigasi View Item yang akan dipanggil untuk menangani item klik menu navigasi
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            // This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                //Memeriksa apakah item tersebut dalam keadaan dicek  atau tidak,
                if(menuItem.isChecked()) menuItem.setChecked(false);
                else menuItem.setChecked(true);
                //Menutup  drawer item klik
                drawerLayout.closeDrawers();
                //Memeriksa untuk melihat item yang akan dilklik dan melalukan aksi
                switch (menuItem.getItemId()){
                    // pilihan menu item navigasi akan menampilkan pesan toast klik kalian bisa menggantinya
                    //dengan intent activity
                    case R.id.action_profile:
                        Intent profile = new Intent(MainActivity.this, ProfileActivity.class);
                        startActivity(profile);
                        Toast.makeText(getApplicationContext(), "Profile", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.action_history:
                        Intent history = new Intent(MainActivity.this, HistoryActivity.class);
                        startActivity(history);
                        Toast.makeText(getApplicationContext(),"History",Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.action_contactus:
                        Intent contact = new Intent(MainActivity.this, ContactActivity.class);
                        startActivity(contact);
                        Toast.makeText(getApplicationContext(),"Contact",Toast.LENGTH_SHORT).show();
                        return true;
                    default:
                        Toast.makeText(getApplicationContext(),"Error 404?!",Toast.LENGTH_SHORT).show();
                        return true;
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (toggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
