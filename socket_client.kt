import java.io.*
import java.net.Socket

fun main(args : Array<String>) {

    var socket = Socket("127.0.0.1",1414)

    var inStream = BufferedReader(InputStreamReader(socket.getInputStream())) // Socket INPUT (read from server)
    var outStream =  PrintWriter(BufferedWriter(OutputStreamWriter(socket.getOutputStream())), true)

    //Read & Write Threads
    Thread{
    while (true) {
      outStream.println(readLine())
    }
    }.start()

    Thread {
    while (true) {
      println(inStream.readLine());
      //println("Someone says : " + inStream.readUTF())
    }
    }.start()

}