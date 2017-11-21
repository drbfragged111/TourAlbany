package com.example.brandonkbarnes.touralbany;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 */
public class FamilyAttractionsFragment extends Fragment {


    public FamilyAttractionsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.attraction_list, container, false);

        // Create a list of restaurants
        final ArrayList<Attractions> attraction = new ArrayList<Attractions>();
        attraction.add(new Attractions(R.string.zero, R.string.zero_contact, R.string.zero_desc, R.string.slater_loc));
        attraction.add(new Attractions(R.string.ge, R.string.ge_contact, R.string.ge_desc, R.string.slater_loc));
        attraction.add(new Attractions(R.string.aiha, R.string.aiha_contact, R.string.aiha_desc, R.string.slater_loc));
        attraction.add(new Attractions(R.string.funplex, R.string.funplex_contact, R.string.funplex_desc, R.string.slater_loc));


        // Create an {@link AttractionsAdapter}, whose data source is a list of {@link Attractions}s. The
        // adapter knows how to create list items for each item in the list.
        AttractionsAdapter adapter = new AttractionsAdapter(getActivity(), attraction, R.color.family);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // attraction_list.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link AttractionsAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Attractions} in the list.
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Get the {@link Attractions} object at the given position the user clicked on
                Attractions attractions = attraction.get(position);
                double latitude = 42.689319;
                double longitude = -73.850338;

                //Open map app to the address
                String uri = String.format(Locale.ENGLISH, "geo:%f,%f", latitude, longitude);
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent);
            }
        });

        return rootView;
    }

}
