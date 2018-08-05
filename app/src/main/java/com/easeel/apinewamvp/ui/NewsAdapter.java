package com.easeel.apinewamvp.ui;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.easeel.apinewamvp.R;
import com.easeel.apinewamvp.models.Article;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsViewHolder> {
    private List<Article> articles;
    private NewsViewHolder.NewsListener listener;

    public NewsAdapter(List<Article> articles, NewsViewHolder.NewsListener listener) {
        this.articles = articles;
        this.listener = listener;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new NewsViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        Article article = articles.get(position);
        holder.showData(article);
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public void addNews(List<Article> news){
        articles.addAll(news);
        this.notifyDataSetChanged();
    }
}
