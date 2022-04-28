package com.example.randomuser.domain.usecase

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.randomuser.data.dto.UserResponse
import com.example.randomuser.data.remote.api.UserList
import com.example.randomuser.data.source.UserListPagingSource
import kotlinx.coroutines.flow.Flow
//import javax.inject.Inject
//import javax.inject.Singleton

class LoadRandomPagingUserListUseCase (
    private val remoteApi: UserList
) {

    fun load(): Flow<PagingData<UserResponse>> {
        return Pager(
            config = PagingConfig(
                pageSize = UserList.defaultPageSize,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { UserListPagingSource(remoteApi) }
        ).flow
    }
}