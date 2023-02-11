package com.codestates.todoappv2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class TodoDto {

    @Getter
    public static class TodoPostDto {
        private String title;
        private int todo_order;
        private boolean completed;
    }

    @Getter
    @Setter
    public static class TodoPatchDto {
        private long todoId;
        private String title;
        private boolean completed;
    }

    @Getter
    @AllArgsConstructor
    public static class TodoResponseDto {
        private long todoId;
        private String title;
        private int todo_order;
        private boolean completed;
    }
}
