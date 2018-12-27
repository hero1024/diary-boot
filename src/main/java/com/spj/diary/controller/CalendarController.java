package com.spj.diary.controller;

import com.spj.diary.common.DateFormatContant;
import com.spj.diary.common.util.UserUtil;
import com.spj.diary.common.vo.SysResult;
import com.spj.diary.pojo.Diary;
import com.spj.diary.pojo.User;
import com.spj.diary.service.CalendarService;
import com.spj.diary.service.DiaryService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;

@RequestMapping("/calendar")
@RestController
public class CalendarController {
    @Resource
    private CalendarService calendarService;
    @Resource
    private DiaryService diaryService;

    @GetMapping("/getDiaryByWD/{writeDate}")
    public SysResult getDiaryByWD(@PathVariable @DateTimeFormat(pattern = DateFormatContant.FORMAT2) Date writeDate, HttpSession session) {
        User user = UserUtil.getCurrUser(session);
        Diary diary = new Diary();
        diary.setUserId(user.getId());
        diary.setStatus(null);
        diary.setWriteDate(writeDate);
        Diary diary1 = this.diaryService.getDiary(diary);
        return SysResult.build(200,"" ,diary1);
    }
}
