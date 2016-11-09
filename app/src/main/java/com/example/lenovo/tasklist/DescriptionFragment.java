package com.example.lenovo.tasklist;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DescriptionFragment extends Fragment{

    TextView textView;
    public DescriptionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_description, container, false);
        textView=(TextView)view.findViewById(R.id.textView);
        Bundle bundle=getArguments();
        String desc=bundle.getString("Desc");
        textView.setText(desc);
        return view;
    }

}
