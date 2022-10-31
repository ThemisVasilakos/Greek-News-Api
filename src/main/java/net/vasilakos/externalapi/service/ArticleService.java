package net.vasilakos.externalapi.service;

import net.vasilakos.externalapi.model.Articles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ArticleService {

    @Autowired
    private RestTemplate template = new RestTemplate();

    public Articles getTopArticles(){
        return template.getForObject("https://newsapi.org/v2/top-headlines?country=gr&apiKey=yourAPIKey", Articles.class);
    }
}
