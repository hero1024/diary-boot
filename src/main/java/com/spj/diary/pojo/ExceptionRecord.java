package com.spj.diary.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@ToString
@Getter
@Setter
@Data
@Table(name = "tb_exception_record")
public class ExceptionRecord extends BasePojo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    /** 异常堆栈信息 */
    private String exceptionInfo;
    /**  解决方案 */
    private String solution;
    /** 异常类型（所属分类） */
    private String remark;
    @Transient
    private List<ExceptionType> exceptionTypes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getExceptionInfo() {
        return exceptionInfo;
    }

    public void setExceptionInfo(String exceptionInfo) {
        this.exceptionInfo = exceptionInfo;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<ExceptionType> getExceptionTypes() {
        return exceptionTypes;
    }

    public void setExceptionTypes(List<ExceptionType> exceptionTypes) {
        this.exceptionTypes = exceptionTypes;
    }
}
