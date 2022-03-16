package com.example.goodnews.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.example.goodnews.R;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.goodnews.adapter.NewsFeedAdapter;
import com.example.goodnews.model.ArticleModel;
import com.example.goodnews.model.ResponseModel;
import com.example.goodnews.rests.APIInterface;
import com.example.goodnews.rests.ApiClient;
import com.example.goodnews.utils.OnRecyclerViewItemClickListener;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsFeed extends AppCompatActivity implements OnRecyclerViewItemClickListener {
    private static final String API_KEY = "bad365f0b7fd4702b3f46487838c9f2a";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RecyclerView mainRecycler = findViewById(R.id.recycle_view_news);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mainRecycler.setLayoutManager(linearLayoutManager);
        final APIInterface apiService = ApiClient.getClient().create(APIInterface.class);
        Call<ResponseModel> call = apiService.getLatestNews("techcrunch", API_KEY);
        call.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                if (response.body().getStatus().equals("ok")) {
                    List<ArticleModel> articleList = response.body().getArticles();
                    if (articleList.size() > 0) {
                        final NewsFeedAdapter mainArticleAdapter = new NewsFeedAdapter(articleList);
                        NewsFeedAdapter.setOnRecyclerViewItemClickListener(NewsFeed.this);
                        mainRecycler.setAdapter(mainArticleAdapter);
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Log.e("out", t.toString());
            }
        });
    }

    @Override
    public void onItemClick(int position, View view) {
        switch (view.getId()) {
            case R.id.lay:
                ArticleModel article = (ArticleModel) view.getTag();
                if (!TextUtils.isEmpty(article.getUrl())) {
                    Log.e("clicked url", article.getUrl());
                    Intent webActivity = new Intent(this, WebActivity.class);
                    webActivity.putExtra("url", article.getUrl());
                    startActivity(webActivity);
                }
                break;
        }
    }
}