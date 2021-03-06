/*
 * Copyright 1999-2015 dangdang.com.
 * <p>
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
 * </p>
 */

package com.dangdang.ddframe.rdb.sharding.spring.cases.namespace;

import com.dangdang.ddframe.rdb.sharding.metrics.MetricsContext;
import com.dangdang.ddframe.rdb.sharding.metrics.ThreadLocalObjectContainer;
import com.dangdang.ddframe.rdb.sharding.spring.AbstractShardingBothDataBasesAndTablesSpringDBUnitTest;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;

import java.sql.Connection;

import static org.junit.Assert.assertNotNull;

@ContextConfiguration(locations = "classpath:META-INF/rdb/namespace/withNamespaceAlgorithmClassAndProps.xml")
public final class WithNamespaceAlgorithmClassAndPropsTest extends AbstractShardingBothDataBasesAndTablesSpringDBUnitTest {
    
    @Test
    public void testMetricsContextWhenEnable() throws  NoSuchFieldException {
        try (Connection connection = getShardingDataSource().getConnection()) {
            assertNotNull(ThreadLocalObjectContainer.getItem(MetricsContext.class));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
