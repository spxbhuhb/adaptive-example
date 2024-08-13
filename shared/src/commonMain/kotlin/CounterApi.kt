import `fun`.adaptive.service.ServiceApi

@ServiceApi
interface CounterApi {

    suspend fun incrementAndGet() : Int

}