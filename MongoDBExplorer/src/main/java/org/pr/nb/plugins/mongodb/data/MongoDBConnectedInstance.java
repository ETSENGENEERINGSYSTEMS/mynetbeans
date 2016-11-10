/*
 * Copyright 2016 Mahakaal.
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
package org.pr.nb.plugins.mongodb.data;

import com.mongodb.MongoClient;

/**
 *
 * @author Mahakaal
 */
public class MongoDBConnectedInstance extends MongoDBInstance {
    MongoClient client;

    public MongoDBConnectedInstance(MongoClient client, String id, String hostName, Integer portNumber, String userName, String displayName) {
        super(id, hostName, portNumber, userName, displayName);
        this.client = client;
    }

    public MongoClient getClient() {
        return client;
    }
    
}
