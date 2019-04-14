package com.xjtu.power.agent.algorithm.learning.utils;

import com.alibaba.fastjson.JSON;
import com.xjtu.power.agent.algorithm.utils.Vec;
import org.testng.annotations.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class VecUnitTest {
    @Test
    public void testJsonSerialization() {
        Vec vec = new Vec(100);
        vec.set(9, 100);
        vec.set(11, 2);
        vec.set(0, 1);
        String json = JSON.toJSONString(vec);
        Vec vec2 = JSON.parseObject(json, Vec.class);
        assertThat(vec).isEqualTo(vec2);
    }
}
