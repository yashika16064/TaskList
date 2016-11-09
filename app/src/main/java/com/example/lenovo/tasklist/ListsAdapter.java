package com.example.lenovo.tasklist;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import static android.R.attr.key;
import static android.provider.AlarmClock.EXTRA_MESSAGE;
import static com.example.lenovo.tasklist.R.id.Tasks;

/**
 * Created by Lenovo on 11/5/2016.
 */

public class ListsAdapter extends
        RecyclerView.Adapter<ListsAdapter.ViewHolder> {

    public final static String key="com.example.lenovo.myapplication.no_key";
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView nameTextView;
        private Context context;

        public ViewHolder(Context context,View itemView) {
            super(itemView);
            nameTextView = (TextView) itemView.findViewById(R.id.title);
            this.context=context;
            itemView.setOnClickListener((View.OnClickListener) this);
        }

        @Override
        public void onClick(View view) {

            int  position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                Intent intent =new Intent(context,DescriptionPagerActivity.class);
                //String describe=MainActivity.tasks.get(position).getDescription();
                intent.putExtra(key, position);
                context.startActivity(intent);

            }
        }
    }

    private List<Lists> mTasks;
    // Store the context for easy access
    private Context mContext;

    // Pass in the contact array into the constructor
    public ListsAdapter(Context context, List<Lists> contacts) {
        mTasks = contacts;
        mContext = context;
    }

    // Easy access to the context object in the recyclerview
    private Context getContext() {
        return mContext;
    }

    @Override
    public ListsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(context,contactView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(ListsAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        Lists lists = mTasks.get(position);

        // Set item views based on your views and data model
        TextView textView = viewHolder.nameTextView;
        textView.setText(lists.getTitle());

    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return mTasks.size();
    }
}