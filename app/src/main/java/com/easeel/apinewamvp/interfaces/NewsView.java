package com.easeel.apinewamvp.interfaces;

import com.easeel.apinewamvp.models.Article;

import java.util.List;

public interface NewsView {
    void onAttach(List<Article> articles);

    void onFailed();
}
