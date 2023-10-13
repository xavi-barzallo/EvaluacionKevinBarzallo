package com.ba.EvaluacionKevinBarzallo.controller;

import com.ba.EvaluacionKevinBarzallo.model.PostModel;
import com.ba.EvaluacionKevinBarzallo.service.PostServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/posts")
public class PostController {

    @Autowired
    PostServiceInterface postServiceInterface;

    @PostMapping
    public List<PostModel> savePosts(){
        return postServiceInterface.savePosts();
    }


    @GetMapping(path = "/titles/{userId}")
    public List<PostModel> getTitlesByUserId(@PathVariable int userId){
        return postServiceInterface.getTitlesByUserId(userId);
    }


}
