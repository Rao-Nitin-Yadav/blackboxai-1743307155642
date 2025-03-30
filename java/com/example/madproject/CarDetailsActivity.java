package com.example.madproject;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.madproject.model.Car;

public class CarDetailsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_details);

        // Get car ID from intent
        String carId = getIntent().getStringExtra("car_id");
        
        // TODO: Fetch actual car details based on ID
        Car car = new Car(carId, "Sample Car", 20000, 25000, "https://example.com/car.jpg");
        
        // Initialize views
        ImageView carImage = findViewById(R.id.carImage);
        TextView carModel = findViewById(R.id.carModel);
        TextView carPrice = findViewById(R.id.carPrice);
        TextView carMileage = findViewById(R.id.carMileage);
        
        // Set car details with Glide
        Glide.with(this)
            .load(car.getImageUrl())
            .placeholder(R.drawable.ic_car_placeholder)
            .error(R.drawable.ic_car_error)
            .into(carImage);
        carModel.setText(car.getModel());
        carPrice.setText(getString(R.string.price_label, car.getPrice()));
        carMileage.setText(getString(R.string.mileage_label, car.getMileage()));
    }
}