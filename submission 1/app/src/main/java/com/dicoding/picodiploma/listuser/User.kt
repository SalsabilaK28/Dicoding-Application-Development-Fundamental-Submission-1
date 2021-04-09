package com.dicoding.picodiploma.listuser

import android.os.Parcel
import android.os.Parcelable

data class User(
        val name: String?,
        val username: String?,
        val photo: Int?,
        val followers: String?,
        val following: String?,
        val company: String?,
        val location: String?,
        val repository: String?
) :  Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(username)
        parcel.writeValue(photo)
        parcel.writeString(followers)
        parcel.writeString(following)
        parcel.writeString(company)
        parcel.writeString(location)
        parcel.writeString(repository)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }
}