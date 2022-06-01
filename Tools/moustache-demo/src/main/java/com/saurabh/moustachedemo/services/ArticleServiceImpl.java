package com.saurabh.moustachedemo.services;

import com.saurabh.moustachedemo.models.Article;
import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Override
    public List<Article> getArticles() {
        return IntStream.range(0, 10)
                .mapToObj(i -> generateArticle("Article Title " + i))
                .collect(Collectors.toList());
    }

    private Article generateArticle(String title) {
        final Article article = new Article();
        final DataFactory factory = new DataFactory();
        article.setTitle(title);
        article.setPublishDate(factory.getBirthDate().toString());
        article.setAuthor(factory.getName());
        article.setBody(
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur faucibus tempor diam. In molestie arcu eget ante facilisis sodales. Maecenas porta tellus sapien, eget rutrum nisi blandit in. Mauris tempor auctor ante, ut blandit velit venenatis id. Ut varius, augue aliquet feugiat congue, arcu ipsum finibus purus, dapibus semper velit sapien venenatis magna. Nunc quam ex, aliquet at rutrum sed, vestibulum quis libero. In laoreet libero cursus maximus vulputate. Nullam in fermentum sem. Duis aliquam ullamcorper dui, et dictum justo placerat id. Aliquam pretium orci quis sapien convallis, non blandit est tempus.");

        return article;
    }
}
