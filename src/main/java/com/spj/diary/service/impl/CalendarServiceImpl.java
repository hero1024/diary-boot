package com.spj.diary.service.impl;

import com.spj.diary.mapper.CalendarMapper;
import com.spj.diary.service.CalendarService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CalendarServiceImpl implements CalendarService {
    @Resource
    private CalendarMapper calendarMapper;
}
