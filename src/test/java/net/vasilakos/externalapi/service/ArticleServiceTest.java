package net.vasilakos.externalapi.service;

import net.vasilakos.externalapi.model.Article;
import net.vasilakos.externalapi.model.Articles;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ArticleServiceTest {

    @Autowired
    private RestTemplate template = new RestTemplate();

    @Autowired
    private EmailSenderService emailSenderService;

    @Test
    void getTopArticles() {
        Articles articles = new Articles();
        articles = template.getForObject("https://newsapi.org/v2/top-headlines?country=gr&apiKey=yourAPIKey", Articles.class);

        String body = null;

        for(int i=0;i<articles.getArticles().length;i++){
            body += articles.getArticles()[i];
            body+="\n";
        }

        //System.out.println(body);

        emailSenderService.sendEmail("youremail@email.com","News",body);
    }

    @Test
    void StringArticle() {
        Article article = new Article();
        article.setTitle("Space");
        article.setDescription("New discovery");
        article.setUrl("space.com");

        System.out.println(article);
    }

}
