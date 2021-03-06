package com.abhiandroid.fragmentexample.Fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;

import com.abhiandroid.fragmentexample.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import androidx.fragment.app.ListFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>A fragment that shows a list of items as a modal bottom sheet.</p>
 * <p>You can show this modal bottom sheet from your activity like this:</p>
 * <pre>
 *     ItemListDialogFragment.newInstance(30).show(getSupportFragmentManager(), "dialog");
 * </pre>
 */
public class ItemListDialogFragment extends ListFragment {

    // TODO: Customize parameter argument names
    private static final String ARG_ITEM_COUNT = "item_count";
    private static List<String> students;

    // TODO: Customize parameters
    public static ItemListDialogFragment newInstance(int itemCount) {
        final ItemListDialogFragment fragment = new ItemListDialogFragment();
        final Bundle args = new Bundle();
        args.putInt(ARG_ITEM_COUNT, itemCount);
        fragment.setArguments(args);
        students=new ArrayList<>(5);
        students.add("Ali");
        students.add("Khan");
        students.add("Ray");
        students.add("Khan");
        students.add("Ali");
        return fragment;
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_item_list_dialog_list_dialog, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        final RecyclerView recyclerView = (RecyclerView) view;
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
       // recyclerView.setAdapter(new ItemAdapter(getArguments().getInt(ARG_ITEM_COUNT)));
        recyclerView.setAdapter(new ItemAdapter(students.size(),students));
    }

    private class ViewHolder extends RecyclerView.ViewHolder {

        final TextView text;

        ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            // TODO: Customize the item layout
            super(inflater.inflate(R.layout.fragment_item_list_dialog_list_dialog_item, parent, false));
            text = itemView.findViewById(R.id.text);
        }
    }

    private class ItemAdapter extends RecyclerView.Adapter<ViewHolder> {

        private final int mItemCount;
        private final List<String> students;

        ItemAdapter(int itemCount, List<String> students) {
            mItemCount = itemCount;
            this.students=students;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()), parent);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            //holder.text.setText(String.valueOf(position));
            holder.text.setText(students.get(position));
        }

        @Override
        public int getItemCount() {
            return students.size();
        }

    }

}
