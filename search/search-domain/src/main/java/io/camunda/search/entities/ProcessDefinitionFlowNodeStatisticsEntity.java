/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH under
 * one or more contributor license agreements. See the NOTICE file distributed
 * with this work for additional information regarding copyright ownership.
 * Licensed under the Camunda License 1.0. You may not use this file
 * except in compliance with the Camunda License 1.0.
 */
package io.camunda.search.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.camunda.util.ObjectBuilder;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ProcessDefinitionFlowNodeStatisticsEntity(
    String flowNodeId, Long active, Long canceled, Long incidents, Long completed) {

  public static class Builder implements ObjectBuilder<ProcessDefinitionFlowNodeStatisticsEntity> {

    private String flowNodeId;
    private Long active;
    private Long canceled;
    private Long incidents;
    private Long completed;

    public Builder flowNodeId(final String flowNodeId) {
      this.flowNodeId = flowNodeId;
      return this;
    }

    public Builder active(final Long active) {
      this.active = active;
      return this;
    }

    public Builder canceled(final Long canceled) {
      this.canceled = canceled;
      return this;
    }

    public Builder incidents(final Long incidents) {
      this.incidents = incidents;
      return this;
    }

    public Builder completed(final Long completed) {
      this.completed = completed;
      return this;
    }

    @Override
    public ProcessDefinitionFlowNodeStatisticsEntity build() {
      return new ProcessDefinitionFlowNodeStatisticsEntity(
          Objects.requireNonNull(flowNodeId, "Expected non-null field for flowNodeId."),
          active,
          canceled,
          incidents,
          completed);
    }
  }
}
