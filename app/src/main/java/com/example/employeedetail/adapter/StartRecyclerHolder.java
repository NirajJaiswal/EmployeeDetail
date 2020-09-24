package com.example.employeedetail.adapter;

import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.employeedetail.listner.ButtonListener;
import com.example.employeedetail.model.ButtonModel;
import com.example.employeedetail.R;

public class StartRecyclerHolder extends RecyclerView.ViewHolder {
    private Button button;
    public StartRecyclerHolder(@NonNull View itemView) {
        super(itemView);
        button=itemView.findViewById(R.id.bt_recycler_view);
    }
    public void onDataBind(final ButtonModel buttonModel, final ButtonListener buttonListener)
    {
    button.setText(buttonModel.getButtonName());
    button.setId(buttonModel.getButtonId());
    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            buttonListener.clickButton(buttonModel.getButtonId());
        }
    });
    }
}
