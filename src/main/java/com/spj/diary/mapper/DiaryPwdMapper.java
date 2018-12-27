package com.spj.diary.mapper;

import com.spj.diary.common.MyMapper;
import com.spj.diary.pojo.DiaryPwd;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DiaryPwdMapper extends MyMapper<DiaryPwd> {
    @Select("SELECT * FROM tb_diary_pwd WHERE user_id = #{uid}")
    DiaryPwd getDiaryPwdByUId(Long uid);
}
