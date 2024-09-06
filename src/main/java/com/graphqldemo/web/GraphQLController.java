package com.graphqldemo.web;

import com.graphqldemo.model.GraphQLRequestBody;
import graphql.ExecutionInput;
import graphql.ExecutionResult;
import graphql.GraphQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController("v1")
public class GraphQLController {

    @Autowired
    private GraphQL graphQL;

    @PostMapping(value = "graphql")
    public Mono<Map<String, Object>> execute(@RequestBody GraphQLRequestBody requestBody) {

        return Mono.fromCompletionStage(
                        graphQL.executeAsync(
                                ExecutionInput.newExecutionInput()
                                        .query(requestBody.query())
                                        .operationName(requestBody.operation())
                                        .variables(requestBody.variables())
                                        .build()))
                .map(ExecutionResult::toSpecification);
    }
}
