package com.dev.hmw.book_memory.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.dev.hmw.book_memory.R;
import com.dev.hmw.book_memory.dao.BestSellerBook;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bill MinWook Heo on 15. 7. 29..
 */
public class BestSellerListAdapter extends BaseAdapter {
    private Context context;

    private List<BestSellerBook> entities;
    private int selectedEntity = -1;

    public BestSellerListAdapter(Context context) {
        this.context = context;
        this.entities = new ArrayList<BestSellerBook>();
    }

    public void setList(List<BestSellerBook> list) {
        entities.addAll(list);
    }

    @Override
    public int getCount() {
        return entities.size();
    }

    @Override
    public BestSellerBook getItem(int position) {
        return entities.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {


        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.api_list_item, viewGroup, false);
        }

        ImageView imageView = (ImageView) view.findViewById(R.id.list_img);
        TextView titleView = (TextView) view.findViewById(R.id.list_title);
        TextView authorView = (TextView) view.findViewById(R.id.book_author);
        TextView publisher = (TextView) view.findViewById(R.id.book_publisher);
        TextView dateView = (TextView) view.findViewById(R.id.book_date);

        Glide.with(context)
                .load(getItem(position).getCover())
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
                .into(imageView);

        titleView.setText(getItem(position).getTitle());
        authorView.setText(getItem(position).getAuthor() + " |");
        publisher.setText(getItem(position).getPublisher() + " | ");
        dateView.setText(getItem(position).getPubDate());

        return view;
    }
}
