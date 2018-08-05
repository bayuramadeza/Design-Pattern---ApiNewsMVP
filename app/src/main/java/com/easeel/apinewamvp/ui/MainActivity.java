package com.easeel.apinewamvp.ui;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.easeel.apinewamvp.R;
import com.easeel.apinewamvp.interfaces.NewsPesenter;
import com.easeel.apinewamvp.interfaces.NewsView;
import com.easeel.apinewamvp.models.Article;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NewsView, NewsViewHolder.NewsListener{
    NewsPesenter presenter;
    RecyclerView rvNews;
    List<Article> articles = new ArrayList<>();
    NewsAdapter newsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new NewsPresenterImp(this);
        rvNews = findViewById(R.id.rv_news);
        newsAdapter = new NewsAdapter(articles, this);
        rvNews.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rvNews.setAdapter(newsAdapter);

        presenter.getData();
    }

    @Override
    public void onAttach(List<Article> articles) {
        newsAdapter.addNews(articles);
        Toast.makeText(this, "Jalan", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onFailed() {
        Toast.makeText(this, "Terjadi kesalahan pada server", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(Article article) {
        String url = article.getUrl();
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

}
