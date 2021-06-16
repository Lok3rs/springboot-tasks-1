package com.codecool.spingboot_tasks.request_counter.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

@Data
@AllArgsConstructor
public class Statistics {

    private String methodName;
    private int usage;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Statistics that = (Statistics) o;
        return Objects.equals(methodName, that.methodName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(methodName);
    }
}
