package com.xjtu.power.agent.TransactionMemberAgent;

import com.xjtu.power.dataParam.ClearingResult;
import com.xjtu.power.dataParam.ResultPair;
import com.xjtu.power.tool.ClearingTool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: Jay
 * @Date: Created in 15:04 2019/4/2
 * @Modified By:
 */
public class PXCAgent {


    public ClearingResult Clearing(List<BuyerBidAgent> buyerList, List<SellerBidAgent> sellerList){
        //        1.数据有效筛选
        List<BuyerBidAgent> buyers = filterBuyer(buyerList);
        List<SellerBidAgent> sellers = filterSeller(sellerList);
//        2.交易排序
        Collections.sort(sellers, new ClearingTool.PriceIncComparator()); // 根据价格排序
        Collections.sort(buyers, new ClearingTool.PriceDecComparator()); // 根据价格排序
//        3.交易竞价
        ClearingResult clearingResult = bid(buyers,sellers);
        return clearingResult;
    }

    private ClearingResult bid(List<BuyerBidAgent> buyers, List<SellerBidAgent> sellers){

        ClearingResult cr = new ClearingResult();
        ArrayList<ResultPair> resultPairs = new ArrayList<ResultPair>();
        Double clearPrice = 0.0;
        int i = 0, j = 0;
        while(i!=buyers.size() && j!=sellers.size()){
            BuyerBidAgent buyer = buyers.get(i);
            SellerBidAgent seller = sellers.get(j);
            Double quantityNow = 0.0;
            quantityNow = Math.min(buyer.getQuantity()-buyer.getFinalQuantity(),seller.getQuantity()-seller.getFinalQuantity());
            buyer.setFinalQuantity(buyer.getFinalQuantity()+quantityNow);
            seller.setFinalQuantity(seller.getFinalQuantity()+quantityNow);
            ResultPair resultPair = new ResultPair(quantityNow,buyer,seller);
            resultPairs.add(resultPair);
            clearPrice = (buyer.getPrice()+seller.getPrice())/2;
            if (buyer.getFinalQuantity() == buyer.getQuantity() || seller.getFinalQuantity() == seller.getQuantity()){
                if (buyer.getFinalQuantity() == buyer.getQuantity()){
                    i++;
                }
                if (seller.getFinalQuantity() == seller.getQuantity()){
                    j++;
                }
            }
        }
        cr.setClearPrice(clearPrice);
        cr.setResultPairList(resultPairs);
        return cr;
    }

    private List<SellerBidAgent> filterSeller(List<SellerBidAgent> sellerList) {
        return sellerList;
    }

    private List<BuyerBidAgent> filterBuyer(List<BuyerBidAgent> buyerList) {
        return buyerList;
    }


    public static void main(String[] args){

    }
}
