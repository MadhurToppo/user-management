package com.madhurtoppo.usermanagement.exceptions;

import java.util.Date;

/** ErrorDetails */
public record Error(boolean success, String message, String details, Date timestamp) {
}
