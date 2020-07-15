package org.eason.state;

import java.util.HashMap;
import java.util.Map;

/**
 * @Desc: //TODO
 * @DateTime: 2020/5/15 14:58
 * @Author chen.yihua
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Leave leave = new Leave();
        leave.setUsername("张三");
        leave.setBeginTime("2020-5-15");
        leave.setEndTime("2020-5-17");
        leave.setDays(3);
        leave.setResult(-1);
        leave.setStatus("草稿");

        StateContext context = new StateContext();
        context.setState(new ProjectManagerState());
        context.setBusinessObject(leave);
        context.doWork();
    }
}
