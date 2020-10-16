package com.example.employeedetail.cricket;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.employeedetail.R;
import com.example.employeedetail.model.CricketerDetails;

public class CricketDetailsFragment extends Fragment {
    private View view;
    private TextView mCricketerName,mCricketerAge,mCricketerRole,mCricketerCountry;
    private ImageView mCricketerImage;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      view=inflater.inflate(R.layout.cricket_details_fragment,container,false);
    initView();
    if(getArguments()!=null){
        CricketerDetails cricketerDetails= (CricketerDetails) getArguments().getSerializable("Cricketer");
        getCricketerData(cricketerDetails);
    }
    else{
        Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();
    }

    return view;
    }

    private void initView() {
        mCricketerName=view.findViewById(R.id.cricketer_fullname);
        mCricketerAge=view.findViewById(R.id.cricketer_ageno);
        mCricketerRole=view.findViewById(R.id.cricketer_rollname);
        mCricketerCountry=view.findViewById(R.id.cricketer_countryname);
        mCricketerImage=view.findViewById(R.id.cricketer_image);


    }
    private void getCricketerData(CricketerDetails cricketerDetails){
        mCricketerImage.setImageResource(cricketerDetails.getCricketerImage());
        mCricketerName.setText(cricketerDetails.getCricketerFullName());
        mCricketerRole.setText(cricketerDetails.getCricketerRole());
        mCricketerAge.setText(String.valueOf(cricketerDetails.getCricketerAge()));
        mCricketerCountry.setText(cricketerDetails.getCricketerCountry());
    }
}
