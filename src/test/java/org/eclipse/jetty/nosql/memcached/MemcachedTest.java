package org.eclipse.jetty.nosql.memcached;

//========================================================================
//Copyright (c) 2011 Intalio, Inc.
//------------------------------------------------------------------------
//All rights reserved. This program and the accompanying materials
//are made available under the terms of the Eclipse Public License v1.0
//and Apache License v2.0 which accompanies this distribution.
//The Eclipse Public License is available at
//http://www.eclipse.org/legal/epl-v10.html
//The Apache License v2.0 is available at
//http://www.opensource.org/licenses/apache2.0.php
//You may elect to redistribute this code under either of these licenses.
//========================================================================


import java.util.Set;

public class MemcachedTest
{
    public static void main(String... args) throws Exception
    {
// TODO: port this tests for MemcahedClient.
/*    	
        Mongo m = new Mongo( "127.0.0.1" , 27017 );
        
        DB db = m.getDB( "mydb" );
        
        Set<String> colls = db.getCollectionNames();

        System.err.println("Colls="+colls);
        
        DBCollection coll = db.getCollection("testCollection");
        

        BasicDBObject key = new BasicDBObject("id","1234");
        BasicDBObject sets = new BasicDBObject("name","value");
        BasicDBObject upsert=new BasicDBObject("$set",sets);
        
        WriteResult result =coll.update(key,upsert,true,false);
        
        System.err.println(result.getLastError());
        
        
        while (coll.count()>0)
        {
            DBObject docZ = coll.findOne();
            System.err.println("removing    "+ docZ);
            if (docZ!=null)
                coll.remove(docZ);
        }
        */
     
    }
}