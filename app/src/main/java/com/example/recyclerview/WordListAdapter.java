package com.example.recyclerview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class WordListAdapter extends
        RecyclerView.Adapter<WordListAdapter.WordViewHolder>  {

    private final LinkedList<String> TitleList;
    private final LinkedList<String> DescList;
    private final LinkedList<Integer> ImgList;

    private LayoutInflater mInflater;

    public WordListAdapter(Context context,
                           LinkedList<String> titleList
                            , LinkedList<String> descList
                            , LinkedList<Integer> imgList) {
        mInflater = LayoutInflater.from(context);
        this.TitleList = titleList;
        this.DescList = descList;
        this.ImgList = imgList;
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(ViewGroup parent,
                                             int viewType) {
        View mItemView = mInflater.inflate(R.layout.wordlist_item,
                parent, false);
        return new WordViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(WordViewHolder holder, int position) {
        String testCurrent = TitleList.get(position);
        holder.titleItemView.setText(testCurrent);

        String descCurrent = DescList.get(position);
        holder.descItemView.setText(descCurrent);

        String imgCurrent = DescList.get(position);
        holder.descItemView.setText(descCurrent);
    }

    @Override
    public int getItemCount() {
        return TitleList.size();
    }

    class WordViewHolder extends RecyclerView.ViewHolder
                                    implements View.OnClickListener{
        public final TextView titleItemView,descItemView;
        public final ImageView imgItemView ;
        final WordListAdapter mAdapter;

        public WordViewHolder(View itemView, WordListAdapter adapter) {
            super(itemView);
            titleItemView = itemView.findViewById(R.id.titleTv);
            this.descItemView = itemView.findViewById(R.id.descriptionTv);
            this.imgItemView = itemView.findViewById(R.id.imageTV);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            // Get the position of the item that was clicked.
            int mPosition = getLayoutPosition();
            // Use that to access the affected item in mWordList.
            String testelement = TitleList.get(mPosition);
            String descelement = DescList.get(mPosition);
            Integer imgelement = ImgList.get(mPosition);
            // Change the word in the mWordList.
            TitleList.set(mPosition, "Clicked! " + testelement);
            DescList.set(mPosition, "Clicked! " + testelement);
            // Notify the adapter, that the data has changed so it can
            // update the RecyclerView to display the data.
            mAdapter.notifyDataSetChanged();
        }
    }
}
