package com.example.employeedetail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CountryAdapter extends ArrayAdapter<CountryItem> {
    private List<CountryItem>countryItems;

   public CountryAdapter(Context context, List<CountryItem> countryItems){
       super(context,0,countryItems);

   }

   @NonNull
   @Override
   public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
       return initView(position,convertView,parent);
   }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position,convertView,parent);
    }

    private View initView(int position, View convertView, ViewGroup parent){
       if(convertView==null) {
           convertView = LayoutInflater.from(getContext()).inflate(R.layout.spinner_country_row, parent, false);
       }
       ImageView imageView=convertView.findViewById(R.id.image_view_flag);
           TextView textView=convertView.findViewById(R.id.text_view_flag);


           CountryItem countryItem= getItem(position);
           if(countryItem!=null) {
               imageView.setImageResource(countryItem.getFlagImage());
               textView.setText(countryItem.getCountryName());
       }


        return convertView;


    }
}
