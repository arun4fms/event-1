package com.app.main.event;

/**
 * Created by bima on 10/12/17.
 */
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class EventListAdapter extends RecyclerView.Adapter<EventListAdapter.EventViewHolder> {

    private Context mContext;
    // COMPLETED (8) Add a new local variable mCount to store the count of items to be displayed in the recycler view
    private int mCount;

    // COMPLETED (9) Update the Adapter constructor to accept an integer for the count along with the context
    /**
     * Constructor using the context and the db cursor
     *
     * @param context the calling context/activity
     */
    public EventListAdapter(Context context, int count) {
        this.mContext = context;
        // COMPLETED (10) Set the local mCount to be equal to count
        mCount = count;
    }

    @Override
    public EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Get the RecyclerView item layout
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.event_item, parent, false);
        return new EventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EventViewHolder holder, int position) {

    }


    // COMPLETED (11) Modify the getItemCount to return the mCount value rather than 0
    @Override
    public int getItemCount() {
        return mCount;
    }


    /**
     * Inner class to hold the views needed to display a single item in the recycler-view
     */
    class EventViewHolder extends RecyclerView.ViewHolder {

        // Will display the event name
        TextView EventNameTextView;
        // Will display the event description
        TextView EventDescriptionTextView;

        /**
         * Constructor for our ViewHolder. Within this constructor, we get a reference to our
         * TextViews
         *
         * @param itemView The View that you inflated in
         *                 {@link EventListAdapter#onCreateViewHolder(ViewGroup, int)}
         */
        public EventViewHolder(View itemView) {
            super(itemView);
            EventNameTextView = (TextView) itemView.findViewById(R.id.event_name_text_view);
            EventDescriptionTextView = (TextView) itemView.findViewById(R.id.event_description_text_view);
        }

    }
}