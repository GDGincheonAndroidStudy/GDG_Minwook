package com.dev.hmw.book_memory.ui.categoryBookList;

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
import com.dev.hmw.book_memory.dao.BestSellerBook;

import java.util.List;

/**
 * Created by Heo Minwook on 2016-01-15.
 */
public class BookListAdapter extends RecyclerView.Adapter<BookListAdapter.ViewHolder> {

    private List<BestSellerBook> mItems;

    public List<BestSellerBook> getmItems() {
        return mItems;
    }

    public BookListAdapter setmItems(List<BestSellerBook> mItems) {
        this.mItems = mItems;
        return this;
    }

    private Context context;

    BookListAdapter(List<BestSellerBook> items, Context context) {
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
        BestSellerBook item = mItems.get(i);

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
