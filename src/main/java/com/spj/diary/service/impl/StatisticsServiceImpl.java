package com.spj.diary.service.impl;

import com.spj.diary.common.DateFormatContant;
import com.spj.diary.common.util.DateUtil;
import com.spj.diary.mapper.StatisticsMapper;
import com.spj.diary.pojo.Diary;
import com.spj.diary.service.DiaryService;
import com.spj.diary.service.StatisticsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class StatisticsServiceImpl implements StatisticsService {
    @Resource
    protected StatisticsMapper statisticsMapper;
    @Resource
    private DiaryService diaryService;

    @Override
    public Date getStartDate(Long uid) {
        return this.statisticsMapper.getStartDate(uid);
    }

    @Override
    public Map<Object, Object> amount(Long uid) {
        return this.statisticsMapper.amount(uid);
    }

    @Override
    public List<String> getWriteDateList2(Long userId, Date startDate, Date endDate) {
        Map<String, Object> params = new HashMap<>();
        params.put("userId", userId);
        params.put("startDate", startDate);
        params.put("endDate", endDate);
        return this.statisticsMapper.getWriteDateList2(params);
    }

    @Override
    public List<Map<Object, Object>> getMoodAndAmountMap(Long uid) {
        return this.statisticsMapper.getMoodAndAmountMap(uid);
    }

    @Override
    public Map<String, List<Diary>> statisticsForTimeline(Long uId) {
        Map<String, List<Diary>> resultMap = new LinkedHashMap<>();

        List<Diary> diaryList = this.diaryService.getDiaryByScore(uId);
        for (Diary diary : diaryList) {
            Date writeDate = diary.getWriteDate();
            String dateStr = DateUtil.getDate(writeDate, DateFormatContant.FORMAT3);

            if (!resultMap.containsKey(dateStr)) {
                resultMap.put(dateStr, new LinkedList<Diary>());
            }
            resultMap.get(dateStr).add(diary);
        }

        return resultMap;
    }
}
