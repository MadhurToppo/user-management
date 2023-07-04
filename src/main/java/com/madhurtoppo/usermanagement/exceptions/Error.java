package com.madhurtoppo.usermanagement.exceptions;

import java.util.Date;

/** ErrorDetails */
public record Error(String message, String details, Date timestamp) {}
