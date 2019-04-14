package com.xjtu.power.agent.TransactionMemberAgent;

import com.xjtu.power.entity.Seller;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author: Jay
 * @Date: Created in 9:26 2019/3/26
 * @Modified By:
 */
@Setter
@Getter
public class SellerBidAgent extends AbstractBidAgent{

    private Seller sellerInfo;

    private String name;

    private double quantity;

    private double price;

    private double maxQuantity;

    private double finalQuantity;

    private double finalPrice;

    private int stateCnt;
    private int actionCnt;

    public SellerBidAgent(int stateCount, int actionCount) {
        super(stateCount, actionCount);
    }

    public SellerBidAgent(int stateCount, int actionCount, Seller sellerInfo) {
        super(stateCount, actionCount);
        this.sellerInfo = sellerInfo;
        name = sellerInfo.getName();
        quantity = sellerInfo.getQuantity();
        price = sellerInfo.getPrice();
        maxQuantity = sellerInfo.getMaxQuantity();
        finalQuantity = sellerInfo.getFinalQuantity();
        finalPrice = sellerInfo.getFinalPrice();
        stateCnt = stateCount;
        actionCnt = actionCount;
    }


    @Override
    public double cost() {
        double a = 1.0, b = 0.8, c = 11.0;
        double ans = 0.0;
        ans = a*finalQuantity*finalQuantity + b*finalQuantity + c;
        return ans;
    }

    /**
     * 这里需要将actionID转换为对应的可变系数。
     * @return
     */
    @Override
    public double bidPrice(int actionId) {
        //对actionID进行变换,使用actionCnt

        double a = 1.0, b = 0.8;
        double ans = 0.0;
        ans = 2*a*finalQuantity + b;
        price = ans;
        return price;
    }

    /**
     * Qtable是一个横坐标是状态（出清价格），纵坐标是动作（选择策略的变化系数）的表
     * 如何去将坐标起始量与实际的对应起来？
     *
     * 最后agent是这样进行更新的：
     *      agent.update(actionId, newStateId, reward);
     * 其中的actionId，newStateId都是从0开始的。
     *
     * 而actionID是这样进行更新的（由选择策略决定）：
     *      int actionId = agent.selectAction().getIndex();
     * stateId是这样维护的:
     *      int newStateId = buyBidAgent.update(actionId);
     *      在本例中即为出清价格-最低出清价格，得到偏移量。
     * 在获得两者以后，需要计算reward：
     *      double reward = buyBidAgent.reward();
     * @return
     */
    @Override
    public int stateTransform() {
//        stateCnt

        return 0;
    }


    @Override
    public int update(int actionId) {
        bidPrice(actionId);
        return stateTransform();
    }

    @Override
    public double reward() {
        double ans = 0.0;
        double cost = cost();
        double revenue = price * finalQuantity;
        ans = cost - revenue;
        return ans;
    }

    @Override
    public void writeBack() {
        quantity = finalQuantity;
    }

    @Override
    public double commit() {
        return 0;
    }

}
