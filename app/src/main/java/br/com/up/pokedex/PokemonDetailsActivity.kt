package br.com.up.pokedex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import br.com.up.pokedex.network.PokeApi
import com.squareup.picasso.Picasso

class PokemonDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_details)

        val pokemonName = intent.getStringExtra("pokemon")
        val tvPokeName =  findViewById<TextView>(R.id.tvName)
        val ivPokeImage = findViewById<ImageView>(R.id.ivImage)

        val tvStatusName1 = findViewById<TextView>(R.id.tvStatsNome1)
        val tvStatusName2 = findViewById<TextView>(R.id.tvStatsNome2)
        val tvStatusName3 = findViewById<TextView>(R.id.tvStatsNome3)
        val tvStatusName4 = findViewById<TextView>(R.id.tvStatsNome4)
        val tvStatusName5 = findViewById<TextView>(R.id.tvStatsNome5)
        val tvStatusName6 = findViewById<TextView>(R.id.tvStatsNome6)

        val tvStatusValue1 = findViewById<TextView>(R.id.tvStatsValue1)
        val tvStatusValue2 = findViewById<TextView>(R.id.tvStatsValue2)
        val tvStatusValue3 = findViewById<TextView>(R.id.tvStatsValue3)
        val tvStatusValue4 = findViewById<TextView>(R.id.tvStatsValue4)
        val tvStatusValue5 = findViewById<TextView>(R.id.tvStatsValue5)
        val tvStatusValue6 = findViewById<TextView>(R.id.tvStatsValue6)

        val tvType1 = findViewById<TextView>(R.id.tvType1)
        val tvType2 = findViewById<TextView>(R.id.tvType2)

        val tvAbilitie1 = findViewById<TextView>(R.id.tvabilitii1)
        val tvAbilitie2 = findViewById<TextView>(R.id.tvabilitii2)

        val tvMove1 = findViewById<TextView>(R.id.tvMove1)
        val tvMove2 = findViewById<TextView>(R.id.tvMove2)
        val tvMove3 = findViewById<TextView>(R.id.tvMove3)



        PokeApi().getPokemonByName(pokemonName!!){
            if (it != null) {
                val id = it.id
                val url = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$id.png"
                tvPokeName.text = it.name
                tvStatusName1.text = it.stats[0].stat.name
                tvStatusName2.text = it.stats[1].stat.name
                tvStatusName3.text = it.stats[2].stat.name
                tvStatusName4.text = it.stats[3].stat.name
                tvStatusName5.text = it.stats[4].stat.name
                tvStatusName6.text = it.stats[5].stat.name

                tvStatusValue1.text = it.stats[0].base_stat.toString()
                tvStatusValue2.text = it.stats[1].base_stat.toString()
                tvStatusValue3.text = it.stats[2].base_stat.toString()
                tvStatusValue4.text = it.stats[3].base_stat.toString()
                tvStatusValue5.text = it.stats[4].base_stat.toString()
                tvStatusValue6.text = it.stats[5].base_stat.toString()

                tvType1.text = it.types[0].type.name
                if(it.types.size > 1){
                    tvType2.text = it.types[1].type.name
                }else{
                    tvType2.visibility = View.GONE
                }

                tvAbilitie1.text = it.abilities[0].ability.name
                tvAbilitie2.text = it.abilities[0].ability.name

                tvMove1.text = it.moves[0].move.name
                tvMove2.text = it.moves[1].move.name
                tvMove3.text = it.moves[3].move.name

                Picasso.get().load(url).into(ivPokeImage)
            }
        }

    }
}