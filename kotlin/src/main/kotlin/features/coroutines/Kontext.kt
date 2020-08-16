package features.coroutines

import kotlinx.coroutines.*

fun main() {
//    whatThreadAmIRunningOn()
    childRoutines()
}

private fun childRoutines() {
    runBlocking {
        val outer = launch {
            println("before child coroutine")
            launch(coroutineContext) {
                repeat(100) {
                    print('.')
                    delay(1)
                }
            }
            println("after child coroutine")
        }

        outer.join()
        println()
        println("Finished")
    }
}

private fun whatThreadAmIRunningOn() {
    runBlocking {
        val jobs = arrayListOf<Job>()

        createJobs(jobs)

        jobs.forEach {
            it.join()
        }

        println()
        println()

        launch {
            createJobs(jobs)

            jobs.forEach {
                it.join()
            }
        }
    }
}

private fun CoroutineScope.createJobs(jobs: ArrayList<Job>) {
    jobs += launch {
        println("                 'default': In thread ${Thread.currentThread().name}")
    }
    jobs += launch(coroutineContext) {
        println("        'coroutineContext': In thread ${Thread.currentThread().name}")
    }
    jobs += launch(Dispatchers.Default) {
        println("       'defaultDispatcher': In thread ${Thread.currentThread().name}")
    }
    jobs += launch(Dispatchers.Unconfined) {
        println("               'Unconfined': In thread ${Thread.currentThread().name}")
    }
    jobs += launch(Dispatchers.IO) {
        println("                      'IO': In thread ${Thread.currentThread().name}")
    }
//    jobs += launch(Dispatchers.Main) {
//        println("                    'Main': In thread ${Thread.currentThread().name}")
//    }
    jobs += launch(newSingleThreadContext("MyOwnSeparateThread")) {
        println("     'MyOwnSeparateThread': In thread ${Thread.currentThread().name}")
    }
}