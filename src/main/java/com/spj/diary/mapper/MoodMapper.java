package com.spj.diary.mapper;

import com.spj.diary.common.MyMapper;
import com.spj.diary.pojo.Mood;
import com.spj.diary.pojo.MoodPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MoodMapper extends MyMapper<Mood> {
    /**
     * 获取心情列表
     *
     * @return
     */
    @Select("SELECT * FROM tb_mood WHERE status = 0")
    List<Mood> listMood();

    List<Mood> listMoodByPage(MoodPage moodPage);

    int count(MoodPage moodPage);
}
