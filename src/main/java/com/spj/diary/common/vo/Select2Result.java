package com.spj.diary.common.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Select2Result {
    List<ResultData> results;

    public List<ResultData> getResults() {
        return results;
    }

    public void setResults(List<ResultData> results) {
        this.results = results;
    }

    @Getter
    @Setter
    public static class ResultData {
        private Long id;
        private String text;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }
}
