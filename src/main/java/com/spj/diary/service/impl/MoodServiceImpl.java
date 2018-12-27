package com.spj.diary.service.impl;

import com.alibaba.fastjson.JSON;
import com.spj.diary.mapper.MoodMapper;
import com.spj.diary.pojo.Mood;
import com.spj.diary.pojo.MoodPage;
import com.spj.diary.service.MoodService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class MoodServiceImpl implements MoodService {
    public static final String DIARY_REDIS_MOOD_KEY = "DIARY_REDIS_MOOD_KEY";

    @Resource
    private MoodMapper moodMapper;

    @Override
    public List<Mood> listMood() {
        List<Mood> moods = null;

        moods = this.moodMapper.listMood();

        return moods;
    }

    @Override
    public List<Mood> listMoodByPage(MoodPage moodPage) {
        return this.moodMapper.listMoodByPage(moodPage);
    }

    @Override
    public int count(MoodPage moodPage) {
        return this.moodMapper.count(moodPage);
    }

    @Transactional
    @RequiresRoles({"role:0"})
    @Override
    public void saveMood(Mood mood) {
        mood.setCreated(new Date());
        mood.setUpdated(mood.getCreated());
        this.moodMapper.insertSelective(mood);

    }

    @Transactional
    @RequiresRoles({"role:0"})
    @Override
    public void updateMood(Mood mood) {
        mood.setUpdated(new Date());
        this.moodMapper.updateByPrimaryKeySelective(mood);

    }

    @Transactional
    @RequiresRoles({"role:0"})
    @Override
    public void removeMoodById(Long moodId) {
        Mood mood = new Mood();
        mood.setId(moodId);
        mood.setStatus(-1);
        mood.setUpdated(new Date());
        this.moodMapper.updateByPrimaryKeySelective(mood);

    }
}
