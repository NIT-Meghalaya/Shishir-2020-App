//package nitmeghalaya.shishir2020.extensions

import com.google.gson.Gson


fun <T> Any.toJson() = Gson().toJson(this as T)