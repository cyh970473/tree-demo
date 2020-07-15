package org.eason.state;

/**
 * @Desc: //TODO
 * @DateTime: 2020/5/15 14:56
 * @Author chen.yihua
 * @Version 1.0
 */
public class DeptManagerState implements State {
    @Override
    public void doWork(StateContext context) {
        Leave leave = (Leave) context.getBusinessObject();
        System.out.println(String.format("部门经理审核：处理%s的请假审核，请假时间%s - %s，共%d天", leave.getUsername(), leave.getBeginTime(), leave.getEndTime(), leave.getDays()));

        System.out.println("部门经理审核：审核通过");
        leave.setResult(1);
        leave.setStatus("部门经理审核");
        context.setState(new OverState());
        context.doWork();
    }
}
