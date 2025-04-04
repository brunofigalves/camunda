/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH under
 * one or more contributor license agreements. See the NOTICE file distributed
 * with this work for additional information regarding copyright ownership.
 * Licensed under the Camunda License 1.0. You may not use this file
 * except in compliance with the Camunda License 1.0.
 */
import { FC, FormEvent } from "react";
import { Form, Stack, Loading } from "@carbon/react";
import { spacing06, colors } from "@carbon/elements";
import styled from "styled-components";
import Modal, { ModalProps } from "./Modal";

// carbon element z-indexes can only be imported using scss modules
import styles from "./styles.module.scss";

const HiddenSubmitButton = styled.input`
  display: none;
`;

const LoadingLabel = styled.div`
  position: fixed;
  color: ${colors.white};
  z-index: ${styles.overlayZIndex + 1};
  display: flex;
  align-items: center;
  justify-content: center;
  block-size: 100%;
  inline-size: 100%;
  inset-inline-start: 0;
`;

const FormModal: FC<ModalProps> = ({ children, onSubmit, ...modalProps }) => {
  const formSubmitHandler = (e: FormEvent) => {
    e.preventDefault();
    onSubmit?.();
  };

  return (
    <Modal {...modalProps} onSubmit={onSubmit}>
      {modalProps.loading && (
        <>
          <Loading />
          <LoadingLabel>{modalProps.loadingDescription}</LoadingLabel>
        </>
      )}
      <Form onSubmit={formSubmitHandler}>
        <Stack gap={spacing06}>{children}</Stack>
        <HiddenSubmitButton type="submit" />
      </Form>
    </Modal>
  );
};

export default FormModal;
