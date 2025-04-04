/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH under
 * one or more contributor license agreements. See the NOTICE file distributed
 * with this work for additional information regarding copyright ownership.
 * Licensed under the Camunda License 1.0. You may not use this file
 * except in compliance with the Camunda License 1.0.
 */
package io.camunda.db.rdbms.sql;

import io.camunda.db.rdbms.read.domain.BatchOperationDbQuery;
import io.camunda.db.rdbms.write.domain.BatchOperationDbModel;
import io.camunda.search.entities.BatchOperationEntity;
import io.camunda.search.entities.BatchOperationEntity.BatchOperationItemEntity;
import io.camunda.search.entities.BatchOperationEntity.BatchOperationStatus;
import java.time.OffsetDateTime;
import java.util.List;

public interface BatchOperationMapper {

  void insert(BatchOperationDbModel batchOperationDbModel);

  void insertItems(BatchOperationItemsDto items);

  void updateCompleted(BatchOperationUpdateDto dto);

  void updateItemsWithState(BatchOperationItemStatusUpdateDto dto);

  void incrementOperationsTotalCount(BatchOperationUpdateTotalCountDto dto);

  void incrementFailedOperationsCount(Long batchOperationKey);

  void incrementCompletedOperationsCount(Long batchOperationKey);

  Long count(BatchOperationDbQuery query);

  List<BatchOperationDbModel> search(BatchOperationDbQuery query);

  List<BatchOperationItemEntity> getItems(Long batchOperationKey);

  record BatchOperationUpdateDto(
      long batchOperationKey, BatchOperationStatus status, OffsetDateTime endDate) {}

  record BatchOperationUpdateTotalCountDto(long batchOperationKey, int operationsTotalCount) {}

  record BatchOperationItemsDto(Long batchOperationKey, List<Long> items) {}

  record BatchOperationItemDto(
      Long batchOperationKey, Long itemKey, BatchOperationEntity.BatchOperationItemStatus status) {}

  record BatchOperationItemStatusUpdateDto(
      Long batchOperationKey,
      BatchOperationEntity.BatchOperationItemStatus oldState,
      BatchOperationEntity.BatchOperationItemStatus newState) {}
}
