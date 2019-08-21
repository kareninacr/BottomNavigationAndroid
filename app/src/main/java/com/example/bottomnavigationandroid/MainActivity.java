package com.example.bottomnavigationandroid;

import android.os.Bundle;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private TextView mTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFragment(new HomeFragment());
        BottomNavigationView nav= findViewById(R.id.navigation);
        nav.setOnNavigationItemSelectedListener(this);
    }

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragment = new HomeFragment();
                    break;

                case R.id.navigation_dashboard:
                    fragment = new DashboardFragment();
                    break;

                case R.id.navigation_notifications:
                    fragment = new NotificationFragment();
                    break;

                case(R.id.navigation_profile):
                    fragment = new ProfileFragment();
                    break;
            }
            return loadFragment(fragment);
        }

        private boolean loadFragment(Fragment fragment) {
            if (fragment != null) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, fragment)
                        .commit();
                return  true;
            }
            return false;
    }



}
