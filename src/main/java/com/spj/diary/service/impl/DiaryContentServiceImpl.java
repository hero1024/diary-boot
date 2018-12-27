package com.spj.diary.service.impl;

import com.spj.diary.mapper.DiaryContentMapper;
import com.spj.diary.pojo.DiaryContent;
import com.spj.diary.service.DiaryContentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DiaryContentServiceImpl implements DiaryContentService {
    @Resource
    private DiaryContentMapper diaryContentMapper;

    @Override
    public DiaryContent getDiaryContentById(Long diaryId) {
        return this.diaryContentMapper.getDiaryContentById(diaryId);
    }
}
