
class Basic<T> {
    var array: Array<T>

    constructor(array: Array<T>) {
        this.array = array
    }

    fun element_s_najvise_ponavljanja(): T {
        var mapa_ponavljanja = mutableMapOf<T, Int>()

        for (element in this.array) {
            if (mapa_ponavljanja.containsKey(element)) {
                mapa_ponavljanja.set(element, mapa_ponavljanja.getValue(element) + 1)
            } else {
                mapa_ponavljanja.put(element, 1)
            }
        }

        var naj_ponavljanja: T = mapa_ponavljanja.keys.elementAt(0)

        for (element in mapa_ponavljanja.iterator()) {
            var trazeni_broj = mapa_ponavljanja.getValue(naj_ponavljanja)
            if (element.value >= trazeni_broj) {
                naj_ponavljanja = element.key
            }
        }

        return naj_ponavljanja
    }
}

fun main() {
    var array: Array<String> = arrayOf("One", "Two", "One", "Three", "One", "Four", "Five")
    var klasa: Basic<String> = Basic<String>(array)
    println(klasa.element_s_najvise_ponavljanja())

    var array2: Array<Int> = arrayOf(1, 3, 4, 2, 3, 1, 4, 5, 6, 2, 3, 3, 3, 2, 5, 1)
    var klasa2 = Basic(array2)
    println(klasa2.element_s_najvise_ponavljanja())
}