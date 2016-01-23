package com.dev.hmw.book_memory.ui.searchBook;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.dev.hmw.book_memory.R;
import com.dev.hmw.book_memory.dao.SearchBook;

import java.util.List;

/**
 * Created by Heo Minwook on 2016-01-15.
 */
public class SearchListAdapter extends RecyclerView.Adapter<SearchListAdapter.ViewHolder> {

    private List<SearchBook> mItems;

    public List<SearchBook> getmItems() {
        return mItems;
    }

    public SearchListAdapter setmItems(List<SearchBook> mItems) {
        this.mItems = mItems;
        return this;
    }

    private Context context;

    SearchListAdapter(List<SearchBook> items, Context context) {
        mItems = items;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.api_list_item, viewGroup, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        SearchBook item = mItems.get(i);

        Glide.with(context)
                .load(item.getCover())
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
                .into(viewHolder.imageView);

        viewHolder.titleView.setText(item.getTitle());
        viewHolder.authorView.setText(item.getAuthor() + " |");
        viewHolder.publisher.setText(item.getPublisher() + " | ");
        viewHolder.dateView.setText(item.getPubDate());
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView imageView;
        private final TextView titleView;
        private final TextView authorView;
        private final TextView publisher;
        private final TextView dateView;

        ViewHolder(View view) {
            super(view);

            imageView = (ImageView) view.findViewById(R.id.list_img);
            titleView = (TextView) view.findViewById(R.id.list_title);
            authorView = (TextView) view.findViewById(R.id.book_author);
            publisher = (TextView) view.findViewById(R.id.book_publisher);
            dateView = (TextView) view.findViewById(R.id.book_date);
        }
    }
}
