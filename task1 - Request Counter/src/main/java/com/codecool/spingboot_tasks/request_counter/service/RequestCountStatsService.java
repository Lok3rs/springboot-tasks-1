package com.codecool.spingboot_tasks.request_counter.service;

import com.codecool.spingboot_tasks.request_counter.model.Statistics;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RequestCountStatsService {

    public static String GET = "GET";
    public static String POST = "POST";
    public static String PUT = "PUT";
    public static String DELETE = "DELETE";
    public static String PATCH = "PATCH";
    /*
     * Map holding statistics of methods execution. key is method name: GET,PUT etc.
     * value is and integer number representing number of executions
     */
    private final Map<String, Integer> stats = new HashMap<>();

    public void increaseCounter(String method) {
        if (stats.containsKey(method)) {
            stats.put(method, stats.get(method) + 1);
        } else {
            stats.put(method, 1);
        }
        System.out.println("Unique methods number: " + stats.size() + " counter for " + method + ": " + stats.get(method));
    }

    public Statistics getStatistics() throws Exception {
        throw new Exception("Not implemented");
    }
}