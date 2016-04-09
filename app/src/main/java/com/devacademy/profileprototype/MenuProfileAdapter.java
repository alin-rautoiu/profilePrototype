package com.devacademy.profileprototype;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Alin on 4/8/2016.
 */
public class MenuProfileAdapter extends RecyclerView.Adapter<MenuProfileAdapter.ViewHolder> {
    private static final String TAG = "CustomAdapter";
    private FragmentManager fragmentManager;
    private ArrayList<MenuItem> mDataSet;
    private static final String PROPERTY_NAME = "PROPERTY_NAME";
    /**
     * Provide a reference to the type of views that you are using (custom ViewHolder)
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {


        public TextView getTvItemName() {
            return tvItemName;
        }

        public TextView getTvItemValue() {
            return tvItemValue;
        }

        private final TextView tvItemName;
        private final TextView tvItemValue;

        public ViewHolder(View v) {
            super(v);
            // Define click listener for the ViewHolder's View.
            tvItemName = (TextView) v.findViewById(R.id.menu_item_name);
            tvItemValue = (TextView) v.findViewById(R.id.menu_item_value);

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent editIntent = new Intent(itemView.getContext(), EditActivity.class);
                    editIntent.putExtra(PROPERTY_NAME,
                            tvItemName.getText().toString());
                    itemView.getContext().startActivity(editIntent);
                }
            });
        }
    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used by RecyclerView.
     */
    public MenuProfileAdapter(ArrayList<MenuItem> dataSet) {
        mDataSet = dataSet;

    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.menu_item_layout, viewGroup, false);

        return new ViewHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        Log.d(TAG, "Element " + position + " set.");

        // Get element from your dataset at this position and replace the contents of the view
        // with that element
        viewHolder.getTvItemName().setText(mDataSet.get(position).getName());
        viewHolder.getTvItemValue().setText((String)mDataSet.get(position).getValue());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataSet.size();
    }
}
