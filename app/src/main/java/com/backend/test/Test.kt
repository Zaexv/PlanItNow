package com.backend.test

import AllPlansQuery
import com.apollographql.apollo.ApolloCall
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.coroutines.await
import com.apollographql.apollo.exception.ApolloException
import com.tfm.planitnow.models.Plan

class Test {
    companion object {
        @JvmStatic fun main(args: Array<String>) {
            connectionTest();
        }

        private fun connectionTest(){

            var res = "";

            val apolloClient: ApolloClient = ApolloClient.builder()
                .serverUrl("http://localhost:8000/graphql")
                .build();

            val response = apolloClient.query(AllPlansQuery()).enqueue(object:
                ApolloCall.Callback<AllPlansQuery.Data>(){
                override fun onResponse(response: Response<AllPlansQuery.Data>) {

                    for(plan in response.data?.allPlans!!){
                        println(plan.toString());
                    }
                    println(response.data?.allPlans!!);
                }
                override fun onFailure(e: ApolloException){
                    println("Failed!");
                }
            }
            );
        }


        //Esto teóricamente se puede llamar sólo desde corutinas.
        suspend fun doQuery(apolloClient: ApolloClient){
            val res2 =
                apolloClient.query(AllPlansQuery()).await();


            for(plan in res2.data?.allPlans!!){
                println(plan.toString());
            }
        }

    }





}