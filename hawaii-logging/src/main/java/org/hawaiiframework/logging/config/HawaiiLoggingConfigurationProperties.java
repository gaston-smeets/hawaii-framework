/*
 * Copyright 2015-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.hawaiiframework.logging.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.stereotype.Component;

/**
 * Model class that represents the Hawaii logging configuration properties.
 *
 * @author Paul Klos
 * @author Wouter Eerdekens
 * @since 2.0.0
 */
@Component
@ConfigurationProperties(prefix = "hawaii.logging.filters")
public class HawaiiLoggingConfigurationProperties {

    @NestedConfigurationProperty
    private LoggingFilterProperties kibana;

    @NestedConfigurationProperty
    private LoggingFilterProperties requestDuration;

    @NestedConfigurationProperty
    private RequestResponseLogFilterConfiguration requestResponse;

    @NestedConfigurationProperty
    private LoggingFilterProperties requestId;

    @NestedConfigurationProperty
    private LoggingFilterProperties transactionId;

    @NestedConfigurationProperty
    private LoggingFilterProperties userDetails;

    public LoggingFilterProperties getKibana() {
        return kibana;
    }

    public void setKibana(final LoggingFilterProperties kibana) {
        this.kibana = kibana;
    }

    public LoggingFilterProperties getRequestDuration() {
        return requestDuration;
    }

    public void setRequestDuration(final LoggingFilterProperties requestDuration) {
        this.requestDuration = requestDuration;
    }

    public RequestResponseLogFilterConfiguration getRequestResponse() {
        return requestResponse;
    }

    public void setRequestResponse(final RequestResponseLogFilterConfiguration requestResponse) {
        this.requestResponse = requestResponse;
    }

    public LoggingFilterProperties getRequestId() {
        return requestId;
    }

    public void setRequestId(final LoggingFilterProperties requestId) {
        this.requestId = requestId;
    }

    public LoggingFilterProperties getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(final LoggingFilterProperties transactionId) {
        this.transactionId = transactionId;
    }

    public LoggingFilterProperties getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(final LoggingFilterProperties userDetails) {
        this.userDetails = userDetails;
    }
}