import java.io.*

//                 t[index]
//          /                   \
//  t[2 * index + 1]        t[2 * index + 2]

class HeapType() {

    fun maxOrMinHeap(nums: MutableList<Int>) {
        var heap = 0
        var noHeap = 0
        for (i in nums.indices) {
            if ((2 * i) + 2 < nums.size - 1){
                if (nums[i] < nums[2 * i + 1] || nums[i] < nums[2 * i + 2]) {
                    noHeap++
                } else {
                    heap++
                }
            }
            if (i == nums.size - 1) {
                if (noHeap == 0) {
                    println("max-heap")
                    break
                }
                if (heap == 0) {
                    println("min-heap")
                    break
                } else {
                    println("no-heap")
                    break
                }
            }
        }
    }

    fun readHeapData(fname: String): MutableList<Int> {
        val dir = System.getProperty("user.home") + "/Desktop/"
        val f = File("${dir}${fname}").readLines()
        var index = 0
        val l = mutableListOf<Int>()
        var temp = ""
        while (index != f.size) {
            for (i in f[index]) {
                if (i.code != 32) {
                    temp += i.toString()
                } else {
                    l.add(temp.trim().toInt())
                    temp = ""
                }
            }
            l.add(temp.trim().toInt())
            maxOrMinHeap(l)
            index++
            l.clear()
            temp = ""
        }
        return l
    }
}


fun main() {
    val heapType = HeapType()
    val l = heapType.readHeapData("heap")
}
