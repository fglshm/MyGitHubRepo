package com.fglshm.mygithubrepo.utils

object Utils {


    object Time {

        fun getTimestampText(nowTimestamp: Long, timestamp: Long): String {

            var timeLag = (nowTimestamp - timestamp * 1000) / 1000

            if (timeLag < 60) {
                return "a few seconds ago"
            }

            when {
                timeLag / 60 < 60 -> {
                    timeLag /= 60
                    if (timeLag == 1L) return "1 minute ago"
                    return "$timeLag minutes ago"
                }
                timeLag / 60 / 60 < 24 -> {
                    timeLag = timeLag / 60 / 60
                    if (timeLag == 1L) return "1 hour ago"
                    return "$timeLag hours ago"
                }
                timeLag / 60 / 60 / 24 < 7 -> {
                    timeLag = timeLag / 60 / 60 / 24
                    if (timeLag == 1L) return "1 day ago"
                    return "$timeLag days ago"
                }
                timeLag / 60 / 60 / 24 / 7 < 4 -> {
                    timeLag = timeLag / 60 / 60 / 24 / 7
                    if (timeLag == 1L) return "1 week ago"
                    return "$timeLag weeks ago"
                }
                timeLag / 60 / 60 / 24 / 7 / 4 < 12 -> {
                    timeLag = timeLag / 60 / 60 / 24 / 7 / 4
                    if (timeLag == 1L) return "1 month ago"
                    return "$timeLag months ago"
                }
                else -> {
                    timeLag = timeLag / 60 / 60 / 24 / 7 / 4 / 12
                    if (timeLag == 1L) return "1 year ago"
                    return "$timeLag years ago"
                }
            }
        }
    }

}