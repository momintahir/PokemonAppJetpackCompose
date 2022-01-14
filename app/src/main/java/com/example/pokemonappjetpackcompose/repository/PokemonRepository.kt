package com.example.pokemonappjetpackcompose.repository

import com.example.pokemonappjetpackcompose.data.remote.PokeApi
import com.example.pokemonappjetpackcompose.data.remote.responses.Pokemon
import com.example.pokemonappjetpackcompose.data.remote.responses.PokemonList
import com.example.pokemonappjetpackcompose.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import java.lang.Exception
import java.time.ZoneOffset
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(
    private val api:PokeApi
) {
suspend fun getPokemonList(limit:Int,offset: Int): Resource<PokemonList> {
    val response = try {
        api.getPokemonList(limit, offset)
    }
    catch (e:Exception){
        return Resource.Error("An unknown error occurred")
    }
    return Resource.Success(response)
}

    suspend fun getPokemonInfo(pokemonName:String): Resource<Pokemon> {
        val response = try {
            api.getPokemonInfo(pokemonName)
        }
        catch (e:Exception){
            return Resource.Error("An unknown error occurred")
        }
        return Resource.Success(response)
    }
}