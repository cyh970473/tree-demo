package org.eason.state;

/**
 * @Desc: //TODO
 * @DateTime: 2020/5/15 14:57
 * @Author chen.yihua
 * @Version 1.0
 */
public class OverState implements State {
    @Override
    public void doWork(StateContext context) {
        Leave leave = (Leave) context.getBusinessObject();
        leave.setStatus("流程结束");
        System.out.println(String.format("流程结束：%s的请假审核，请假时间%s - %s，共%d天", leave.getUsername(), leave.getBeginTime(), leave.getEndTime(), leave.getDays()));
        System.out.println(String.format("审核结果：%s", leave.getResult() == 1 ? "通过" : "失败"));
    }
}
