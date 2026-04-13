package com.can.taskapi;

public record TaskDto(Long id, String title, String description, CardStatus status) {}