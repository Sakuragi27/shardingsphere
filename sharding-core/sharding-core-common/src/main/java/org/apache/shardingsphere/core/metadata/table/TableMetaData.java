/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.core.metadata.table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Table metadata.
 *
 * @author panjuan
 */
@Getter
@EqualsAndHashCode
@ToString
public final class TableMetaData {
    
    private final Map<String, ColumnMetaData> columns;
    
    private final Set<String> logicIndexes;
    
    public TableMetaData(final Collection<ColumnMetaData> columnMetaDataList, final Set<String> logicIndexes) {
        columns = getColumns(columnMetaDataList);
        this.logicIndexes = logicIndexes;
    }
    
    private Map<String, ColumnMetaData> getColumns(final Collection<ColumnMetaData> columnMetaDataList) {
        final Map<String, ColumnMetaData> columns;
        columns = new LinkedHashMap<>(columnMetaDataList.size(), 1);
        for (ColumnMetaData each : columnMetaDataList) {
            columns.put(each.getColumnName(), each);
        }
        return columns;
    }
}
