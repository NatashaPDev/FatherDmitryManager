package com.natalia.fatherdmitrymanager;

import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.natalia.fatherdmitrymanager.data.VariantsContracts;


public class VariantListAdapter extends RecyclerView.Adapter<VariantListAdapter.VariantViewHolder> {

    private Cursor cursor;

    private final OnItemClickListener clickListener;

    public VariantListAdapter(OnItemClickListener clickListener) {
        super();
        this.clickListener = clickListener;
    }

    @Override
    public VariantListAdapter.VariantViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.variant_layout, parent, false);
        return new VariantViewHolder(view);
    }

    @Override
    public void onBindViewHolder(VariantListAdapter.VariantViewHolder holder, int position) {

        if (cursor.moveToPosition(position)) {
            holder.itemView.setTag(cursor.getString(cursor.getColumnIndex(VariantsContracts.VariantsEntry._ID)));
            holder.tvDescription.setText(cursor.getString(cursor.getColumnIndex(VariantsContracts.VariantsEntry.COLUMN_DESCRIPTION)));
        }
    }

    @Override
    public int getItemCount() {
        return cursor == null ? 0 : cursor.getCount();
    }

    public void setCursor(Cursor cursor) {
        this.cursor = cursor;
        notifyDataSetChanged();
    }

    public interface OnItemClickListener {
        void OnItemClick(String id, View view);
    }

    public class VariantViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        final TextView tvDescription;

        public VariantViewHolder(View h) {
            super(h);
            this.tvDescription = h.findViewById(R.id.tvDescription);
            this.itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            clickListener.OnItemClick((String) view.getTag(), view);
        }
    }
}
