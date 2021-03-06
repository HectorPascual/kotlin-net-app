import java.io.*
import java.net.*

class MySock(ip: String, port: Int) {
    private var out: PrintWriter? = null
    private var input: BufferedReader? = null
    private var socket: Socket? = null


    init {
        socket = Socket(ip, port)
    }

    fun close() {
        socket!!.close()
    }

    fun shutdownInput() {
        socket!!.shutdownInput()
    }

    fun write(line: String) {
        out = PrintWriter(socket!!.getOutputStream(), true)
        out!!.println(line)
    }

    fun read(): String? {
        input = BufferedReader(InputStreamReader(socket!!.getInputStream()))
        return input!!.readLine()
    }

}
