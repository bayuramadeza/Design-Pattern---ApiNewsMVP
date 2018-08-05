package com.easeel.apinewamvp.ui;

import com.easeel.apinewamvp.BaseApps;
import com.easeel.apinewamvp.interfaces.NewsPesenter;
import com.easeel.apinewamvp.interfaces.NewsView;
import com.easeel.apinewamvp.models.Response;

import retrofit2.Call;
import retrofit2.Callback;

public class NewsPresenterImp implements NewsPesenter {
    NewsView view;

    public NewsPresenterImp(NewsView view) {
        this.view = view;
    }

    @Override
    public void getData() {
        BaseApps.getServices().listNews().enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                if (response.isSuccessful()){
                    view.onAttach(response.body().getArticles());
                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                view.onFailed();
            }
        });
    }
}
