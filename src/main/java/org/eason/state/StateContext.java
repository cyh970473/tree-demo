package org.eason.state;

/**
 * @Desc: 状态机context
 * @DateTime: 2020/5/15 14:47
 * @Author chen.yihua
 * @Version 1.0
 */
public class StateContext {
    private State state;
    private Object businessObject;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Object getBusinessObject() {
        return businessObject;
    }

    public void setBusinessObject(Object businessObject) {
        this.businessObject = businessObject;
    }

    public void doWork() {
        this.state.doWork(this);
    }
}
