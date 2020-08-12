package com.example.tiku32_36.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tiku32_36.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.change)
    ImageView change;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.title1)
    TextView title1;
    @BindView(R.id.navigation_view)
    NavigationView navigationView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        title.setText("主界面");
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Class myClass = null;
                switch (menuItem.getItemId()) {
                    case R.id.dtcx:
                        myClass = Z_DTCXActivity.class;
                        break;
                    case R.id.gslk:
                        myClass = Z_GSLKActivity.class;
                        break;
                    case R.id.gsetc:
                        myClass = Z_GSETCActivity.class;
                        break;
                    case R.id.lxxx:
                        myClass = Z_LXXXActivity.class;
                        break;
                    case R.id.tqxx:
                        myClass = Z_TQXXActivity.class;
                        break;
                }
                if (myClass != null) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                    startActivity(new Intent(MainActivity.this, myClass));
                }
                return false;
            }
        });
    }

    @OnClick(R.id.change)
    public void onViewClicked() {
        drawerLayout.openDrawer(GravityCompat.START);
    }
}
