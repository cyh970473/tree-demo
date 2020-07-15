package org.eason.state;

/**
 * @Desc: //TODO
 * @DateTime: 2020/5/15 14:53
 * @Author chen.yihua
 * @Version 1.0
 */
public class ProjectManagerState implements State {
    @Override
    public void doWork(StateContext context) {
        Leave leave = (Leave) context.getBusinessObject();
        System.out.println(String.format("项目经理审核：处理%s的请假审核，请假时间%s - %s，共%d天", leave.getUsername(), leave.getBeginTime(), leave.getEndTime(), leave.getDays()));


        leave.setStatus("项目经理审核");
        if (leave.getDays() >= 3) {
            System.out.println("项目经理审核：3天及以上需要部门经理审核");
            context.setState(new DeptManagerState());
            context.doWork();
        } else {
            System.out.println("项目经理审核：审核通过");
            leave.setResult(1);
            context.setState(new OverState());
            context.doWork();
        }
    }
}
