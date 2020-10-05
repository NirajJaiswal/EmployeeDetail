package com.example.employeedetail.navigation;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.employeedetail.R;

public class FragmentNavigation extends Fragment {
    private FragNavigationListener listener;
    private EditText mTextEditText;
    private Button mSubmitButton;

    public interface FragNavigationListener{
        void printText(String input);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_navigation,container,false);
        mTextEditText=v.findViewById(R.id.et_editText);
        mSubmitButton=v.findViewById(R.id.bt_Submit);
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input=mTextEditText.getText().toString();
                listener.printText(input);

            }
        });
        return v;
    }



    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if(context instanceof FragNavigationListener){
            listener=(FragNavigationListener) context;
        }
        else{
            throw new RuntimeException(context.toString() + "not executed");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener=null;
    }
}
