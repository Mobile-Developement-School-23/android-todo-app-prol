package com.example.todoapp.api

import com.example.todoapp.api.request.TaskListRequest
import com.example.todoapp.api.request.TaskRequest
import com.example.todoapp.api.response.TaskListResponse
import com.example.todoapp.api.response.TaskResponse
import com.example.todoapp.utils.TOKEN
import retrofit2.Response
import retrofit2.http.*
import java.util.UUID

interface ToDoApi {

    @GET("list")
    @Headers("Authorization: Bearer $TOKEN")
    suspend fun getList(): Response<TaskListResponse>

    @PATCH("list")
    @Headers("Authorization: Bearer $TOKEN")
    suspend fun updateList(
        @Header("X-Last-Known-Revision") lastKnownRevision: Int,
        @Body taskListRequest: TaskListRequest
    ): Response<TaskListResponse>

    @GET("list/{id}")
    @Headers("Authorization: Bearer $TOKEN")
    suspend fun getTaskById(@Path("id") itemId: UUID): Response<TaskResponse>

    @POST("list")
    @Headers("Authorization: Bearer $TOKEN")
    suspend fun addTask(
        @Header("X-Last-Known-Revision") lastKnownRevision: Int,
        @Body taskRequest: TaskRequest
    ): Response<TaskResponse>

    @PUT("list/{id}")
    @Headers("Authorization: Bearer $TOKEN")
    suspend fun updateTask(
        @Header("X-Last-Known-Revision") lastKnownRevision: Int,
        @Path("id") itemId: UUID,
        @Body taskRequest: TaskRequest
    ): Response<TaskResponse>

    @DELETE("list/{id}")
    @Headers("Authorization: Bearer $TOKEN")
    suspend fun deleteTask(
        @Header("X-Last-Known-Revision") lastKnownRevision: Int,
        @Path("id") itemId: UUID,
    ): Response<TaskResponse>

}