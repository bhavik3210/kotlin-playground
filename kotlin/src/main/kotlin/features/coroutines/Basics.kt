package features.coroutines

import kotlinx.coroutines.*
import java.lang.Thread.sleep
import java.util.concurrent.atomic.AtomicInteger
import kotlin.concurrent.thread

fun main(args: Array<String>) {

//    //timeout based coroutine
//    runBlocking {
//        val job = withTimeoutOrNull(100) {
//            repeat(1000) {
//                yield()
//
//                print(".")
//                Thread.sleep(1)
//            }
//        }
//
//        if(job == null) println("TimedOut")
//        else println("Done")
//
//
//    }

//    runBlocking {
//        val job = launch {
//            try {
//                repeat(100) {
//                    delay(100)
//                    print(" $it ")
//                }
//            } catch (ex: CancellationException) {
//                println("\n Cancellation Exception Occurred")
//                println("\n ${ex.localizedMessage}" )
//            } finally {
//                run {
//                    println("\n In Finally")
//                }
//
//            }
//        }
//
//        println("Before delay of 3 seconds")
//        delay(3000)
//        job.cancel(CancellationException("REASON: Cancelled Due to No Network Connection"))
//        job.join()
//        println("After delay of 3 seconds")
//
//    }

//    print("\n\n before runBlocking \n\n")
////    runBlocking {
//        GlobalScope.launch {
//            delay(5000)
//            print(" world!!")
//        }
//
//        sleep(1500)
//        print("hello")
////    }
//    print("\n\n after runBlocking \n\n")

//    --------------
//    val result = AtomicInteger()
//
//    runBlocking {
//
//        for(i in 1..1_500_000) {
//            launch {
//                result.getAndIncrement()
//            }
//        }
//
//    }
//    print(result.get())
//

//    --------------
//        launch {
//            delay(3000)
//            println("delay of 3 seconds \n")
//        }
//
//        println("between coroutines \n")
//
//        launch {
//            delay(1000)
//            println("delay of 1 second \n")
//        }
//
//        println("after all coroutines \n ")


}

