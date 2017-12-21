package pl.com.booker.util

import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonToken

import java.io.IOException


object JsonUtils {
    @Throws(IOException::class)
    fun readNullSafeString(reader: JsonReader): String? {
        if (reader.peek() == JsonToken.NULL) {
            reader.nextNull()
            return null
        } else {
            return reader.nextString()
        }
    }

    @Throws(IOException::class)
    fun readNullSafeLong(reader: JsonReader): Long? {
        if (reader.peek() == JsonToken.NULL) {
            reader.nextNull()
            return null
        } else {
            return reader.nextLong()
        }
    }

    @Throws(IOException::class)
    fun readNullSafeInteger(reader: JsonReader): Int? {
        if (reader.peek() == JsonToken.NULL) {
            reader.nextNull()
            return null
        } else {
            return reader.nextInt()
        }
    }

    @Throws(IOException::class)
    fun readNullSafeDouble(reader: JsonReader): Double? {
        if (reader.peek() == JsonToken.NULL) {
            reader.nextNull()
            return null
        } else {
            return reader.nextDouble()
        }
    }

    @Throws(IOException::class)
    fun readNullSafeFloat(reader: JsonReader): Float? {
        if (reader.peek() == JsonToken.NULL) {
            reader.nextNull()
            return null
        } else {
            return reader.nextDouble().toFloat()
        }
    }

    @Throws(IOException::class)
    fun readNullSafeBoolean(reader: JsonReader): Boolean? {
        if (reader.peek() == JsonToken.NULL) {
            reader.nextNull()
            return null
        } else {
            return reader.nextBoolean()
        }
    }
}
