package dictionary.bot;

import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by harshit on 25/1/16.
 */
public interface IrctcInterface {

    // in DD-MM-YYYY
    @GET("/pnr_status/pnr/{pnr_no}/apikey/{apikey}/")
    PNRStatus getPnrStatus(@Path("pnr_no") String pnrNo, @Path("apikey") String apiKey);

    @GET("/check_seat/train/{trainNumber}/source/{source}/dest/" +
            "{dest}/date/{doj}/class/{class>/quota/{quota}/apikey/{apikey}")
    SeatAvailability getSeat(@Path("trainNumber") String trainNumber, @Path("source") String sourceCode,
                             @Path("dest") String destCode, @Path("doj")String doj, @Path("quota")String quota,
                             @Path("apikey")String apiKey);

    //dd-mm
    @GET("/between/source/{source}/dest/{dest}/date/{date}/apikey/{apikey}/")
    Trains getTrainBetweenStations(@Path("source") String sourceCode,
                                   @Path("dest") String destCode, @Path("doj")String doj,
                                   @Path("apikey")String apiKey);

    @GET("/live/train/{trainNumber}/doj/{doj}/apikey/{apikey}/")
    LiveStatus getLiveStatus(@Path("trainNumber") String trainNumber, @Path("doj") String doj, @Path("apikey") String apiKey);
}
