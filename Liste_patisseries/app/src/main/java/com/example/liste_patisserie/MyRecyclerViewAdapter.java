package com.example.liste_patisserie;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import java.util.ArrayList;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collection;
import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> implements Filterable {

    private static final String TAG="RecyclerAdapter";
    private List<String> mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    List<String> patisseriesList;


    MyRecyclerViewAdapter(Context context, List<String> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.patisseriesList = new ArrayList<>(data);
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyclerview_row, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String patisserie = mData.get(position);
        holder.myTextView.setText(patisserie);
    }


    @Override
    public int getItemCount() {

        return mData.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            List<String> filteredList = new ArrayList<>();

            if (constraint.toString().isEmpty()){
                filteredList.addAll(patisseriesList);
            }else{
                for (String patisserie: patisseriesList){
                    if (patisserie.toLowerCase().contains(constraint.toString().toLowerCase())){
                        filteredList.add(patisserie);
                    }
                }
            }

            FilterResults filterResults = new FilterResults();
            filterResults.values = filteredList;

            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults filterResults) {
            mData.clear();
            mData.addAll((Collection<? extends String>) filterResults.values);
            notifyDataSetChanged();
        }
    };



    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView myTextView;

        ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.Planete_detail);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }


    String getItem(int id) {
        return mData.get(id);
    }


    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }


    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

}
