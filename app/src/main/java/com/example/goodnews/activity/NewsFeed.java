package com.example.goodnews.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.goodnews.R;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.goodnews.adapter.NewsFeedAdapter;
import com.example.goodnews.model.ArticleModel;
import com.example.goodnews.model.ResponseModel;
import com.example.goodnews.rests.ApiInterface;
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
        final ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
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

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                Context context = NewsFeed.this;
                // Store SecondActivity.class in a Class object called destinationActivity
                Class destinationActivity = NewsFeed.class;
                // Create an Intent to start SecondActivity
                Intent intent = new Intent(context, destinationActivity);
                // Start the SecondActivity
                startActivity(intent);
                break;
            case R.id.preferences:
                Context contextPreferences = NewsFeed.this;
                // Store SecondActivity.class in a Class object called destinationActivity
                Class destinationActivityPreferences = Preferences.class;
                // Create an Intent to start SecondActivity
                Intent intentPreferences = new Intent(contextPreferences, destinationActivityPreferences);
                // Start the SecondActivity
                startActivity(intentPreferences);
                break;
            case R.id.help:
                Context contextHelp = NewsFeed.this;
                // Store SecondActivity.class in a Class object called destinationActivity
                Class destinationActivityHelp = Help.class;
                // Create an Intent to start SecondActivity
                Intent intentHelp = new Intent(contextHelp, destinationActivityHelp);
                // Start the SecondActivity
                startActivity(intentHelp);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return false;
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