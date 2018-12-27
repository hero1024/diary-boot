package com.spj.diary.service;

import com.spj.diary.pojo.ExceptionType;

import java.util.List;

public interface ExceptionTypeService {
    List<ExceptionType> listExceptionTypeByUserId(Long id, Long erId);

    void saveExceptionType(ExceptionType exceptionType);

    void removeExceptioTypeById(long l);
}
