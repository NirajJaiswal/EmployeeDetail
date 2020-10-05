package com.example.employeedetail.navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.employeedetail.R;

public class FragmentNavigate extends Fragment {
    private TextView mNameTextView;
private View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view =inflater.inflate(R.layout.fragment_navigate,container,false);
        initValue();
        String data=getArguments().getString("id");
        if(data!=null)
        {
            mNameTextView.setText(data);
        }
        return view;

    }



    private void initValue() {
        mNameTextView=view.findViewById(R.id.et_text);

    }


}
