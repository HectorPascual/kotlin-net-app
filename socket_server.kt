import java.net.ServerSocket
import java.io.*
import java.net.Socket

fun main(args : Array<String>) {

  //MULTICLIENT SERVER

  var server=ServerSocket(8080);
  var newestClient = Socket()
  var clientsMap = HashMap<String,MySocket>()

  Thread {
    while (true) {
      newestClient = server.accept()
      val newestClientSocket = MySocket(newestClient)
      clientsMap.put(newestClientSocket.inStream.readUTF(), newestClientSocket)
    }
  }

  Thread {
    while (true) {
      //println(clientName + " says : " + inStream.readUTF())
      for(i in clientsMap){
        println(i.key + " says : " + i.value.inStream.readUTF())
      }
    }
  }.start()
}


class MySocket(socket: Socket){
  val inStream=DataInputStream(socket.getInputStream())
  val outStream=DataOutputStream(socket.getOutputStream())

}