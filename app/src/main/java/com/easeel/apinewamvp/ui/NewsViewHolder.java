package com.easeel.apinewamvp.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.easeel.apinewamvp.R;
import com.easeel.apinewamvp.models.Article;
import com.squareup.picasso.Picasso;

public class NewsViewHolder extends RecyclerView.ViewHolder {
    private ImageView imageNews;
    private TextView tvTitle;
    private TextView tvDesc;
    private TextView tvSource;
    private NewsListener listener;

    public NewsViewHolder(View itemView, NewsListener listener) {
        super(itemView);
        imageNews = itemView.findViewById(R.id.imageView);
        tvDesc = itemView.findViewById(R.id.tv_description);
        tvTitle = itemView.findViewById(R.id.tv_title);
        this.listener = listener;
        tvSource = itemView.findViewById(R.id.tv_source);
    }

    public void showData(final Article article){
        Picasso.get()
                .load(article.getUrlToImage())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(imageNews);
        tvDesc.setText(article.getDescription());
        tvTitle.setText(article.getTitle());
        tvSource.setText(article.getSource().getName());
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(article);
            }
        });
    }

    public interface NewsListener{
        void onClick(Article article);
    }
}
