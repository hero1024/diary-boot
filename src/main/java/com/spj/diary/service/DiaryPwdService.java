package com.spj.diary.service;

import com.spj.diary.common.vo.SysResult;
import com.spj.diary.pojo.DiaryPwd;

public interface DiaryPwdService {
    DiaryPwd getDiaryPwdByUId(Long uid);

    SysResult checkDiaryPwdByUserId(Long id);

    SysResult updateDiaryPwd(DiaryPwd diaryPwd, String oldPwd);

    void saveDiaryPwd(DiaryPwd diaryPwd);
}
