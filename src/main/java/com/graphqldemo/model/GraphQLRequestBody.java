package com.graphqldemo.model;

import java.util.Map;

public record GraphQLRequestBody(
        String query,
        String operation, Map<String, Object> variables) {
}
