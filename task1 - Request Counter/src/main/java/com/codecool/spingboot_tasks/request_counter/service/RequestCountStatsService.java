package com.codecool.spingboot_tasks.request_counter.service;

import com.codecool.spingboot_tasks.request_counter.model.Statistics;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RequestCountStatsService {

    /*
     * Map holding statistics of methods execution. key is method name: GET,PUT etc.
     * value is and integer number representing number of executions
     */
    private Map<String, Integer> stats = new HashMap<>();

    public void increaseCounter(String method){
        if(stats.containsKey(method)){
            stats.put(method, stats.get(method) + 1);
        }else{
            stats.put(method, 1);
        }
    }

    public List<Statistics> getStatistics(){
        List<Statistics> statsList = new ArrayList<>();
        Set<String> keys = stats.keySet();

        for (String key : keys) {
            Integer integer = stats.get(key);
            statsList.add(new Statistics(key, integer));
        }
        return  statsList;
    }
}
