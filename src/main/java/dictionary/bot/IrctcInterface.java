package dictionary.bot;

import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by harshit on 25/1/16.
 */
public interface IrctcInterface {

    @GET("/pnr_status/pnr/{pnr_no}/apikey/{apikey}/")
    PNRStatus getPnrStatus(@Path("pnr_no") String pnrNo, @Path("apikey") String apikey);
}
