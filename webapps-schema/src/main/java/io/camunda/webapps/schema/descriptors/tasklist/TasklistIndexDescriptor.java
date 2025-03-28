/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH under
 * one or more contributor license agreements. See the NOTICE file distributed
 * with this work for additional information regarding copyright ownership.
 * Licensed under the Camunda License 1.0. You may not use this file
 * except in compliance with the Camunda License 1.0.
 */
package io.camunda.webapps.schema.descriptors.tasklist;

import static io.camunda.webapps.schema.descriptors.ComponentNames.TASK_LIST;

import io.camunda.webapps.schema.descriptors.AbstractIndexDescriptor;

public abstract class TasklistIndexDescriptor extends AbstractIndexDescriptor {

  public TasklistIndexDescriptor(final String indexPrefix, final boolean isElasticsearch) {
    super(indexPrefix, isElasticsearch);
  }

  @Override
  public String getComponentName() {
    return TASK_LIST.toString();
  }
}
