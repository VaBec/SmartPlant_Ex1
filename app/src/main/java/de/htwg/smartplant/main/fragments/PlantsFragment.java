package de.htwg.smartplant.main.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONException;

import java.io.UnsupportedEncodingException;
import java.util.List;

import de.htwg.smartplant.R;
import de.htwg.smartplant.main.MainPresenter;
import de.htwg.smartplant.main.recycler.PlantsAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlantsFragment extends Fragment implements MainPresenter.IPlantsView {

private View view;
private RecyclerView recyclerView;
PlantsAdapter plantsAdapter;
private List<Object> data;
    public PlantsFragment() throws UnsupportedEncodingException, JSONException {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_plants, container, false);
        setUpRecycler(view);
        return view;
    }

    private void setUpRecycler(View view){
        recyclerView = (RecyclerView)view.findViewById(R.id.recycler_plants);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    public void addPlantsData(List<String> plants) {
        plantsAdapter = new PlantsAdapter(plants);
        recyclerView.setAdapter(plantsAdapter);
    }

//    private Object getPlants() throws UnsupportedEncodingException, JSONException {
//        MainActivity activity = (MainActivity) getActivity();
//        return activity.getPlants();
//    }

//    private void loadPlants() throws UnsupportedEncodingException, JSONException {
//        List<String> plants = null;
//        MainPresenter.IMainActivity mainActivity = (MainActivity) getActivity();
//        if (mainActivity != null) {
//                mainActivity.getPlants();
//        }
//    }
//
//    private void refreshAdapter() {
//        plantsAdapter.updateData(data);
//        plantsAdapter.notifyDataSetChanged();
//    }
}
