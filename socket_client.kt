import java.io.*
import java.net.Socket

fun main(args : Array<String>) {

  var socket = Socket("127.0.0.1",8080)
  var inStream= DataInputStream(socket.getInputStream()) // Socket INPUT (read from server)
  var outStream= DataOutputStream(socket.getOutputStream()) // Socket OUTPUT (write to server)

  //Send name
  print("Type your name : ")
  var name = readLine();
  outStream.writeUTF(name);
  outStream.flush()

  //Read & Write Threads
  Thread{
    while (true) {
      outStream.writeUTF(readLine())
      outStream.flush()
    }
  }.start()

  Thread {
    while (true) {
      println("Server says : " + inStream.readUTF())
    }
  }.start()

}
