package com.orange.client.githubimport.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Copyright (C) 2016 Orange
 * <p>
 * This software is distributed under the terms and conditions of the 'Apache-2.0'
 * license which can be found in the file 'LICENSE' in this package distribution
 * or at 'https://opensource.org/licenses/Apache-2.0'.
 * <p>
 * Author: Arthur Halet
 * Date: 14/09/2016
 */
public class Since extends Date {

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public Since() {
        super();
    }

    public Since(long date) {
        super(date);
    }

    public Since(Date date) {
        this(date.getTime());
    }

    @Override
    public String toString() {
        return this.dateFormat.format(this);
    }
}
