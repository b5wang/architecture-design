package com.b5wang.architect.ratelimiting.conf;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Configuration
public class SentinelFlowRulesConfig {

    @PostConstruct
    public void initFlowRules(){
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule();
        rule.setResource("sayHello");
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        // Set limit QPS to 1.
        rule.setCount(1);
        rules.add(rule);
        FlowRuleManager.loadRules(rules);
        log.info("Init sentinel flow rules.");
    }

}
