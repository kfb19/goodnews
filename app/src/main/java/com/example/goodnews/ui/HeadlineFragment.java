package com.example.goodnews.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.goodnews.Adapter;
import com.example.goodnews.R;
import com.example.goodnews.Utils;
import com.example.goodnews.api.ApiClient;
import com.example.goodnews.api.ApiInterface;
import com.example.goodnews.models.Article;
import com.example.goodnews.models.News;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.util.ArrayList;
import java.util.List;

public class HeadlineFragment extends Fragment {

    public static final String BASE_URL = "https://newsapi.org/v2/top-headlines?apiKey=";
    public static final String API_KEY = "bad365f0b7fd4702b3f46487838c9f2a";
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<Article> articles = new ArrayList<>();
    private Adapter adapter;
    private String TAG = MainActivity.class.getSimpleName();
    ArrayList<Article> items;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_headline, container, false);
        return inflater.inflate(R.layout.fragment_headline, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final RecyclerView recyclerView = getView().findViewById(R.id.recycle_news);

        String urltemp = BASE_URL + API_KEY;


        Ion.with(getActivity()).load("GET", urltemp).asJsonObject().setCallback(new FutureCallback<JsonObject>() {
            @Override
            public void onCompleted(Exception e, JsonObject result) {

                String status = result.get("status").getAsString();

                if (status.equals("ok")) {
                    JsonArray array = result.get("articles").getAsJsonArray();

                    for (int i = 0; i < ((JsonArray) array).size(); i++) {
                        JsonObject object = array.get(i).getAsJsonObject();
                        String author = object.get("author").toString();
                        String source = object.get("source").toString();
                        String description = object.get("description").toString();
                        String title = object.get("title").toString();
                        title = title.substring(1, title.length() - 1);
                        String url = object.get("url").toString();
                        url = url.substring(1, url.length() - 1);
                        String urlToImage = object.get("urlToImage").toString();
                        urlToImage = urlToImage.substring(1, urlToImage.length() - 1);
                        String date = object.get("publishedAt").toString();
                        String content = object.get("content").toString();
                        content = content.substring(1, content.length() - 1);
                        items.add(new Article(source, author, title, description, url, urlToImage, date));
                    }
                    adapter = new Adapter(items, getActivity());
                    recyclerView.setAdapter(adapter);
                    LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                    recyclerView.setLayoutManager(layoutManager);
                    Log.e("Prashant", "success");

                } else {Log.e("Prashant", "error");}
            }});}}

    /**@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        recyclerView = getView().findViewById(R.id.recycle_news);
        layoutManager = new LinearLayoutManager(getActivity().this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setNestedScrollingEnabled(false);

        LoadJson();
    }

    public void LoadJson() {
        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        String country = Utils.getCountry();

        newsApiClient.getTopHeadlines(
                new TopHeadlinesRequest.Builder()
                        .q("bitcoin")
                        .language("en")
                        .build(),
                new NewsApiClient.ArticlesResponseCallback() {
                    @Override
                    public void onSuccess(ArticleResponse response) {
                        System.out.println(response.getArticles().get(0).getTitle());
                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        System.out.println(throwable.getMessage());
                    }
                }
        );
    } **/


