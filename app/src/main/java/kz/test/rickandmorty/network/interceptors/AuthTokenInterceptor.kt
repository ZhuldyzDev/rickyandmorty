package kz.test.rickandmorty.network.interceptors

import kz.test.rickandmorty.data.consts.Header
import kz.test.rickandmorty.network.utils.HeaderUtils
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class AuthTokenInterceptor(
    private val headerUtils: HeaderUtils
) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()

        // Customize the request
        val request = original.newBuilder()
            .header(Header.ACCEPT, headerUtils.getAccept())
            .header(Header.APP_VERSION, headerUtils.getAppVersion())
            .header(Header.DEVICE_BRAND, headerUtils.getDeviceBrand())
            .header(Header.DEVICE_MODEL, headerUtils.getDeviceModel())
            .header(Header.DEVICE_OS, headerUtils.getDeviceOs())
            .header(Header.DEVICE_OS_MAIN, headerUtils.getDeviceOsMain())
            .header(Header.DEVICE_ADD_INFO, headerUtils.getDeviceAddInfo())
            .method(original.method, original.body)
            .build()

        return chain.proceed(request)
    }

}