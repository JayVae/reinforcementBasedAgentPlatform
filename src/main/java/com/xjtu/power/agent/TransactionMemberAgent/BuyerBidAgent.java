package com.xjtu.power.agent.TransactionMemberAgent;

import com.xjtu.power.entity.Buyer;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author: Jay
 * @Date: Created in 10:45 2019/3/26
 * @Modified By:
 */
@Getter
@Setter
public class BuyerBidAgent extends AbstractBidAgent{

    private Buyer buyerInfo;

    private String name;

    private double quantity;

    private double price;

    private double maxQuantity;

    private double finalQuantity;

    private double finalPrice;

    private int stateCnt;
    private int actionCnt;

    public BuyerBidAgent(int stateCount, int actionCount) {
        super(stateCount, actionCount);
    }

    public BuyerBidAgent(int stateCount, int actionCount, Buyer buyerInfo, String name, double quantity, double price, double maxQuantity, double finalQuantity, double finalPrice, int stateCnt, int actionCnt) {
        super(stateCount, actionCount);
        this.buyerInfo = buyerInfo;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.maxQuantity = maxQuantity;
        this.finalQuantity = finalQuantity;
        this.finalPrice = finalPrice;
        this.stateCnt = stateCnt;
        this.actionCnt = actionCnt;
    }

    public BuyerBidAgent(int stateCount, int actionCount, Buyer buyerInfo) {
        super(stateCount, actionCount);
        this.buyerInfo = buyerInfo;
        name = buyerInfo.getName();
        quantity = buyerInfo.getQuantity();
        price = buyerInfo.getPrice();
        maxQuantity = buyerInfo.getMaxQuantity();
        finalQuantity = buyerInfo.getFinalQuantity();
        finalPrice = buyerInfo.getFinalPrice();
        stateCnt = stateCount;
        actionCnt = actionCount;
    }

    @Override
    public double cost() {
        return 0;
    }

    @Override
    public double bidPrice(int actionId) {
        return 0;
    }

    @Override
    public int stateTransform() {
        return 0;
    }

    @Override
    public double commit() {
        return 0;
    }

    @Override
    public int update(int actionId) {
        return 0;
    }

    @Override
    public double reward() {
        return 0;
    }

    @Override
    public void writeBack() {
        quantity = finalQuantity;
    }
}
