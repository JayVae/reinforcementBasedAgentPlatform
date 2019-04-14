package com.xjtu.power.agent.algorithm.test;

import com.xjtu.power.agent.algorithm.actionselection.SoftMaxActionSelectionStrategy;
import com.xjtu.power.agent.TransactionMemberAgent.AbstractBidAgent;
import com.xjtu.power.agent.TransactionMemberAgent.SellerBidAgent;
import com.xjtu.power.agent.algorithm.learning.qlearn.QAgent;

import java.util.Random;

/**
 * @Author: Jay
 * @Date: Created in 20:40 2019/3/17
 * @Modified By:
 */
public class QLearnTest {

    public static void main(String[] args) {
        int stateCount = 100;
        int actionCount = 10;

        AbstractBidAgent world = new SellerBidAgent(stateCount, actionCount);
        QAgent agent = world.getAgent();

        agent.getLearner().setActionSelection(SoftMaxActionSelectionStrategy.class.getCanonicalName());
        Random random = new Random();

        agent.start(random.nextInt(stateCount));
        for (int time = 0; time < 1000; ++time) {

            int actionId = agent.selectAction().getIndex();
            System.out.println("Agent does action-" + actionId);

//            int newStateId = random.nextInt(actionCount);
//            double reward = random.nextDouble();
//            注释掉的是环境中如何更新状态和计算奖赏。
/* 这里应该分为两步来做：
            1. 根据actionId和报价公式计算得到当前更新到的报价量价对pair；
            2. 将pair提交给ISOAgent进行出清，等待；
            3. 当ISOAgent收到所有代理的出清请求后，调用出清算法得到出清价格和出清量，其中出清价格即为状态；
            4. 根据状态和出清量计算此次的即时收益，进入下一次迭代；*/

/*
* 电力市场主体代理与强化学习的关系：
* 电力市场主体代理中有一个强化学习算法，内部类，电力市场主体代理相当于环境，环境中是有对应的变量来计算收益
*
* 电力市场主体与电力市场主体代理的关系：
* 电力市场主体是数据库中的，而电力市场主体代理是运行时的载体。
* 代理的通用属性：报价模型，报价策略，成本模型，利益模型。
* 电力市场主体是基本的信息，如机组，类型，线路
* 对比两者的属性，代理中的属性更聚合一些，类似数据主题这样。
* */

/*
* ISOAgent中，出清算法是行为。
* */
            int newStateId = world.update( actionId);

            double reward = world.reward();

            System.out.println("Now the new state is " + newStateId);
            System.out.println("Agent receives Reward = " + reward);

            agent.update(actionId, newStateId, reward);
        }
    }
}
