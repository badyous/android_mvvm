package io.digiteam.mvvm.network;

import android.arch.lifecycle.LiveData;

import java.util.List;

import io.digiteam.mvvm.database.entity.Offer;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * The interface which provides methods to get result of webservices
 */
public interface NetworkApiService {

    /**
     *
     * @return the list of the "Offres" from the API
     */
    @GET("/offres")
    LiveData<ApiResponse<List<Offer>>> getOffres();
}
