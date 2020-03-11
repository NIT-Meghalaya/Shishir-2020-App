package nitmeghalaya.shishir2020.screens

import android.content.Context
import android.widget.Toast

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

 fun makeShortToast(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}

 inline fun <reified T> Gson.getListFromJson(json: String) =
    this.fromJson<T>(json, object : TypeToken<T>() {}.type)

 inline fun <reified T> Gson.getJsonFromList(eventsList: ArrayList<*>) =
    this.toJson(eventsList, object : TypeToken<T>() {}.type)