package dictionary.bot.operations;

import dictionary.bot.OutputBody;

import java.io.Serializable;
import java.util.List;

/**
 * Created by harshit on 25/1/16.
 */
public class LiveStatus implements OutputBody {
    private static final long serialVersionUID = -2296473266632528232L;
    private String position;
    private String train_number;
    private List<Route> route;

    @Override
    public String toString() {
        return "LiveStatus{" +
                "position='" + position + '\'' +
                ", train_number='" + train_number + '\'' +
                ", route=" + route +
                '}';
    }

    @Override
    public String toUserString() {
        return toString();
    }

    private class Route implements Serializable {
        private static final long serialVersionUID = 4926112385177142029L;
        private int no;
        private String station;
        private boolean has_arrived;
        private boolean has_departed;
        private int distance;
        private int day;
        private String scharr;
        private String schdep;
        private String actarr;
        private String actdep;
        private int latemin;
        private String scharr_date;
        private String schdep_date;

        @Override
        public String toString() {
            return "Route{" +
                    "no=" + no +
                    ", station='" + station + '\'' +
                    ", has_arrived=" + has_arrived +
                    ", has_departed=" + has_departed +
                    ", distance=" + distance +
                    ", day=" + day +
                    ", scharr='" + scharr + '\'' +
                    ", schdep='" + schdep + '\'' +
                    ", actarr='" + actarr + '\'' +
                    ", actdep='" + actdep + '\'' +
                    ", latemin=" + latemin +
                    ", scharr_date='" + scharr_date + '\'' +
                    ", schdep_date='" + schdep_date + '\'' +
                    '}';
        }
    }
}
