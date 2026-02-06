package eu.tutorials.DailyDoserApp



import android.app.Application

class DailyDoserApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Graph.provide(this)
    }
}