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

import com.flowlogix.testcontainers.PayaraServerLifecycleExtension;
import com.flowlogix.util.ShrinkWrapManipulator;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.junit5.ArquillianExtension;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(PayaraServerLifecycleExtension.class)
@ExtendWith(ArquillianExtension.class)
class IndexPageIT {
    @Drone
    WebDriver browser;

    @FindBy(how = How.TAG_NAME, using = "h1")
    WebElement h1;

    @Test
    void h1HasText() {
        browser.get("index.xhtml");
        assertThat(h1.getText()).isEqualTo("Heading for Starter Project");
    }

    @Deployment
    @SuppressWarnings("unused")
    static WebArchive deploy() {
        return ShrinkWrapManipulator.createDeployment(WebArchive.class);
    }
}
