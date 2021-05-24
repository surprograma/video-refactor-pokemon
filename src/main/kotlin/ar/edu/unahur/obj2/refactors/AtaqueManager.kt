package ar.edu.unahur.obj2.refactors

object AtaqueManager {
    fun resolverAtaque(ataque: Ataque, atacante: Pokemon, atacado: Pokemon) {
        if (!atacante.estado.puedeAtacar() || atacante.estaDebilitado() || atacado.estaDebilitado())
            return

        ataque.atacar(atacante, atacante.estado.obtenerAtacado(atacante, atacado))
    }
}

interface Ataque {
    fun atacar(atacante: Pokemon, atacado: Pokemon)
}

object PistolaDeAgua : Ataque {
    override fun atacar(atacante: Pokemon, atacado: Pokemon) {
        atacado.vida -= atacante.dañoPara(10)
    }
}

object Derribo : Ataque {
    override fun atacar(atacante: Pokemon, atacado: Pokemon) {
        atacado.vida -= atacante.dañoPara(25)
        atacante.vida -= 5
    }
}

object Descanso : Ataque {
    override fun atacar(atacante: Pokemon, atacado: Pokemon) {
        atacante.estado = EstadoPokemon.Dormido
        atacante.curar()
    }
}

object RayoConfuso : Ataque {
    override fun atacar(atacante: Pokemon, atacado: Pokemon) {
        atacado.estado = EstadoPokemon.Confundido
    }
}