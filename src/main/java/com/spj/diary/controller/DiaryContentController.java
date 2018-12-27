package com.spj.diary.controller;

import com.spj.diary.common.vo.SysResult;
import com.spj.diary.pojo.DiaryContent;
import com.spj.diary.service.DiaryContentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class DiaryContentController {
    @Resource
    private DiaryContentService diaryContentService;

    /**
     * 根据 ID 获取日记内容
     *
     * @param diaryId
     * @return
     */
    @GetMapping("/diary/content/{diaryId}")
    public SysResult getDiaryContentById(@PathVariable Long diaryId) {
        DiaryContent content = this.diaryContentService.getDiaryContentById(diaryId);
        return SysResult.ok(content);
    }
}
