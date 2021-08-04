package com.tfm.backend

import com.apollographql.apollo.ApolloClient
import com.query.AllPlansQuery

class Main {

    companion object {
        @JvmStatic fun main(args: Array<String>) {
            testeo();
        }

        private fun testeo(){
            val apolloClient = ApolloClient.builder()
                .serverUrl("http://localhost:8000/graphql")
                .build();

            val response = apolloClient.query(AllPlansQuery());


            println(response.toString());
        }
    }






}