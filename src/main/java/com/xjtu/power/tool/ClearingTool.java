package com.xjtu.power.tool;

import com.xjtu.power.agent.TransactionMemberAgent.BuyerBidAgent;
import com.xjtu.power.agent.TransactionMemberAgent.SellerBidAgent;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: Jay
 * @Date: Created in 20:12 2018/12/26
 * @Modified By:
 */
public class ClearingTool {

    // 自定义比较器：对卖方按价格升序
    public static class PriceIncComparator implements Comparator {
        public int compare(Object object1, Object object2) {// 实现接口中的方法
            SellerBidAgent s1 = (SellerBidAgent) object1; // 强制转换
            SellerBidAgent s2 = (SellerBidAgent) object2; // 强制转换
            Double d1 = new Double(s1.getPrice());
            Double d2 = new Double(s2.getPrice());
            if (d1.compareTo(d2)==0){
                return new Double(s2.getQuantity()).compareTo(new Double(s1.getQuantity()));
            }else {
                return d1.compareTo(d2);
            }
        }
    }
    public static class PriceDecComparator implements Comparator {
        public int compare(Object object1, Object object2) {// 实现接口中的方法
            BuyerBidAgent s1 = (BuyerBidAgent) object1; // 强制转换
            BuyerBidAgent s2 = (BuyerBidAgent) object2; // 强制转换
            return new Double(s2.getPrice()).compareTo(new Double(s1.getPrice()));
        }
    }

    public static void myprint(List list) {
        Iterator it = list.iterator(); // 得到迭代器，用于遍历list中的所有元素
        while (it.hasNext()) {// 如果迭代器中有元素，则返回true
            System.out.println("\t" + it.next());// 显示该元素
        }
    }

    public static void main(String[] args){
     /*   List<BuyerBidAgent> list = new ArrayList<BuyerBidAgent>(); // 数组序列
        BuyerBidAgent b1 = new BuyerBidAgent("张三",1,1);
        BuyerBidAgent b2 = new BuyerBidAgent("李四",1,20);
        BuyerBidAgent b3 = new BuyerBidAgent("王五",20,13);
        BuyerBidAgent b4 = new BuyerBidAgent("赵六",1,15);
        BuyerBidAgent b5 = new BuyerBidAgent("钱七",1,13);
        BuyerBidAgent b6 = new BuyerBidAgent("孙八",1,10);
        list.add(b1);
        list.add(b2);
        list.add(b3);
        list.add(b4);
        list.add(b5);
        list.add(b6);
        System.out.println("数组序列中的元素:");
        myprint(list);
        Collections.sort(list,new PriceDecComparator());
        System.out.println("降序结果:");
        myprint(list);

        List<Seller> list1 = new ArrayList<Seller>(); // 数组序列
        Seller s1 = new Seller("张三",1,1);
        Seller s2 = new Seller("李四",1,20);
        Seller s3 = new Seller("王五",1,13);
        Seller s4 = new Seller("赵六",1,15);
        Seller s5 = new Seller("钱七",20,13);
        Seller s6 = new Seller("孙八",1,10);
        list1.add(s1);
        list1.add(s2);
        list1.add(s3);
        list1.add(s4);
        list1.add(s5);
        list1.add(s6);
        System.out.println("数组序列中的元素:");
        myprint(list1);
        Collections.sort(list1,new PriceIncComparator());
        System.out.println("升序结果:");
        myprint(list1);*/
    }
}
