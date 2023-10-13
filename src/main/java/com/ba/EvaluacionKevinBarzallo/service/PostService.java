package com.ba.EvaluacionKevinBarzallo.service;

import com.ba.EvaluacionKevinBarzallo.model.PostModel;
import com.ba.EvaluacionKevinBarzallo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.beans.Transient;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService implements PostServiceInterface {

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Value("${url.posts.api}")
    private String urlPostsApi;

    @Autowired
    PostRepository postRepository;

    @Override
    public List<PostModel> getTitlesByUserId(int userId) {

        List<PostModel> posts = (List<PostModel>) postRepository.findAll();

        return posts.stream()
                .filter(post -> post.getUserId() == userId)
                .collect(Collectors.toList());

    }

    @Override
    @Transient
    public List<PostModel> savePosts() {

        List<PostModel> posts = new LinkedList<>();
        List<PostModel> postList = fetchPosts().collectList().block();

        for(PostModel post: postList){
            System.out.println(post.getId());
            System.out.println(post.getTitle());
            posts.add(postRepository.save(post));
        }

        return posts;
    }

    public Flux<PostModel> fetchPosts() {
        return webClientBuilder.baseUrl(urlPostsApi)
                .build()
                .get()
                .retrieve()
                .bodyToFlux(PostModel.class);
    }
}
