package com.spj.diary.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class DiaryPage extends Page {
    private String startTime;
    private String endTime;
    private Long moodId;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Long getMoodId() {
        return moodId;
    }

    public void setMoodId(Long moodId) {
        this.moodId = moodId;
    }
}
