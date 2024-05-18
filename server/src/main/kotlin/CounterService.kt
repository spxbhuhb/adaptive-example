import hu.simplexion.adaptive.server.builtin.ServiceImpl
import hu.simplexion.adaptive.server.builtin.worker

class CounterService : CounterApi, ServiceImpl<CounterService> {

    val worker by worker<CounterWorker>()

    override suspend fun incrementAndGet(): Int {
        return worker.counter.incrementAndGet()
    }

}