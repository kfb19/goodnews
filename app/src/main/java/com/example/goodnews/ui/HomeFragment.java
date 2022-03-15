package com.example.goodnews.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.goodnews.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        // Inflate the layout for this fragment
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        NewsData[] NewsData = new NewsData[] {
                new NewsData("Email", android.R.drawable.ic_dialog_email),
                new NewsData("Info", android.R.drawable.ic_dialog_info),
                new NewsData("Delete", android.R.drawable.ic_delete),
                new NewsData("Dialer", android.R.drawable.ic_dialog_dialer),
                new NewsData("Alert", android.R.drawable.ic_dialog_alert),
                new NewsData("Map", android.R.drawable.ic_dialog_map),
                new NewsData("Email", android.R.drawable.ic_dialog_email),
                new NewsData("Info", android.R.drawable.ic_dialog_info),
                new NewsData("Delete", android.R.drawable.ic_delete),
                new NewsData("Dialer", android.R.drawable.ic_dialog_dialer),
                new NewsData("Alert", android.R.drawable.ic_dialog_alert),
                new NewsData("Map", android.R.drawable.ic_dialog_map),
        };

        RecyclerView recyclerView = view.findViewById(R.id.recycle_news);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        recyclerView.setHasFixedSize(true);
        NewsDataAdapter adapter = new NewsDataAdapter(NewsData);
        recyclerView.setAdapter(adapter);


        return inflater.inflate(R.layout.fragment_home, container, false);
    }

}