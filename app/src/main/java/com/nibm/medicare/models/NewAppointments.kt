package com.nibm.medicare.models

import android.os.Parcel
import android.os.Parcelable

data class NewAppointments(
    val name:String,
    val speciality:String,
    val location:String,
    val rating:String,
    val image:Int,
    val date:String,
    val hospital1:String,
//    val hospital2:String,
//    val hospital3:String,
    val time1:String,
//    val time2:String,
//    val time3:String

    ) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
//        parcel.readString()!!,
//        parcel.readString()!!,
        parcel.readString()!!,
//        parcel.readString()!!,
//        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(speciality)
        parcel.writeString(location)
        parcel.writeString(rating)
        parcel.writeInt(image)
        parcel.writeString(date)
        parcel.writeString(hospital1)
//        parcel.writeString(hospital2)
//        parcel.writeString(hospital3)
        parcel.writeString(time1)
//        parcel.writeString(time2)
//        parcel.writeString(time3)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<NewAppointments> {
        override fun createFromParcel(parcel: Parcel): NewAppointments {
            return NewAppointments(parcel)
        }

        override fun newArray(size: Int): Array<NewAppointments?> {
            return arrayOfNulls(size)
        }
    }

}
