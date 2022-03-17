package com.example.goodnews.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
/**
 * The Response model class.
 * @author Kate Belson
 */
public class ResponseModel {
    @SerializedName("status")
    private String status;
    @SerializedName("totalResults")
    private int totalResults;
    @SerializedName("articles")
    private List<ArticleModel> articles = null;
    //getters and setters for each variable
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public int getTotalResults() {
        return totalResults;
    }
    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }
    public List<ArticleModel> getArticles() {
        return articles;
    }
    public void setArticles(List<ArticleModel> articles) {
        this.articles = articles;
    }
}