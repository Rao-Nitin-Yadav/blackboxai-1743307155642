package com.example.madproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.CarViewHolder> {
    private List<Car> carList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Car car);
    }

    public CarAdapter(List<Car> carList, OnItemClickListener listener) {
        this.carList = carList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_car, parent, false);
        return new CarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarViewHolder holder, int position) {
        Car car = carList.get(position);
        holder.bind(car, listener);
    }

    @Override
    public int getItemCount() {
        return carList.size();
    }

    public static class CarViewHolder extends RecyclerView.ViewHolder {
        ImageView carImage;
        TextView carTitle;
        TextView carPrice;
        TextView carMileage;
        Button viewDetailsBtn;

        public CarViewHolder(@NonNull View itemView) {
            super(itemView);
            carImage = itemView.findViewById(R.id.carImage);
            carTitle = itemView.findViewById(R.id.carTitle);
            carPrice = itemView.findViewById(R.id.carPrice);
            carMileage = itemView.findViewById(R.id.carMileage);
            viewDetailsBtn = itemView.findViewById(R.id.viewDetailsBtn);
        }

        public void bind(final Car car, final OnItemClickListener listener) {
            carTitle.setText(car.getModel());
            carPrice.setText(String.format(itemView.getContext().getString(R.string.price_label), car.getPrice()));
            carMileage.setText(String.format(itemView.getContext().getString(R.string.mileage_label), car.getMileage()));
            
            // Load image with Glide
            Glide.with(itemView.getContext())
                .load(car.getImageUrl())
                .placeholder(R.drawable.ic_car_placeholder)
                .error(R.drawable.ic_car_error)
                .into(carImage);
            
            viewDetailsBtn.setOnClickListener(v -> listener.onItemClick(car));
        }
    }
}