package com.spj.diary.mapper;

import com.spj.diary.common.MyMapper;
import com.spj.diary.pojo.ExceptionType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ExceptionTypeMapper extends MyMapper<ExceptionType> {
    List<ExceptionType> listExceptionTypeByUserId(@Param("userId") Long userId, @Param("erId") Long erId);
}
