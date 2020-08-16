package features.coroutines

import kotlinx.coroutines.*
import kotlin.random.Random
import kotlin.system.measureTimeMillis

fun main() {
    runBlocking {
//    simpleDifferenceBetweenAsyncVsSync()

//        doWorkAsync().await()

//        doLazyWorkAsync()
        val asdf = async(start = CoroutineStart.LAZY) {  doLazyWorkAsync() }
        println("${asdf.await()}")
    }
}

suspend fun doWorkAsync(): Deferred<Int> = coroutineScope {
    async {
        println("getting data")
        delay(500)
        println("got data")
        return@async 42
    }
}

suspend fun doLazyWorkAsync(): Int {
    println("getting lazy data")
    delay(500)
    println("got lazy data")
    return 42
}

private fun simpleDifferenceBetweenAsyncVsSync() {
    runBlocking {
        val job = launch {
            //Synchronous Work
            val time1 = measureTimeMillis {
                val r1 = doWorkOne()
                val r2 = doWorkTwo()
                println("result: ${r1 + r2}")
            }
            println("Synchronous(Sequential) Time It Takes: $time1")

            println("------------------")

            //Asynchronous Work
            val time2 = measureTimeMillis {
                val r1 = async { doWorkOne() }
                val r2 = async { doWorkTwo() }
                println("result: ${r1.await() + r2.await()}")
            }
            println("Asynchronous Time It Take: $time2")
        }
    }
}

suspend fun doWorkOne(): Int {
    delay(100)
    println("Doing Work 1")
    return Random(System.currentTimeMillis()).nextInt(42)
}

suspend fun doWorkTwo(): Int {
    delay(200)
    println("Doing Work 2")
    return Random(System.currentTimeMillis()).nextInt(42)
}
