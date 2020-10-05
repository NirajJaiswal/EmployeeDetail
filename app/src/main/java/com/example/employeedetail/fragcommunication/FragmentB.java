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

public class FragmentB extends Fragment {
   private FragBListener listener;
    private EditText mTextEditText;
    private Button mSubmitButton;

    public interface FragBListener{
        void inputB(CharSequence input2);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.frag_b,container,false);
        mTextEditText=v.findViewById(R.id.et_name2);
        mSubmitButton=v.findViewById(R.id.bt_submit);
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence input2=mTextEditText.getText();
                listener.inputB(input2);
            }
        });
        return  v;
    }
public void updateEditText(CharSequence word){
        mTextEditText.setText(word);
}
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof FragBListener){
            listener=(FragBListener) context;
        }
        else{
            throw new RuntimeException(context.toString() + "must implement FragmentB Listener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener=null;
    }
}
