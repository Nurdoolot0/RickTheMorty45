package com.example.rickthemorty45.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.rickthemorty45.data.Repository
import com.example.rickthemorty45.data.models.CharacterResponse.Character

class CharacterPagingSource(private val repository: Repository) : PagingSource<Int, Character>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character> {
        val page = params.key ?: 1
        return try {
            val response = repository.getCharacters(page)

            LoadResult.Page(
                data = response.results,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (response.results.isEmpty()) null else page + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Character>): Int? {
        return state.anchorPosition?.let { state.closestPageToPosition(it)?.prevKey }
    }
}