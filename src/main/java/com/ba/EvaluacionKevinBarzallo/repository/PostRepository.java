package com.ba.EvaluacionKevinBarzallo.repository;

import com.ba.EvaluacionKevinBarzallo.model.PostModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<PostModel, Long> {



}
