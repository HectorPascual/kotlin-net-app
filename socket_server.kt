import java.net.ServerSocket
import java.io.*
fun main(args : Array<String>) {

  var server=ServerSocket(8080);
  var serverClient=server.accept();

  var inStream=DataInputStream(serverClient.getInputStream())
  var outStream=DataOutputStream(serverClient.getOutputStream())

  //First read is the name
  var clientName = inStream.readUTF();

  Thread{
    while (true) {

      outStream.writeUTF(readLine())
      outStream.flush()
    }
  }.start()

  Thread {
    while (true) {
      println(clientName + " says : " + inStream.readUTF())
    }
  }.start()
}
