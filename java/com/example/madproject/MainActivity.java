package com.example.madproject;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.example.madproject.model.Car;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView carRecyclerView;
    private BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        carRecyclerView = findViewById(R.id.carRecyclerView);
        bottomNavigation = findViewById(R.id.bottomNavigation);

        // Setup RecyclerView with sample data
        carRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        
        // Sample car data with real image URLs
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("1", "Honda Civic", 15000, 45000, "https://cdn.pixabay.com/photo/2016/11/22/23/44/porsche-1851246_1280.jpg"));
        cars.add(new Car("2", "Toyota Corolla", 18000, 30000, "https://cdn.pixabay.com/photo/2012/11/02/13/02/car-63930_1280.jpg"));
        cars.add(new Car("3", "Ford Mustang", 35000, 15000, "https://cdn.pixabay.com/photo/2012/04/12/23/47/car-30990_1280.jpg"));
        cars.add(new Car("4", "BMW 3 Series", 28000, 20000, "https://cdn.pixabay.com/photo/2015/05/28/23/12/auto-788747_1280.jpg"));
        
        CarAdapter adapter = new CarAdapter(cars, car -> {
            // Handle car item click
            Intent intent = new Intent(MainActivity.this, CarDetailsActivity.class);
            intent.putExtra("car_id", car.getId());
            startActivity(intent);
        });
        carRecyclerView.setAdapter(adapter);

        // Setup bottom navigation
        bottomNavigation.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.nav_home:
                    // Refresh home feed
                    carRecyclerView.smoothScrollToPosition(0);
                    return true;
                case R.id.nav_search:
                    // Show search dialog
                    showSearchDialog();
                    return true;
                case R.id.nav_sell:
                    // Navigate to sell activity
                    startActivity(new Intent(this, SellActivity.class));
                    return true;
                case R.id.nav_profile:
                    // Navigate to profile activity
                    startActivity(new Intent(this, ProfileActivity.class));
                    return true;
            }
            return false;
        });
        
        // Select home by default
        bottomNavigation.setSelectedItemId(R.id.nav_home);
    }
}
