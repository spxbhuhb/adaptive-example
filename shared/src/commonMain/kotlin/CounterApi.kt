import hu.simplexion.adaptive.service.ServiceApi

@ServiceApi
interface CounterApi {

    suspend fun incrementAndGet() : Int

}