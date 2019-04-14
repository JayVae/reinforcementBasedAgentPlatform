package com.xjtu.power.agent.algorithm.learning.qlearn;


import com.xjtu.power.agent.algorithm.actionselection.SoftMaxActionSelectionStrategy;
import org.testng.annotations.Test;

import java.util.Random;


/**
 * Created by xschen on 6/5/2017.
 */
public class QAgentUnitTest {

   @Test
   public void test_q_learn(){
      int stateCount = 100;
      int actionCount = 10;
      QAgent agent = new QAgent(stateCount, actionCount);

      agent.getLearner().setActionSelection(SoftMaxActionSelectionStrategy.class.getCanonicalName());

      Random random = new Random();
      agent.start(random.nextInt(stateCount));
      for(int time=0; time < 1000; ++time){

         int actionId = agent.selectAction().getIndex();
         System.out.println("Agent does action-"+actionId);

         int newStateId = random.nextInt(actionCount);
         double reward = random.nextDouble();

         System.out.println("Now the new state is "+newStateId);
         System.out.println("Agent receives Reward = "+reward);

         agent.update(actionId, newStateId, reward);
      }
   }
}
