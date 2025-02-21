package com.demo.sortgeek.service;

public interface LikeService {
    Boolean createLike (Long codeId);

    Boolean likeExists (Long codeId);

    Boolean deleteLike (Long codeId);
}
