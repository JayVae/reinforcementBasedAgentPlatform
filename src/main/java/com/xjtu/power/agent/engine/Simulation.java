package com.xjtu.power.agent.engine;

import com.xjtu.power.agent.TransactionMemberAgent.BuyerBidAgent;
import com.xjtu.power.agent.TransactionMemberAgent.ISOAgent;
import com.xjtu.power.agent.TransactionMemberAgent.PXCAgent;
import com.xjtu.power.agent.TransactionMemberAgent.SellerBidAgent;
import com.xjtu.power.agent.algorithm.learning.qlearn.QAgent;
import com.xjtu.power.dataParam.ClearingResult;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Jay
 * @Date: Created in 15:18 2019/4/11
 * @Modified By:
 * 将要仿真的信息传递到这里[即init]，初始化信息，然后进行迭代，并且保存每一步的结果
 */
public class Simulation
{
    private List<BuyerBidAgent> buyerBidAgents = new ArrayList<>();

    private List<SellerBidAgent> sellerBidAgents = new ArrayList<>();

    private int iterNum = 1000;

    private int simulationId;



    public void simulation(){

        init();


        for (int i = 0; i < iterNum; i++) {

            PXCAgent pxcAgent = new PXCAgent();
            ClearingResult clearingResult = pxcAgent.Clearing(buyerBidAgents,sellerBidAgents);

            double clearPrice = clearingResult.getClearPrice();

            for (BuyerBidAgent buyBidAgent :
                    buyerBidAgents) {
                QAgent agent = buyBidAgent.getAgent();
                int actionId = agent.selectAction().getIndex();
                System.out.println("Agent does action-" + actionId);

                int newStateId = buyBidAgent.update( actionId);

                double reward = buyBidAgent.reward();

                System.out.println("Now the new state is " + newStateId);
                System.out.println("Agent receives Reward = " + reward);

                agent.update(actionId, newStateId, reward);

//                将更改后的报价策略回写到报价代理中
                buyBidAgent.writeBack();
            }
            for (SellerBidAgent sellerBidAgent:
                 sellerBidAgents) {
                QAgent agent = sellerBidAgent.getAgent();
                int actionId = agent.selectAction().getIndex();
                System.out.println("Agent does action-" + actionId);

                int newStateId = sellerBidAgent.update( actionId);

                double reward = sellerBidAgent.reward();

                System.out.println("Now the new state is " + newStateId);
                System.out.println("Agent receives Reward = " + reward);

                agent.update(actionId, newStateId, reward);

                sellerBidAgent.writeBack();
            }

            safetyCheck();

            saveThisResult();
        }

        saveFinalResult();

        showFinalResultTable();
    }

    public void showFinalResultTable() {

    }

    public void safetyCheck() {
        ISOAgent isoAgent = new ISOAgent();
        isoAgent.safetyCheck();
    }

    private void saveFinalResult() {
    }

    private void saveThisResult() {

    }

    public void init(){

    }

    public void addBuyerBideAgent(){

    }

    public void setBuyerBidAgents(List<BuyerBidAgent> buyerBidAgents) {
        this.buyerBidAgents = buyerBidAgents;
    }

    public void setSellerBidAgents(List<SellerBidAgent> sellerBidAgents) {
        this.sellerBidAgents = sellerBidAgents;
    }
}
