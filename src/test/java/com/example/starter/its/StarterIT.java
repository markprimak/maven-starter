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
package com.example.starter.its;

import com.example.starter.Calculator;
import com.flowlogix.testcontainers.PayaraServerLifecycleExtension;
import com.flowlogix.util.ShrinkWrapManipulator;
import jakarta.inject.Inject;
import org.eu.ingwar.tools.arquillian.extension.suite.annotations.ArquillianSuiteDeployment;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit5.ArquillianExtension;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import java.util.Random;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(PayaraServerLifecycleExtension.class)
@ExtendWith(ArquillianExtension.class)
@ArquillianSuiteDeployment
class StarterIT {
    @Inject
    Calculator calculator;

    private final Random random = new Random();

    @Test
    @SuppressWarnings("checkstyle:MagicNumber")
    void subtract() {
        int a = random.nextInt(1, 1000);
        int b = random.nextInt(1, 1000);
        assertThat(calculator.subtract(a, b)).isEqualTo(a - b);
    }

    @Deployment
    @SuppressWarnings("unused")
    static WebArchive deploy() {
        return ShrinkWrapManipulator.createDeployment(WebArchive.class);
    }
}
