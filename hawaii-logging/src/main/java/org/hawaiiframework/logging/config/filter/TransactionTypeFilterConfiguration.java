/*
 * Copyright 2015-2020 the original author or authors.
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

package org.hawaiiframework.logging.config.filter;

import org.hawaiiframework.logging.web.filter.TransactionTypeFilter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.hawaiiframework.logging.config.filter.FilterRegistrationBeanUtil.createFilterRegistrationBean;

/**
 * Configures the {@link TransactionTypeFilter}.
 */
@Configuration
public class TransactionTypeFilterConfiguration {

    /**
     * The logging configuration properties.
     */
    private final HawaiiLoggingConfigurationProperties hawaiiLoggingConfigurationProperties;

    /**
     * The constructor.
     *
     * @param hawaiiLoggingConfigurationProperties The logging configuration properties.
     */
    public TransactionTypeFilterConfiguration(final HawaiiLoggingConfigurationProperties hawaiiLoggingConfigurationProperties) {
        this.hawaiiLoggingConfigurationProperties = hawaiiLoggingConfigurationProperties;
    }

    /**
     * Create the {@link TransactionTypeFilter} bean.
     *
     * @param applicationContext the application context of the Spring Boot Application
     * @return the {@link TransactionTypeFilter} bean, wrapped in a {@link FilterRegistrationBean}
     */
    @Bean
    @ConditionalOnProperty(prefix = "hawaii.logging.filters.transaction-type", name = "enabled")
    public TransactionTypeFilter transactionTypeFilter(final ApplicationContext applicationContext) {
        return new TransactionTypeFilter(applicationContext);
    }

    /**
     * Register the {@link TransactionTypeFilter} bean.
     *
     * @param transactionNameFilter the transaction name filter
     * @return the {@link TransactionTypeFilter} bean, wrapped in a {@link FilterRegistrationBean}
     */
    @Bean
    @ConditionalOnProperty(prefix = "hawaii.logging.filters.transaction-name", name = "enabled")
    public FilterRegistrationBean<TransactionTypeFilter> transactionTypeFilterRegistration(
            final TransactionTypeFilter transactionNameFilter) {
        final var filterProperties = hawaiiLoggingConfigurationProperties.getTransactionType();
        return createFilterRegistrationBean(transactionNameFilter, filterProperties);
    }
}
