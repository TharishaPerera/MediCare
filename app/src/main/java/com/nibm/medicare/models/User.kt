package com.nibm.medicare.models

import com.google.gson.annotations.SerializedName

data class User (
        @SerializedName("user_mobile") val uMobile: String?,
        @SerializedName("address") val uAddress: String?,
        @SerializedName("blood_group") val uBloodGroup: String?,
        @SerializedName("dob") val dob: String?,
        @SerializedName("first_name") val uFirstName: String?,
        @SerializedName("last_name") val uLastName: String?,
        @SerializedName("gender")val uGender: String?
        )