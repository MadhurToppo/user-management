package com.madhurtoppo.usermanagement.exceptions;

import java.util.Date;

/** ErrorDetails */
public record Error(boolean status, String message, String details, Date timestamp) {
}
