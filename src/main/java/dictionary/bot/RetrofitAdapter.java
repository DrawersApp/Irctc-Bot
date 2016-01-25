package dictionary.bot;

import retrofit.RestAdapter;

import java.util.stream.Collectors;

/**
 * Created by harshit on 20/1/16.
 */
public class RetrofitAdapter {
    private String apiKey = "uyuaq4041";
    private RetrofitAdapter() {
        createDictionaryInterface();
    }

    private static RetrofitAdapter retrofitAdapter;
    public synchronized static RetrofitAdapter getRetrofitAdapter() {
        if (retrofitAdapter == null) {
            retrofitAdapter = new RetrofitAdapter();
        }
        return retrofitAdapter;
    }

    private IrctcInterface  irctcInterface;


    public IrctcInterface getIrctcInterface() {
        return irctcInterface;
    }

    private void createDictionaryInterface() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://api.railwayapi.com")
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();

        irctcInterface = restAdapter.create(IrctcInterface.class);
    }

    static String generateText(PNRStatus pnrStatus) {
        return pnrStatus.toJsonString();
    }


    public String getApiKey() {
        return apiKey;
    }
}
