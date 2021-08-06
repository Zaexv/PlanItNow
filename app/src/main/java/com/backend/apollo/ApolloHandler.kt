package com.backend.apollo

import AllPlansQuery
import com.apollographql.apollo.ApolloCall
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.exception.ApolloException
import com.tfm.planitnow.models.Plan

const val GraphQLServerAddress = "http://localhost:8000/graphql";

open class ApolloHandler() {

companion object {
    private var apolloClient : ApolloClient? = null;
    fun getInstance(): ApolloClient? {
        if (apolloClient == null) {
            apolloClient = buildApolloClient();
        }
        return apolloClient;
    }

    private fun buildApolloClient(): ApolloClient {
        return ApolloClient.builder()
            .serverUrl(GraphQLServerAddress)
            .build();
    }

    fun getAllPlans(): List<Plan> {
        var allPlansQuery : List<AllPlansQuery.AllPlan?>? = null;
        val result : List<Plan> = ArrayList();

        val response = apolloClient?.query(AllPlansQuery())?.enqueue(object:
            ApolloCall.Callback<AllPlansQuery.Data>(){
            override fun onResponse(response: Response<AllPlansQuery.Data>) {
                allPlansQuery = response.data?.allPlans!!;
                for (query in allPlansQuery!!){
                    val p = Plan(Integer.parseInt(query?.id), query?.title, query?.description)
                }
            }
            override fun onFailure(e: ApolloException){
                println("Failed!");
            }
        }
        );

        return result;
    }
}
}