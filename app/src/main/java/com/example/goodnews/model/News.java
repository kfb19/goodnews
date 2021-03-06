package com.example.goodnews.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
/**
 * The News model class.
 * @author Kate Belson
 */
public class News {
    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("totalResult")
    @Expose
    private int totalResult;

    @SerializedName("articles")
    @Expose
    private List<ArticleModel> article;
    //getters and setters for each variable
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalResult() {
        return totalResult;
    }

    public void setTotalResult(int totalResult) {
        this.totalResult = totalResult;
    }

    public List<ArticleModel> getArticle() {
        return article;
    }

    public void setArticle(List<ArticleModel> article) {
        this.article = article;
    }
}
