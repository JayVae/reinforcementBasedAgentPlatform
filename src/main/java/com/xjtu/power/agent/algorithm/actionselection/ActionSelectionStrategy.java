package com.xjtu.power.agent.algorithm.actionselection;

import com.xjtu.power.agent.algorithm.utils.IndexValue;
import com.xjtu.power.agent.algorithm.models.QModel;
import com.xjtu.power.agent.algorithm.models.UtilityModel;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;


/**
 * Created by xschen on 9/27/2015 0027.
 */
public interface ActionSelectionStrategy extends Serializable, Cloneable {
    IndexValue selectAction(int stateId, QModel model, Set<Integer> actionsAtState);
    IndexValue selectAction(int stateId, UtilityModel model, Set<Integer> actionsAtState);
    String getPrototype();
    Map<String, String> getAttributes();
}
