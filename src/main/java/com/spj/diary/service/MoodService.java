package com.spj.diary.service;

import com.spj.diary.pojo.Mood;
import com.spj.diary.pojo.MoodPage;

import java.util.List;

public interface MoodService {
    /**
     * 获取心情列表
     *
     */
    List<Mood> listMood();

    List<Mood> listMoodByPage(MoodPage moodPage);

    int count(MoodPage moodPage);

    void saveMood(Mood mood);

    void updateMood(Mood mood);

    void removeMoodById(Long moodId);
}
