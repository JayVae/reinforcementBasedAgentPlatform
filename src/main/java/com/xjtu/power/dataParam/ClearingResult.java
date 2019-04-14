package com.xjtu.power.dataParam;

import lombok.Data;

import java.util.List;

/**
 * @Author: Jay
 * @Date: Created in 19:47 2018/12/26
 * @Modified By:
 */
@Data
public class ClearingResult {

    private double clearPrice;

    private List<ResultPair> resultPairList;
}
