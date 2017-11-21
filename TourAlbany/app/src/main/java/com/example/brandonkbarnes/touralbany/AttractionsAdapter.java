package com.example.brandonkbarnes.touralbany;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Brandon on 11/20/2017.
 */

public class AttractionsAdapter extends ArrayAdapter<Attractions>{
    private int mColorResourceId;

    public AttractionsAdapter(Context context, ArrayList<Attractions> pAttractions, int colorResourceId) {
        super(context,0, pAttractions);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        Attractions local_attraction = getItem(position);
        TextView name = (TextView) listItemView.findViewById(R.id.name);
        name.setText(local_attraction.getName());
        TextView contact = (TextView) listItemView.findViewById(R.id.contact);
        contact.setText(local_attraction.getContact());
        TextView description = (TextView) listItemView.findViewById(R.id.description);
        description.setText(local_attraction.getDescription());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);

        if(local_attraction.hasImage()){
            imageView.setImageResource(local_attraction.getImageResourceId());
        }
        else {
            imageView.setVisibility(View.GONE);
        }

        View textContainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        textContainer.setBackgroundColor(color);

        return listItemView;
    }
}
