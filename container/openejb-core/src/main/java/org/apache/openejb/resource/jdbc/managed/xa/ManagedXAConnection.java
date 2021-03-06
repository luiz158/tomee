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

package org.apache.openejb.resource.jdbc.managed.xa;

import org.apache.openejb.resource.jdbc.managed.local.ManagedConnection;

import javax.sql.DataSource;
import javax.sql.XAConnection;
import javax.transaction.TransactionManager;
import javax.transaction.xa.XAResource;
import java.sql.Connection;
import java.sql.SQLException;

public class ManagedXAConnection extends ManagedConnection {
    private final XAConnection xaConnection;

    public ManagedXAConnection(final DataSource ds, final XAConnection xa, final Connection connection, final TransactionManager txMgr) throws SQLException {
        super(ds, connection, txMgr);
        this.xaConnection = xa;
    }

    @Override
    public XAResource getXAResource() throws SQLException {
        return xaConnection.getXAResource();
    }

    @Override
    protected void setAutoCommit(final boolean value) throws SQLException {
        // no-op
    }
}
