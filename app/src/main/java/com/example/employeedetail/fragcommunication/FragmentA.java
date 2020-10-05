package com.example.employeedetail.fragcommunication;

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

public class FragmentA extends Fragment {
    private FragAListener listener;
    private EditText mNameEditText;
    private Button mOkButton;

    public interface FragAListener{
        void inputA(CharSequence input);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.frag_a,container,false);

        mNameEditText=v.findViewById(R.id.et_name);
        mOkButton=v.findViewById(R.id.bt_ok);
        mOkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence input=mNameEditText.getText();
                listener.inputA(input);
            }
        });

        return v;
    }
    public void updateEditText(CharSequence textInput){
        mNameEditText.setText(textInput);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if(context instanceof FragAListener){
            listener=(FragAListener) context;
        }
        else{
            throw new RuntimeException(context.toString() + "must implement FragmentA listener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener=null;
    }
}
