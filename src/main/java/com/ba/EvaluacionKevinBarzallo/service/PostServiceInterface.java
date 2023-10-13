package com.ba.EvaluacionKevinBarzallo.service;

import com.ba.EvaluacionKevinBarzallo.model.PostModel;

import java.util.List;

public interface PostServiceInterface {

    public List<PostModel> getTitlesByUserId(int userId);

    public List<PostModel> savePosts();

}
