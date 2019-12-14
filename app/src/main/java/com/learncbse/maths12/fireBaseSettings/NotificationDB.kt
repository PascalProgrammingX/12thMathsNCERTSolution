package com.learncbse.maths12.fireBaseSettings

import io.realm.RealmObject
import io.realm.annotations.RealmClass

@RealmClass
open class NotificationDB : RealmObject(){
    var content :String?= ""
    var title :String?= ""
    var imageUrl :String?= ""

}