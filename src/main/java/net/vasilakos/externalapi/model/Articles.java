package net.vasilakos.externalapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Articles {
    @JsonProperty("articles")
    private Article[] articles;

    public Article[] getArticles() {
        return articles;
    }

    @JsonProperty("articles")
    public void setArticles(Article[] articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return articles.toString();
    }
}
