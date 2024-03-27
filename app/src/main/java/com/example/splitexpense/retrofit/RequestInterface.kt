package com.example.splitexpense.retrofit

import io.reactivex.Observable
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Path
import retrofit2.http.Query

interface RequestInterface {

    @POST("groups")
    fun CreateGroup(@Body jsonobject: RequestBody): Call<ResponseBody>

        @GET("groups/list/{username}")
//    fun GetGroupUserName(): Call<ResponseBody>
    fun GetGroupUserName(@Path("username") username: String): Call<ResponseBody>

    @GET("index.php?action=changePassword")
    fun forgotPassword(@Path("email") email: String): Call<ResponseBody>


  /*
     @GET("index.php?action=userloginnew")
    fun logIn(
        @Query("email") email: String,
        @Query("password") password: String,
        @Query("user_apns_key") user_apns_key: String,
        @Query("user_apns_type") user_apns_type: String,
        @Query("user_udid") user_udid: String,
        @Query("user_player_ids") user_player_ids: String,
    ): Observable<String>

  @GET("index.php?action=changePassword")
    fun forgotPassword(@Query("email") email: String): Observable<com.community.connectT.model.LoginResponse>

//    @GET("index.php?action=forcefully_update_version")
//    fun getAppStoreLocation(@Query("android_version") version: String): Observable<GetAppStoreVersionResponse>

    @GET("index.php?action=appVersion&platform=android")
    fun getAppStoreLocation(@Query("app_version") version: String): Observable<com.community.connectT.model.GetAppStoreVersionResponse>

    @GET("index.php?action=androidRegistration")
    fun androidRegistration(
        @Query("device_unique_id") device_unique_id: String,
        @Query("user_player_id") user_player_id: String,
    ): Observable<com.community.connectT.model.GetPlayerIdResponse>

    @GET("index.php?action=removeAccount")
    fun removeAccount(
        @Query("user_vendor_id") vendorId: String,
        @Query("user_id") userId: String,
    ): Observable<com.community.connectT.model.LoginResponse>

    @GET("index.php?action=usersignupnew")
    fun register(
        @Query("udid") udid: String,
        @Query("token") token: String,
        @Query("email") email: String,
        @Query("password") password: String,
//        @Query("numberhousehold") numberhousehold: String,
        @Query("user_vendor_id") user_vendor_id: String,
        @Query("user_apns_type") user_apns_type: String,
        @Query("user_address") user_address: String,
        @Query("user_lat") user_lat: String,
        @Query("user_long") user_long: String,
        @Query("user_zip") user_zip: String,
        @Query("user_route_id") user_route_id: String,
        @Query("user_player_ids") user_player_ids: String,
    ): Observable<com.community.connectT.model.RegisterResponse>

    @GET("index.php?action=findnearvendor")
    fun findVendor(
        @Query("lat") lat: String,
        @Query("udid") udid: String,
        @Query("zip") zip: String,
        @Query("address") address: String,
        @Query("long") long: String,
    ): Observable<com.community.connectT.model.FindVendorResponse>

    //user_id=124&udid=7CA71A76-8F07-4EA0-9ED6-F51DAFC66311&user_address=20 Bentley Road MONTCLAIR NJ&user_lat=41.8367594&user_long=-74.23593009999&zip=07043
    @GET("index.php?action=changeAddress")
    fun changeAddress(
        @Query("user_id") userId: String,
        @Query("udid") udid: String,
        @Query("user_address") address: String,
        @Query("user_lat") lat: String,
        @Query("user_long") long: String,
        @Query("zip") zip: String,
    ): Observable<com.community.connectT.model.FindVendorResponse>

    @GET("index.php?action=usersurveyanswer")
    fun userReviewResult(
        @Query("user_id") user_id: String,
        @Query("vendor_id") vendor_id: String,
        @Query("question_id") question_id: String,
        @Query("answer_text") answer_text: String,
    ): Observable<com.community.connectT.model.UserAppointmentListResponse>

    // old
    *//* @GET("index.php?action=userAppointmentList")
     fun userAppointmentList(
         @Query("user_id") user_id: String,
         @Query("vendor_id") vendor_id: String,
     ): Observable<UserAppointmentListResponse>*//*

    //new retrofit
    @GET("index.php?action=userAppointmentListWithSurvey")
    fun userAppointmentList(
        @Query("user_id") user_id: String,
        @Query("vendor_id") vendor_id: String,
    ): Observable<com.community.connectT.model.UserAppointmentListResponse>

    @GET("index.php?action=cancelAppointment")
    fun cancelAppointment(
        @Query("vendor_id") vendor_id: String,
        @Query("user_id") user_id: String,
        @Query("pickup_type_id") pickup_type_id: String,
        @Query("pickup_schedule_date") pickup_schedule_date: String,
    ): Observable<com.community.connectT.model.CancelAppointmentResponse>
    @GET("index.php?action=cancelAppointment")
    fun cancelAppointment_v1(
        @Query("appointment_id") appointment_id: String
    ): Observable<com.community.connectT.model.CancelAppointmentResponse_v1>

    @GET("index.php?action=getcustompickuptypelist")
    fun getCustomPickUpTypeList(
        @Query("vendor_id") vendor_id: String,
    ): Observable<com.community.connectT.model.GetCustomPickUpTypeListResponse>

    @GET("index.php?action=getcustompickuptypelist_v1")
    fun getCustomPickUpTypeListV1(
        @Query("vendor_id") vendor_id: String,
        @Query("user_id") user_id: String,
    ): Observable<com.community.connectT.model.GetCustomPickUpTypeListV1Response>

    @GET("index.php?action=getappointmentlist")
    fun getAppointmentList(
        @Query("vendor_id") vendor_id: String,
        @Query("pickup_type_id") pickup_type_id: String,
    ): Observable<com.community.connectT.model.GetAppointmentListResponse>

    @GET("index.php?action=getappointmentlistv1")
    fun getAppointmentListV1(
        @Query("vendor_id") vendor_id: String,
        @Query("pickup_type_id") pickup_type_id: String,
        @Query("user_id") user_id: String,
    ): Observable<com.community.connectT.model.GetAppointmentListV1Response>

    @GET("index.php?action=addappointment")
    fun addAppointment(
        @Query("vendor_id") vendor_id: String,
        @Query("user_id") user_id: String,
        @Query("pickup_type_id") pickup_type_id: String,
        @Query("pickup_schedule_date") pickup_schedule_date: String,
        @Query("route_id") route_id: String,
        @Query("calander_id") calander_id: String,
        @Query("message") message: String,
    ): Observable<com.community.connectT.model.AddAppointmentResponse>

    @GET("index.php?action=addappointmentv1")
    fun addAppointmentV1(
        @Query("vendor_id") vendor_id: String,
        @Query("user_id") user_id: String,
        @Query("pickup_type_id") pickup_type_id: String,
        @Query("pickup_schedule_date") pickup_schedule_date: String,
        @Query("route_id") route_id: String,
        @Query("calander_id") calander_id: String,
        @Query("message") message: String,
        @Query("amount") amount: String,
        @Query("paymentIntent") pay_intent: String,
    ): Observable<com.community.connectT.model.AddAppointmentResponse>

    @GET("index.php?action=getcustompickuptypelist")
    fun getCustomPickupList(
        @Query("vendor_id") vendor_id: String,
    ): Observable<com.community.connectT.model.GetCustomPickUpTypeListResponse>

    @GET("index.php?action=rescheduleNew")
    fun rescheduleNew(
        @Query("appointment_id") appointment_id: String,
        @Query("pickup_schedule_date") pickup_schedule_date: String,
        @Query("reschedule_date") reschedule_date: String,
    ): Observable<com.community.connectT.model.RescheduleNewResponse>

    @GET("index.php?action=routeList")
    fun routeList(
        @Query("vendor_id") vendor_id: String, @Query("user_id") user_id: String,
    ): Observable<com.community.connectT.model.RouteListResponse>

    @GET("index.php?action=updateRoute")
    fun updateRoute(
        @Query("vendor_id") vendor_id: String,
        @Query("user_id") user_id: String,
        @Query("route_id") route_id: String,
    ): Observable<com.community.connectT.model.UpdateRouteResponse>

    @GET("index.php?action=missingReportPickupList")
    fun missingReportPickUpList(@Query("vendor_id") vendor_id: String): Observable<com.community.connectT.model.MissingReportPickUpListResponse>

    @GET("index.php?action=missedPickupReport")
    fun missedPickUpReport(
        @Query("vendor_id") vendor_id: String,
        @Query("user_id") user_id: String,
        @Query("pickup_type_id") pickup_type_id: String,
        @Query("pickup_schedule_date") pickup_schedule_date: String,
    ): Observable<com.community.connectT.model.MissedPickUpReportResponse>

    @GET("index.php?action=sendMessage")
    fun sendMessage(
        @Query("vendor_id") vendor_id: String,
        @Query("user_id") user_id: String,
        @Query("message") message: String,
    ): Observable<com.community.connectT.model.SendMessageResponse>

    @GET("index.php?action=redeemVoucher")
    fun redeemVoucher(
        @Query("voucher_id") vendor_id: String,
        @Query("user_id") user_id: String,
    ): Observable<com.community.connectT.model.VoucherDetailResponse>

    @GET("index.php?action=isDisplay")
    fun isVoucherDisplay(
        @Query("address") address: String,
        @Query("user_zip") user_zip: String,
    ): Observable<com.community.connectT.model.SendMessageResponse>

    @POST("index.php?action=GetAllVouchersforUsers")
    @FormUrlEncoded
    fun isVoucherUsers(
        @Field("user_id") user_id: String,
        @Field("vendor_id") vendor_id: String,
    ): Observable<com.community.connectT.model.VoucherUsersResponse>
 @POST("index.php?action=GetAllVouchersforUsers_v1")
    @FormUrlEncoded
    fun isVoucherUsers_V1(
        @Field("user_id") user_id: String,
        @Field("vendor_id") vendor_id: String,
    ): Observable<com.community.connectT.model.VoucherUsersResponseV1>

    @POST("index.php?action=GetVoucherDetails")
    @FormUrlEncoded
    fun isVoucherDetails(
        @Field("Voucher_id") vendor_id: String,
    ): Observable<com.community.connectT.model.VoucherDetailsResponse>

    @POST("index.php?action=MarkVoucherScanned")
    @FormUrlEncoded
    fun isVoucherConfirm(
        @Field("retailerQRCode") retailerQRCode: String,
        @Field("user_id") user_id: String,
        @Field("vendor_id") vendor_id: String,
        @Field("voucher_id") voucher_id: String,
    ): Observable<com.community.connectT.model.VoucherConfirmsResponse>

    @GET("index.php?action=townNotFound")
    fun townNotFound(
        @Query("address") address: String,
        @Query("lat") lat: String,
        @Query("lang") lang: String,
        @Query("zip_code") zip_code: String,
        @Query("email") email: String,
    ): Observable<com.community.connectT.model.TownNotFoundResponse>

    @GET("index.php?action=updatetokenwithemail")
    fun updateTokenWithEmail(
        @Query("email") email: String,
        @Query("user_udid") user_udid: String,
        @Query("user_apns_key") user_apns_key: String,
        @Query("user_apns_type") user_apns_type: String,
        @Query("user_player_ids") user_player_ids: String,
    ): Observable<com.community.connectT.model.UpdateTokenWithEmailResponse>

    @GET("index.php?action=getpushalerts")
    fun getPushAlerts(
        @Query("vendor_id") vendorId: String,
        @Query("route_id") routeId: String,
        @Query("page") page: Int,
    ): Observable<com.community.connectT.model.PushAlertResponse>

    @GET("index.php?action=getFaqList")
    fun getFaqDetail(@Query("vendor_id") vendorId: String): Observable<com.community.connectT.model.FAQModelClass>

    @GET("index.php?action=voucherDetail")
    fun getVoucherDetail(): Observable<com.community.connectT.model.VoucherDetailResponse>

    @POST("index.php?action=verificationsendmail")
    @Multipart
    fun sendVerification(
        @Part("user_id") user_id: RequestBody,
        @Part file: MultipartBody.Part,
        @Part("vendor_id") vendor_id: RequestBody,
    ): Observable<com.community.connectT.model.SendVerificationResponse>

    @POST("index.php?action=strickpayment")
    fun PaymentSuccess(
        @Part("user_id") user_id: RequestBody,
    ): Observable<com.community.connectT.model.PaymentResponse>

        @GET("index.php?action=lowIncomeVerification")
    fun sendStatusVerification(
        @Query("user_id") user_id: String,
    ): Observable<com.community.connectT.model.SendVerificationStatusResponse>

    @GET("index.php?action=paymentStatus")
    fun sendPaymentStatus(
        @Query("pay_id") pay_id: String,
        @Query("user_id") user_id: String,
        @Query("status") status: String,
        @Query("reason") reason: String,
    ): Observable<com.community.connectT.model.PaymentStatusResponse>
*/
}
