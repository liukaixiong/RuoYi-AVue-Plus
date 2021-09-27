package com.ruoyi.client.model;

import com.ruoyi.client.annotation.*;
import com.ruoyi.client.annotation.column.*;
import com.ruoyi.client.annotation.column.props.AVueUploadPropsHttp;
import com.ruoyi.client.controller.AVueControllerTest;
import com.ruoyi.client.enums.CheckStatusEnums;
import com.ruoyi.client.enums.SexEnums;

import java.util.Date;
import java.util.List;

/**
 * 模拟增删改查表单列表构建数据
 *
 * @author liukaixiong
 * @Email liukx@elab-plus.com
 * @date 2021/8/17 - 13:02
 */
@AVueRouteKey(groupKey = "test-route")
@AVueTableOption(title = "这是一个测试", dialogDrag = true)
@AVueConfig(list = AVueControllerTest.LIST_URL, update = AVueControllerTest.UPDATE_URL, save = AVueControllerTest.UPDATE_URL)
@AVueEventButtons(tableRowButtons = {@AVueClickButton(methodName = "testA", btnName = "测试按钮A"),
    @AVueClickButton(methodName = "testB", btnName = "测试按钮B")}, tableTopLeftButtons = {
    @AVueClickButton(methodName = "testA", btnName = "测试按钮C")})
public class AVueCrudModel {

    @AVueInput(prop = "id", label = "主键", addDisplay = false, editDisabled = true, search = true)
    private String id;

    @AVueInput(prop = "username", label = "用户名称", search = true, searchRequired = true, onClick = "testB")
    private String username;

    @AVueSelect(prop = "checkStatus", label = "认证状态", dicData = "CheckStatusEnums", search = true)
    private String checkStatus = CheckStatusEnums.FOOTBALL.getCode().toString();

    @AVueSelect(prop = "likeStar", label = "喜欢明星", dicData = "test-likeStar-map", dicUrl = "/liukx")
    private Integer likeStar;

    @AVueNumber(prop = "age", label = "年龄", labelTip = "这是选择年龄的地方")
    private Integer age = 18;

    @AVueRadio(prop = "sex", label = "性别", border = true, dicData = "SexEnums")
    private int sex = (int)SexEnums.UNKNOWN.getCode();

    @AVueDatetime(prop = "validDate", label = "有效时间")
    private Date validDate;

    @AVueTime(prop = "time", label = "时分秒选择")
    private Date time;

    @AVueTimeRange(prop = "timeRange", label = "时分秒范围", rangeSeparator = "-")
    private String timeRange;

    @AVueDateRange(prop = "dateRange", rangeSeparator = "-", label = "日期范围", search = true, valueFormat = "yyyy-MM-dd", format = "yyyy-MM-dd")
    private List<Date> dateRange;

    @AVueCheckbox(prop = "interest", label = "兴趣爱好", dicData = "InterestEnums")
    private List<String> interest;

    @AVueSwitch(prop = "status", label = "状态", dicData = "StatusEnums")
    private int status;

    @AVueUpload(prop = "image", label = "单图上传", listType = "picture-img", action = "/upload", propsHttp = @AVueUploadPropsHttp(res = "single", name = "fileName"))
    private String image;

    @AVueUpload(prop = "imageList", dataType = "array", listType = "picture-card", label = "单图上传", action = "/upload", propsHttp = @AVueUploadPropsHttp(res = "single", name = "fileName"))
    private List<String> imageList;

    @AVueJson(prop = "dataJson", label = "拓展字段")
    private String dataJson;

    //    @AVueDynamic(prop = "simpleModel", label = "子表单测试")
    //    private AVueSimpleModel simpleModel;
    //
    //    @AVueGroup(prop = "groupModel", label = "分组测试1")
    //    private AVueNodeModel groupModel;
    //
    //    @AVueGroup(prop = "groupModel2", label = "分组测试2")
    //    private AVueNodeModel groupModel2;

    //    public AVueNodeModel getGroupModel() {
    //        return groupModel;
    //    }
    //
    //    public void setGroupModel(AVueNodeModel groupModel) {
    //        this.groupModel = groupModel;
    //    }
    //
    //    public AVueNodeModel getGroupModel2() {
    //        return groupModel2;
    //    }
    //
    //    public void setGroupModel2(AVueNodeModel groupModel2) {
    //        this.groupModel2 = groupModel2;
    //    }
    //
    //    public AVueSimpleModel getSimpleModel() {
    //        return simpleModel;
    //    }
    //
    //    public void setSimpleModel(AVueSimpleModel simpleModel) {
    //        this.simpleModel = simpleModel;
    //    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getTimeRange() {
        return timeRange;
    }

    public void setTimeRange(String timeRange) {
        this.timeRange = timeRange;
    }

    public List<Date> getDateRange() {
        return dateRange;
    }

    public void setDateRange(List<Date> dateRange) {
        this.dateRange = dateRange;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(String checkStatus) {
        this.checkStatus = checkStatus;
    }

    public Integer getLikeStar() {
        return likeStar;
    }

    public void setLikeStar(Integer likeStar) {
        this.likeStar = likeStar;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public Date getValidDate() {
        return validDate;
    }

    public void setValidDate(Date validDate) {
        this.validDate = validDate;
    }

    public List<String> getInterest() {
        return interest;
    }

    public void setInterest(List<String> interest) {
        this.interest = interest;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
