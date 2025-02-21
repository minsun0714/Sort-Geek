package com.demo.sortgeek.service;

public interface DislikeService {
    Boolean createDislike (Long codeId);

    Boolean dislikeExists (Long codeId);

    Boolean deleteDislike (Long codeId);
}
