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
package org.pr.nb.plugins.mongodb.service;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import java.text.MessageFormat;
import java.util.Objects;
import org.openide.util.lookup.ServiceProvider;
import org.pr.nb.plugins.mongodb.data.MongoDBConnectedInstance;
import org.pr.nb.plugins.mongodb.data.MongoDBInstance;

/**
 *
 * @author Mahakaal
 */
@ServiceProvider(service = MongoService.class)
public class MongoServiceImpl implements MongoService{

    private static final String MONGO_CLIENT_URI_WITH_CREDS_FORMAT="mongodb://{0}:{1}@{2}:{3}";
    private static final String MONGO_CLIENT_URI_WITHOUT_CREDS_FORMAT="mongodb://{0}:{1}";
    @Override
    public void testConnection(MongoDBInstance instance) {
        MongoClient client = prepareClient(instance);
        client.listDatabaseNames();
    }

    @Override
    public MongoDBConnectedInstance connect(MongoDBInstance instance) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void disconnect(MongoDBConnectedInstance instance) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void executeQuery(String queryInJSONForm) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private MongoClient prepareClient( MongoDBInstance instance) {
        MongoClientURI clientUri = null;
        if(Objects.isNull(instance.getUserName()) || instance.getUserName().isEmpty()){
            String uri = MessageFormat.format(MONGO_CLIENT_URI_WITHOUT_CREDS_FORMAT, instance.getHostName(), instance.getPortNumber());
            clientUri = new MongoClientURI(uri);
        }else{
            String uri = MessageFormat.format(MONGO_CLIENT_URI_WITH_CREDS_FORMAT, instance.getUserName(), instance.getPassword(), instance.getHostName(), instance.getPortNumber());
            clientUri = new MongoClientURI(uri);
        }
        MongoClient retValue = new MongoClient(clientUri);
        return retValue;
    }

}
