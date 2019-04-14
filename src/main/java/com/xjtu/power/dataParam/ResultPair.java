package com.xjtu.power.dataParam;


import com.xjtu.power.agent.TransactionMemberAgent.BuyerBidAgent;
import com.xjtu.power.agent.TransactionMemberAgent.SellerBidAgent;
import lombok.AllArgsConstructor;

/**
 * @Author: Jay
 * @Date: Created in 19:55 2018/12/26
 * @Modified By:
 */
@AllArgsConstructor
public class ResultPair {

    private double quantity;

    private BuyerBidAgent buyer;

    private SellerBidAgent seller;
}
