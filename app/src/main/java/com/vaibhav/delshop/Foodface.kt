package com.vaibhav.delshop
import com.vaibhav.delshop.dataClasses.Recipeclasses
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://api.edamam.com/"

     val retrofit: Retrofit.Builder = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)

    interface foodface {

         @GET("/search")
        suspend fun getreciepe(
             @Query("app_id") app_id:String,
             @Query("q") q:String,
             @Query("app_key") app_key:String
        ): Response<Recipeclasses>
    }
        object foodie {
            val retrofitService: foodface by lazy { retrofit.build().create(foodface::class.java) }
        }