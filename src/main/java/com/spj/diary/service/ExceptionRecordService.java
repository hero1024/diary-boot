package com.spj.diary.service;

import com.spj.diary.pojo.ExceptionRecord;

public interface ExceptionRecordService {
    void removeExceptionRecordById(Long id);

    ExceptionRecord getExceptionRecordById(Long id);
}
