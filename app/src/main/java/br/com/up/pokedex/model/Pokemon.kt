package br.com.up.pokedex.model

data class Pokemon(
    val url : String,
    val name : String,
)

data class PokemonApiResult (
    val name : String,
    val id : Int,
    val types: List<PokemonTypes>,
    val stats: List<PokemonStatus>,
    val moves: List<PokemonMoves>,
    val abilities: List<PokemonAbilities>
        )

data class PokemonTypes(
    val slot: Int,
    val type: PokemonType
)

data class PokemonType (
    val name: String
)

data class PokemonStatus(
    val base_stat : Int,
    val stat: PokemonStat
)

data class PokemonStat(
    val name :String
)

data class PokemonMoves (
    val move : PokemonMove
)
data class PokemonMove(
    val name:String
)

data class PokemonAbilities(
    val ability:PokemonAbilitie
)

data class PokemonAbilitie(
    val name: String
)