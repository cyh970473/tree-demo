package org.eason.state;

/**
 * @Desc: 状态接口
 * @DateTime: 2020/5/15 14:47
 * @Author chen.yihua
 * @Version 1.0
 */
public interface State {
    void doWork(StateContext context);
}
