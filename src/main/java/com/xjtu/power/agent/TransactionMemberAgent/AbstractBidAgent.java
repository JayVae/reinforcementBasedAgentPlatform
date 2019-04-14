package com.xjtu.power.agent.TransactionMemberAgent;

import com.xjtu.power.agent.algorithm.learning.qlearn.QAgent;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author: Jay
 * @Date: Created in 15:23 2019/3/21
 * @Modified By:
 */
@Setter
@Getter
public abstract class AbstractBidAgent {

    /*
    * 代理的通用属性：报价模型，报价策略，成本模型，利益模型。
    * */
    private int stateCount;
    private int actionCount;
    private int newStateId;
    private double reward;
    public QAgent agent;

    public AbstractBidAgent(int stateCount, int actionCount) {
        this.stateCount = stateCount;
        this.actionCount = actionCount;
        this.agent = new QAgent(stateCount, actionCount);
    }

    /**
     *
     * @return
     */
    public abstract double cost();
    public abstract double bidPrice(int actionId);
    public abstract int stateTransform();
    public abstract double commit();

    /**
     * 根据qagent与actionId计算新的状态
     * @param actionId
     * @return
     */
    public abstract int update(int actionId) ;

    /**
     * 计算收益
     * @return
     */
    public abstract double reward();

    public abstract void writeBack();
}
