import java.io.*
import java.net.*

class MySock(ip: String, port: Int) {
    private var out: PrintWriter? = null
    private var input: BufferedReader? = null
    private var socket: Socket? = null


    init {
        try {
            socket = Socket(ip, port)
        } catch (ex: IOException) {
        }

    }


    fun close() {
        try {
            socket!!.close()
        } catch (ex: IOException) {
        }

    }

    fun shutdownInput() {
        try {
            socket!!.shutdownInput()
        } catch (ex: IOException) {
        }

    }

    fun write(line: String) {
        try {
            out = PrintWriter(socket!!.getOutputStream(), true)
        } catch (ex: IOException) {
        }

        out!!.println(line)
    }

    fun read(): String? {
        try {
            input = BufferedReader(InputStreamReader(socket!!.getInputStream()))
            return input!!.readLine()
        } catch (ex: IOException) {
        }

        return null
    }

}
