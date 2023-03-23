package com.nibm.medicare

import android.content.res.Resources
import android.util.Log
import com.android.volley.*
import com.android.volley.RequestQueue
import com.android.volley.toolbox.HttpHeaderParser
import com.android.volley.toolbox.StringRequest
import org.json.JSONObject
import java.io.UnsupportedEncodingException

class SMS {
    fun generateOTP(): Int {
        return (Math.random() * 9000).toInt() + 1000
    }

    fun sendOTP(mobileNumber: String, OTP: Int, reqQueue: RequestQueue){
        val queue = reqQueue
        val url = "https://db73-2402-d000-8118-5180-98b6-83b3-d0dc-b845.ap.ngrok.io/otp"

        val jsonBody = JSONObject()
        jsonBody.put("to", mobileNumber)
        jsonBody.put("body", "OTP MSG: "+ OTP)
        val jsonRequestBody : String = jsonBody.toString();

        try {
            val stringReq: StringRequest =
                object : StringRequest(Method.POST, url,
                    Response.Listener { response ->
                        // response
                        var strResp = response.toString()
                        Log.d("SMS", strResp)
                    },
                    Response.ErrorListener { error ->
                        Log.d("SMS", "error => $error")
                    }
                ) {
                    override fun getBodyContentType(): String? {
                        return "application/json; charset=utf-8"
                    }

                    @Throws(AuthFailureError::class)
                    override fun getBody(): ByteArray? {
                        return try {
                            if (jsonRequestBody == null) null else jsonRequestBody.toByteArray(
                                Charsets.UTF_8
                            )
                        } catch (uee: UnsupportedEncodingException) {
                            VolleyLog.wtf(
                                "Unsupported Encoding while trying to get the bytes of %s using %s",
                                jsonRequestBody,
                                "utf-8"
                            )
                            null
                        }
                    }

                    override fun parseNetworkResponse(response: NetworkResponse?): Response<String?>? {
                        var responseString = ""
                        if (response != null) {
                            responseString = response.statusCode.toString()
                        }
                        return Response.success(
                            responseString,
                            HttpHeaderParser.parseCacheHeaders(response)
                        )
                    }
                };
            queue.add(stringReq)
        } catch (error : Exception){
            println(error.toString())
        }
    }
}