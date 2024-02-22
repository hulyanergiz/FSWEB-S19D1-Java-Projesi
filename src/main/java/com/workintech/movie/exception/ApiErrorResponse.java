package com.workintech.movie.exception;

import java.time.LocalDateTime;

public record ApiErrorResponse(int status, String message, LocalDateTime createdAt) {
}
