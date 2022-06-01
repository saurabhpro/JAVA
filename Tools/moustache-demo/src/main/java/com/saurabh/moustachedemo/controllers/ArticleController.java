package com.saurabh.moustachedemo.controllers;

import com.saurabh.moustachedemo.models.Article;
import com.saurabh.moustachedemo.services.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/articles")
    public ModelAndView displayArticle(Map<String, Object> model) {

        final List<Article> articles = articleService.getArticles();

        model.put("articles", articles);

        return new ModelAndView("index", model);
    }
}
