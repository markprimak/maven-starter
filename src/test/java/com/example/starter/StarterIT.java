/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.example.starter;

import com.flowlogix.testcontainers.PayaraServerLifecycleExtension;
import com.flowlogix.util.ShrinkWrapManipulator;
import org.eu.ingwar.tools.arquillian.extension.suite.annotations.ArquillianSuiteDeployment;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit5.ArquillianExtension;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(PayaraServerLifecycleExtension.class)
@ExtendWith(ArquillianExtension.class)
@ArquillianSuiteDeployment
class StarterIT {
    @Test
    void sanityCheck() {
        assertThat(true).isTrue();
    }

    @Test
    @SuppressWarnings("checkstyle:MagicNumber")
    void calcBasicFunc() {
        int a = (int) (Math.random() * 100) + 1;
        int b = (int) (Math.random() * 100) + 1;
        Calculator calculator = new Calculator();
        assertThat(calculator.add(a, b)).isEqualTo(a + b);
        assertThat(calculator.subtract(a, b)).isEqualTo(a - b);
        assertThat(calculator.multiply(a, b)).isEqualTo(a * b);
        assertThat(calculator.divide(a, b)).isEqualTo(a / b);
    }

    @Deployment
    @SuppressWarnings("unused")
    static WebArchive deploy() {
        return ShrinkWrapManipulator.createDeployment(WebArchive.class);
    }
}
