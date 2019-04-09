import java.io.*
import java.net.Socket

/*
In kotlin all exceptions are unchecked, so it is not forced by the compiler to either handle or specify the exception.
Might be handled manually
 */

fun main(args : Array<String>) {

    var socket = MySock("127.0.0.1",1414)
    //Read & Write Threads
    Thread{
        var line : String? = null
        while (readLine().let { line = it; line!=null}) {
            socket.write(line!!)
        }
        socket.shutdownInput()
    }.start()

    Thread {
        var line : String? = null
        while(socket.read().let { line = it; line!=null }){
            println(line)
        }
        socket.close()
    }.start()
}