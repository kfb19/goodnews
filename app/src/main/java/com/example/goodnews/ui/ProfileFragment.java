package com.example.goodnews.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.goodnews.R;
import com.example.goodnews.User;
import com.example.goodnews.UserLocal;
import com.example.goodnews.ui.login.LoginActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment implements View.OnClickListener{

    Button bLogout;
    EditText etName, etEmailAddress;
    UserLocal localStore;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        etName = (EditText) getView().findViewById(R.id.person_name);
        etEmailAddress = (EditText) getView().findViewById(R.id.email);
        bLogout = (Button) getView().findViewById(R.id.logout);
        bLogout.setOnClickListener(this);
        localStore = new UserLocal((LoginActivity) getActivity());
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        if (authenticate() == true){
            displayUserDetails();;
        }
    }

    private boolean authenticate() {
        return localStore.getUserLoggedIn();
    }

    private void displayUserDetails() {
        User user = localStore.getLoggedInUser();
        etName.setText(user.name);
        etEmailAddress.setText(user.email_address);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.logout:
                localStore.clearUserData();
                localStore.setUserLoggedIn(false);
                break;
        }
    }
}